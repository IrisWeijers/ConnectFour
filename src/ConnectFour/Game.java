package ConnectFour;

import java.util.Scanner;

import ConnectFour.Board;

public class Game {
	
	public static final int NUMBER_PLAYERS = 2;
	
  /**
  list of players
  */
	private Player[] players;
 
	/**
  Index of the current player
  */
	private int currentPlayer;
  
  /**
  the board
  */
	private Board board;
  
 /**
 creates a new game object with players
 @ parameter p0
 			first player
 @ parameter p1
            second player
 
	/**
	 * Constructor for client.
	 */
	public Game(Player p0, Player p1, Board board) {
		board = new Board();
        players = new Player[NUMBER_PLAYERS];
        players[0] = p0;
        players[1] = p1;
        currentPlayer = 0;
    }
	
	/**
     * Starts the ConnectFour game. <br>
     * Asks after each ended game if the user want to continue. Continues until
     * the user does not want to play anymore.
     */
    public void start() {
        boolean doorgaan = true;
        while (doorgaan) {
            reset();
            play();
            doorgaan = readBoolean("\n> Play another time? (y/n)?", "y", "n");
        }
    }

    /**
     * Prints a question which can be answered by yes (true) or no (false).
     * After prompting the question on standard out, this method reads a String
     * from standard in and compares it to the parameters for yes and no. If the
     * user inputs a different value, the prompt is repeated and te method reads
     * input again.
     * 
     * @parom prompt the question to print
     * @param yes
     *            the String corresponding to a yes answer
     * @param no
     *            the String corresponding to a no answer
     * @return true is the yes answer is typed, false if the no answer is typed
     */
    private boolean readBoolean(String prompt, String yes, String no) {
        String answer;
        do {
            System.out.print(prompt);
            try (Scanner in = new Scanner(System.in)) {
                answer = in.hasNextLine() ? in.nextLine() : null;
            }
        } while (answer == null || (!answer.equals(yes) && !answer.equals(no)));
        return answer.equals(yes);
    }

    /**
     * Resets the game. <br>
     * The board is emptied and player[0] becomes the current player.
     */
    private void reset() {
        currentPlayer = 0;
        board.reset();
    }

    /**
     * Plays the ConnectFour game. <br>
     * First the (still empty) board is shown. Then the game is played until it
     * is over. Players can make a move one after the other. After each move,
     * the changed game situation is printed.
     */
    private void play() {
        // TODO: implement, see P-4.20
    	System.out.println(board.toString());
    	while (!board.gameOver()){
    		players[currentPlayer].makeMove(board);
    		update();
    		currentPlayer++;
    		currentPlayer = currentPlayer % Game.NUMBER_PLAYERS;
    	}
    		printResult();	
    }

    /**
     * Prints the game situation.
     */
    private void update() {
        System.out.println("\ncurrent game situation: \n\n" + board.toString()
                + "\n");
    }

    /*@
       requires this.board.gameOver();
     */

    /**
     * Prints the result of the last game. <br>
     */
    private void printResult() {
        if (board.hasWinner()) {
            Player winner = board.isWinner(players[0].getLocationState()) ? players[0]
                    : players[1];
            System.out.println("Speler " + winner.getName() + " ("
                    + winner.getLocationState().toString() + ") has won!");
        } else {
            System.out.println("Draw. There is no winner!");
        }
    }
 
}
