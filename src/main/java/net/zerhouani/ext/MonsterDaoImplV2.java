package net.zerhouani.ext;

import net.zerhouani.dao.IMonstreDao;
import org.springframework.stereotype.Repository;

import java.util.Random;

@Repository("monsterDaoV2")
public class MonsterDaoImplV2 implements IMonstreDao {
    private String monstreName;
    private int requiredActions;

    public MonsterDaoImplV2() {
        String[] monsters = {"Gobelin", "Orc", "Dragon"};
        monstreName = monsters[new Random().nextInt(monsters.length)];
        requiredActions = new Random().nextInt(4) + 1;
    }

    @Override
    public String getMonstreName() {
        return monstreName;
    }

    @Override
    public int getRequiredActions() {
        return requiredActions;
    }
}
