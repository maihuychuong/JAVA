package store.data;

import store.entities.Order;
import store.entities.Product;
import store.entities.User;

import java.math.BigDecimal;
import java.util.*;

public class Database {
    public static List<User> users = new ArrayList<>();

    public static List<Product> products = new ArrayList<>();

    public static Map<Integer, Integer> productsCart = new HashMap<>();

    public static Map<String, Map<Integer, Integer>> userCarts = new HashMap<>();

    public static List<Order> orders = new ArrayList<>();

    public static List<String> bankNames = new ArrayList<>();

    static {
        users.add(new User("admin", "Admin123!", "admin123@gmail.com", "Admin"));
        users.add(new User("kim", "Kim123!", "kim123@gmail.com", "Customer"));
        users.add(new User("lan", "Lan123!", "lan123@gmail.com", "Customer"));
        users.add(new User("hung", "Hung123!", "hung123@gmail.com", "Customer"));
        users.add(new User("nam", "Nam123!", "nam123@gmail.com", "Seller"));
        users.add(new User("binh", "Binh123!", "binh123@gmail.com", "Seller"));
        users.add(new User("khai", "Khai123!", "khai123@gmail.com", "Seller"));
        products.add(new Product("Thắt lưng da nam", new BigDecimal(65000), "hắt Lưng Da Nam Khóa Tự Động Cao Cấp Dây Nịt Nam Mặt Xoay Chính Hãng , Phong Cách Hàn Quốc", 24, "nam"));
        products.add(new Product("Serum DIVE IN TORRIDEN", new BigDecimal(275000), "Serum DIVE IN TORRIDEN chứa axit hyaluronic phân tử thấp giúp giữ ẩm sáng bóng da giữ ẩm sâu bên trong", 177, "nam"));
        products.add(new Product("Dép TL Spor", new BigDecimal(33000), "Dép TL Sport , quai nút không dán keo, có size trẻ em 10 màu", 145, "binh"));
        products.add(new Product("Tai Nghe Không Dây Baseus", new BigDecimal(549000), "Tai Nghe Không Dây Baseus D02 Pro Bluetooth 5.0 Âm Lập Thể HIFIPhong Cách Thể Thao", 282, "binh"));
        products.add(new Product("Kem Chống Nắng", new BigDecimal(103000), "Kem Chống Nắng Nhật Bản Skin Aqua nâng tone trắng sáng Tone up UV SPF 50+ PA++++ 80gr", 100, "khai"));
        products.add(new Product("Tai nghe không dây BASEUS", new BigDecimal(919000), "Tai nghe không dây BASEUS owie H1i Bluetooth 5.3 38db ANC khử tiếng ồn Hi-RES 3D", 273, "khai"));
        bankNames.add("VPBank");
        bankNames.add("Vietcombank");
        bankNames.add("Techcombank");
        bankNames.add("Vietinbank");
        bankNames.add("BIDV");
        bankNames.add("MBBank");
        bankNames.add("ACB");
        bankNames.add("Agribank");
        bankNames.add("HDBank");
        bankNames.add("TPBank");
    }
}
