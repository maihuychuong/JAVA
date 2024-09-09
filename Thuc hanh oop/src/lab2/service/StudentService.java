package lab2.service;

import lab2.entities.Student;

import java.util.Scanner;

public class StudentService {
    public Student studentInput(Scanner scanner){
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập điểm môn Toán: ");
        double scoreMath = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập điểm môn Lý: ");
        double scorePhysic = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập điểm môn Hóa: ");
        double scoreChemistry = Double.parseDouble(scanner.nextLine());
        return new Student(name, scoreMath, scorePhysic, scoreChemistry);
    }
    private double avgScore(Student student){
        return (student.getScoreMath() + student.getScorePhysic() + student.getScoreChemistry())/3;
    }
    public String classify(Student student){
        if(avgScore(student) >=8){
            return "Xếp loại A";
        } else  if (avgScore(student) < 8 && avgScore(student) >= 6.5){
            return "Xếp loại B";
        } else if (avgScore(student) < 6.5 ){
            return "Xếp loại C";
        }
        return null;
    }

}
