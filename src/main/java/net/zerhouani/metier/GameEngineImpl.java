package net.zerhouani.metier;

import net.zerhouani.dao.IMonstreDao;
import net.zerhouani.dao.IPlayerDao;
import net.zerhouani.dao.MonstreDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Service("gameEngine")
public class GameEngineImpl implements IGameEngine {
    private IPlayerDao playerDao;
    private IMonstreDao monsterDao;

    @Autowired
    public GameEngineImpl(IPlayerDao playerDao, IMonstreDao monsterDao) {
        this.playerDao = playerDao;
        this.monsterDao = monsterDao;
    }

    public GameEngineImpl(MonstreDaoImpl monstreDao) {
        this.monsterDao = monsterDao;
    }

    @Override
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        List<String> actions = playerDao.getAvailableActions();

        String monster = monsterDao.getMonstreName();
        int required = monsterDao.getRequiredActions();
        int successCount = 0;

        System.out.println("🎮 Bienvenue dans l'arène RPG !");
        System.out.println("Un " + monster + " sauvage apparaît ! 👾");
        System.out.println("Tu dois réussir " + required + " actions pour le vaincre.\n");

        while (successCount < required) {
            System.out.println("Choisissez votre action :");
            for (int i = 0; i < actions.size(); i++) {
                System.out.println((i + 1) + ". " + actions.get(i));
            }
            System.out.print(">> ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Entrée invalide. Essayez encore.\n");
                continue;
            }

            if (choice < 1 || choice > actions.size()) {
                System.out.println("Choix invalide. Essayez encore.\n");
                continue;
            }

            boolean success = random.nextBoolean();
            if (success) {
                successCount++;
                System.out.println("✅ " + actions.get(choice - 1) + " réussie !");
            } else {
                System.out.println("❌ " + actions.get(choice - 1) + " échouée...");
            }

            System.out.println("Actions réussies : " + successCount + " / " + required + "\n");
        }

        System.out.println("🎉 Victoire ! Tu as vaincu le " + monster + " !");
    }
}