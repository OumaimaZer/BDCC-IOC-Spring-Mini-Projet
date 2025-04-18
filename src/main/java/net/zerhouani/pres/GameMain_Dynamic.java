package net.zerhouani.pres;

import net.zerhouani.dao.IMonstreDao;
import net.zerhouani.dao.IPlayerDao;

import java.io.File;
import java.util.*;

public class GameMain_Dynamic {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("config.txt"));

        String playerDaoClassName = scanner.nextLine();
        IPlayerDao playerDao = (IPlayerDao) Class.forName(playerDaoClassName)
                .getDeclaredConstructor().newInstance();

        String monsterDaoClassName = scanner.nextLine();
        IMonstreDao monsterDao = (IMonstreDao) Class.forName(monsterDaoClassName)
                .getDeclaredConstructor().newInstance();

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
