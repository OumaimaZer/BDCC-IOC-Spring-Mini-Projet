package net.zerhouani.dao;

import org.springframework.stereotype.Repository;

@Repository("monstreDao")
public class MonstreDaoImpl implements IMonstreDao {
    @Override
    public int getForce() {
        System.out.println("Version base de données");
        return 30;
    }
}