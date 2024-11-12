package bai19;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập 1 chuỗi: ");
        String inputString = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == 'a' || inputString.charAt(i) == 'A') {
                count++;
            }
        }
        System.out.println("Ký tự 'a' xuất hiện " + count + " lần trong chuỗi.");
    }
}
