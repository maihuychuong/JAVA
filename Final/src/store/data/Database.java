package store.data;

import store.entities.Order;
import store.entities.Product;
import store.entities.User;

import java.util.*;

public class Database {
    public static List<User> users = new ArrayList<>(Arrays.asList(new User("admin", "admin123!", "admin123@gmail.com", "Admin")));
    public static List<Product> products = new ArrayList<>();
    public static Map<Integer, Integer> productsCart = new HashMap<>();
    public static List<Order> orders = new ArrayList<>();
}
