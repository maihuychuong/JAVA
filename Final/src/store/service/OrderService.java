package store.service;

import store.data.Database;
import store.entities.Order;
import store.entities.Product;
import store.entities.User;
import store.utils.Utils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class OrderService {
    CartService cartService = new CartService();
    ProductService productService = new ProductService();

    //    Xác nhận đơn hàng
    public void confirmOrder(Scanner scanner, User user) {
        cartService.checkEmptyCart();
        System.out.println("Nhập thông tin đơn hàng: ");
        System.out.println("Địa chỉ giao hàng: ");
        String shippingAddress = Utils.inputString(scanner);
        LocalDateTime orderDate = LocalDateTime.now();
        System.out.println("Đơn hàng của bạn: ");
        cartService.displayCart();
        System.out.println("Xác nhận đơn hàng: (Y/N)");
        String confirm = Utils.inputString(scanner);
        while (!confirm.equalsIgnoreCase("Y") && !confirm.equalsIgnoreCase("N")) {
            System.out.println("Lựa chọn bạn nhập không hợp lệ. Vui lòng thử lại.");
            confirm = Utils.inputString(scanner);
        }
        if (confirm.equalsIgnoreCase("Y")) {
            for (Map.Entry<Integer, Integer> entry : Database.productsCart.entrySet()) {
                int id = entry.getKey();
                int quantityCart = entry.getValue();
                Product product = productService.findProductById(id);
                if (product != null) {
                    product.setQuantity(product.getQuantity() - quantityCart);
                }
            }
            Order order = new Order(new HashMap<>(Database.productsCart), user.getUsername(), calculateTotalPrice(), orderDate, shippingAddress);
            Database.orders.add(order);
            System.out.println("Đơn hàng của bạn đã được xác nhận thành công. Thông tin đơn hàng: ");
            System.out.println(order);
            System.out.println("------------------------------------------------------------------");
            payment(order, scanner);
            cartService.deleteCart();
        } else if (confirm.equalsIgnoreCase("N")) {
            System.out.println("Hủy xác nhận đơn hàng. thành công.");
        }
    }

    //    Tính tổng số tiền của đơn hàng
    private BigDecimal calculateTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer, Integer> entry : Database.productsCart.entrySet()) {
            int id = entry.getKey();
            int quantityCart = entry.getValue();
            Product product = productService.findProductById(id);
            if (product != null) {
                BigDecimal quantity = new BigDecimal(quantityCart);
                totalPrice = totalPrice.add(product.getPrice().multiply(quantity));
            }
        }
        return totalPrice;
    }

    //    Hiển thị lịch sử mua hàng của người mua
    public void displayPurchaseHistory(User user) {
        System.out.println("Lịch sử mua hàng của người dùng " + user.getUsername() + " :");
        List<Order> ordersBuyer = findAllOrderByBuyer(user);
        if (ordersBuyer.isEmpty()) {
            System.out.println("Lịch sử giao dịch của bạn trống");
        } else {
            for (Order order : ordersBuyer) {
                System.out.println(order);
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
        return ordersBuyer;
    }

    //    Hiển thị đơn hàng của người bán sau khi người mua đã xác nhận đơn hàng
    public void displayOrderForSeller(User user) {
        System.out.println("Danh sách đơn hàng của người dùng " + user.getUsername() + " :");
        boolean hasOrders = false;
        for (Order order : Database.orders) {
            boolean hasSellerProduct = false;
            for (Map.Entry<Integer, Integer> entry : order.getProductsCart().entrySet()) {
                int id = entry.getKey();
                Product product = productService.findProductById(id);
                if (product != null && product.getSeller().equalsIgnoreCase(user.getUsername())) {
                    hasSellerProduct = true;
                    break;
                }
            }
            if (hasSellerProduct) {
                System.out.println(order);
                hasOrders = true;
            }
        }
        if (!hasOrders) {
            System.out.println("Bạn không có đơn hàng nào");
        }
    }

    //    Hiển thị doanh thu của người bán
    public void displayRevenueForSeller(User user) {
        BigDecimal totalRevenue = new BigDecimal(0);
        Map<String, Integer> productSaleCount = new HashMap<>();
        for (Order order : Database.orders) {
            for (Map.Entry<Integer, Integer> entry : order.getProductsCart().entrySet()) {
                int id = entry.getKey();
                Product product = productService.findProductById(id);
                if (product != null && product.getSeller().equalsIgnoreCase(user.getUsername())) {
                    BigDecimal productRevenue = product.getPrice().multiply(new BigDecimal(entry.getValue()));
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
        while (!Database.bankNames.contains(bankName)){
            System.out.println("Tên ngân hàng vùa nhập không tồn tại trong nhưng ngân hàng được cho phép. Vui lòng nhập lại.");
            bankName = Utils.inputString(scanner);
        }
        System.out.println("Số tài khoản: ");
        String accountNumber = Utils.inputString(scanner);
        while (!Utils.conditionAccountNumber(accountNumber)){
            System.out.println("Số tài khoản vừa nhập không hợp lệ. Vui lòng nhập lại");
            accountNumber = Utils.inputString(scanner);
        }
        System.out.println("Chuyển khoản thành công.");
        order.setOrderStatus("Đã thanh toán.");
        System.out.println(order.getOrderStatus());
    }

    //    Người bán xử lý đơn hàng
    public void processOrder(Scanner scanner, User user) {
        System.out.println("Nhập ID đơn hàng muốn xử lý: ");
        int id = Utils.inputInt(scanner);
        Order order = findOrderById(id);
        while (order == null) {
            System.out.println("Khồn có đơn hàng nào với id " + id + " tồn tại. Vui lòng thử lại");
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
                order.setOrderStatus("Hàng đang được giao");  // Consider using a constant or enum for statuses
                System.out.println("Đơn hàng đã được xác nhận và gửi.");
            } else {
                System.out.println("Đơn hàng không được xác nhận gửi.");
            }
        } else {
            System.out.println("Đơn hàng này không có sản phẩm của bạn.");
        }
    }

    //    Xóa đơn hàng
    public void deleteOrder(Scanner scanner) {
        System.out.println("Nhập ID đơn hàng muốn xóa: ");
        int id = Utils.inputInt(scanner);
        Order order = findOrderById(id);
        while (order == null) {
            System.out.println("Khồn có đơn hàng nào với id " + id + " tồn tại. Vui lòng thử lại");
            id = Utils.inputInt(scanner);
            order = findOrderById(id);
        }
        Database.orders.remove(order);
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

    //    Hiển thị doanh thu admin
    public void displayRevenueForAdmin() {
        Map<String, BigDecimal> sellerRevenueMap = new HashMap<>();
        Map<String, Map<String, Integer>> sellerProductSalesMap = new HashMap<>();
        for (Order order : Database.orders) {
            for (Map.Entry<Integer, Integer> entry : order.getProductsCart().entrySet()) {
                int productId = entry.getKey();
                int quantity = entry.getValue();
                Product product = productService.findProductById(productId);
                if (product != null) {
                    String sellerUsername = product.getSeller();
                    BigDecimal productRevenue = product.getPrice().multiply(new BigDecimal(quantity));
                    sellerRevenueMap.put(sellerUsername, sellerRevenueMap.getOrDefault(sellerUsername, new BigDecimal(0)).add(productRevenue));
                    sellerProductSalesMap.putIfAbsent(sellerUsername, new HashMap<>());
                    sellerProductSalesMap.get(sellerUsername).put(product.getName(), sellerProductSalesMap.get(sellerUsername).getOrDefault(product.getName(), 0) + quantity);
                }
            }
        }
        for (Map.Entry<String, BigDecimal> sellerEntry : sellerRevenueMap.entrySet()) {
            String seller = sellerEntry.getKey();
            BigDecimal totalRevenue = sellerEntry.getValue();
            System.out.println("Doanh thu của người bán " + seller + ": " + totalRevenue);
            System.out.println("Số lượng sản phẩm đã bán: ");
            Map<String, Integer> productSales = sellerProductSalesMap.get(seller);
            if (productSales != null) {
                for (Map.Entry<String, Integer> productEntry : productSales.entrySet()) {
                    System.out.println("Sản phẩm: " + productEntry.getKey() + ", Số lượng đã bán: " + productEntry.getValue());
                }
            }
            System.out.println("------------");
        }
    }
}


