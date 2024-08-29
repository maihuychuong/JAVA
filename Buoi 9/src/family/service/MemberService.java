package family.service;

import family.entities.Member;

import java.util.Scanner;

public class MemberService {
    public Member inputMember(Scanner scanner){
        System.out.println("Nhập số nhà: ");
        String houseNumber = scanner.nextLine();
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập số ngày sinh: ");
        String dob = scanner.nextLine();
        System.out.println("Nhập số nghề nghiệp: ");
        String job = scanner.nextLine();
        return new Member(houseNumber, name, dob, job);
    }
}
