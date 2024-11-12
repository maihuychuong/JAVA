package bai11;

import javax.sound.midi.Soundbank;
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
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        double avgSum = (double) sum /n;
        System.out.println("Trung bình cộng của các số trong mảng là: " +avgSum);
    }
}