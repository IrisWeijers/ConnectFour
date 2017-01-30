package ConnectFour;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import ConnectFour.Board;


public class HumanTUI implements Observer {
	private String Boardgraphic;

	private Board board;
	
	public static final String EMPTY = "   ";
	public static final String YELLOW = "YELLOW";
	public static final String RED = "RED";
	
	public HumanTUI (Board s) {
		this.board = s;
		Boardgraphic = boardtostring(board);
	}
	
	public String boardtostring(Board brd1){
		int height = 0 ;
		int row = 0;
		int col = 0;
		int layer = 0; 
		
		final int levelLength = "level".length();
		
		Boardgraphic = "";
		
		// HACK: (int) ((3 * brd1.getDIM() + brd1.getDIM() + 1) - levelLength)/2 calculates how many 
				// spaces does layer i need to its left and its right for it 
				// to be centered on top of its board
		
		
		for(int i = 0; i < brd1.getDIM(); i++) {
			for(int j = 0; j < (int) ((3 * brd1.getDIM() + brd1.getDIM() + 1) - levelLength)/2; j++) {
					Boardgraphic = Boardgraphic + " ";
				}
			Boardgraphic = Boardgraphic + "layer " + i;
			for(int j = 0; j < (int) ((3 * brd1.getDIM() + brd1.getDIM() + 1) - levelLength)/2; j++) {
					Boardgraphic = Boardgraphic + " ";
				}
			Boardgraphic = Boardgraphic + "  ";	
			}
		Boardgraphic = Boardgraphic + "\n";
		for(int k = 0; k < brd1.getDIM(); k++) {
			for(int i = 0; i < brd1.getDIM(); i++) {
				for(int j = 0; j < brd1.getDIM(); j++) {
						Boardgraphic = Boardgraphic + "+---";
					}
				Boardgraphic = Boardgraphic + "+  ";
				}
				Boardgraphic = Boardgraphic + "\n";
				for(int i = 0; i < brd1.getDIM(); i++) {
					for(int j = 0; j < brd1.getDIM(); j++) {
						Boardgraphic = Boardgraphic + "|" + locationtostring(col,row,height);
						col++;
					}
				height++;
				col = 0;
				Boardgraphic = Boardgraphic + "|  "; 
			}
			Boardgraphic = Boardgraphic + "\n";
			height = 0;
			row++;
		}
		for(int i = 0; i < brd1.getDIM(); i++) {
			for(int j = 0; j < brd1.getDIM(); j++) {
				Boardgraphic = Boardgraphic + "+---";
			}
			Boardgraphic = Boardgraphic + "+  ";
		}
		Boardgraphic = Boardgraphic + "\n";
		return Boardgraphic;
	}
		
		
	public String locationtostring(int i , int j, int k) {
		if (board.getLocation(i, j, k) == LocationState.EMPTY) {
			return EMPTY;
		} else if (board.getLocation(i, j, k) == LocationState.YELLOW) {
			return YELLOW;
		} else if (board.getLocation(i, j, k) == LocationState.RED) {
			return RED;
		}
		return EMPTY;
	}
	

	
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println(this.boardtostring(board));

	}

	
	public Board getBoard() {
		return board;
	}

	
	}



