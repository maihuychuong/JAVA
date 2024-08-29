package tiktok;

import tiktok.entities.Idol;
import tiktok.entities.Tiktok;
import tiktok.sevice.IdolService;
import tiktok.sevice.TiktokService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TiktokService tiktokService = new TiktokService();
        Tiktok tiktok = tiktokService.inputTiktok(scanner);
        System.out.println(tiktok);
    }
}
