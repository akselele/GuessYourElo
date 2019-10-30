package domain.model;

import db.GameDB;
import db.GameDBinMemory;
import db.PersonDb;
import db.PersonDbInMemory;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ShopService {
    private GameDB gameDB = new GameDBinMemory();
    private PersonDb personDb = new PersonDbInMemory();


    public String get(Game game){
        if(game == null){
            throw new IllegalArgumentException("No url given");
        }
        return getGameDB().getMap().get(game.getUrl());
    }

    public boolean checkRank(String rank, String game){
        for(Game key : getAllGames()){
            if(key.getUrl().contains(game)){
                if(getMap().get(key).equalsIgnoreCase(rank)){
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public String getRandom(){
        Random random = new Random();
        return getAllGames().get(random.nextInt(getAllGames().size())).getUrl();
    }

    public List<Game> getAllGames(){
        return getGameDB().getAll();
    }

    public Map<Game, String> getMap(){
       return getGameDB().getMap();
    }

    public void add(Game game, String rank) {
        getGameDB().add(game, rank);
    }

    public void deleteGame(String url) {
        getGameDB().delete(new Game(url));
    }

    private GameDB getGameDB(){
        return gameDB;
    }

    public Person getPerson(String personId) {
        return getPersonDb().get(personId);
    }

    public List<Person> getAll() {
        return getPersonDb().getAll();
    }

    public void add(Person person) {
        getPersonDb().add(person);
    }

    public void updatePersons(Person person) {
        getPersonDb().update(person);
    }

    public void deletePerson(String id) {
        getPersonDb().delete(id);
    }

    private PersonDb getPersonDb() {
        return personDb;
    }


}
