package bai6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập 1 số nguyên nguyên dương: ");
        int n = Integer.parseInt(scanner.nextLine());
        while (n <= 0 ){
            System.out.println("Số vừa nhập <= 0. Vui lòng nhập lại.");
            n = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Tổng các số chẵn trong khoảng từ 0 đến " +n+ " là:" +calculateEvenSum(n));
    }

    private static int calculateEvenSum(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i += 2) {
            sum += i;
        }
        return sum;
    }
}