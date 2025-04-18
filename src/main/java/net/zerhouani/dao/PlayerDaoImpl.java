package net.zerhouani.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository("playerDao")
@Primary
public class PlayerDaoImpl implements IPlayerDao {
    @Override
    public List<String> getAvailableActions() {
        return Arrays.asList("Attaquer", "Défendre");
    }
}
