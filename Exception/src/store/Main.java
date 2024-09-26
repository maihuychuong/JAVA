package store;


import store.view.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        menu.displayPreLogin(scanner);
    }
}
