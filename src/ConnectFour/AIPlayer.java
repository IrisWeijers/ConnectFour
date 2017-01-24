package ConnectFour;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;




/**
* Computer Player
* 
*/
public class AIPlayer extends Player {

	//iinstance variables
	//the intial the number of moves taken by the AI Player
	private int movesTaken = 0;
  
	
	
	
	
	
public AIPlayer(LocationState playerState) {
		
		super(playerState);

	}

/**
 * Method that returns the computer players chosen column.
 */
@Override
public int getMove(Board board) {
	System.out.print(board.toString() + "\n");

	int chosenColumn = 0;

	if (movesTaken == 0) {
		
		chosenColumn = tryTakeCentre(board);
		return chosenColumn;
	} 
	else {

		return bestMove(board);

	}
}

  
  
}
