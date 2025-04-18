package net.zerhouani.ext;

import net.zerhouani.dao.IPlayerDao;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository("playerDaoV2")
public class PlayerDaoImplV2 implements IPlayerDao {
    @Override
    public List<String> getAvailableActions() {
        return Arrays.asList("Attaquer", "Défendre", "Se soigner", "Fuir");
    }
}
