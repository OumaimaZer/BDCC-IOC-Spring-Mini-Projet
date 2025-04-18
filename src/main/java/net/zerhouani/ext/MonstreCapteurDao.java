package net.zerhouani.ext;

import net.zerhouani.dao.IMonstreDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Random;

@Qualifier("capteurDao")
public class MonstreCapteurDao implements IMonstreDao {
    @Override
    public int getForce() {
        int force = new Random().nextInt(20) + 10; // entre 10 et 30
        System.out.println("Version capteurs - force aléatoire : " + force);
        return force;
    }
}
