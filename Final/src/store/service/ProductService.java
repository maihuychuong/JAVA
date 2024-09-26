package store.service;

import store.data.Database;
import store.entities.Product;
import store.utils.Utils;

import java.util.ArrayList;
import java.util.List;
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
        int quantity = Utils.inputInt(scanner);
        System.out.println("Nhập tên người bán: ");
        String seller = scanner.nextLine();
        Database.products.add(new Product(name, price, description, quantity, seller));
    }

    public void editProduct(Scanner scanner, boolean update) {
        System.out.println("Nhập id sản phẩm cần tìm: ");
        int id = Utils.inputInt(scanner);
        Product product = findProductById(id);
        while (product == null) {
            System.out.println("Sản phẩm không tồn tại");
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
            int quantity = Utils.inputInt(scanner);
            System.out.println("Nhập tên người bán: ");
            String seller = scanner.nextLine();
            product.setName(name);
            product.setPrice(price);
            product.setDescription(description);
            product.setQuantity(quantity);
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

    private Product findProductByName(String name) {
        for (Product product : Database.products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public void filterByName(Scanner scanner) {
        System.out.println("Nhập tên sản phẩm cần tìm: ");
        List<Product> productsName = new ArrayList<>();
        String name = scanner.nextLine();
        Product product = findProductByName(name);
        while (product == null) {
            System.out.println("Sản phẩm không tồn tại");
        }
        productsName.add(product);
        System.out.println(productsName);
    }

    public void findProductByPriceLow() {
        List<Product> productsPriceLow = new ArrayList<>();
        for (Product product : Database.products) {
            if (100000 > product.getPrice()) {
                productsPriceLow.add(product);
            }
        }
        System.out.println(productsPriceLow);
    }

    public void findProductByPriceMed() {
        List<Product> productsPriceMed = new ArrayList<>();
        for (Product product : Database.products) {
            if (100000 <= product.getPrice() && 500000 >= product.getPrice()) {
                productsPriceMed.add(product);
            }
        }
        System.out.println(productsPriceMed);
    }

    public void findProductByPriceHigh() {
        List<Product> productsPriceHigh = new ArrayList<>();
        for (Product product : Database.products) {
            if (500000 < product.getPrice()) {
                productsPriceHigh.add(product);
            }
        }
        System.out.println(productsPriceHigh);
    }

    private Product findProductBySeller(String seller) {
        for (Product product : Database.products) {
            if (product.getSeller().equalsIgnoreCase(seller)) {
                return product;
            }
        }
        return null;
    }

    public void findProductBySeller(Scanner scanner) {
        List<Product> productsSeller = new ArrayList<>();
        System.out.println("Nhập tên người bán: ");
        String seller = scanner.nextLine();
        Product product = findProductBySeller(seller);
        while (product == null) {
            System.out.println("Sản phẩm không tồn tại");
        }
        productsSeller.add(product);
        System.out.println(productsSeller);
    }
}
