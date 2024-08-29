package tiktok.sevice;

import tiktok.entities.Follower;
import tiktok.entities.Idol;
import tiktok.entities.Song;
import tiktok.entities.Tiktok;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TiktokService {
    IdolService idolService = new IdolService();
    SongService songService = new SongService();
    public Tiktok inputTiktok(Scanner scanner){
        System.out.println("Nhập danh sách thần tượng: ");
        System.out.println("----------------------------------");

        List<Idol> idols = new ArrayList<>();
        while (true){
            Idol idol = idolService.inputIdol(scanner);
            idols.add(idol);
            System.out.print("Do want to continue? (Y/N)");
            String choice = scanner.nextLine();
            if(choice.equalsIgnoreCase("N")){
                break;
            }
        }
        System.out.println();
        System.out.println("//////////////////////////////////");
        System.out.println();
        System.out.println("Nhập danh sách bài hát: ");
        System.out.println("----------------------------------");
        List<Song> songs = new ArrayList<>();
        while (true){
            Song song = songService.inputSong(scanner);
            songs.add(song);
            System.out.print("Do want to continue? (Y/N)");
            String choice = scanner.nextLine();
            if(choice.equalsIgnoreCase("N")){
                break;
            }
        }
        return new Tiktok(idols, songs);
    }
}
