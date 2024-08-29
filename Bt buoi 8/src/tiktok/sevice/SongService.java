package tiktok.sevice;

import tiktok.entities.Song;

import java.util.Scanner;

public class SongService {
    public Song inputSong(Scanner scanner){
        System.out.print("Nhập tên bài hát: ");
        String name = scanner.nextLine();
        System.out.print("Nhập tên ca sĩ: ");
        String singer = scanner.nextLine();
        return new Song(name, singer);
    }
}
