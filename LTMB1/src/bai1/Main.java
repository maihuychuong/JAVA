package bai1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập 1 số nguyên: ");
        int n = Integer.parseInt(scanner.nextLine());
        if (n >= 0){
            System.out.println("Đây là số nguyên dương.");
        } else {
            System.out.println("Đây là số nguyên âm");
        }
    }
}