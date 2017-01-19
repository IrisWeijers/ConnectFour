package ConnectFour;

/**
 * This class represents a board for the 3D Connect 4.
 * Board has n rows and n columns and n levels
 * These are pre-defined by the game rules
 * Contains a 3D dimensional arrays of locations
 * to be fill with players or chip colours to provide a better visual representation
 * 
 */

public class Board {

  /**
  * In the constructor we create and initialise the board using the following parameter
  */
  public Board(int col, int row,int level){
	  
		if (col > 0) {
			noCols = col;
		} else {
			noCols = 4;
		}
		if (row > 0) {
			noRows = row;
		} else {
			noCols = 4;
		}
	        if (level > 0) {
			noLevels = level;
		} else {
			noCols = 4;
		}
	  
		board = new LocationState[col][row];
		clear();
    
   }
  
  /**
  * This method sets each space on the board to empty
  */
  public void reset(){
	  for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++)
				for(int k =0; k < board[0].length; k++)
				board[i][j][k] = LocationState.EMPTY;

	}
  
  }
/**
* This method gets the location state (i.e player chip colour) at a particular location
*@param location 
*@return Location state as LocationState
*/
  public LocationState getLocationState( Location location) {
  }
  
  /**
  * This method take the location object as a parameter
  *Each location is essentially a point on the board
  * And each location has a current state
  * Limits the location within board boundaries 
  *@return True
  *@param location
  *
  */
  
  
  public boolean setLocationState(Location location, LocationState state) {
  }
  
  /** String representation of the object Board
  *
  *
  *
  */
  
  public String toString() {
  
  }
  
  /**
	 * Checks for horizontal win
	 * 
	 * @param
	 * @param
	 * @return
	 */
	public boolean checkHorizontal() {
  }
  
  /**
	 * Check for vertical win
	 * 
	 * @param
	 * @param
	 * @return
	 */
  
  public boolean checkVertical(){
  }
  
  	/**
	 * 
	 * Check diagonal left win
	 * 
	 * @param 
	 * @param 
	 * @return
	 */
  
  
	public boolean checkDiagLeft() {
  }
  
  	/**
	 * 
	 * Check diagonal right win
	 * 
	 * @param
	 * @param
	 * @return
	 */
	public boolean checkDiagRight() {
  
}
  
  
    public boolean gameOver(){
  }
  
  public boolean isFull(){
  }
