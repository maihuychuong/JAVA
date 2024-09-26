package store.service;

import store.data.Database;
import store.entities.Product;
import store.utils.Utils;

import java.util.Scanner;

public class ProductService {
    public void addProduct(Scanner scanner) {
        System.out.println("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Nhập số lượng: ");
        int amount = Utils.inputInt(scanner);
        System.out.println("Nhập giá: ");
        double price = Utils.inputDouble(scanner);
        Database.products.add(new Product(name, amount, price));
    }

    public void editProduct(Scanner scanner, boolean update) {
        System.out.println("Nhập id sản phẩm cần sửa/xóa: ");
        int id = Utils.inputInt(scanner);
        Product product = findProductById(id);
        while (product == null) {
            System.out.println("Sản phẩm nhập không tồn tại");
        }
        if (update == true) {
            System.out.println("Nhập tên sản phẩm mới: ");
            String name = scanner.nextLine();
            System.out.println("Nhập số lượng mới: ");
            int amount = Utils.inputInt(scanner);
            System.out.println("Nhập giá mới: ");
            double price = Utils.inputDouble(scanner);
            product.setName(name);
            product.setAmount(amount);
            product.setPrice(price);
        } else {
            Database.products.remove(product);
        }
    }

    private Product findProductById(int id) {
        for (Product product : Database.products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
