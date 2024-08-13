import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        String choice;
        do {
            System.out.print("Nhập vào một số nguyên: ");
            int number = scanner.nextInt();
            sum += number;
            System.out.print("Do you want to continue? (Y/N): ");
            choice = scanner.next();
        } while (choice.equalsIgnoreCase("Y"));
        System.out.println("Tổng các số vừa nhập là: "+sum);
    }
}
