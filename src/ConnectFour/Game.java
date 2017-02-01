package ConnectFour;

import java.util.Scanner;

import ConnectFour.Board;
import ConnectFour.Protocol;
import client.Client;
import ConnectFour.HumanTUI;
import exceptions.NoWinnerException;

public class Game extends Thread {
	
	public static final int NUMBER_PLAYERS = 2;
	
  /**
  list of players
  */
	private Player player1;
	private Player player2;
 
	/**
  Index of the current player
  */

  
  /**
  the board
  */
	private Board board;
//<<<<<<< HEAD
//=======

  //The initial number of turns
	private int turn;
//>>>>>>> branch 'master' of https://github.com/IrisWeijers/ConnectFour.git
  
	private int Numofplayers;
	private Client client;
	private boolean Local;
	private HumanTUI Htui;
	
 /**
 creates a new game object with players
 @ parameter p0
 			first player
 @ parameter p1
            second player
 
	/**
	 * Constructor for client.
	 */
	public Game(Player p0, Player p1, boolean local) {
		board = new Board();
		Htui = new HumanTUI(board);
        player1 = p0;
        player2 = p1;
        board.addObserver(Htui);
		if (p0 instanceof AIPlayer) {
			board.addObserver(((AIPlayer) p0).getStrategy());
		}
		if (p1 instanceof AIPlayer) {
			board.addObserver(((AIPlayer) p1).getStrategy());
		}
		turn = 0;
		Numofplayers = 2;
		Local = local;
    }
	
	/**
     * Starts the ConnectFour game. <br>
     * Asks after each ended game if the user want to continue. Continues until
     * the user does not want to play anymore.
     */
   
	
	public void run() {
		System.out.println(Htui.boardtostring(board));
		while (!board.gameOver()) {
			boolean moveMade = false;
			while (!moveMade) {
				try {
					moveMade = true;
					makeMove(this.detemineTurn());
				} catch (IndexOutOfBoundsException | InterruptedException e) {
					System.out.println(e.getMessage());
					moveMade = false;
				}
			}
		}
		try {
			System.out.println(getWinner().getName() + " has won the game!");
		} catch (NoWinnerException e) {
			System.out.println("it's a draw!");
		}
		if (Local == false) {
			System.out.println("Game finished. To play another, type GAME READY");
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
	public void makeMove(Player player)
			throws IndexOutOfBoundsException, InterruptedException {
		if (player instanceof OnlinePlayer) {
			OnlinePlayer onlinePlayer = (OnlinePlayer) player;
			System.out.println("Waiting for opponents move...");
			while (onlinePlayer.getMoveBuffer() == -1) {
				sleep(100);
			}
		}
		int[] coords = player.determineMove(board);
		for (int coord : coords) {
			if (coord >= board.getDIM() || coord < 0) {
				throw new IndexOutOfBoundsException("Field does not exist! Try a new move");
			}
		}
		board.setLocation(coords[0], coords[1], player.getLocationState());
		turn++;
		if (player instanceof OnlinePlayer) {
			int[] reset = new int[2];
			reset[0] = -1;
			OnlinePlayer onlinePlayer = (OnlinePlayer) player;
			onlinePlayer.setMoveBuffer(reset);
		} else if (!Local) {
			client.writeToServer(Protocol.CLIENT_MOVE + " " + coords[0] + " " + coords[1]);
		}
	}
	
	
	public Player detemineTurn() {
		turn = turn % Numofplayers;
		if (turn == 0) {
			return player1;
		} else {
			return player2;
		}
	}

	public Player getWinner() throws NoWinnerException {
		if (board.isWinner(player1.getLocationState())) {
			return player1;
		}
		if (board.isWinner(player2.getLocationState())) {
			return player2;
		} else {
			throw new NoWinnerException("getGame was called on board without winner");
		}
	}

	public void setClient(Client client) {
		this.client = client;
	}

    /**
     * Resets the game. <br>
     * The board is emptied and player[0] becomes the current player.
     */
//    private void reset() {
//        currentPlayer = 0;
//        board.reset();
//    }

    /**
     * Plays the ConnectFour game. <br>
     * First the (still empty) board is shown. Then the game is played until it
     * is over. Players can make a move one after the other. After each move,
     * the changed game situation is printed.
     */
//    private void play() {
//        // TODO: implement, see P-4.20
//    	System.out.println(board.toString());
//    	while (!board.gameOver()){
//    		players[currentPlayer].makeMove(board);
//    		update();
//    		currentPlayer++;
//    		currentPlayer = currentPlayer % Game.NUMBER_PLAYERS;
//    	}
//    		printResult();	
//    }

    /**
     * Prints the game situation.
     */
//    private void update() {
//        System.out.println("\ncurrent game situation: \n\n" + board.toString()
//                + "\n");
//    }

    /*@
       requires this.board.gameOver();
     */

    /**
     * Prints the result of the last game. <br>
     */
//<<<<<<< HEAD
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
//=======
//    private void printResult() {
//        if (board.hasWinner()) {
//            Player winner = board.isWinner(players[0].getLocationState()) ? players[0]
//                    : players[1];
//            System.out.println("Speler " + winner.getName() + " ("
//                    + winner.getLocationState().toString() + ") has won!");
//        } else {
//            System.out.println("Draw. There is no winner!");
//        }
//    }
  

    
	  

//	  
//			/**
//			 * Checks if the top row of a selected column is full. If column full return
//			 * false for invalid move and player must choose another column.
//			 * 
//			 * @param column
//			 *            - The column as selected by the player
//			 * @return - If column is full or not
//			 */
//			public boolean checkColumnFull(int column) {
//
//				if (board.getLocationState(new Location(column, 0)) != LocationState.EMPTY) {
//					return true;
//				} else {
//					return false;
//				}
//
//			}
//			
//			
//			
//			/**
//			 * Method used by graphical user interface in order to avoid
//			 * the loop situation within the taketurn() and playGame() methods
//			 * @param column
//			 * @return
//			 */
//			public int makeMove (int column){
//				
//				
//				int row = -1; ;
//				for (int i = board.getNoRows() - 1; i >= 0; i--) {
//					Location chosenLocation = new Location(column, i);
//
//					if (board.getLocationState(chosenLocation) == LocationState.EMPTY) {
//						board.setLocationState(chosenLocation,
//								currentPlayer.getPlayerState());
//						numTurns++ ;
//						
//						row = i ;
//						break;
//					}
//				}
//				return row;
//				
//			}
//			
//			
//
//
//		}
			

>>>>>>> branch 'master' of https://github.com/IrisWeijers/ConnectFour.git
 
}
