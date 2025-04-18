package net.zerhouani.pres;

import net.zerhouani.metier.IGameEngine;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresSpringAnnotation {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("net.zerhouani");
        IGameEngine game = context.getBean(IGameEngine.class);
        System.out.println("Résultat du combat : " + game.calculerDegats());
    }
}
