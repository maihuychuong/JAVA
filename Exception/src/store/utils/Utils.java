package store.utils;

import java.util.Scanner;

public class Utils {
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
