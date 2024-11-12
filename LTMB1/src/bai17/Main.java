package bai17;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập 1 chuỗi: ");
        String inputString = scanner.nextLine();
        System.out.println("Nhập 1 ký tự: ");
        char checkChar = scanner.nextLine().charAt(0);
        int position = inputString.indexOf(checkChar);
        if (position != -1) {
            System.out.println("Ký tự '" + checkChar + "' xuất hiện lần đầu tại vị trí: " + position);
        } else {
            System.out.println("Ký tự không có trong chuỗi.");
        }
    }
}
