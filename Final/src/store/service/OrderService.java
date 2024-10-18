package store.service;

import store.data.Database;
import store.entities.Order;
import store.entities.Product;
import store.entities.User;
import store.utils.Utils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class OrderService {
    CartService cartService = new CartService();
    ProductService productService = new ProductService();

    //    Xác nhận đơn hàng
    public void confirmOrder(Scanner scanner, User user) {
        cartService.checkEmptyCart(user);
        System.out.println("Nhập thông tin đơn hàng: ");
        System.out.println("Địa chỉ giao hàng: ");
        String shippingAddress = Utils.inputString(scanner);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String orderDate = now.format(formatter);
        System.out.println("Đơn hàng của bạn: ");
        cartService.displayCart(user);
        System.out.println("Xác nhận đơn hàng: (Y/N)");
        String confirm = Utils.inputString(scanner);
        while (!confirm.equalsIgnoreCase("Y") && !confirm.equalsIgnoreCase("N")) {
            System.out.println("Lựa chọn bạn nhập không hợp lệ. Vui lòng thử lại.");
            confirm = Utils.inputString(scanner);
        }
        if (confirm.equalsIgnoreCase("Y")) {
            Map<Integer, Integer> currentCart = Database.userCarts.get(user.getUsername());

            if (currentCart != null) {
                for (Map.Entry<Integer, Integer> entry : currentCart.entrySet()) {
                    int id = entry.getKey();
                    int quantityCart = entry.getValue();
                    Product product = productService.findProductById(id);
                    if (product != null) {
                        product.setQuantity(product.getQuantity() - quantityCart);
                    }
                }
                Order order = new Order(new HashMap<>(currentCart), user.getUsername(), calculateTotalPrice(user), orderDate, shippingAddress);
                Database.orders.add(order);
                System.out.println("Đơn hàng của bạn đã được xác nhận thành công. Thông tin đơn hàng: ");
                System.out.println(order);
                System.out.println("------------------------------------------------------------------");
                payment(order, scanner);
                cartService.deleteCart(user);
            }
        } else if (confirm.equalsIgnoreCase("N")) {
            System.out.println("Hủy xác nhận đơn hàng thành công.");
        }
    }

    //    Tính tổng số tiền của đơn hàng
    private BigDecimal calculateTotalPrice(User user) {
        BigDecimal totalPrice = new BigDecimal(0);
        Map<Integer, Integer> currentCart = Database.userCarts.get(user.getUsername());
        if (currentCart != null) {
            for (Map.Entry<Integer, Integer> entry : currentCart.entrySet()) {
                int id = entry.getKey();
                int quantityCart = entry.getValue();
                Product product = productService.findProductById(id);
                if (product != null) {
                    BigDecimal quantity = new BigDecimal(quantityCart);
                    totalPrice = totalPrice.add(product.getPrice().multiply(quantity));
                }
            }
        }
        return totalPrice;
    }

    //    Hiển thị lịch sử mua hàng của người mua
    public void displayPurchaseHistory(User user) {
        System.out.println("Lịch sử mua hàng của người dùng " + user.getUsername() + " :");
        List<Order> ordersBuyer = findAllOrderByBuyer(user);
        if (ordersBuyer.isEmpty()) {
            System.out.println("Lịch sử giao dịch của bạn trống.");
        } else {
            for (Order order : ordersBuyer) {
                System.out.println("Đơn hàng ID: " + order.getId());
                System.out.println("Ngày đặt hàng: " + order.getOrderDate());
                System.out.println("Địa chỉ giao hàng: " + order.getShippingAddress());
                System.out.println("Tổng giá: " + order.getTotalPrice());
                System.out.println("Trạng thái: " + order.getOrderStatus());
                if (order.getOrderStatus() == OrderStatus.CANCELED) {
                    System.out.println("Lý do hủy: " + order.getCancellationReason());
                }
                System.out.println("Sản phẩm trong đơn hàng: ");
                for (Map.Entry<Integer, Integer> entry : order.getProductsCart().entrySet()) {
                    int productId = entry.getKey();
                    int quantity = entry.getValue();
                    Product product = productService.findProductById(productId);
                    if (product != null) {
                        System.out.println(" - Tên: " + product.getName() + ", Số lượng: " + quantity);
                    }
                }
                System.out.println("------------------------------------------------------------------");
            }
        }
    }

    //    Tìm kiếm đơn hàng bằng tên người mua
    private List<Order> findAllOrderByBuyer(User user) {
        List<Order> ordersBuyer = new ArrayList<>();
        for (Order order : Database.orders) {
            if (order.getBuyer().equalsIgnoreCase(user.getUsername())) {
                ordersBuyer.add(order);
            }
        }
        if (ordersBuyer.isEmpty()) {
            System.out.println("Không tìm thấy đơn hàng nào cho người dùng: " + user.getUsername());
        }
        return ordersBuyer;
    }

    //    Hiển thị đơn hàng của người bán sau khi người mua đã xác nhận đơn hàng
    public void displayOrderForSeller(User user) {
        System.out.println("Danh sách đơn hàng của người bán " + user.getUsername() + " :");
        boolean hasOrders = false;
        for (Order order : Database.orders) {
            if (containsSellerProduct(order, user.getUsername())) {
                System.out.println(order);
                hasOrders = true;
            }
        }
        if (!hasOrders) {
            System.out.println("Bạn không có đơn hàng nào.");
        }
    }

    //    Kiểm tra xem đơn hàng có sản phẩm nào của người bán không
    private boolean containsSellerProduct(Order order, String sellerUsername) {
        for (Map.Entry<Integer, Integer> entry : order.getProductsCart().entrySet()) {
            int id = entry.getKey();
            Product product = productService.findProductById(id);
            if (product != null && product.getSeller().equalsIgnoreCase(sellerUsername)) {
                return true;
            }
        }
        return false;
    }

    //    Hiển thị doanh thu của người bán
    public void displayRevenueForSeller(User user) {
        BigDecimal totalRevenue = BigDecimal.ZERO;
        Map<String, Integer> productSaleCount = new HashMap<>();
        for (Order order : Database.orders) {
            for (Map.Entry<Integer, Integer> entry : order.getProductsCart().entrySet()) {
                int id = entry.getKey();
                Product product = productService.findProductById(id);
                if (product != null && product.getSeller().equalsIgnoreCase(user.getUsername())) {
                    BigDecimal productRevenue = product.getPrice().multiply(BigDecimal.valueOf(entry.getValue()));
                    totalRevenue = totalRevenue.add(productRevenue);
                    productSaleCount.put(product.getName(), productSaleCount.getOrDefault(product.getName(), 0) + entry.getValue());
                }
            }
        }
        System.out.println("Doanh thu của người bán " + user.getUsername() + " : " + totalRevenue);
        System.out.println("Số lượng sản phẩm đã bán: ");
        for (Map.Entry<String, Integer> entry : productSaleCount.entrySet()) {
            System.out.println("Sản phẩm: " + entry.getKey() + ", Số lượng đã bán: " + entry.getValue());
        }
    }

    //    Thanh toán
    private void payment(Order order, Scanner scanner) {
        System.out.println("Thanh toán đơn hàng: ");
        System.out.println("Nhập thông tin tài khoản ngân hàng:");
        System.out.println("Tên ngân hàng: (VPBank/Vietcombank/Techcombank/Vietinbank/BIDV/MBBank/ACB/Agribank/HDBank/TPBank)");
        String bankName = Utils.inputString(scanner);
        boolean validBankName = false;
        for (String validBank : Database.bankNames) {
            if (validBank.equalsIgnoreCase(bankName)) {
                validBankName = true;
                break;
            }
        }
        while (!validBankName) {
            System.out.println("Tên ngân hàng vừa nhập không tồn tại trong những ngân hàng được cho phép. Vui lòng nhập lại.");
            bankName = Utils.inputString(scanner);
            validBankName = false;
            for (String validBank : Database.bankNames) {
                if (validBank.equalsIgnoreCase(bankName)) {
                    validBankName = true;
                    break;
                }
            }
        }
        System.out.println("Số tài khoản: ");
        String accountNumber = Utils.inputString(scanner);
        while (!Utils.conditionAccountNumber(accountNumber)) {
            System.out.println("Số tài khoản vừa nhập không hợp lệ. Vui lòng nhập lại");
            accountNumber = Utils.inputString(scanner);
        }
        System.out.println("Chuyển khoản thành công.");
        order.setOrderStatus(OrderStatus.PENDING_PAID);
        System.out.println("Trạng thái đơn hàng: " + order.getOrderStatus().getDisplayName());
    }

    //    Người bán xử lý đơn hàng
    public void processOrder(Scanner scanner, User user) {
        System.out.println("Nhập ID đơn hàng muốn xử lý: ");
        int id = Utils.inputInt(scanner);
        Order order = findOrderById(id);
        while (order == null) {
            System.out.println("Không có đơn hàng nào với ID " + id + " tồn tại. Vui lòng thử lại.");
            id = Utils.inputInt(scanner);
            order = findOrderById(id);
        }
        boolean hasSellerProduct = false;
        for (Map.Entry<Integer, Integer> entry : order.getProductsCart().entrySet()) {
            int productId = entry.getKey();
            Product product = productService.findProductById(productId);
            if (product != null && product.getSeller().equalsIgnoreCase(user.getUsername())) {
                hasSellerProduct = true;
                break;
            }
        }
        if (hasSellerProduct) {
            System.out.println("Đơn hàng này có sản phẩm của bạn. Thông tin đơn hàng: ");
            System.out.println(order);
            System.out.println("Xác nhận gửi hàng cho đơn hàng này? (Y/N): ");
            String confirm = Utils.inputString(scanner);
            while (!confirm.equalsIgnoreCase("Y") && !confirm.equalsIgnoreCase("N")) {
                System.out.println("Lựa chọn bạn nhập không hợp lệ. Vui lòng thử lại.");
                confirm = Utils.inputString(scanner);
            }
            if (confirm.equalsIgnoreCase("Y")) {
                order.setOrderStatus(OrderStatus.SHIPPED);
                System.out.println("Đơn hàng đã được xác nhận và gửi.");
            } else if (confirm.equalsIgnoreCase("N")) {
                order.setOrderStatus(OrderStatus.CANCELED);
                System.out.println("Đơn hàng đã bị hủy.");
                System.out.println("Nhập lý do hủy đơn hàng: ");
                String cancellationReason = Utils.inputString(scanner);
                order.setCancellationReason(cancellationReason);
                System.out.println("Lý do hủy: " + cancellationReason);
                refundUser(order.getBuyer(), order.getTotalPrice());
            }
        } else {
            System.out.println("Đơn hàng này không có sản phẩm của bạn.");
        }
    }

    //    Hoàn trả tiền cho người mua
    private void refundUser(String buyer, BigDecimal amount) {
        System.out.println("Hoàn trả số tiền " + amount + " cho người mua " + buyer + ".");
    }

    //    Tự động xóa đơn hàng quá 7 ngày và hoản tiền cho người mua
    public void autoCancelOrders() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        for (Order order : Database.orders) {
            if (order.getOrderStatus() == OrderStatus.PENDING_PAID) {
                LocalDateTime orderDate = LocalDateTime.parse(order.getOrderDate(), formatter);
                long daysBetween = ChronoUnit.DAYS.between(orderDate, now);
                if (daysBetween > 7) {
                    if (order.getOrderStatus() != OrderStatus.CANCELED) {
                        order.setOrderStatus(OrderStatus.CANCELED);
                        order.setCancellationReason("Đơn hàng chưa được xử lý trong vòng 7 ngày.");
                        System.out.println("Đơn hàng ID: " + order.getId() + " đã bị hủy do quá 7 ngày chưa được xử lý.");
                        refundUser(order.getBuyer(), order.getTotalPrice());
                    }
                }
            }
        }
    }

    //    Xóa các đơn hàng bị hủy sau 7 ngày
    public void deleteCanceledOrders() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        List<Order> ordersToDelete = new ArrayList<>();
        for (Order order : Database.orders) {
            if (order.getOrderStatus() == OrderStatus.CANCELED) {
                LocalDateTime orderDate = LocalDateTime.parse(order.getOrderDate(), formatter);
                long daysBetween = ChronoUnit.DAYS.between(orderDate, now);
                if (daysBetween > 7) {
                    ordersToDelete.add(order);
                }
            }
        }
        for (Order order : ordersToDelete) {
            Database.orders.remove(order);
            System.out.println("Đơn hàng ID: " + order.getId() + " đã bị xóa do đã bị hủy quá 7 ngày.");
        }
    }

    //    Tìm kiếm đơn hàng bằng ID
    private Order findOrderById(int id) {
        for (Order order : Database.orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    //    Hiển thị doanh thu từng người bán
    public void sellerStatistics() {
        Map<String, BigDecimal> sellerRevenue = new HashMap<>();
        Map<String, Map<String, Integer>> sellerProductSales = new HashMap<>();
        for (Order order : Database.orders) {
            for (Map.Entry<Integer, Integer> entry : order.getProductsCart().entrySet()) {
                int productId = entry.getKey();
                int quantity = entry.getValue();
                Product product = productService.findProductById(productId);
                if (product != null) {
                    String sellerUsername = product.getSeller();
                    BigDecimal productRevenue = product.getPrice().multiply(BigDecimal.valueOf(quantity));
                    sellerRevenue.put(sellerUsername, sellerRevenue.getOrDefault(sellerUsername, BigDecimal.ZERO).add(productRevenue));
                    sellerProductSales.putIfAbsent(sellerUsername, new HashMap<>());
                    sellerProductSales.get(sellerUsername).put(product.getName(), sellerProductSales.get(sellerUsername).getOrDefault(product.getName(), 0) + quantity);
                }
            }
        }
        for (Map.Entry<String, BigDecimal> sellerEntry : sellerRevenue.entrySet()) {
            String seller = sellerEntry.getKey();
            BigDecimal totalRevenue = sellerEntry.getValue();
            System.out.println("Doanh thu của người bán " + seller + ": " + totalRevenue);
            System.out.println("Số lượng sản phẩm đã bán: ");
            Map<String, Integer> productSales = sellerProductSales.get(seller);
            if (productSales != null) {
                for (Map.Entry<String, Integer> productEntry : productSales.entrySet()) {
                    System.out.println("Sản phẩm: " + productEntry.getKey() + ", Số lượng đã bán: " + productEntry.getValue());
                }
            }
            System.out.println("------------");
        }
    }

    //    Hiển thị danh sách đơn hàng
    public void viewAllOrders() {
        if (Database.orders.isEmpty()) {
            System.out.println("Hiện tại không có đơn hàng nào.");
        } else {
            for (Order order : Database.orders) {
                System.out.println("Đơn hàng ID: " + order.getId() + ", Người mua: " + order.getBuyer());
                System.out.println("Trạng thái đơn hàng: " + order.getOrderStatus());
                System.out.println("------------------------------------------------------------------");
            }
        }
    }

    //    Hiển thị chi tiết đơn hàng
    public void viewOrderDetail(Scanner scanner) {
        System.out.println("Nhập ID đơn hàng cần xem chi tiết: ");
        int id = Utils.inputInt(scanner);
        Order order = findOrderById(id);
        if (order != null) {
            System.out.println("Chi tiết đơn hàng ID: " + order.getId());
            System.out.println("Người mua: " + order.getBuyer());
            System.out.println("Ngày đặt hàng: " + order.getOrderDate());
            System.out.println("Địa chỉ giao hàng: " + order.getShippingAddress());
            System.out.println("Tổng giá: " + order.getTotalPrice());
            System.out.println("Trạng thái: " + order.getOrderStatus());
            System.out.println("Sản phẩm trong đơn hàng: ");
            for (Map.Entry<Integer, Integer> entry : order.getProductsCart().entrySet()) {
                int productId = entry.getKey();
                int quantity = entry.getValue();
                Product product = productService.findProductById(productId);
                if (product != null) {
                    System.out.println(" - Tên: " + product.getName() + ", Số lượng: " + quantity);
                }
            }
            System.out.println("------------------------------------------------------------------");
        } else {
            System.out.println("Không có đơn hàng nào với ID " + id);
        }
    }

    //    Hiển thị sản phẩm bán chạy
    public void displayBestSellingProducts() {
        Map<Integer, Integer> productSalesCount = new HashMap<>();
        for (Order order : Database.orders) {
            for (Map.Entry<Integer, Integer> entry : order.getProductsCart().entrySet()) {
                int productId = entry.getKey();
                int quantity = entry.getValue();
                productSalesCount.put(productId, productSalesCount.getOrDefault(productId, 0) + quantity);
            }
        }
        System.out.println("Sản phẩm bán chạy nhất:");
        productSalesCount.entrySet().stream().sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue())).limit(5).forEach(entry -> {
            Product product = productService.findProductById(entry.getKey());
            if (product != null) {
                System.out.println("Sản phẩm: " + product.getName() + ", Số lượng đã bán: " + entry.getValue());
            }
        });
    }

    //    Hiển thị doanh thu tháng
    public void displayMonthlyRevenue() {
        Map<String, BigDecimal> monthlyRevenue = new HashMap<>();
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM");
        for (Order order : Database.orders) {
            LocalDateTime orderDate = LocalDateTime.parse(order.getOrderDate(), inputFormatter);
            String monthKey = orderDate.format(outputFormatter);
            BigDecimal orderTotal = order.getTotalPrice();
            monthlyRevenue.put(monthKey, monthlyRevenue.getOrDefault(monthKey, BigDecimal.ZERO).add(orderTotal));
        }
        System.out.println("Doanh thu theo tháng:");
        monthlyRevenue.forEach((month, revenue) -> {
            System.out.println("Tháng " + month + ": " + revenue);
        });
    }
}


