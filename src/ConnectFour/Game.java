package ConnectFour;

import java.util.Scanner;

import ConnectFour.AIPlayer;
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

  //The initial number of turns
	private int numTurns = 0;
  
 /**
 creates a new game object with players
 @ parameter human
              first player
 @ parameter computer
              second player
 
	/**
	 * Constructor for client.
	 */
	public Game(Player p0, Player p1, Board board) {
		board = new Board(4,4,4);
        players = new Player[NUMBER_PLAYERS];
        players[0] = p0;
        players[1] = p1;
        currentPlayer = 0;
    }
  
	/**
	 * Getter method for board object
	 * 
	 * @return
	 */
	public Board getBoard() {
		return board;
	}

//	/**
//	 * Getter method for human object
//	 * 
//	 * @return
//	 */
//	public Player getHuman() {
//		return human;
//	}
//
//	/**
//	 * Setter method for human player
//	 * 
//	 * @param human
//	 */
//	public void setHuman(Player human) {
//		this.human = human;
//	}
//
//	/**
//	 * Getter method for computer player object
//	 * 
//	 * @return
//	 */
//	public Player getAI() {
//		return AI;
//	}
//	/**
//	 * Setter method for computer player
//	 * 
//	 * @param computer
//	 */
//	public void setAI(IPlayer AI) {
//		this.AI = AI;
//	}

	/**
	 * Getter method for currentPlayer
	 * 
	 * @return
	 */
	public int getCurrentPlayer() {
		return currentPlayer;
	}

	/**
	 * Setter method for current player
	 * 
	 * @param currentPlayer
	 */
	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	/**
	 * Getter method for numTurns
	 * 
	 * @return - Total turns taken
	 */
	public int getNumTurns() {
		return numTurns;
	}

	/**
	 * Setter method for numTurns
	 * 
	 * @param numTurns
	 */
	public void setNumTurns(int numTurns) {
		this.numTurns = numTurns;
	}

	/**
	 * Setter method for board object
	 * 
	 * @param board
	 */
	public void setBoard(Board board) {
		this.board = board;
	}


	/**
	 * Method the initializes all necessary objects to play the game. Sets the
	 * board size to user input via the command line.Calls method to make first
	 * move.
	 * 
	 * @param - The game object
	 * @throws InterruptedException 
	 */
	public void setUpGame(Game game) throws InterruptedException {

		//Player human = new HumanPlayer(LocationState.YELLOW);
		Player human = new HumanPlayer(LocationState.YELLOW);
	    Player AI = new AIPlayer(LocationState.RED);
	  // Player AI = new AIPlayer(LocationState.RED);
		Scanner boardSize = new Scanner(System.in);
		System.out.print("Enter number of columns" + "\n");
		
		int numCols = boardSize.nextInt();
		System.out.print("Enter number of rows" + "\n");
		int numRows = boardSize.nextInt();
		System.out.print("Enter number of levels" + "\n");
		int numLevels = boardSize.nextInt();
		Board board = new Board(numCols, numRows, numLevels);
		game.setBoard(board);
		game.setHuman(human);
		game.setComputer(AI);
		game.setCurrentPlayer(human);
		game.playGame(game);
	}
  
  /**
  resets the game.
  The board is emptied and player[0] becomes the current player.
  */
  private void reset(){
  }
  
  
  
  /**
	 * Main method-run to start game Calls for the game to be created
	 * 
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {

		Game game = new Game(null, null, null);
		game.setUpGame(game);
	}
	
  /**
   Plays the Connet Four game.
   First the (still empty) board is shown. Then the game is played until it
   is over. Players can make a move one after the other. After each move,
   the changed game situation is printed.
  */

	  public void play(Game game) throws InterruptedException {

			while (!isWin(board)) {
				try {

					if (takeTurn()) {
						if (!isWin(board)) {
							nextPlayer();
						}
					}
				} catch (ArrayIndexOutOfBoundsException e) {

					System.out.print("Invalid position entered" + "\n");
					playGame(game);
				}
	  
		}
  }
  
  /**
  ??
  */
	  
	  /**
		 * Method to switch players after a turn has been completed
		 */
		public void nextPlayer() {

			if (currentPlayer == human) {

				currentPlayer = AI;

			} else {
				currentPlayer = human;

			}

		}
		/**
		 * Checks if there's a winner
		 * 
		 * @param board
		 * @return boolean to detect winner
		 */
		public boolean isWin(Board board) {

			return currentPlayer.checkForFour(currentPlayer, board);

		}


	  
	  /**
		 * Checks for a drawn game.
		 * 
		 * @return
		 */
		public boolean isDraw() {

			
			
			return numTurns == board.getNoCols() * board.getNoRows() * board.getNoLevels();

		}  
	  
		
		/**
		 * Method called to get next move from player Allows the player to select an
		 * integer which is a column. If this column is valid and not full will
		 * place a chip at the lowest row of that column. Otherwise if a column is
		 * full return false and player must select again. Once seven moves have
		 * been made, begin checking for winner.
		 * 
		 * @return boolean indicating move take successfully
		 * @throws InterruptedException 
		 */
		public   boolean takeTurn()  {
			
			
			int col = currentPlayer.getMove(board);

			if (!board.checkColumnFull(col)) {

				for (int i = board.getNoRows() - 1; i >= 0; i--) {
					Location chosenLocation = new Location(col, i);
					for (int k = board.getNoLevels() -1 ; k >= 0; k--) {
						Location chosenLocation = new Location(col, i);

					if (board.getLocationState(chosenLocation) == LocationState.EMPTY) {
						board.setLocationState(chosenLocation,
								currentPlayer.getPlayerState());
						numTurns++;

						if (numTurns >= 4) {

							if (isWin(board)) {
								System.out.print(board.toString() + "\n");
								System.out
										.print("Game over, player "
												+ currentPlayer.toString()
												+ " wins" + "\n");
							}
						}
						return true;
					}
				}
			}
			System.out.print("That column is full" + "\n");
			return false;
		}
		
	  
			/**
			 * Checks if the top row of a selected column is full. If column full return
			 * false for invalid move and player must choose another column.
			 * 
			 * @param column
			 *            - The column as selected by the player
			 * @return - If column is full or not
			 */
			public boolean checkColumnFull(int column) {

				if (board.getLocationState(new Location(column, 0)) != LocationState.EMPTY) {
					return true;
				} else {
					return false;
				}

			}
			
			
			
			/**
			 * Method used by graphical user interface in order to avoid
			 * the loop situation within the taketurn() and playGame() methods
			 * @param column
			 * @return
			 */
			public int makeMove (int column){
				
				
				int row = -1; ;
				for (int i = board.getNoRows() - 1; i >= 0; i--) {
					Location chosenLocation = new Location(column, i);

					if (board.getLocationState(chosenLocation) == LocationState.EMPTY) {
						board.setLocationState(chosenLocation,
								currentPlayer.getPlayerState());
						numTurns++ ;
						
						row = i ;
						break;
					}
				}
				return row;
				
			}
			
			


		}
			

 
}
