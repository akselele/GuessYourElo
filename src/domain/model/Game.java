package domain.model;

public class Game {
    private String url;

    public Game(String url){
        setUrl(url);
    }

    public Game(){

    }

    public void setUrl(String url) {
        if(url.isEmpty()){
            throw new IllegalArgumentException("URL cannot be emtpy!");
        }
        if(!(url.substring(0,16).equalsIgnoreCase("https://plays.tv"))){
            throw new IllegalArgumentException("Link is not from plays.tv!");
        }
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
