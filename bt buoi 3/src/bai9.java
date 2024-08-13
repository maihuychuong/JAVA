import java.util.Scanner;

public class bai9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name, address, choice;
        int age;
        do{
            System.out.print("Nhập tên sinh viên: ");
            name = scanner.nextLine();
            System.out.print("Nhập địa chỉ sinh viên: ");
            address = scanner.nextLine();
            System.out.print("Nhập tuổi của sinh viên: ");
            age = scanner.nextInt();
            scanner.nextLine();
            System.out.println("\nThông tin sinh viên:");
            System.out.println("Tên: " + name);
            System.out.println("Địa chỉ: " + address);
            System.out.println("Tuổi: " + age);
            System.out.print("\nDo you want to continue? (Y/N): ");
            choice = scanner.nextLine();
        } while (choice.equalsIgnoreCase("Y"));
        System.out.println("Chương trình kết thúc.");
    }
}
