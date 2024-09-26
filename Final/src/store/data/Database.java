package store.data;
import store.entities.Product;
import store.entities.User;

import java.util.ArrayList;
import java.util.List;

public class Database {
    public static List<User> users = new ArrayList<>();
    static {
        User admin = new User("admin", "admin123!", "admin123@gmail.com", "Admin");
        users.add(admin);
    }
    public static List<Product> products = new ArrayList<>();
}
