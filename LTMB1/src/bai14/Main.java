package bai14;

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
        int[] reversedArr = new int[n];
        for (int i = 0; i < n; i++) {
            reversedArr[i] = arr[n - 1 - i];
        }
        System.out.println(Arrays.toString(reversedArr));
    }
}