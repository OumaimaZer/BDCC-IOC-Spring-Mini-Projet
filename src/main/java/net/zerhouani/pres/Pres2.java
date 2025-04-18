package net.zerhouani.pres;

import net.zerhouani.dao.IMonstreDao;
import net.zerhouani.metier.IGameEngine;

import java.io.File;
import java.util.Scanner;

public class Pres2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("config.txt"));

        String daoClassName = scanner.nextLine();
        Class<?> cDao = Class.forName(daoClassName);
        IMonstreDao dao = (IMonstreDao) cDao.getDeclaredConstructor().newInstance();

        String metierClassName = scanner.nextLine();
        Class<?> cMetier = Class.forName(metierClassName);
        IGameEngine game = (IGameEngine) cMetier.getConstructor(IMonstreDao.class).newInstance(dao);

        System.out.println("Résultat du combat pres2: " + game.calculerDegats());
    }
}
