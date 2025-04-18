package net.zerhouani.metier;

import net.zerhouani.dao.IMonstreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("metier")
public class GameEngineImpl implements IGameEngine {

    private IMonstreDao monstreDao;

    // Injection par constructeur
    public GameEngineImpl(@Qualifier("capteurDao") IMonstreDao monstreDao) {
        this.monstreDao = monstreDao;
    }

    // Injection par setter
    public void setMonstreDao(IMonstreDao monstreDao) {
        this.monstreDao = monstreDao;
    }

    @Override
    public int calculerDegats() {
        int force = monstreDao.getForce();
        int degats = force * 2 - 5;
        System.out.println("Dégâts infligés : " + degats);
        return degats;
    }
}