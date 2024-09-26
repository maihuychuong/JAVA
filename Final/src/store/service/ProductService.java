package store.service;

import store.data.Database;
import store.entities.Product;
import store.utils.Utils;

import java.util.Scanner;

public class ProductService {
    public void addProduct(Scanner scanner) {
        System.out.println("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Nhập giá: ");
        double price = Utils.inputDouble(scanner);
        System.out.println("Nhập mô tả về sản phẩm: ");
        String description = scanner.nextLine();
        System.out.println("Nhập số lượng: ");
        int amount = Utils.inputInt(scanner);
        System.out.println("Nhập tên người bán: ");
        String seller = scanner.nextLine();
        Database.products.add(new Product(name, price, description, amount, seller));
    }

    public void editProduct(Scanner scanner, boolean update) {
        System.out.println("Nhập id sản phẩm cần tìm: ");
        int id = Utils.inputInt(scanner);
        Product product = findProductById(id);
        while (product == null) {
            System.out.println("Sản phẩm nhập không tồn tại");
        }
        if (update) {
            System.out.println("NHập thông tin mới của sản phẩm");
            System.out.println("Nhập tên sản phẩm: ");
            String name = scanner.nextLine();
            System.out.println("Nhập giá: ");
            double price = Utils.inputDouble(scanner);
            System.out.println("Nhập mô tả về sản phẩm: ");
            String description = scanner.nextLine();
            System.out.println("Nhập số lượng: ");
            int amount = Utils.inputInt(scanner);
            System.out.println("Nhập tên người bán: ");
            String seller = scanner.nextLine();
            product.setName(name);
            product.setPrice(price);
            product.setDescription(description);
            product.setAmount(amount);
            product.setSeller(seller);
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
