package bai9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập 1 số nguyên: ");
        int n = Integer.parseInt(scanner.nextLine());
        while (n > 20 || n < 0){
            System.out.println("Số vừa nhập k hợp lệ. Vui lòng nhập lại.");
            n = Integer.parseInt(scanner.nextLine());
        }
        if (n == 0 || n == 1) {
            System.out.println("1");
        } else {
            int a = 1, b = 1;
            int result = 1;
            for (int i = 2; i <= n; i++) {
                result = a + b;
                a = b;
                b = result;
            }
            System.out.println(result);
        }
    }
}