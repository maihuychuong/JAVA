package store.view;

import store.data.Database;
import store.entities.User;
import store.service.ProductService;
import store.service.UserService;

import java.util.Scanner;

public class Menu {
    UserService userService = new UserService();
    ProductService productService = new ProductService();

    public void preLogin(Scanner scanner){
        System.out.println("1 - Đăng nhập");
        System.out.println("2 - Đăng ký");
        System.out.println("3 - Thoát chương trình");
        System.out.println("Mời lựa chọn: ");
        selectPreLogin(scanner);
    }
    private void selectPreLogin(Scanner scanner){
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                System.out.println("Thực hiện login");
                User user = userService.login(scanner);
                if(user != null){
                    System.out.println("Chào mừng "+user.getUsername()+" , bạn có thể thực hiện các công việc sau: ");
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

    private void postLogin(Scanner scanner, User user){
        System.out.println("1 - Hiển thị menu");
        System.out.println("2 - Cập nhật tài khoản cá nhân");
        System.out.println("3 - Đăng xuất");
        System.out.println("Mời lựa chọn: ");
        selectPostLogin(scanner, user);
    }
    private void selectPostLogin(Scanner scanner, User user){
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                System.out.println("Thực hiện hiển thị menu");
                if ("Seller".equalsIgnoreCase(user.getRole())){
                    sellerMenu(scanner, user);
                } else if ("Customer".equalsIgnoreCase(user.getRole())){
                    sellerMenu(scanner, user);
                } else if ("Admin".equalsIgnoreCase(user.getRole())){
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

    private void userMenu(Scanner scanner, User user){
        System.out.println("1 - Thay đổi username");
        System.out.println("2 - Thay đổi email");
        System.out.println("3 - Thay đổi password");
        System.out.println("4 - Quay lại");
        System.out.println("Mời lựa chọn: ");
        selectUserMenu(scanner, user);
    }

    private void selectUserMenu(Scanner scanner, User user){
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
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
    private void forgotPassword(Scanner scanner){
        System.out.println("1 - Đăng nhập lại.");
        System.out.println("2 - Quên mật khẩu");
        System.out.println("Mời lựa chọn: ");
        selectForgotPassword(scanner);
    }
    private void selectForgotPassword(Scanner scanner){
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
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

    private void sellerMenu(Scanner scanner, User user){
        while (true){
            System.out.println("1 - Quản lý sản phẩm");
            System.out.println("2 - Quản lý đơn hàng");
            System.out.println("3 - Xem doanh thu");
            System.out.println("4 - Quay lại");
            System.out.println("Mời lựa chọn: ");
            selectSellerMenu(scanner, user);
        }
    }
    private void selectSellerMenu(Scanner scanner, User user){
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                productMenu(scanner, user);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                postLogin(scanner, user);
        }
    }
    private void productMenu(Scanner scanner, User user){
        while (true){
            System.out.println("1 - Hiển thị danh sách sản phẩm");
            System.out.println("2 - Thêm sản phẩm");
            System.out.println("3 - Cập nhât sản phẩm");
            System.out.println("4 - Xóa sản phẩm");
            System.out.println("5 - Quay lại");
            System.out.println("Mời lựa chọn: ");
            selectProductMenu(scanner, user);
        }
    }
    private void selectProductMenu(Scanner scanner, User user){
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
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
}
