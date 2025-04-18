package net.zerhouani.pres;

import net.zerhouani.ext.MonstreCapteurDao;
import net.zerhouani.metier.GameEngineImpl;

public class Pres1 {
    public static void main(String[] args) {
        MonstreCapteurDao dao = new MonstreCapteurDao();
        GameEngineImpl engine = new GameEngineImpl(dao);
        // engine.setMonstreDao(dao);
        System.out.println("Résultat du combat pres1: " + engine.calculerDegats());
    }
}
