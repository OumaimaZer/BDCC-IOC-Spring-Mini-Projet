package net.zerhouani.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import org.springframework.stereotype.Repository;

import java.util.Random;

@Repository("monsterDao")
@Primary
public class MonstreDaoImpl implements IMonstreDao {
    private String monstreName;
    private int requiredActions;

    public MonstreDaoImpl() {
        String[] monsters = {"Gobelin", "Orc", "Dragon"};
        monstreName = monsters[new Random().nextInt(monsters.length)];
        requiredActions = 1;
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