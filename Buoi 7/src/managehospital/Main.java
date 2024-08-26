package managehospital;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập thông tin bệnh nhân: ");
        System.out.println("Tên: ");
        String name1 = scanner.nextLine();
        System.out.println("Tuổi: ");
        int age1 = Integer.parseInt(scanner.nextLine());
        System.out.println("Số bệnh án: ");
        int medicalRecordNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Ngày nhập viện: ");
        String dateOfAdmission = scanner.nextLine();
        System.out.println();
        System.out.println("Nhập thông tin bác sĩ: ");
        System.out.println("Tên: ");
        String name2 = scanner.nextLine();
        System.out.println("Tuổi: ");
        int age2 = Integer.parseInt(scanner.nextLine());
        System.out.println("Chuyên khoa: ");
        String specialty = scanner.nextLine();
        System.out.println("Số giờ làm việc: ");
        int numberOfWorkingHours = Integer.parseInt(scanner.nextLine());
        Patient patient = new Patient(name1, age1, medicalRecordNumber, dateOfAdmission);
        Doctor doctor = new Doctor(name2, age2, specialty, numberOfWorkingHours);
        ManageHospital manageHospital = new ManageHospital(doctor, patient);
        System.out.println(manageHospital);
    }
}