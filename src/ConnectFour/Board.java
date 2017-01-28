package ConnectFour;

import java.util.Observable;

public class Board extends Observable {
	public static int DIM = 4;
	private  LocationState[][][] board;
	
	/**
	 * Creates an empty board.
	 *  
	 */
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
		
		public void setLocation(Location location, LocationState player) {
			board[location.getX()][location.getY()][location.getZ()] = player;

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
					if (board.getBoard()[i][j][k] == player) {
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
				for (int j = 0; j < DIM; j++) {
					for (int i = 0; i < DIM; i++) {
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

	
	


