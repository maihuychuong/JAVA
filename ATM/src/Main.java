import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Account account = new Account("techmaster", "hoclacoviec", 1000000);
        if (login(account)) {
            menu(account);
        }
    }
    public static boolean login(Account account) {
        boolean loginSuccess = false;
        while (!loginSuccess) {
            System.out.println("Vui lòng đăng nhập:");
            System.out.print("Username: ");
            String inputUsername = scanner.nextLine();
            System.out.print("Password: ");
            String inputPassword = scanner.nextLine();
            if (inputUsername.equals(account.getUsername()) && inputPassword.equals(account.getPassword())) {
                loginSuccess = true;
            } else {
                System.out.println("Đăng nhập thất bại. Sai username hoặc password.");
                System.out.print("Bạn có muốn thử lại không? (Y/N): ");
                String retry = scanner.nextLine();
                if (retry.equalsIgnoreCase("N")) {
                    System.exit(0);
                }
            }
        }
        return loginSuccess;
    }
    public static void menu(Account account) {
        boolean continueUsing = true;

        while (continueUsing) {
            System.out.println("\nChọn tính năng:");
            System.out.println("1. Xem thông tin tài khoản");
            System.out.println("2. Rút tiền");
            System.out.println("3. Thoát");

            System.out.print("Lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    account.displayAccountInfo();
                    break;
                case 2:
                    withdrawMoney(account);
                    break;
                case 3:
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }

            System.out.print("Do you want to continue? (Y/N): ");
            String continueChoice = scanner.nextLine();
            if (continueChoice.equalsIgnoreCase("N")) {
                System.out.println("Thoát chương trình.");
                continueUsing = false;
                System.exit(0);
            }
        }
    }
    public static void withdrawMoney(Account account) {
        System.out.print("Nhập số tiền muốn rút: ");
        long amount = scanner.nextLong();
        scanner.nextLine(); // Consume newline left-over
        account.withdraw(amount);
    }
}