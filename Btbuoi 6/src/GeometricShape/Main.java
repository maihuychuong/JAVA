package GeometricShape;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chiều dài hình chữ nhật: ");
        double chieuDai = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập chiều rộng hình chữ nhật: ");
        double chieuRong = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập cạnh hình vuông: ");
        double canh = Double.parseDouble(scanner.nextLine());
        HinhChuNhat hinhChuNhat = new HinhChuNhat(chieuDai, chieuRong);
        HinhVuong hinhVuong = new HinhVuong(canh);
        System.out.println();
        System.out.println(hinhChuNhat);
        System.out.println(hinhVuong);
    }
}
