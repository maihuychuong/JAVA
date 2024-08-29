package summonrift.sevice;

import summonrift.entities.Figure;

import java.util.Scanner;

public class FigureService {
    public Figure inputFigure(Scanner scanner){
        System.out.print("Nhập tên tướng: ");
        String name = scanner.nextLine();
        System.out.print("Nhập vị trí (Top, Jungle, Mid, Adc, Support): ");
        String position = scanner.nextLine();
        return new Figure(name, position);
    }
}
