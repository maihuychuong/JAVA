package store.service;

import store.data.Database;
import store.entities.Product;
import store.entities.User;
import store.utils.Utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService {
    public void addProduct(Scanner scanner, User user) {
        Product product = inputInfo(scanner, user);
        Database.products.add(product);
    }

    private Product inputInfo(Scanner scanner, User user){
        System.out.println("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Nhập giá: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());
        System.out.println("Nhập mô tả về sản phẩm: ");
        String description = scanner.nextLine();
        System.out.println("Nhập số lượng: ");
        int quantity = Utils.inputInt(scanner);
        return new Product(name, price, description, quantity, user.getUsername());
    }

    public void editProduct(Scanner scanner, boolean update, User user) {
        System.out.println("Nhập id sản phẩm cần tìm: ");
        int id = Utils.inputInt(scanner);
        Product product = findProductById(id);
        while (product == null) {
            System.out.println("Sản phẩm không tồn tại. Vui lòng thử lại.");
            id = Utils.inputInt(scanner);
            product = findProductById(id);
        }
        if (update) {
            System.out.println("Nhập thông tin mới của sản phẩm: ");
            Product updateProduct = inputInfo(scanner, user);
            product.setName(updateProduct.getName());
            product.setPrice(updateProduct.getPrice());
            product.setDescription(updateProduct.getDescription());
            product.setQuantity(updateProduct.getQuantity());
            product.setSeller(updateProduct.getSeller());
        } else {
            Database.products.remove(product);
        }
    }

    public Product findProductById(int id) {
        for (Product product : Database.products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    private List<Product> findAllProductsByName(String name) {
        List<Product> productsName = new ArrayList<>();
        for (Product product : Database.products) {
            if (product.getName().equalsIgnoreCase(name)) {
                productsName.add(product);
            }
        }
        return productsName;
    }

    public void filterByName(Scanner scanner) {
        System.out.println("Nhập tên sản phẩm cần tìm: ");
        String name = scanner.nextLine();
        List<Product> productsName = findAllProductsByName(name);
        if (productsName.isEmpty()) {
            System.out.println("Không có sản phẩm nào tên " +name);
        } else {
            System.out.println("Danh sách sản phẩm có tên " +name+ " :");
            System.out.println(productsName);
        }
    }

    private void findProductByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        List<Product> productsInRange = new ArrayList<>();
        for (Product product : Database.products) {
            BigDecimal productPrice = product.getPrice();
            if (productPrice.compareTo(minPrice) >= 0 && productPrice.compareTo(maxPrice) <= 0) {
                productsInRange.add(product);
            }
        }
        System.out.println(productsInRange);
    }
    public void filterByPriceLow() {
        findProductByPriceRange(new BigDecimal(0), new BigDecimal(99999));
    }

    public void filterByPriceMed() {
        findProductByPriceRange(new BigDecimal(100000), new BigDecimal(500000));
    }

    public void filterByPriceHigh() {
        findProductByPriceRange(new BigDecimal(500001), new BigDecimal(999999999));
    }

    private List<Product> findAllProductsBySeller(String seller) {
        List<Product> productsSeller = new ArrayList<>();
        for (Product product : Database.products) {
            if (product.getSeller().equalsIgnoreCase(seller)) {
                productsSeller.add(product);
            }
        }
        return productsSeller;
    }

    public void filterBySeller(Scanner scanner) {
        System.out.println("Nhập tên người bán: ");
        String seller = scanner.nextLine();
        List<Product> productsSeller = findAllProductsBySeller(seller);
        if (productsSeller.isEmpty()) {
            System.out.println("Không có sản phẩm nào từ người bán " +seller);
        } else {
            System.out.println("Danh sách sản phẩm của " +seller+ " :");
            System.out.println(productsSeller);
        }
    }
}
