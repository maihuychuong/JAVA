package service;

import entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserService {
    List<User> users = new ArrayList<>();

    public User register(Scanner scanner) {
        String username;
        do {
            System.out.println("Nhập username: ");
            username = scanner.nextLine();
            if (existUsername(username)) {
                System.out.println("Username đã tồn tại. Vui lòng thử lại với một username khác.");
            }
        } while (existUsername(username));

        String email;
        do {
            System.out.println("Nhập email: ");
            email = scanner.nextLine();
            if (!conditionEmail(email)) {
                System.out.println("Email không hợp lệ. Vui lòng thử lại.");
            }
        } while (!conditionEmail(email));

        String password;
        do {
            System.out.println("Nhập password: ");
            password = scanner.nextLine();
            if (!conditionPassword(password)) {
                System.out.println("Password không hợp lệ. Vui lòng thử lại.");
            }
        } while (!conditionPassword(password));
        User newUser = new User(username, email, password);
        users.add(newUser);
        System.out.println("Đăng ký thành công!");
        return newUser;
    }

    private boolean conditionEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@[\\w-]+\\.[a-z]{2,4}$";
        return Pattern.matches(emailRegex, email);
    }

    public boolean conditionPassword(String password) {
        String passwordRegex = "^(?=.*[A-Z])(?=.*[!@#$&*.-_])[A-Za-z0-9!@#$&*.-_]{7,15}$";
        return Pattern.matches(passwordRegex, password);
    }

    private boolean existUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    private boolean existEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    public User checkUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public User changeUsername(User user, Scanner scanner) {
        String newUsername;
        do {
            System.out.println("Nhập username mới: ");
            newUsername = scanner.nextLine();
            if (existUsername(newUsername)) {
                System.out.println("Username đã tồn tại. Vui lòng thử lại.");
            }
        } while (existUsername(newUsername));
        user.setUsername(newUsername);
        System.out.println("Thay đổi username thành công!");
        return user;
    }

    public User changeEmail(User user, Scanner scanner) {
        String newEmail;
        do {
            System.out.println("Nhập email mới: ");
            newEmail = scanner.nextLine();
            if (!conditionEmail(newEmail)) {
                System.out.println("Email không hợp lệ. Vui lòng thử lại.");
            } else if (existEmail(newEmail)) {
                System.out.println("Email đã tồn tại. Vui lòng thử lại.");
            }
        } while (!conditionEmail(newEmail) || existEmail(newEmail));
        user.setEmail(newEmail);
        System.out.println("Thay đổi email thành công!");
        return user;
    }

    public User changePassword(User user, Scanner scanner) {
        String newPassword;
        do {
            System.out.println("Nhập mật khẩu mới: ");
            newPassword = scanner.nextLine();
            if (!conditionPassword(newPassword)) {
                System.out.println("Password không hợp lệ. Vui lòng thử lại.");
            }
        } while (!conditionPassword(newPassword));
        user.setPassword(newPassword);
        System.out.println("Thay đổi mật khẩu thành công!");
        return user;
    }

    public User resetPasswordEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }
}


