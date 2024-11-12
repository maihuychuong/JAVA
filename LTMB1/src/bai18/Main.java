package bai18;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập 1 chuỗi: ");
        String inputString = scanner.nextLine();
        boolean containsDigit = false;
        for (int i = 0; i < inputString.length(); i++) {
            if (Character.isDigit(inputString.charAt(i))) {
                containsDigit = true;
                break;
            }
        }
        if (containsDigit) {
            System.out.println("Có");
        } else {
            System.out.println("Không");
        }
    }
}
