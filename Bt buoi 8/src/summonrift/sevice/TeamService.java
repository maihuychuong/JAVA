package summonrift.sevice;

import summonrift.entities.Figure;
import summonrift.entities.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeamService {
    FigureService figureService = new FigureService();
    public Team inputTeam(Scanner scanner) {
        List<Figure> figures = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            System.out.println("Nhập thông tin người chơi " + (i + 1) + ": ");
            Figure figure = figureService.inputFigure(scanner);
            figures.add(figure);
        }
        System.out.print("Nhập thời gian bắt đầu trận đấu: ");
        String matchStartTime = scanner.nextLine();
        return new Team(figures, matchStartTime);
    }
}
