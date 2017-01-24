package ConnectFour;

import java.util.Scanner;
/**
 * This class extends IPlayer and this human player
 * makes their moves by user input 
 * via the console or the GUI
 * @author Sam
 */
public class HumanPlayer extends Player{
  
  public HumanPlayer(LocationState playerState) {
	  super(playerState);
  
  }

  /**
	 * Move which returns the players chosen column
	 */
  @Override
  
  public int getMove(Board board) {
	  

		System.out.print(board.toString());
		System.out.print("What column would " + "you like to place chip in"
				+ " \n ");
		Scanner userInput = new Scanner(System.in);
		int position = userInput.nextInt();
		if (position >= 0 && position < board.getNoCols()) {

			return position;

		} else {

			System.out.print("Invalid position entered" + "\n");
			getMove(board);
			return 0;
		

	}
    
    
  }
}

  
  

