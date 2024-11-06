package snakeladder.snakeladder.entity;

public class Player {
    
    public String name;

    private String id;

    private static int count=1;

    public Player(String name){
        this.name=name;
        this.id="P"+count;
        count++;
    }

    public String getName(){
        return name;
    }

    public String getId(){
        return id;
    }



}
