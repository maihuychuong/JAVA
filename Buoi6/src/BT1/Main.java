package BT1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập thông tin sản phẩm: id,name,price ");
        String id = scanner.nextLine();
        String name = scanner.nextLine();
        double price = Double.parseDouble(scanner.nextLine());
        Product product = new Product(id, name, price);
        double  tax = product.getPrice()/10;
        System.out.println(product);
        System.out.println("Tax: "+tax);
    }
}