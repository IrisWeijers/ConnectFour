package ConnectFour;

import java.util.Observable;
import ConnectFour.Location;

public class Board extends Observable {
	public static int DIM = 4;
	private  LocationState[][][] board;
	
	/**
	 * Creates an empty board.
	 *  
	 */
	
	///
	//----- BOARD CONSTRUCTOR-----//
	public Board(){
		
		board = new LocationState[DIM][DIM][DIM];
		reset();
		
		for (int i = 0; i < DIM; i++ ){
			for (int j =0; j< DIM; j++) {
				for (int k = 0 ; k < DIM; k++){
					board[i][j][k]= LocationState.EMPTY;
				}
			}
		}
	}
		
	public int getDIM() {
		return DIM;
	}
	
	public static void setDIM(int dim) {
		DIM = dim;
	}

	
	
		/**
		  * This method sets each space on the board to empty
		  */
           public void reset(){
			  for (int i = 0; i < DIM; i++) {
					for (int j = 0; j < DIM; j++) {
						for(int k =0; k < DIM; k++) {
							board[i][j][k] = LocationState.EMPTY;
						}
					}
			  }

			}
		  
	 public Board deepCopy() {
				Board copy = new Board();
				 for (int i = 0; i < DIM; i++){
						for (int j = 0; j < DIM; j++){
							for(int k =0; k < DIM; k++) {
							copy.board[i][j][k] = this.board[i][j][k];
						}
					}
				 }
				return copy;
		}
	 
	
	   
	   /**
	    * This method take the location object as a parameter
	    *Each location is essentially a point on the board
	    * And each location has a current player
	    * Limits the location within board boundaries 
	    *@return True
	    *@param location
	    *
	    */
	    
	    /*
	     * @require location is in the board
	     * @ensure getLocationState(location).equals(player);
	     */
	    public boolean setLocationState(Location location, LocationState player) {
	  	  
	  	  if (location.getX() < DIM && location.getY() < DIM && location.getZ() < DIM){
	  			board[location.getX()][location.getY()][location.getZ()] = player;
	  			return true;
	  		}
	  		return false;
	    
	    
	    }
	    
	    public boolean isLocation(Location location) {
			return location.getX() < DIM && location.getX() >= 0 && location.getY() < DIM && location.getY() >= 0 && location.getZ() < DIM && location.getZ() >= 0;
		}
	    
	    
	    /**
		 * This method gets the location player (i.e player chip colour) at a particular location
		 *@param location 
		 *@return Location player as LocationState
		 */
		public LocationState getLocationState(Location location, LocationState player) {
			if (isLocation(location)) {
				return board[location.getX()][location.getY()][location.getZ()];
			} else {
				return null;
			}

		}
		
		
		public LocationState getLocation(int i, int j, int k) {
			return board[i][j][k];
		}
		
