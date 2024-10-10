package store.service;

import store.data.Database;
import store.entities.Order;
import store.entities.Product;
import store.entities.User;
import store.utils.Utils;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.*;

public class OrderService {
    CartService cartService = new CartService();
    ProductService productService = new ProductService();
//    Xác nhận đơn hàng
    public void confirmOrder(Scanner scanner, User user){
        cartService.checkEmptyCart();
        System.out.println("Nhập thông tin đơn hàng: ");
        System.out.println("Địa chỉ giao hàng: ");
        String shippingAddress = scanner.nextLine();
        LocalDateTime orderDate = LocalDateTime.now();
        System.out.println("Đơn hàng của bạn: ");
        cartService.displayCart();
        System.out.println("Xác nhận đơn hàng: (Y/N)");
        String confirm = scanner.nextLine();
        while (!confirm.equalsIgnoreCase("Y") && !confirm.equalsIgnoreCase("N")){
            System.out.println("Lựa chọn bạn nhập không hợp lệ. Vui lòng thử lại.");
            confirm = scanner.nextLine();
        }
        if (confirm.equalsIgnoreCase("Y")){
            for (Map.Entry<Integer, Integer> entry : Database.productsCart.entrySet()) {
                int id = entry.getKey();
                int quantityCart = entry.getValue();
                Product product = productService.findProductById(id);
                if (product != null){
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
    private BigDecimal calculateTotalPrice(){
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer, Integer> entry : Database.productsCart.entrySet()) {
            int id = entry.getKey();
            int quantityCart = entry.getValue();
            Product product = productService.findProductById(id);
            if (product != null){
                BigDecimal quantity = new BigDecimal(quantityCart);
                totalPrice = totalPrice.add(product.getPrice().multiply(quantity));
            }
        }
        return totalPrice;
    }
//    Hiển thị lịch sử mua hàng của người mua
    public void displayPurchaseHistory(User user){
        System.out.println("Lịch sử mua hàng của người dùng " +user.getUsername()+ " :");
        List<Order> ordersBuyer = findAllOrderByBuyer(user);
        if (ordersBuyer.isEmpty()){
            System.out.println("Lịch sử giao dịch của bạn trống");
        } else {
            for (Order order : ordersBuyer) {
                System.out.println(order);
            }
        }

    }
//    Tìm kiếm đơn hàng bằng tên người mua
    private List<Order> findAllOrderByBuyer(User user){
        List<Order> ordersBuyer = new ArrayList<>();
        for (Order order: Database.orders){
            if (order.getBuyer().equalsIgnoreCase(user.getUsername())){
                ordersBuyer.add(order);
            }
        }
        return ordersBuyer;
    }
//    Hiển thị đơn hàng của người bán sau khi người mua đã xác nhận đơn hàng
    public void displayOrder(User user){
        System.out.println("Danh sách đơn hàng của người dùng " +user.getUsername()+ " :");
        boolean hasOrders = false;
        for (Order order: Database.orders){
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
    public void displayRevenue(User user){
        BigDecimal totalRevenue = new BigDecimal(0);
        Map<String, Integer> productSaleCount = new HashMap<>();
        for (Order order: Database.orders){
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
        System.out.println("Doanh thu của người bán " +user.getUsername()+ " : " +totalRevenue);
        System.out.println("Số lượng sản phẩm đã bán: ");
        for (Map.Entry<String, Integer> entry : productSaleCount.entrySet()) {
            System.out.println("Sản phẩm: " + entry.getKey() + ", Số lượng đã bán: " + entry.getValue());
        }
    }
//    Thanh toán
    private void payment(Order order, Scanner scanner){
        System.out.println("Thanh toán đơn hàng: ");
        System.out.println("Nhập thông tin tài khoản ngân hàng:");
        System.out.println("Tên ngân hàng: ");
        String bankName = scanner.nextLine();
        while (bankName.equalsIgnoreCase("")){
            System.out.println("Vui lòng nhập tên ngân hàng: ");
            bankName = scanner.nextLine();
        }
        System.out.println("Số tài khoản: ");
        String accountNumber = scanner.nextLine();
        while (accountNumber.equalsIgnoreCase("")){
            System.out.println("Vui lòng nhập tên ngân hàng: ");
            accountNumber = scanner.nextLine();
        }
        System.out.println("Chuyển khoản thành công.");
        order.setOrderStatus("Đã thanh toán.");
    }
//    Người bán xử lý đơn hàng
    public void processOrder(Scanner scanner){
        System.out.println("Nhập ID đơn hàng muốn xử lý: ");
        int id = Utils.inputInt(scanner);

    }
}


