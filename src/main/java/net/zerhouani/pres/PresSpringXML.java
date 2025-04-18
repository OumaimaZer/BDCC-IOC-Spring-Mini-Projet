package net.zerhouani.pres;

import net.zerhouani.metier.IGameEngine;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresSpringXML {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("config.xml");
        IGameEngine game = context.getBean(IGameEngine.class);
        System.out.println("Résultat du combat : " + game.calculerDegats());
    }
}
