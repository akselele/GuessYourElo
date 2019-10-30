package db;

import domain.model.Game;

import java.util.HashMap;
import java.util.*;

public class GameDBinMemory implements GameDB {
    private Map<Game, String> gamesranks =new HashMap<>();
    String[] ranks = new String[]{"bronze", "silver","gold","platinum","diamond","master","grandmaster","challenger"};
    List<String> list = Arrays.asList(ranks);

    public String get(Game game){
        if(game == null){
            throw new IllegalArgumentException("No url given");
        }
        return gamesranks.get(game.getUrl());
    }


    public GameDBinMemory(){
        Game game = new Game("https://plays.tv/video/5db70037e3eb7d1114/elder-drake-steal");
        Game game2 = new Game("https://plays.tv/video/5da761ccdddba2ba1d/dont-mess-with-me-lux-leagueoflegends-outplay-3v1-doublekill");
        add(game2,"Challenger");
        add(game, "Gold");
    }


    public List<Game> getAll(){
        return new ArrayList<Game>(gamesranks.keySet());
    }

    public Map<Game, String> getMap(){
        return gamesranks;
    }

    @Override
    public void add(Game game, String rank) {
        if(game == null){
            throw new IllegalArgumentException("No person given");
        }
        if (gamesranks.containsKey(game.getUrl())) {
            throw new IllegalArgumentException("Game already submitted");
        }
        if(!(list.contains(rank.toLowerCase()))){
            throw new IllegalArgumentException("Rank does not exist");
        }
        gamesranks.put(game, rank);
    }

    @Override
    public void delete(Game game) {
        if(game == null){
            throw new IllegalArgumentException("No url given");
        }
        gamesranks.remove(game);
    }
}
