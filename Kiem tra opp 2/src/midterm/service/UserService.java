package midterm.service;


import midterm.data.Database;
import midterm.entities.User;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UserService {

    public void register(Scanner scanner){
        System.out.println("Nhập username: ");
        String username = scanner.nextLine();
        System.out.println("Nhập email: ");
        String email = scanner.nextLine();
        System.out.println("Nhập password: ");
        String password = scanner.nextLine();
        if (!conditionEmail(email)) {
            System.out.println("Email không hợp lệ. Vui lòng nhập email đúng định dạng.");
            return;
        }
        if (!conditionPassword(password)) {
            System.out.println("Mật khẩu không hợp lệ. Mật khẩu phải chứa ít nhất 1 ký tự viết hoa, 1 ký tự đặc biệt và có độ dài từ 7 đến 15 ký tự.");
            return;
        }
        if(findUserByUsernameAndEmail(username, email) == null){
            Database.users.add(new User(username, password, email));
            System.out.println("Đăng lý thành công");
        } else {
            System.out.println("Username hoặc email đã tồn tại ");
        }
    }

    public User login(Scanner scanner){
        System.out.println("Nhập username: ");
        String username = scanner.nextLine();
        System.out.println("Nhập password: ");
        String password = scanner.nextLine();
        User user = findUserByUsernameAndPassword(username, password);
        if(user != null){
            return user;
        } else {
            return null;
        }
    }

    private boolean conditionEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@[\\w-]+\\.[a-z]{2,4}$";
        return Pattern.matches(emailRegex, email);
    }

    private boolean conditionPassword(String password) {
        String passwordRegex = "^(?=.*[A-Z])(?=.*[!@#$&*.-_])[A-Za-z0-9!@#$&*.-_]{7,15}$";
        return Pattern.matches(passwordRegex, password);
    }

    private User findUserByUsername(String username){
        for (User user: Database.users){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    private User findUserByEmail(String email){
        for (User user: Database.users){
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }
    private User findUserByUsernameAndPassword(String username, String password){
        for (User user: Database.users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    private User findUserByUsernameAndEmail(String username, String email){
        for (User user: Database.users){
            if(user.getUsername().equals(username) && user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }

    public void changeUsername(Scanner scanner, User user){
        System.out.println("Nhập username mới: ");
        String username = scanner.nextLine();
        while (findUserByUsername(username) != null) {
            System.out.println("Username đã tồn tại. Nhập lại username mới: ");
            username = scanner.nextLine();
        }
        user.setUsername(username);
        System.out.println("Username đã được thay đổi thành công.");
    }

    public void changeEmail(Scanner scanner, User user) {
        System.out.println("Nhập email mới: ");
        String email = scanner.nextLine();
        while (!conditionEmail(email) || findUserByEmail(email) != null) {
            if (!conditionEmail(email)) {
                System.out.println("Email không hợp lệ. Nhập lại email mới: ");
            } else {
                System.out.println("Email đã tồn tại. Nhập lại email mới: ");
            }
            email = scanner.nextLine();
        }
        user.setEmail(email);
    }

    public void changePassword(Scanner scanner, User user){
        System.out.println("Nhập password mới: ");
        String password = scanner.nextLine();
        while (!conditionPassword(password)){
            System.out.println("Password không hợp lệ. Nhập lại password mới: ");
            password = scanner.nextLine();
        }
        user.setPassword(password);
    }
    public void resetPassword(Scanner scanner){
        System.out.println("Nhập email của tài khoản cần reset mật khẩu: ");
        String email = scanner.nextLine();
        User user = findUserByEmail(email);
        while (user == null) {
            System.out.println("Email không tồn tại. Nhập lại email: ");
            email = scanner.nextLine();
            user = findUserByEmail(email);
        }
        changePassword(scanner, user);
    }
}
