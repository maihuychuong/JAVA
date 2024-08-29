package summonrift;

import summonrift.entities.SummonRift;
import summonrift.entities.Team;
import summonrift.sevice.SummonRiftService;
import summonrift.sevice.TeamService;
import tiktok.entities.Song;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SummonRiftService summonRiftService = new SummonRiftService();
        SummonRift summonRift = summonRiftService.display(scanner);
        System.out.println(summonRift);
    }
}
