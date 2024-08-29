package tiktok.sevice;

import tiktok.entities.Follower;

import java.util.Scanner;

public class FollowerService {
    public Follower inputFollewer(Scanner scanner){
        System.out.print("Nhập tên người theo dõi: ");
        String name = scanner.nextLine();
        System.out.print("Nhập email: ");
        String email = scanner.nextLine();
        System.out.print("Nhập số lượt thích: ");
        int numberOfLike = Integer.parseInt(scanner.nextLine());
        return new Follower(name, email, numberOfLike);
    }
}
