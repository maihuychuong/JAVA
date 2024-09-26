package store.view;

import store.data.Database;
import store.entities.User;
import store.service.ProductService;
import store.service.UserService;
import store.utils.Utils;

import java.util.Scanner;

public class Menu {
    UserService userService = new UserService();
    ProductService productService = new ProductService();

    public void preLogin(Scanner scanner) {
        System.out.println("1 - Đăng nhập");
        System.out.println("2 - Đăng ký");
        System.out.println("3 - Thoát chương trình");
        System.out.println("Mời lựa chọn: ");
        selectPreLogin(scanner);
    }

    private void selectPreLogin(Scanner scanner) {
        int choice = Utils.inputInt(scanner);
        switch (choice) {
            case 1:
                System.out.println("Thực hiện login");
                User user = userService.login(scanner);
                if (user != null) {
                    System.out.println("Chào mừng " + user.getUsername() + " , bạn có thể thực hiện các công việc sau: ");
                    postLogin(scanner, user);
                } else {
                    System.out.println("Username hoặc password không đúng");
                    forgotPassword(scanner);
                }
                break;
            case 2:
                System.out.println("Thực hiện đăng ký");
                userService.register(scanner);
                preLogin(scanner);
                break;
            case 3:
                System.exit(0);
        }
    }

    private void postLogin(Scanner scanner, User user) {
        System.out.println("1 - Hiển thị menu");
        System.out.println("2 - Cập nhật tài khoản cá nhân");
        System.out.println("3 - Đăng xuất");
        System.out.println("Mời lựa chọn: ");
        selectPostLogin(scanner, user);
    }

    private void selectPostLogin(Scanner scanner, User user) {
        int choice = Utils.inputInt(scanner);
        switch (choice) {
            case 1:
                System.out.println("Thực hiện hiển thị menu");
                if ("Seller".equalsIgnoreCase(user.getRole())) {
                    sellerMenu(scanner, user);
                } else if ("Customer".equalsIgnoreCase(user.getRole())) {
                    customerMenu(scanner, user);
                } else if ("Admin".equalsIgnoreCase(user.getRole())) {
                    sellerMenu(scanner, user);
                }
                break;
            case 2:
                System.out.println("Thực hiện cập nhập tài khoản cá nhân");
                userMenu(scanner, user);
                break;
            case 3:
                System.out.println("Thực hiện đăng xuất");
                preLogin(scanner);
        }
    }

    private void userMenu(Scanner scanner, User user) {
        System.out.println("1 - Thay đổi username");
        System.out.println("2 - Thay đổi email");
        System.out.println("3 - Thay đổi password");
        System.out.println("4 - Quay lại");
        System.out.println("Mời lựa chọn: ");
        selectUserMenu(scanner, user);
    }

    private void selectUserMenu(Scanner scanner, User user) {
        int choice = Utils.inputInt(scanner);
        switch (choice) {
            case 1:
                System.out.println("Thực hiện thay đổi username: ");
                userService.changeUsername(scanner, user);
                System.out.println("Username đã được thay đổi thành công.");
                break;
            case 2:
                System.out.println("Thực hiện thay đổi email: ");
                userService.changeEmail(scanner, user);
                System.out.println("Email đã được thay đổi thành công.");
                break;
            case 3:
                System.out.println("Thực hiện thay đổi password: ");
                userService.changePassword(scanner, user);
                System.out.println("Password đã được thay đổi thành công.");
                break;
            case 4:
                System.out.println("Thực hiện quay lại");
                postLogin(scanner, user);
        }
    }

    private void forgotPassword(Scanner scanner) {
        System.out.println("1 - Đăng nhập lại.");
        System.out.println("2 - Quên mật khẩu");
        System.out.println("Mời lựa chọn: ");
        selectForgotPassword(scanner);
    }

    private void selectForgotPassword(Scanner scanner) {
        int choice = Utils.inputInt(scanner);
        switch (choice) {
            case 1:
                System.out.println("Vui lòng đăng nhập lại: ");
                userService.login(scanner);
                break;
            case 2:
                System.out.println("Thực hiện reset password: ");
                userService.resetPassword(scanner);
                System.out.println("Password đã được thay đổi thành công. Vui lòng đăng nhập lại: ");
                userService.login(scanner);
        }
    }

    private void sellerMenu(Scanner scanner, User user) {
        while (true) {
            System.out.println("1 - Quản lý sản phẩm");
            System.out.println("2 - Quản lý đơn hàng");
            System.out.println("3 - Xem doanh thu");
            System.out.println("4 - Quay lại");
            System.out.println("Mời lựa chọn: ");
            selectSellerMenu(scanner, user);
        }
    }

    private void selectSellerMenu(Scanner scanner, User user) {
        int choice = Utils.inputInt(scanner);
        switch (choice) {
            case 1:
                productSellerMenu(scanner, user);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                postLogin(scanner, user);
        }
    }

