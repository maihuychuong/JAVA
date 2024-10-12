package store.service;

import store.data.Database;
import store.entities.Product;
import store.utils.Utils;

import java.util.Map;
import java.util.Scanner;

public class CartService {
    ProductService productService = new ProductService();

    //    Thêm sản phẩm vào giỏ hàng
    public void addProductToCart(Scanner scanner) {
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
        if (Database.productsCart.containsKey(id)) {
            int currentQuantity = Database.productsCart.get(id);
            Database.productsCart.put(id, currentQuantity + quantity);
        } else {
            Database.productsCart.put(id, quantity);
        }
        System.out.println("Đã thêm " + quantity + " sản phẩm " + product.getName() + " thành công vào giỏ hàng.");
    }

    //    Xóa sản phẩm khỏi giỏ hàng
    public void removeProductFromCart(Scanner scanner) {
        System.out.println("Nhập ID sản phẩm muốn xóa khỏi giỏ hàng: ");
        int id = Utils.inputInt(scanner);
        if (Database.productsCart.containsKey(id)) {
            Database.productsCart.remove(id);
            System.out.println("Đã xóa sản phẩm với id " + id + " thành công.");
        } else {
            System.out.println("Không có sản phẩm với id " + id + " trong giỏ hàng.");
        }
    }

    //    Hiển thị các sản phẩm có trong giỏ hàng
    public void displayCart() {
        System.out.println("Giỏ hàng của bạn: ");
        checkEmptyCart();
        for (Map.Entry<Integer, Integer> entry : Database.productsCart.entrySet()) {
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
    public void checkEmptyCart() {
        if (Database.productsCart.isEmpty()) {
            System.out.println("Không có sản phẩm nào trong giỏ hàng của bạn.");
        }
    }

    //   Xóa toàn bộ sản phẩm khỏi giỏ hàng (Hủy giỏ hàng)
    public void deleteCart() {
        checkEmptyCart();
        Database.productsCart.clear();
    }
}
