package ConnectFour;

import java.util.Observable;


/**
 * 
 * @author Sam , Iris
 *
 */

public class Board extends Observable {
	public static int DIM = 4;
	private  LocationState[][][] board;

	/**
	 * Creates an empty board.
	 *  
	 */
	/*@
	 invariant (\forall int i, j, k; 0 <= j & j < getDIM() & 0 <= i & i < getDIM() &
	   0 <= k & k < getDIM(); getField(i, j, k) == Location.EMPTY || getField(i, j, k) == LocationState.YELLOW ||
	   getField(i, j, k) == LocationState.RED);
	 */

	/*@
	  ensures (\forall int i, j, k; 0 <= j & j < getDIM() & 0 <= i & i < getDIM() &
	   0 <= k & k < getDIM(); getField(i, j, k) == LocationState.EMPTY);
	 */
	///
	//----- BOARD CONSTRUCTOR-----//



	public Board(){

		board = new LocationState[DIM][DIM][DIM];
		reset();
	}

	/**
	 * Returns the dimensions of all boards.
	 * @return the dimensions of the boards.
	 */

	public int getDIM() {
		return DIM;
	}
	/**
	 * Sets the Dimensions of all boards instances.
	 * 
	 * @param dimension 
	 * the supposed new dimension of the boards.
	 * 
	 */
	//@requires dimension > 0;
	//@ensures (\forall Board b; b.getDIM() == dim);
	public static void setDIM(int dim) {
		DIM = dim;
	}



	/**
	 * This method sets each space on the board to empty
	 * 
	 * /**
	 * Resets the board by setting all fields to an empty mark.
	 */
	/*@
	  ensures (\forall int c, r, h; 0 <= c & c < getDIM() & 0 <= r & r < getDIM() &
	   0 <= h & h < getDIM(); getField (c, r, h) == Mark.EMPTY);
	 */

	public void reset(){
		for (int j = 0; j < DIM; j++) {
			for (int i = 0; i < DIM; i++) {
				for(int k =0; k < DIM; k++) {
					board[j][i][k] = LocationState.EMPTY;
				}
			}
		}
		this.setChanged();
		this.notifyObservers();

	}

	/**
	 * Returns a deepCopy() of the current board state.
	 * @return copy of the current board state.
	 */
	//@ensures this.equals(deepCopy());
	//@pure

	public Board deepCopy() {
		Board copy = new Board();
		for (int j = 0; j < DIM; j++){
			for (int i = 0; i < DIM; i++){
				for(int k =0; k < DIM; k++) {
					copy.board[j][i][k] = this.board[j][i][k];
				}
			}
		}
		return copy;
	}

	/**
	 * Sets a mark on the board by giving a column and a row as a parameter.
	 * A gravity algorithm takes care of the height of the mark.
	 * @param col column in which the mark is supposed to be put.
	 * @param row row in which the mark is supposed to be put.
	 * @param m mark that has to be set for the specified field.
	 */
	//@requires col >= 0 & col < getDIM();
	//@requires row >= 0 & row < getDIM();
	//@ensures (\exists int h; h >= 0 & h < getDIM(); getField(col, row, h) == m);

