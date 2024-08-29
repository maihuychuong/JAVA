package summonrift.sevice;

import summonrift.entities.SummonRift;
import summonrift.entities.Team;
import tiktok.entities.Idol;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SummonRiftService {
    TeamService teamService = new TeamService();
    public SummonRift display(Scanner scanner){
        System.out.println("Nhập thông tin đội SKT: ");
        List<Team> skt = new ArrayList<>();
        Team team1 = teamService.inputTeam(scanner);
        skt.add(team1);
        System.out.println("------------------------");
        System.out.println("Nhập thông tin đội G2: ");
        List<Team> g2 = new ArrayList<>();
        Team team2 = teamService.inputTeam(scanner);
        g2.add(team2);
        return new SummonRift (skt, g2);
    }
}