    private void productSellerMenu(Scanner scanner, User user) {
        while (true) {
            System.out.println("1 - Hiển thị danh sách sản phẩm");
            System.out.println("2 - Thêm sản phẩm");
            System.out.println("3 - Cập nhât sản phẩm");
            System.out.println("4 - Xóa sản phẩm");
            System.out.println("5 - Quay lại");
            System.out.println("Mời lựa chọn: ");
            selectProductSellerMenu(scanner, user);
        }
    }

    private void selectProductSellerMenu(Scanner scanner, User user) {
        int choice = Utils.inputInt(scanner);
        switch (choice) {
            case 1:
                System.out.println("Thực hiện hiển thị danh sách sản phẩm");
                System.out.println(Database.products);
                break;
            case 2:
                System.out.println("Thực hiện thêm sản phẩm");
                productService.addProduct(scanner);
                System.out.println("Thêm sản phẩm thành công");
                break;
            case 3:
                System.out.println("Thực hiện cập nhật sản phẩm");
                productService.editProduct(scanner, true);
                System.out.println("Cập nhật sản phẩm thành công");
                break;
            case 4:
                System.out.println("Thực hiện xóa sản phẩm");
                productService.editProduct(scanner, false);
                System.out.println("Xóa sản phẩm thành công");
                break;
            case 5:
                sellerMenu(scanner, user);
        }
    }

    private void customerMenu(Scanner scanner, User user) {
        while (true) {
            System.out.println("1 - Danh sách sản phẩm");
            System.out.println("2 - Quản lý giỏ hàng");
            System.out.println("3 - Thanh toán");
            System.out.println("4 - Xem lịch sử mua hàng");
            System.out.println("5 - Quay lại");
            System.out.println("Mời lựa chọn: ");
            selectCustomerMenu(scanner, user);
        }
    }

    private void selectCustomerMenu(Scanner scanner, User user) {
        int choice = Utils.inputInt(scanner);
        switch (choice) {
            case 1:
                productCustomerMenu(scanner, user);
                break;
            case 2:
                cartMenu(scanner, user);
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                postLogin(scanner, user);
        }
    }

    private void productCustomerMenu(Scanner scanner, User user) {
        while (true) {
            System.out.println("1 - Hiển thị danh sách sản phẩm");
            System.out.println("2 - Tìm kiếm sản phầm theo tên");
            System.out.println("2 - Tìm kiếm sản phầm theo khoảng giá");
            System.out.println("2 - Tìm kiếm sản phầm theo tên người bán");
            System.out.println("5 - Quay lại");
            System.out.println("Mời lựa chọn: ");
            selectProductCustomerMenu(scanner, user);
        }
    }

    private void selectProductCustomerMenu(Scanner scanner, User user) {
        int choice = Utils.inputInt(scanner);
        switch (choice) {
            case 1:
                System.out.println("Thực hiện hiển thị danh sách sản phẩm");
                System.out.println(Database.products);
                break;
            case 2:
                System.out.println("Thực hiện tìm kiếm sản phầm theo tên");
                productService.filterByName(scanner);
                break;
            case 3:
                System.out.println("Thực hiện tìm kiếm sản phầm theo khoảng giá");
                filterByPrice(scanner, user);
                break;
            case 4:
                System.out.println("Thực hiện tìm kiếm sản phầm theo tên người bán");
                productService.findProductBySeller(scanner);
                break;
            case 5:
                postLogin(scanner, user);
        }
    }

    private void filterByPrice(Scanner scanner, User user) {
        while (true) {
            System.out.println("1 - Dưới 100.000Đ");
            System.out.println("2 - 100.000 -> 500.000Đ");
            System.out.println("3 - Trên 500.000Đ");
            System.out.println("4 - Quay lại");
            System.out.println("Mời lựa chọn: ");
            selectFilterPrice(scanner, user);
        }

    }

    private void selectFilterPrice(Scanner scanner, User user) {
        int choice = Utils.inputInt(scanner);
        switch (choice) {
            case 1:
                System.out.println("Danh sách sản phẩm dưới 100.000Đ: ");
                productService.findProductByPriceLow();
                break;
            case 2:
                System.out.println("Danh sách sản phẩm từ 100.000 đến 500.000Đ: ");
                productService.findProductByPriceMed();
                break;
            case 3:
                System.out.println("Danh sách sản phẩm trên 500.000Đ: ");
                productService.findProductByPriceHigh();
                break;
            case 4:
                productCustomerMenu(scanner, user);
        }
    }
    private void cartMenu(Scanner scanner, User user){
        while (true){
            System.out.println("1 - Thêm sản phẩm");
            System.out.println("2 - Xóa sản phẩm");
            System.out.println("3 - Danh sách sản phẩm đã thêm vào giỏ hàng");
            System.out.println("4 - Xác nhận đơn hàng");
            System.out.println("5 - Hủy đơn hàng");
            System.out.println("6 - Quay lại");
            System.out.println("Mời lựa chọn: ");
            selectCartMenu(scanner, user);
        }

    }
    private void selectCartMenu(Scanner scanner, User user){
        int choice = Utils.inputInt(scanner);
        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                customerMenu(scanner, user);
        }
    }
}
