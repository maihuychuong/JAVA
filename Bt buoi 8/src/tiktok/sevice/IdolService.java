package tiktok.sevice;

import tiktok.entities.Follower;
import tiktok.entities.Idol;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IdolService {
    FollowerService followerService = new FollowerService();
    public Idol inputIdol(Scanner scanner) {
        System.out.print("Nhập tên thần tượng: ");
        String name = scanner.nextLine();
        System.out.print("Nhập tên email: ");
        String email = scanner.nextLine();
        System.out.println("Nhập danh sách người theo dõi: ");
        System.out.println("----------------------------------");
        List<Follower> followers = new ArrayList<>();
        while (true){
            Follower follower = followerService.inputFollewer(scanner);
            followers.add(follower);
            System.out.print("Do want to continue? (Y/N)");
            String choice = scanner.nextLine();
            if(choice.equalsIgnoreCase("N")){
                break;
            }
        }
        System.out.print("Nhập nhóm: ");
        String group = scanner.nextLine();
        return new Idol(name, email, followers, group);
    }
}
