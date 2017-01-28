package ConnectFour;


/**
 * Executable class for the game ConnectFour.
 */

public class ConnectFour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length == 2){
			Board board = new Board();
    		Player player1 = new Player(args[0], LocationState.YELLOW);
        	Player player2 = new Player(args[1], LocationState.RED);
        	Game game = new Game(player1, player2, board);
        	game.start();	
    	}
	}

}
