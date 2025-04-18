package net.zerhouani.pres;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class GameMenu {
    private final Scanner scanner = new Scanner(System.in);

    public int showMenu(List<String> actions) {
        System.out.println("Choisissez votre action :");
        for (int i = 0; i < actions.size(); i++) {
            System.out.println((i + 1) + ". " + actions.get(i));
        }
        System.out.print(">> ");

        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }
}
