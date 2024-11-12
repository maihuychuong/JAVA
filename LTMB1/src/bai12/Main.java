package bai12;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập 1 số nguyên: ");
        int n = Integer.parseInt(scanner.nextLine());
        while (n <= 0) {
            System.out.println("Số vừa nhập k hợp lệ. Vui lòng nhập lại.");
            n = Integer.parseInt(scanner.nextLine());
        }
        int[] arr = new int [n];
        for (int i = 0; i < n; i++){
            System.out.println("Nhập phần tử thứ " +(i + 1)+ " :");
            int num = Integer.parseInt(scanner.nextLine());
            arr[i] = num;
        }
        System.out.println(Arrays.toString(arr));
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Phần tử có giá trị lớn nhất là: " +max);
    }
}