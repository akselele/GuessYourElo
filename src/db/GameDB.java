package db;

import domain.model.Game;

import java.util.List;
import java.util.Map;

public interface GameDB {


    List<Game> getAll();

    Map<Game,String> getMap();

    void add(Game game, String rank);

    void delete(Game game);
}
