package m1.service;

import m1.service.entities.Family;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng thành viên gia đình: ");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Family> families = new ArrayList<>();
        for (int i =0; i<n; i++){
            FamilyService familyService = new FamilyService();
            Family family = familyService.inputFamily(scanner);
            families.add(family);
        }
        for (int i =0; i<n; i++){
            System.out.println(families.get(i));
        }
    }
}