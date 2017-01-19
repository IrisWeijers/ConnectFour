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

	private LocationState	board[][][];
	private int				noCols;
	private int             noRows;
	private int             noLevels;

	/**
	 * 
	 * This constructor creates and initialises the board.
	 * @param col
	 * The number of columns in the board
	 * @param row
	 * The number of rows in the board
	 * @param level
	 * The number of levels in the board
	 * @see LocationState
	 */
  public Board(int col, int row, int level){
	  
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
	  
		board = new LocationState[col][row][level];
		reset();
    
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
  
  
/**
* This method gets the location state (i.e player chip colour) at a particular location
*@param location 
*@return Location state as LocationState
*/
  public LocationState getLocationState( Location location) {
	  

		return board[location.getX()][location.getY()][location.getZ()];

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
	  
	  if (location.getX() < getNoCols() && location.getY() < getNoRows() && location.getZ() < getNoLevels()){
			board[location.getX()][location.getY()][location.getZ()] = state;
			return true;
		}
		return false;
  
  
  }
  
  /** String representation of the object Board
  *
  *
  *
  */
  
  public String toString() {
	  
		String s = "";
		for (int i = 0; i < noRows; i++)
		{
			for (int j = 0; j < noCols; j++)
			{
				for (int k = 0; k < noLevels; k++)
				{
			
				s += (board[j][i][k] + "\t");
			s += "\n";
		     }
		   }
		}

		return s;
  }
  
  
  
  
  
  
  /**
	 * Gets the number of columns on the board.
	 * 
	 * @return number of columns on board as an integer
	 */
	public int getNoCols()
		{
			return noCols;
		}

	/**
	 * Gets the number of rows on the board.
	 * 
	 * @return number of rows on board as an integer
	 */
	public int getNoRows()
		{
			return noRows;
		}
	/**
	 * Gets the number of rows on the board.
	 * 
	 * @return number of rows on board as an integer
	 */
	public int getNoLevels()
		{
			return noLevels;
		}

	/**
	 * Getter method for two dimensional array
	 * @return
	 */
	public LocationState[][][] getBoard()
		{
			return board;
		}

	/**
	 * Setter method for 2d array
	 * 
	 * @param board
	 */
	public void setBoard(LocationState[][][] board)
		{
			this.board = board;
		}

	/**
	 * Setter method for number of columns
	 * on the board
	 * @param noCols
	 */
	public void setNoCols(int noCols) {
		if (noCols > 0) {
			this.noCols = noCols;
		}
	}

	/**
	 * Setter method for number of
	 * rows on the board
	 * @param noRows
	 */
	public void setNoRows(int noRows)
		{
			if (noRows>0){
			this.noRows = noRows;
			}
		}
	
	/**
	 * Setter method for number of
	 * rows on the board
	 * @param noLevels
	 */
	public void setNoLevels(int noLevels)
		{
			if (noLevels>0){
			this.noLevels = noLevels;
			}
		}


  
  
  
  
  
  
  /**
	 * Checks for horizontal win
	 * 
	 * @param
	 * @param
	 * @return
	 */
	public boolean checkHorizontal(LocationState Player, Board board) {
		
		int stretch = 0;
		for (int row = board.getNoRows(); row >= 0; row--) {
			for (int col = 0; col < board.getNoCols(); col++) {
				for (int level = 0; level < board.getNoLevels(); level++) {
				if (board.getBoard()[col][row][level] == Player) {
					stretch = 1;
					while (board.getBoard()[++col][row][++level] == Player) {
						stretch++;
						if (stretch == 4) {
							return true ;
						}
					}
					
				}
			  }
			}
		}
		return false;
		
		
  }
  
  /**
	 * Check for vertical win
	 * 
	 * @param
	 * @param
	 * @return
	 */
  
 
	  public boolean checkVertical(LocationState Player, Board board) {

			int stretch = 0;
			for (int col = 0; col < board.getNoCols(); col++) {
				for (int row = 0; row < board.getNoRows(); row++) {
					for (int level = 0; level < board.getNoLevels() ; level++) {
					if (board.getBoard()[col][row][level] == Player) {
						while (board.getBoard()[col][row++][level] == Player) {
							stretch++;
							if (stretch == 4) {
								return true;
							}
						}

					  }

				   }
				}
			}
			return false;
			
			
  }
  
  	/**
	 * 
	 * Check diagonal left win
  	 * @param 
	 * 
	 * @param 
	 * @param 
	 * @return
	 */
  
  

		public boolean checkDiagLeft(LocationState Player, Board board ) {

			int stretch = 0;
			for (int col = 0; col < board.getNoCols(); col++) {
				for (int row = 0; row < board.getNoRows() ; row++) {
					for (int level = 0; level < board.getNoLevels() ; level++) {
					if (board.getBoard()[col][row][level] == Player) {
						for (int tmpRow = row, tmpCol = col, tmplevel = level; board.getBoard()[tmpCol++][tmpRow++][tmplevel++] == Player;) {
							if (++ stretch == 4) {
								return true ;
							}
						}
						
					}
				 }
				
			   }
			}
			return false;

		
		
		
  }
  
  	/**
	 * 
	 * Check diagonal right win
	 * 
	 * @param
	 * @param
	 * @return
	 */
		public boolean checkDiagRight(LocationState Player, Board board) {

			int stretch = 0;
			for (int col = board.getNoCols() ; col > 2; col--) {
				for (int row = 0; row < 3; row++) {
					for (int level = 0; level < 3; level++) {
					if (board.getBoard()[col][row][level] == Player) {
						for (int tmpRow = row, tmpCol = col, tmplevel = level; board.getBoard()[tmpCol--][tmpRow++][tmplevel++] == Player;) {
							stretch++;
							if (stretch == 4) {
								return true;
							}
						}
						
					}
				  }
				}

			}
			return false;
		}

  
  
    public boolean gameOver(){
  }
  
  public boolean isFull(){
  }
  

}
