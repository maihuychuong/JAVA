package store.utils;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Utils {
    public static boolean conditionEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@[\\w-]+\\.[a-z]{2,4}$";
        return Pattern.matches(emailRegex, email);
    }

    public static boolean conditionPassword(String password) {
        String passwordRegex = "^(?=.*[A-Z])(?=.*[!@#$&*.-_])[A-Za-z0-9!@#$&*.-_]{7,15}$";
        return Pattern.matches(passwordRegex, password);
    }
    public static int inputInt(Scanner scanner){
        while (true){
            try {
                int n = Integer.parseInt(scanner.nextLine());
                return n;
            }
            catch (Exception e){
                System.out.println("Sai định dạng. Vui lòng nhập lại");
            }
        }
    }

    public static double inputDouble(Scanner scanner){
        while (true){
            try {
                double n = Integer.parseInt(scanner.nextLine());
                return n;
            }
            catch (Exception e){
                System.out.println("Sai định dạng. Vui lòng nhập lại");
            }
        }
    }
}
