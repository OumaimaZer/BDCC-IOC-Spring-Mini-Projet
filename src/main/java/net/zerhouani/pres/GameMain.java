package net.zerhouani.pres;

import net.zerhouani.dao.IPlayerDao;
import net.zerhouani.dao.IMonstreDao;
import net.zerhouani.dao.PlayerDaoImpl;
import net.zerhouani.dao.MonstreDaoImpl;

import java.util.List;
import java.util.Random;

public class GameMain {
    public static void main(String[] args) {
        IPlayerDao playerDao = new PlayerDaoImpl();
        IMonstreDao monsterDao = new MonstreDaoImpl();
        GameMenu gameMenu = new GameMenu();
        GameUI gameUI = new GameUI();

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