	public void setLocation(int j, int i, LocationState player) {
		int k;
		int tmp = 0;
		for (k = 0; k < getDIM(); k++) {
			if (getLocation(j, i, k) == LocationState.EMPTY) {
				tmp = k;
				k = getDIM();
			}
		}
		board[j][i][tmp] = player;
		this.setChanged();
		this.notifyObservers();
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
	public boolean setLocationState(int j, int i, int k, LocationState player) {

		if (i < DIM && j < DIM && k < DIM){
			board[j][i][k] = player;
			return true;
		}
		return false;


	}

	public boolean isLocation(int j, int i, int k) {
		return i < DIM && i >= 0 && j < DIM && j >= 0 && k < DIM && k >= 0;
	}




	/**
	 * Returns the mark of a specified field.
	 * @param col column in which the required field occurs.
	 * @param row row in which the required field occurs.
	 * @param height height on which the required field occurs.
	 * @return mark of the specified field.
	 */
	//@requires col >= 0 & col < getDIM();
	//@requires row >= 0 & row < getDIM();
	//@requires height >= 0 & height < getDIM();
	//@pure
	public LocationState getLocation(int j, int i, int k) {
		return board[j][i][k];
	}






	/**
	 * Checks whether the given mark meets the win condition of having an entire row of marks.
	 * @param m the mark for which the win condition should be checked
	 * @return true if win condition is met, false if win condition is not met.
	 */
	/*@ensures \result == (\exists int c, h; c >= 0 & h >= 0 & c < getDIM() & h < getDIM();
		  (\forall int r; r >= 0 & r < getDIM(); getField(c, r, h) == m));
		@pure
	 */



	public boolean checkHorizontal(LocationState player) {
		boolean fullRow;
		for (int i = 0; i < DIM; i++) {
			for (int k = 0; k < DIM; k++) {
				fullRow = true;
				for (int j = 0; j < DIM; j++) {
					if (board[j][i][k] != player) {
						fullRow = false;
					}
				}
				if (fullRow) {
					return true;

				}
			}
		}
		return false;

	}

	/**
	 * Checks whether the given mark meets the win condition of having an entire column of marks.
	 * @param m the mark for which the win condition should be checked
	 * @return true if win condition is met, false if win condition is not met.
	 */
	/*@ensures \result == (\exists int r, h; r >= 0 & h >= 0 & r < getDIM() & h < getDIM();
		  (\forall int c; c >= 0 & c < getDIM(); getField(c, r, h) == m));
		@pure
	 */



	public boolean checkVertical(LocationState player) {
		boolean fullCol;
		for (int j = 0; j < DIM; j++) {
			for (int k = 0; k < DIM; k++) {
				fullCol = true;
				for (int i = 0; i < DIM; i++) {
					if (board[j][i][k] != player) {
						fullCol = false;
					}
				}
				if (fullCol) {
					return true;

				}
			}
		}
		return false;
	}



	/**
	 * Checks whether the given mark meets the win condition of having a stack of
	 * marks matching the height of the board.
	 * @param m the mark for which the win condition should be checked
	 * @return true if win condition is met, false if win condition is not met.
	 */
	/*@ensures \result == (\exists int r, c; r >= 0 & c >= 0 & r < getDIM() & c < getDIM();
				  (\forall int h; h >= 0 & h < getDIM(); getField(c, r, h) == m));
				@pure
	 */

	public boolean CheckLevel(LocationState player) {
		boolean fullLevel;
		for (int i = 0; i < DIM; i++) {
			for (int j = 0; j < DIM; j++) {
				fullLevel = true;
				for (int k = 0; k < DIM; k++) {
					if (board[j][i][k] != player) {
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

	/**
	 * Checks whether the given mark meets the win condition of having a diagonal in the plains
	 * of rows and columns.
	 * @param m the mark for which the win condition should be checked
	 * @return true if win condition is met, false if win condition is not met.
	 */
	/*@ensures \result == (\exists int h; h >= 0 & h < getDIM();
				  (\forall int rc; rc >= 0 & rc < getDIM(); getField(rc, rc, h) == m) ||
				  (\forall int rc; rc >= 0 & rc < getDIM(); getField(rc, rc - getDIM(), h) == m));
				@pure
	 */




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
			for (int ij = 0; ij < DIM; ij++) {
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

	/**
	 * Checks whether the given mark meets the win condition of having a diagonal in the plains
	 * of rows and height.
	 * @param m the mark for which the win condition should be checked
	 * @return true if win condition is met, false if win condition is not met.
	 */
	/*@ensures \result == (\exists int c; c >= 0 & c < getDIM();
			  (\forall int rh; rh >= 0 & rh < getDIM(); getField(c, rh, rh) == m) ||
			  (\forall int rh; rh >= 0 & rh < getDIM(); getField(c, rh - getDIM(), rh) == m));
			@pure
	 */

	public boolean hasRowLevel(LocationState player) {
		boolean fullRowLevel;
		for (int i = 0; i < DIM; i++) {
			fullRowLevel = true;
			for (int ik = 0; ik < DIM; ik++) {
				if (board[ik][i][ik] != player) {
					fullRowLevel = false;
				}
			}
			if (fullRowLevel) {
				return true;
			}
		}
		for (int i = 0; i < DIM; i++) {
			fullRowLevel = true;
			for (int ik = 0; ik < DIM; ik++) {
				if (board[ik][i][DIM - ik - 1] != player) {
					fullRowLevel = false;
				}
			}
			if (fullRowLevel) {
				return true;
			}
		}
		return false;
	}


	/**
	 * Checks whether the given mark meets the win condition of having a diagonal in the plains
	 * of columns and height.
	 * @param m the mark for which the win condition should be checked
	 * @return true if win condition is met, false if win condition is not met.
	 */
	/*@ensures \result == (\exists int r; r >= 0 & r < getDIM();
			  (\forall int ch; ch >= 0 & ch < getDIM(); getField(ch, r, ch) == m) ||
			  (\forall int ch; ch >= 0 & ch < getDIM(); getField(ch - getDIM(), r, ch) == m));
			@pure
	 */


	public boolean hasColumnLevel(LocationState player) {
		boolean fullColumnLevel;
		for (int j = 0; j < DIM; j++) {
			fullColumnLevel = true;
			for (int jk = 0; jk < DIM; jk++) {
				if (board[j][jk][jk] != player) {
					fullColumnLevel = false;
				}
			}
			if (fullColumnLevel) {
				return true;
			}
		}
		for (int j = 0; j < DIM; j++) {
			fullColumnLevel = true;
			for (int jk = 0; jk < DIM; jk++) {
				if (board[j][jk][DIM - jk - 1] != player) {
					fullColumnLevel = false;
				}
			}
			if (fullColumnLevel) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks whether the given mark meets the win condition of having a 3 dimensional
	 * diagonal of equal length of the boards dimensions.
	 * @param m the mark for which the win condition should be checked
	 * @return true if win condition is met, false if win condition is not met.
	 */
	/*
			@ensures \result == (\forall int i; i >= 0 & i < getDIM(); getField(i, i, i) == m) ||
			(\forall int i; i >= 0 & i < getDIM(); getField(i - getDIM(), i, i) == m) ||
			(\forall int i; i >= 0 & i < getDIM(); getField(i, i - getDIM(), i) == m) ||
			(\forall int i; i >= 0 & i < getDIM(); getField(i - getDIM(), i - getDIM(), i) == m);
			@pure
	 */

	public boolean hasRowColumnLevel(LocationState player) {
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




	/**
	 * Checks whether the board is full. In other words if there are still empty marks in the board.
	 * @return true if board is full, false if there are still empty marks left.
	 */
	/*@
			  ensures \result == (\forall int c, r, h; 0 <= c & c < getDIM() & 0 <= r & r < getDIM() &
			   0 <= h & h < getDIM(); getField(c, r, h) != Mark.EMPTY);
	 */
	//@pure

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

	/**
	 * Checks whether the game is over. The game is over when board is either full, or
	 * there one of the marks meets a win condition.
	 * @return true if the game is over, false is the game is not yet over.
	 */
	//@ensures \result == isFull() || hasWinner();
	//@pure

	public boolean gameOver() {
		return isFull() || hasWinner();
	}

	/**
	 * Indicates if one of the marks (not the empty mark) meets a win condition.
	 * @return true if one of the marks meets a win condition, false if none of 
	 * the marks meets a win condition.
	 */
	//@ensures \result == isWinner(Mark.O) || isWinner(Mark.X);
	//@pure

	public boolean hasWinner() {
		return isWinner(LocationState.RED) || isWinner(LocationState.YELLOW);
	}

	/**
	 * Checks whether the given mark meets any of the win conditions.
	 * @param m mark for which needs to be checked whether one of the win conditions
	 * has been met.
	 * @return true if mark meets a win condition, false if mark doesn't meet any
	 * win condition.
	 */
	/*
			@requires m != Mark.EMPTY;
			@ensures \result == hasRow(m) || hasColumn(m) || hasHeight(m) 
			|| hasRowHeight(m) || hasRowColumn(m) || hasColumnHeight(m) 
			|| hasRowColumnHeight(m);
	 */
	//@pure

	public boolean isWinner(LocationState player) {
		return checkHorizontal(player) || checkVertical(player) || CheckLevel(player) 
				|| hasRowLevel(player) || hasRowColumn(player) || hasColumnLevel(player) 
				|| hasRowColumnLevel(player);

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

	/**
	 * Checks if the locationstate player has won. A  locationstate wins if it controls at
	 * least one row, column or diagonal.
	 *
	 * @param player
	 *            the mark of interest
	 * @return true if the mark has won
	 */
	//@requires m == LocationState.YELLOW | m == LocationState.RED;
	//@ ensures \result == this.hasRow(m) || this.hasColumn(m) | this.hasDiagonal(m);
	/*@ pure */


	/**
	 * Returns true if the game has a winner. This is the case when one of the
	 * marks controls at least one row, column or diagonal.
	 *
	 * @return true if the game has a winner.
	 */
	//@ ensures \result == isWinner(LocationState.YELLOW) | \result == isWinner(LocationState.RED);
	/*@pure*/



	/**
	 * Checks for a drawn game.
	 * 
	 * @return
	 */
	public boolean isDraw() {
		if (isFull() && !hasWinner()){
			return true;
		}
		return false;
	}  

}





