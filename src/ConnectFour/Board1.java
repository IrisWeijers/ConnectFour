package ConnectFour;

public class Board1 {
	private static final int DIM = 4;
	private  LocationState[][][] board;
	
	/**
	 * Creates an empty board.
	 */
	//----- BOARD CONSTRUCTOR-----//
	public Board1(){
		
		board = new LocationState[DIM][DIM][DIM];
		
		for (int i = 0; i < DIM; i++ ){
			for (int j =0; j< DIM; j++) {
				for (int k = 0 ; k < DIM; k++){
					board[i][j][k]= LocationState.EMPTY;
				}
			}
		}
		
		
		
		/**
		  * This method sets each space on the board to empty
		  */
		  public void reset();{
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
		
	}

	private void reset() {
		// TODO Auto-generated method stub
		
	}
	
	

}
