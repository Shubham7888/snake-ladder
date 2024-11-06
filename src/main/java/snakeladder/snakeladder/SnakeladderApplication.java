package snakeladder.snakeladder;

import java.lang.management.PlatformLoggingMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import snakeladder.snakeladder.entity.Ladder;
import snakeladder.snakeladder.entity.Player;
import snakeladder.snakeladder.entity.Snake;
import snakeladder.snakeladder.services.SnakeandLadderService;

@SpringBootApplication
public class SnakeladderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnakeladderApplication.class, args);

		Scanner scanner=new Scanner(System.in);

		int noOfSnakes=scanner.nextInt();
		List<Snake>snakes=new ArrayList<Snake>();

		for(int i=0;i<noOfSnakes;i++){
			snakes.add(new Snake(scanner.nextInt(), scanner.nextInt()));
		}

		int noOfLadders=scanner.nextInt();
		List<Ladder>ladders=new ArrayList<Ladder>();

		for(int i=0;i<noOfLadders;i++){
			ladders.add(new Ladder(scanner.nextInt(), scanner.nextInt()));
		}

		int noOfPlayers=scanner.nextInt();
		List<Player>players=new ArrayList<>();
		for(int i=0;i<noOfPlayers;i++){
			players.add(new Player(scanner.next()));
		}

		SnakeandLadderService snakeandLadderService=new SnakeandLadderService();
		snakeandLadderService.setPlayers(players);
		snakeandLadderService.setLadders(ladders);
		snakeandLadderService.setSnakes(snakes);

		snakeandLadderService.startGame();
	}

}