		public void setLocation(int i , int j, LocationState player) {
			int k;
			int tmp = 0;
			for(k = 0; k < getDIM(); k++) {
				if ( getLocation(i,j,k) == LocationState.EMPTY){
					tmp = k;
					k= getDIM();
				}
			}
			board[i][j][k]= player;

		}
		
		
//		public void setLocation(Location player) {
//			int x = player.getX();
//			int y = player.getY();
//			int z = player.getZ();
//			LocationState one = player.getLocation();
//			board[location.getX()][location.getY()][location.getZ()] = one;
//		}
		
	

		
		/**
		 * Checks for horizontal win
		 * 
		 * @param
		 * @param
		 * @return
		 */	
		public boolean checkHorizontal(LocationState player, Board board) {
			
			int stretch = 0;
			for (int i = 0; i < DIM; i++) {
				for (int j = 0; j < DIM; j++) {
					for (int k = 0; k < DIM; k++) {
					if (board[i][j][k] == player) {
						stretch = 1;
						while (j < DIM && board.getBoard()[i][++j][k] == player) {
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
	  
	 
		  public boolean checkVertical(LocationState player, Board board) {

				int stretch = 0;
				for (int i = 0; i < DIM; i++) {
					for (int j = 0; j < DIM; j++){
						for (int k = 0; k < DIM ; k++) {
						if (board.getBoard()[i][j][k] == player) {
							stretch=1;
							while (i < DIM && board.getBoard()[++i][j][k] == player) {
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
		  
		  public boolean CheckLevel(LocationState player) {
				boolean fullLevel;
				for (int i = 0; i < DIM; i++) {
					for (int j = 0; j < DIM; j++) {
						fullLevel = true;
						for (int k = 0; k < DIM; k++) {
							if (board[i][j][k] != player) {
								fullLevel = false;
							}
						}
						if (fullLevel) {
							return true;

						}
					}
				}
				return false;
			}

		  
		  public boolean hasRowColumn(LocationState player) {
				boolean fullRowColumn;
				for (int k = 0; k < DIM; k++) {
					fullRowColumn = true;
					for (int ij = 0; ij < DIM; ij++) {
						if (board[ij][ij][k] != player) {
							fullRowColumn = false;
						}
					}
					if (fullRowColumn) {
						return true;
					}
				}
				for (int k = 0; k < DIM; k++) {
					fullRowColumn = true;
					for (int ij = 0; ij < DIM; k++) {
						if (board[ij][DIM - ij - 1][k] != player) {
							fullRowColumn = false;
						}
					}
					if (fullRowColumn) {
						return true;
					}
				}
				return false;
			}
		  
		  public boolean hasRowHeight(LocationState player) {
				boolean fullRowHeight;
				for (int i = 0; i < DIM; i++) {
					fullRowHeight = true;
					for (int ik = 0; ik < DIM; ik++) {
						if (board[ik][i][ik] != player) {
							fullRowHeight = false;
						}
					}
					if (fullRowHeight) {
						return true;
					}
				}
				for (int i = 0; i < DIM; i++) {
					fullRowHeight = true;
					for (int ik = 0; ik < DIM; ik++) {
						if (board[ik][i][DIM - ik - 1] != player) {
							fullRowHeight = false;
						}
					}
					if (fullRowHeight) {
						return true;
					}
				}
				return false;
			}
		  
		  
		  public boolean hasColumnHeight(LocationState player) {
				boolean fullColumnHeight;
				for (int j = 0; j < DIM; j++) {
					fullColumnHeight = true;
					for (int jk = 0; jk < DIM; jk++) {
						if (board[j][jk][jk] != player) {
							fullColumnHeight = true;
						}
					}
					if (fullColumnHeight) {
						return true;
					}
				}
				for (int j = 0; j < DIM; j++) {
					fullColumnHeight = true;
					for (int jk = 0; jk < DIM; jk++) {
						if (board[j][jk][DIM - jk - 1] != player) {
							fullColumnHeight = true;
						}
					}
					if (fullColumnHeight) {
						return true;
					}
				}
				return false;
			}
		  
		  public boolean hasRowColumnHeight(LocationState player) {
				// booleans indicate start of diagonal in bottom level
				boolean diagTopLeft = true;
				boolean diagTopRight = true;
				boolean diagBottomLeft = true;
				boolean diagBottomRight = true;
				for (int ijk = 0; ijk < DIM; ijk++) {
					if (board[ijk][ijk][ijk] != player) {
						diagTopLeft = false;
					}
					if (board[DIM - ijk - 1][ijk][ijk] != player) {
						diagTopRight = false;
					}
					if (board[ijk][DIM - ijk - 1][ijk] != player) {
						diagBottomLeft = false;
					}
					if (board[DIM - ijk - 1][DIM - ijk - 1][ijk] != player) {
						diagBottomRight = false;
					}
				}

				return diagTopLeft || diagTopRight || diagBottomLeft || diagBottomRight;
			}
		  
		  public boolean isFull() {
				boolean full = true;
				for (int i = 0; i < DIM; i++) {
					for (int j = 0; j < DIM; j++) {
						for (int k = 0; k < DIM; k++) {
							if (board[i][j][k] == LocationState.EMPTY) {
								full = false;
							}
						}
					}
				}
				return full;
			}

			public boolean gameOver() {
				return isFull() || hasWinner();
			}

			public boolean hasWinner() {
				return isWinner(LocationState.RED) || isWinner(LocationState.YELLOW);
			}

			public boolean isWinner(LocationState player) {
				return checkHorizontal(player,board) || checkVertical(player ,board) || checkLevel(player, board) 
						|| hasRowHeight(m) || hasRowColumn(m) || hasColumnHeight(m) 
						|| hasRowColumnHeight(m);

			}

	    /** String representation of the object Board
	    *
	    *
	    *
	    */
	    
	    public String toString() {
	  	  
	  		String s = "";
	  		for (int i = 0; i < DIM; i++)
	  		{
	  			for (int j = 0; j < DIM; j++)
	  			{
	  				for (int k = 0; k < DIM; k++)
	  				{
	  					s += (board[j][i][k] + "\t");
	  				}
	  				s += "\n";
	  			}
	  			s += "\n";
	  		}

	  		return s;
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
		 * Setter method for 3d array
		 * 
		 * @param board
		 */
		public void setBoard(LocationState[][][] board)
			{
				this.board = board;
			}

	    
		
	}

	
	


