package store.utils;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Utils {
    //    Check hợp lệ của email
    public static boolean conditionEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@[\\w-]+\\.[a-z]{2,4}$";
        return Pattern.matches(emailRegex, email);
    }

    //    Check hợp lệ của mật khẩu
    public static boolean conditionPassword(String password) {
        String passwordRegex = "^(?=.*[A-Z])(?=.*[!@#$&*.-_])[A-Za-z0-9!@#$&*.-_]{7,15}$";
        return Pattern.matches(passwordRegex, password);
    }

    //    Check hợp lệ của số tài khoản ngân hàng
    public static boolean conditionAccountNumber(String accountNumber) {
        String accountNumberRegex = "^[0-9]{8,15}$";
        return Pattern.matches(accountNumberRegex, accountNumber);
    }

    //    Kiểm tra xem kiểu dữ liệu vừa nhập đã đúng kiểu dữ liệu int hay chưa
    public static int inputInt(Scanner scanner) {
        while (true) {
            try {
                int n = Integer.parseInt(scanner.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println("Sai định dạng. Vui lòng nhập lại");
            }
        }
    }

    //    Kiểm tra xem nội dung nhập có trống hay không
    public static String inputString(Scanner scanner) {
        String input = scanner.nextLine();
        while (input.isEmpty()) {
            System.out.println("Không thể để trống chố này. Vui lòng nhập lại.");
            input = scanner.nextLine();
        }
        return input;
    }
}
