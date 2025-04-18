package net.zerhouani.pres;

import net.zerhouani.dao.IMonstreDao;
import net.zerhouani.dao.IPlayerDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Random;

public class GameMainAnnotation {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("net.zerhouani");

        IPlayerDao playerDao = context.getBean(IPlayerDao.class);
        IMonstreDao monsterDao = context.getBean(IMonstreDao.class);
        GameMenu gameMenu = context.getBean(GameMenu.class);
        GameUI gameUI = context.getBean(GameUI.class);

        List<String> actions = playerDao.getAvailableActions();
        String monster = monsterDao.getMonstreName();
        int required = monsterDao.getRequiredActions();
        int successCount = 0;

        gameUI.showWelcomeMessage(monster, required);

        while (successCount < required) {
            int choice = gameMenu.showMenu(actions);

            if (choice < 1 || choice > actions.size()) {
                if (choice == -1) {
                    gameUI.showInvalidInputMessage();
                } else {
                    gameUI.showInvalidChoiceMessage();
                }
                continue;
            }

            String action = actions.get(choice - 1);
            boolean success = new Random().nextBoolean();

            if (success) successCount++;

            gameUI.showActionResult(action, success, successCount, required);
        }

        gameUI.showVictoryMessage(monster);
    }
}

