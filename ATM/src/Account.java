
import java.util.Date;
import java.text.SimpleDateFormat;
public class Account {
    private String username;
    private String password;
    private long balance;

    public Account(String username, String password, long balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public long getBalance() {
        return balance;
    }

    public void withdraw(long amount) {
        if (amount > balance) {
            System.out.println("Số dư không đủ.");
        } else {
            balance -= amount;
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd/HH:mm:ss").format(new Date());
            System.out.println("Bạn đã rút " + amount + " vnd vào lúc " + timeStamp);
        }
    }

    public void displayAccountInfo() {
        System.out.println("Thông tin tài khoản:");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Balance: " + balance + " vnd");
    }
}
