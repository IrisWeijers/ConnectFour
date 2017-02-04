package ConnectFour;


/**
 * Executable class for the game ConnectFour.
 */

import ConnectFour.Game;
import ConnectFour.AIPlayer;
import ConnectFour.HumanPlayer;
import ConnectFour.Player;
import ConnectFour.SmartStrategy;
import ConnectFour.Board;
import ConnectFour.LocationState;



public class ConnectFour {
	public static final String USAGE = 
			"Usage: <Dimensions> <humanplayer/computerplayer> <humanplayer/computerplayer";
	public static void main(String[] args) {
		Player player1 = null;
		Player player2 = null;
		Game game = null;
		if (args.length < 3) {
			exit();
		}
		try {
			Board.setDIM(Integer.parseInt(args[0]));
		} catch (NumberFormatException e) {
			exit();
		}
		if (args[1].equals("humanplayer")) {
			player1 = new HumanPlayer(LocationState.YELLOW, "player1");
		} else if (args[1].equals("AIplayer")) {
			player1 = new AIPlayer(LocationState.YELLOW, new SmartStrategy());
		} else {
			exit();
		}
		
		if (args[2].equals("humanplayer")) {
			player2 = new HumanPlayer(LocationState.YELLOW, "player1");
		} else if (args[2].equals("AIplayer")) {
			player2 = new AIPlayer(LocationState.YELLOW, new SmartStrategy());
		} else {
			exit();
		}
		
		game = new Game(player1, player2, true);
		game.run();
	}

	public static void exit() {
		System.out.println(USAGE);
		System.exit(0);
	}

	}
