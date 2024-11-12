package bai3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập số đầu tiên: ");
        double a = Double.parseDouble(scanner.nextLine());
        System.out.println("Mời bạn nhập số thứ hai: ");
        double b = Double.parseDouble(scanner.nextLine());
        System.out.println("Mời bạn nhập số thứ ba: ");
        double c = Double.parseDouble(scanner.nextLine());
        if (a > 0 && b > 0 && c > 0){
            if ((a + b > c) || (a + c > b) || (b + c > a)) {
                System.out.println("Đây là tam giác");
            } else {
                System.out.println("Đây ko phải tam giác");
            }
        } else {
            System.out.println("Đây ko phải tam giác");
        }
    }
}