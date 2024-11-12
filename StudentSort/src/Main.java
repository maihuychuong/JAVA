import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Nguyen Van A", 20, 3));
        students.add(new Student("Nguyen Thi B", 22, 3));
        students.add(new Student("Nguyen Thi B", 23, 4));
        students.add(new Student("Nguyen Thi A", 23, 4));
        students.add(new Student("Hoang Thi D", 22, 2));

        // #1: Sắp xếp theo fullName, nếu giống fullName thì ai nhiều tuổi hơn đứng trước
        students.sort(Comparator.comparing(Student::getFullName)
                .thenComparing(Comparator.comparingInt(Student::getAge).reversed()));
        System.out.println("Sắp xếp theo fullName và tuổi:");
        students.forEach(System.out::println);

        // #2: Sắp xếp theo tuổi tăng dần, nếu bằng tuổi thì xếp theo GPA giảm dần
        students.sort(Comparator.comparingInt(Student::getAge)
                .thenComparing(Comparator.comparingInt(Student::getGPA).reversed()));
        System.out.println("\nSắp xếp theo tuổi và GPA:");
        students.forEach(System.out::println);

        // #3: Sắp xếp theo tên (Ví dụ là Hoàng Văn A, thì chỉ xét A thôi)
        students.sort(Comparator.comparing(student -> student.getFullName().split(" ")[student.getFullName().split(" ").length - 1]));
        System.out.println("\nSắp xếp theo tên (xét tên cuối cùng):");
        students.forEach(System.out::println);
    }
}