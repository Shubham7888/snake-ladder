package snakeladder.snakeladder.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    
    private int size;
    private List<Snake>snakes;
    private List<Ladder>ladders;
    private Map<String,Integer>playerpieces;

   public Board(int size){
    this.size=size;
    this.snakes=new ArrayList<Snake>();
    this.ladders=new ArrayList<Ladder>();
    this.playerpieces=new HashMap<String,Integer>();
   }

   public int getSize(){
    return size;
   }

   public List<Snake> getSnakes(){
    return snakes;
   }

   public List<Ladder>getLadders(){
    return ladders;
   }

   public Map<String,Integer> getPlayerPieces(){
    return playerpieces;
   }

public void setSize(int size) {
    this.size = size;
}

public void setSnakes(List<Snake> snakes) {
    this.snakes = snakes;
}

public void setLadders(List<Ladder> ladders) {
    this.ladders = ladders;
}

public void setPlayerpieces(Map<String, Integer> playerpieces) {
    this.playerpieces = playerpieces;
}

   


}
