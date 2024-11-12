package bai8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập 1 số nguyên (1-999): ");
        int n = Integer.parseInt(scanner.nextLine());
        while (n >= 1000 || n <= 0){
            System.out.println("Số vừa nhập k hợp lệ. Vui lòng nhập lại.");
            n = Integer.parseInt(scanner.nextLine());
        }
        int sum = 0;
        for (int i = 0; i <= n; i++){
            sum += i;
        }
        System.out.println("Tổng các số trong khoảng từ 0 dến " +n+ " là: " +sum);
    }
}