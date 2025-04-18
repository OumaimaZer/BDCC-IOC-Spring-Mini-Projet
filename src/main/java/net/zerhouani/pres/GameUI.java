package net.zerhouani.pres;

import org.springframework.stereotype.Component;

@Component
public class GameUI {

    public void showWelcomeMessage(String monster, int required) {
        System.out.println("🎮 Bienvenue dans l'arène RPG !");
        System.out.println("Un " + monster + " sauvage apparaît ! 👾");
        System.out.println("Tu dois réussir " + required + " actions pour le vaincre.\n");
    }

    public void showActionResult(String action, boolean success, int current, int total) {
        if (success) {
            System.out.println("✅ " + action + " réussie !");
        } else {
            System.out.println("❌ " + action + " échouée...");
        }
        System.out.println("Actions réussies : " + current + " / " + total + "\n");
    }

    public void showVictoryMessage(String monster) {
        System.out.println("🎉 Victoire ! Tu as vaincu le " + monster + " !");
    }

    public void showInvalidInputMessage() {
        System.out.println("Entrée invalide. Essayez encore.\n");
    }

    public void showInvalidChoiceMessage() {
        System.out.println("Choix invalide. Essayez encore.\n");
    }
}
