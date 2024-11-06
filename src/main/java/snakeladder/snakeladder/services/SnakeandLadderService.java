package snakeladder.snakeladder.services;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import snakeladder.snakeladder.entity.Board;
import snakeladder.snakeladder.entity.Ladder;
import snakeladder.snakeladder.entity.Player;
import snakeladder.snakeladder.entity.Snake;

public class SnakeandLadderService {
    
    private Board board;
    private int initailNumberOfPlayers;
    private Queue<Player>players;
    private boolean GameCompleted;

    public SnakeandLadderService(){
        this.board=new Board(100);
        this.players=new LinkedList<Player>();
    }
    
    //////////// Initialize board /////////////////
    
    public void setPlayers(List<Player>players){
         this.players=new LinkedList<Player>();
         this.initailNumberOfPlayers=players.size();
         Map<String,Integer>playerpieces=new HashMap<String,Integer>();
         
         for(Player player:players){
            this.players.add(player);
            playerpieces.put(player.getId(),0);
         }

         board.setPlayerpieces(playerpieces);

    }

    public void setSnakes(List<Snake>snakes){
        board.setSnakes(snakes);
    }

    public void setLadders(List<Ladder>ladders){
        board.setLadders(ladders);
    }
    

    //////////// Logic ///////////////////
     
   public int getDiceValue(){
    return DiceService.roll();
   }
   
   public int Check(int newPosition){
      
    for(Snake snake:board.getSnakes()){
       if(snake.getStart()==newPosition){
        newPosition=snake.getEnd();
       }
    }

    for(Ladder ladder:board.getLadders()){
        if(ladder.getStart()==newPosition){
            newPosition=ladder.getEnd();
        }

    }

    return newPosition;
   }
   public void moveplayer(Player player,int Dicevalue){
        int oldPosition=board.getPlayerPieces().get(player.getId());
        int newPosition=oldPosition+Dicevalue;

        if(newPosition>board.getSize()){
            newPosition=oldPosition;
        }else{
            newPosition=Check(newPosition);
        }

        board.getPlayerPieces().put(player.getId(),newPosition);
        System.out.println(player.getName()+" rolled and moved from "+oldPosition+" to "+newPosition);
   }

    public void startGame(){
        while(players.size()>1){
            Player player=players.peek();
            int dicevalue=getDiceValue();
            moveplayer(player,dicevalue);
            if(board.getPlayerPieces().get(player.getId())==100){
                players.remove();
                continue;
            }
            if(dicevalue!=6){
                players.remove();
                players.add(player);
            }

        }
    }




}
