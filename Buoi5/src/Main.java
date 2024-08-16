import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Khởi tạo đối tượng
        System.out.println("Nhập vận tốc: ");
        int speed = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        Vehicle x = new Vehicle(speed, name);
        System.out.println(x);
    }
}