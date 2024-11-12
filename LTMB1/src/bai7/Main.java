package bai7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập 1 số nguyên: ");
        int n = Integer.parseInt(scanner.nextLine());
        for ( int i = 1; i <= 20; i++){
            System.out.println("Kết quả " +n+ " nhân với " +i+ " là: " +(n*i));
        }
    }
}