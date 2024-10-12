package store.view;

import store.data.Database;
import store.entities.User;
import store.service.CartService;
import store.service.OrderService;
import store.service.ProductService;
import store.service.UserService;
import store.utils.Utils;

import java.util.Scanner;

public class Menu {
    UserService userService = new UserService();
    ProductService productService = new ProductService();
    CartService cartService = new CartService();
    OrderService orderService = new OrderService();

    //    Menu trước khi đăng nhập
    public void preLogin(Scanner scanner) {
        System.out.println("1 - Đăng nhập");
        System.out.println("2 - Đăng ký");
        System.out.println("3 - Thoát chương trình");
        System.out.println("Mời lựa chọn: ");
        selectPreLogin(scanner);
    }

    //    Lựa chọn Menu trước khi đăng nhập
    private void selectPreLogin(Scanner scanner) {
        int choice = Utils.inputInt(scanner);
        switch (choice) {
            case 1:
                System.out.println("Thực hiện login");
                User user = userService.login(scanner);
                if (user != null) {
                    if (user.isLocked()) {
                        System.out.println("Tài khoản của bạn đã bị khóa. Vui lòng liên hệ với admin.");
                    } else {
                        System.out.println("Chào mừng " + user.getUsername() + " , bạn có thể thực hiện các công việc sau: ");
                        postLogin(scanner, user);
                    }
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
                break;
            default:
                System.out.println("Lựa chọn của bạn không hợp lệ vui lòng chọn lại.");
                preLogin(scanner);
        }
    }

    //    Menu sau khi đăng nhập
    private void postLogin(Scanner scanner, User user) {
        System.out.println("1 - Hiển thị menu");
        System.out.println("2 - Cập nhật tài khoản cá nhân");
        System.out.println("3 - Đăng xuất");
        System.out.println("Mời lựa chọn: ");
        selectPostLogin(scanner, user);
    }

    //    Lựa chọn Menu sau khi đăng nhập
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
                    adminMenu(scanner, user);
                }
                break;
            case 2:
                System.out.println("Thực hiện cập nhập tài khoản cá nhân");
                userMenu(scanner, user);
                break;
            case 3:
                System.out.println("Thực hiện đăng xuất");
                preLogin(scanner);
                break;
            default:
                System.out.println("Lựa chọn của bạn không hợp lệ vui lòng chọn lại.");
                postLogin(scanner, user);
        }
    }

    //    Menu cập nhập tài khoản của người dùng
    private void userMenu(Scanner scanner, User user) {
        while (true) {
            System.out.println("1 - Thay đổi username");
            System.out.println("2 - Thay đổi email");
            System.out.println("3 - Thay đổi password");
            System.out.println("4 - Quay lại");
            System.out.println("Mời lựa chọn: ");
            selectUserMenu(scanner, user);
        }
    }

    //    Lựa chọn Menu cập nhập tài khoản của người dùng
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
                break;
            default:
                System.out.println("Lựa chọn của bạn không hợp lệ vui lòng chọn lại.");
                userMenu(scanner, user);
        }
    }

    //    Menu quên mật khẩu
    private void forgotPassword(Scanner scanner) {
        System.out.println("1 - Đăng nhập lại.");
        System.out.println("2 - Quên mật khẩu");
        System.out.println("Mời lựa chọn: ");
        selectForgotPassword(scanner);
    }

    //    Lựa chọn Menu quên mật khẩu
    private void selectForgotPassword(Scanner scanner) {
        int choice = Utils.inputInt(scanner);
        switch (choice) {
            case 1:
                System.out.println("Vui lòng đăng nhập lại: ");
                preLogin(scanner);
                break;
            case 2:
                System.out.println("Thực hiện reset password: ");
                userService.resetPassword(scanner);
                System.out.println("Password đã được thay đổi thành công. Vui lòng đăng nhập lại: ");
                userService.login(scanner);
                break;
            default:
                System.out.println("Lựa chọn của bạn không hợp lệ vui lòng chọn lại.");
                forgotPassword(scanner);
        }
    }

    //    Menu người bán
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

    //    Lựa chọn Menu người bán
    private void selectSellerMenu(Scanner scanner, User user) {
        int choice = Utils.inputInt(scanner);
        switch (choice) {
            case 1:
                productSellerMenu(scanner, user);
                break;
            case 2:
                orderMenu(scanner, user);
                break;
            case 3:
                System.out.println("Thực hiện hiển thị doanh thu của người bán: ");
                orderService.displayRevenueForSeller(user);
                break;
            case 4:
                postLogin(scanner, user);
                break;
            default:
                System.out.println("Lựa chọn của bạn không hợp lệ vui lòng chọn lại.");
                sellerMenu(scanner, user);
        }
    }

    //    Menu quản lí sản phẩm của người bán
    private void productSellerMenu(Scanner scanner, User user) {
        while (true) {
            System.out.println("1 - Hiển thị danh sách tất cả sản phẩm");
            System.out.println("2 - Hiển thị danh sách sản phẩm mình bán");
            System.out.println("3 - Thêm sản phẩm");
            System.out.println("4 - Cập nhât sản phẩm");
            System.out.println("5 - Xóa sản phẩm");
            System.out.println("6 - Quay lại");
            System.out.println("Mời lựa chọn: ");
            selectProductSellerMenu(scanner, user);
        }
    }

    //    Lựa chọn Menu quản lí sản phẩm của người bán
    private void selectProductSellerMenu(Scanner scanner, User user) {
        int choice = Utils.inputInt(scanner);
        switch (choice) {
            case 1:
                System.out.println("Thực hiện hiển thị danh sách tất cả sản phẩm");
                System.out.println(Database.products);
                break;
            case 2:
                System.out.println("Thực hiện hiển thị danh sách sản phẩm mình bán");
                productService.displaySellerProduct(user);
                break;
            case 3:
                System.out.println("Thực hiện thêm sản phẩm");
                productService.addProduct(scanner, user);
                System.out.println("Thêm sản phẩm thành công");
                break;
            case 4:
                System.out.println("Thực hiện cập nhật sản phẩm");
                productService.editProduct(scanner, true, user);
                System.out.println("Cập nhật sản phẩm thành công");
                break;
            case 5:
                System.out.println("Thực hiện xóa sản phẩm");
                productService.editProduct(scanner, false, user);
                System.out.println("Xóa sản phẩm thành công");
                break;
            case 6:
                sellerMenu(scanner, user);
                break;
            default:
                System.out.println("Lựa chọn của bạn không hợp lệ vui lòng chọn lại.");
                productSellerMenu(scanner, user);
        }
    }

    //    Menu quản lí đơn hàng của người bán
    private void orderMenu(Scanner scanner, User user) {
        while (true) {
            System.out.println("1 - Hiển thị danh sách đơn hàng");
            System.out.println("2 - Xử lý đơn hàng");
            System.out.println("3 - Quay lại");
            System.out.println("Mời lựa chọn: ");
            selectOrderMenu(scanner, user);
        }
    }

    //   Lựa chọn Menu quản lí đơn hàng của người bán
    private void selectOrderMenu(Scanner scanner, User user) {
        int choice = Utils.inputInt(scanner);
        switch (choice) {
            case 1:
                System.out.println("Thực hiện hiển thị danh sách đơn hàng");
                orderService.displayOrderForSeller(user);
                break;
            case 2:
                System.out.println("Thực hiện xử lý đơn hàng");
                orderService.processOrder(scanner, user);
                break;
            case 3:
                sellerMenu(scanner, user);
                break;
            default:
                System.out.println("Lựa chọn của bạn không hợp lệ vui lòng chọn lại.");
                orderMenu(scanner, user);
        }
    }

    //    Menu người mua
    private void customerMenu(Scanner scanner, User user) {
        while (true) {
            System.out.println("1 - Duyệt sản phẩm");
            System.out.println("2 - Quản lý giỏ hàng");
            System.out.println("3 - Xem lịch sử mua hàng");
            System.out.println("4 - Quay lại");
            System.out.println("Mời lựa chọn: ");
            selectCustomerMenu(scanner, user);
        }
    }

    //    Lựa chọn Menu người mua
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
                orderService.displayPurchaseHistory(user);
                break;
            case 4:
                postLogin(scanner, user);
                break;
            default:
                System.out.println("Lựa chọn của bạn không hợp lệ vui lòng chọn lại.");
                customerMenu(scanner, user);
        }
    }

    //    Menu duyệt sản phẩm
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

    //    Lựa chọn Menu duyệt sản phẩm
    private void selectProductCustomerMenu(Scanner scanner, User user) {
        int choice = Utils.inputInt(scanner);
        switch (choice) {
            case 1:
                System.out.println("Thực hiện hiển thị danh sách sản phẩm");
                System.out.println(Database.products);
                break;
            case 2:
                System.out.println("Thực hiện lọc sản phầm theo tên");
                productService.filterByName(scanner);
                break;
            case 3:
                System.out.println("Thực hiện lọc sản phầm theo khoảng giá");
                filterByPrice(scanner, user);
                break;
            case 4:
                System.out.println("Thực hiện lọc sản phầm theo tên người bán");
                productService.filterBySeller(scanner);
                break;
            case 5:
                postLogin(scanner, user);
                break;
            default:
                System.out.println("Lựa chọn của bạn không hợp lệ vui lòng chọn lại.");
                productCustomerMenu(scanner, user);
        }
    }

    //    Duyệt sản phẩm theo giá
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

    //    Lựa chọn duyệt sản phẩm theo giá
    private void selectFilterPrice(Scanner scanner, User user) {
        int choice = Utils.inputInt(scanner);
        switch (choice) {
            case 1:
                System.out.println("Danh sách sản phẩm có giá dưới 100.000Đ: ");
                productService.filterByPriceLow();
                break;
            case 2:
                System.out.println("Danh sách sản phẩm có giá từ 100.000 đến 500.000Đ: ");
                productService.filterByPriceMed();
                break;
            case 3:
                System.out.println("Danh sách sản phẩm có giá trên 500.000Đ: ");
                productService.filterByPriceHigh();
                break;
            case 4:
                productCustomerMenu(scanner, user);
                break;
            default:
                System.out.println("Lựa chọn của bạn không hợp lệ vui lòng chọn lại.");
                filterByPrice(scanner, user);
        }
    }

    //    Menu quản lí giỏ hàng
    private void cartMenu(Scanner scanner, User user) {
        while (true) {
            System.out.println("1 - Hiển thị danh sách sản phẩm");
            System.out.println("2 - Thêm sản phẩm");
            System.out.println("3 - Xóa sản phẩm");
            System.out.println("4 - Danh sách sản phẩm trong giỏ hàng");
            System.out.println("5 - Xác nhận đơn hàng");
            System.out.println("6 - Hủy giỏ hàng");
            System.out.println("7 - Quay lại");
            System.out.println("Mời lựa chọn: ");
            selectCartMenu(scanner, user);
        }

    }

    //    Lựa chọn Menu quản lí giỏ hàng
    private void selectCartMenu(Scanner scanner, User user) {
        int choice = Utils.inputInt(scanner);
        switch (choice) {
            case 1:
                System.out.println("Thực hiện hiển thị danh sách sản phẩm");
                System.out.println(Database.products);
                break;
            case 2:
                System.out.println("Thực hiện thêm sản phẩm vào đơn hàng");
                cartService.addProductToCart(scanner);
                break;
            case 3:
                System.out.println("Thực hiện xóa sản phẩm khỏi đơn hàng");
                cartService.removeProductFromCart(scanner);
                break;
            case 4:
                System.out.println("Thực hiện hiển thị các sản phẩm trong giỏ hàng");
                cartService.displayCart();
                break;
            case 5:
                System.out.println("Thực hiện xác nhận đơn hàng");
                orderService.confirmOrder(scanner, user);
                break;
            case 6:
                System.out.println("Thực hiện hủy giỏ hàng");
                cartService.deleteCart();
                System.out.println("Hủy giỏ hàng thành công");
                break;
            case 7:
                System.out.println("Nếu thoát giỏ hàng của bạn sẽ bị xóa tự động, bạn có muốn quay lại? (Y/N)");
                String confirm = Utils.inputString(scanner);
                while (!confirm.equalsIgnoreCase("Y") && !confirm.equalsIgnoreCase("N")) {
                    System.out.println("Lựa chọn bạn nhập không hợp lệ. Vui lòng thử lại.");
                    confirm = Utils.inputString(scanner);
                }
                if (confirm.equalsIgnoreCase("Y")){
                    cartService.deleteCart();
                    customerMenu(scanner, user);
                } else if (confirm.equalsIgnoreCase("N")){
                    cartMenu(scanner, user);
                }
                break;
            default:
                System.out.println("Lựa chọn của bạn không hợp lệ vui lòng chọn lại.");
                cartMenu(scanner, user);
        }
    }

    //    Menu admin
    private void adminMenu(Scanner scanner, User user) {
        while (true) {
            System.out.println("1 - Quản lí người dùng");
            System.out.println("2 - Quản lí sản phẩm");
            System.out.println("3 - Quản lí đơn hàng");
            System.out.println("4 - Thống kê doanh thu");
            System.out.println("5 - Quay lại");
            System.out.println("Mời lựa chọn: ");
            selectAdminMenu(scanner, user);
        }
    }

    //    Lựa chọn Menu admin
    private void selectAdminMenu(Scanner scanner, User user) {
        int choice = Utils.inputInt(scanner);
        switch (choice) {
            case 1:
                userManagerMenu(scanner, user);
                break;
            case 2:
                productManagerMenu(scanner, user);
                break;
            case 3:
                orderManagerMenu(scanner, user);
                break;
            case 4:
                System.out.println("Thực hiện thống kê doanh thu");
                orderService.displayRevenueForAdmin();
                break;
            case 5:
                postLogin(scanner, user);
                break;
            default:
                System.out.println("Lựa chọn của bạn không hợp lệ vui lòng chọn lại.");
                adminMenu(scanner, user);
        }
    }

    //    Menu quản lí người dùng admin
    private void userManagerMenu(Scanner scanner, User user) {
        while (true) {
            System.out.println("1 - Danh sách người dùng");
            System.out.println("2 - Thay đổi quyền của người dùng");
            System.out.println("3 - Khóa/Mở khóa tài khoản người dùng");
            System.out.println("4 - Quay lại");
            System.out.println("Mời lựa chọn: ");
            selectUserManagerMenu(scanner, user);
        }
    }

    //    Lựa chọn Menu quản lí người dùng admin
    private void selectUserManagerMenu(Scanner scanner, User user) {
        int choice = Utils.inputInt(scanner);
        switch (choice) {
            case 1:
                System.out.println("Thực hiển hiển thị danh sách người dùng");
                System.out.println(Database.users);
                break;
            case 2:
                System.out.println("Thực hiển thay đổi quyền của người dùng");
                userService.changeUserRole(scanner);
                break;
            case 3:
                System.out.println("Thực hiện Khóa/Mở khóa tài khoản người dùng");
                userService.lockUnlockAccount(scanner);
                break;
            case 4:
                adminMenu(scanner, user);
                break;
            default:
                System.out.println("Lựa chọn của bạn không hợp lệ vui lòng chọn lại.");
                userManagerMenu(scanner, user);
        }
    }

    //    Menu quản lí sản phẩm admin
    private void productManagerMenu(Scanner scanner, User user) {
        while (true) {
            System.out.println("1 - Danh sách sản phẩm");
            System.out.println("2 - Xóa sản phẩm");
            System.out.println("3 - Quay lại");
            System.out.println("Mời lựa chọn: ");
            selectProductManagerMenu(scanner, user);
        }
    }

    //    Lựa chọn Menu quản lí sản phẩm admin
    private void selectProductManagerMenu(Scanner scanner, User user) {
        int choice = Utils.inputInt(scanner);
        switch (choice) {
            case 1:
                System.out.println("Thực hiển hiển thị danh sách sản phẩm");
                System.out.println(Database.products);
                break;
            case 2:
                System.out.println("Thực hiển xóa sản phẩm");
                productService.editProduct(scanner, false, user);
                System.out.println("Xóa sant phẩm thành công");
                break;
            case 3:
                adminMenu(scanner, user);
                break;
            default:
                System.out.println("Lựa chọn của bạn không hợp lệ vui lòng chọn lại.");
                productManagerMenu(scanner, user);
        }
    }

    //    Menu quản lí đơn hàng admin
    private void orderManagerMenu(Scanner scanner, User user) {
        while (true) {
            System.out.println("1 - Danh sách đơn hàng");
            System.out.println("2 - Xóa đơn hàng");
            System.out.println("3 - Quay lại");
            System.out.println("Mời lựa chọn: ");
            selecOrderManagerMenu(scanner, user);
        }
    }

    //    Lựa chọn Menu quản lí đơn hàng admin
    private void selecOrderManagerMenu(Scanner scanner, User user) {
        int choice = Utils.inputInt(scanner);
        switch (choice) {
            case 1:
                System.out.println("Thực hiển hiển thị danh sách đơn hàng");
                System.out.println(Database.orders);
                break;
            case 2:
                System.out.println("Thực hiển xóa đơn hàng");
                orderService.deleteOrder(scanner);
                System.out.println("Xóa đơn hàng thành công");
                break;
            case 3:
                adminMenu(scanner, user);
                break;
            default:
                System.out.println("Lựa chọn của bạn không hợp lệ vui lòng chọn lại.");
                orderManagerMenu(scanner, user);
        }
    }
}
