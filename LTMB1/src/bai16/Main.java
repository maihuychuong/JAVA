package bai16;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập 1 chuỗi: ");
        String inputString = scanner.nextLine();
        System.out.println("Nhập 1 ký tự: ");
        char checkChar = scanner.nextLine().charAt(0);
        if (inputString.indexOf(checkChar) != -1) {
            System.out.println("Có");
        } else {
            System.out.println("Không");
        }
    }
}
