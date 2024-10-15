package store.service;

import store.data.Database;
import store.entities.Product;
import store.entities.User;
import store.utils.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CartService {
    ProductService productService = new ProductService();

    //    Thêm sản phẩm vào giỏ hàng
    public void addProductToCart(Scanner scanner, User user) {
        System.out.println("Nhập ID sản phẩm muốn thêm vào giỏ hàng: ");
        int id = Utils.inputInt(scanner);
        Product product = productService.findProductById(id);
        while (product == null) {
            System.out.println("Sản phẩm không tồn tại. Vui lòng thử lại.");
            id = Utils.inputInt(scanner);
            product = productService.findProductById(id);
        }
        System.out.println("Nhập số lượng sản phẩm muốn mua: ");
        int quantity = Utils.inputInt(scanner);
        while (quantity > product.getQuantity() || quantity <= 0) {
            if (quantity <= 0) {
                System.out.println("Số lượng muốn mua phải lớn hơn 0. Vui lòng thử lại.");
            } else {
                System.out.println("Số lượng muốn mua vượt quá số lượng hàng còn lại. Vui lòng thử lại.");
            }
            quantity = Utils.inputInt(scanner);
        }
        Map<Integer, Integer> currentCart = Database.userCarts.getOrDefault(user.getUsername(), new HashMap<>());
        if (currentCart.containsKey(id)) {
            int currentQuantity = currentCart.get(id);
            currentCart.put(id, currentQuantity + quantity);
        } else {
            currentCart.put(id, quantity);
        }
        Database.userCarts.put(user.getUsername(), currentCart);
        System.out.println("Đã thêm " + quantity + " sản phẩm " + product.getName() + " vào giỏ hàng của bạn.");
    }

    //    Xóa sản phẩm khỏi giỏ hàng
    public void removeProductFromCart(Scanner scanner, User user) {
        System.out.println("Nhập ID sản phẩm muốn xóa khỏi giỏ hàng: ");
        int id = Utils.inputInt(scanner);
        Map<Integer, Integer> currentCart = Database.userCarts.get(user.getUsername());
        if (currentCart == null || currentCart.isEmpty()) {
            System.out.println("Giỏ hàng của bạn đang trống.");
            return;
        }
        if (currentCart.containsKey(id)) {
            currentCart.remove(id);
            System.out.println("Đã xóa sản phẩm với ID " + id + " thành công khỏi giỏ hàng.");
            Database.userCarts.put(user.getUsername(), currentCart);
        } else {
            System.out.println("Không có sản phẩm với ID " + id + " trong giỏ hàng của bạn.");
        }
    }

    //    Hiển thị các sản phẩm có trong giỏ hàng
    public void displayCart(User user) {
        System.out.println("Giỏ hàng của bạn: ");
        Map<Integer, Integer> currentCart = Database.userCarts.get(user.getUsername());
        if (currentCart == null || currentCart.isEmpty()) {
            System.out.println("Giỏ hàng của bạn đang trống.");
            return;
        }
        for (Map.Entry<Integer, Integer> entry : currentCart.entrySet()) {
            int id = entry.getKey();
            int quantity = entry.getValue();
            Product product = productService.findProductById(id);
            if (product != null) {
                System.out.println("ID: " + id + " , Tên: " + product.getName() + " , Số lượng: " + quantity);
            } else {
                System.out.println("Sản phẩm với ID: " + id + " không còn tồn tại.");
            }
        }
    }

    //    Kiểm tra xem giỏ hàng có trống hay không
    public void checkEmptyCart(User user) {
        Map<Integer, Integer> currentCart = Database.userCarts.get(user.getUsername());
        if (currentCart == null || currentCart.isEmpty()) {
            throw new IllegalStateException("Giỏ hàng của bạn đang trống. Không thể tiếp tục.");
        }
    }

    //   Xóa toàn bộ sản phẩm khỏi giỏ hàng (Hủy giỏ hàng)
    public void deleteCart(User user) {
        Map<Integer, Integer> currentCart = Database.userCarts.get(user.getUsername());
        if (currentCart == null || currentCart.isEmpty()) {
            System.out.println("Giỏ hàng của bạn đã trống.");
        } else {
            currentCart.clear();
            System.out.println("Giỏ hàng đã được xóa thành công.");
        }
    }
}
