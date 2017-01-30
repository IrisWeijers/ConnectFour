package ConnectFour;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import ConnectFour.Board;


public class HumanTUI implements Observer {

	private Board board;
	
	private static final String RowSeparator = "     ---+---+---+---    ---+---+---+---    ---+---+---+---    ---+---+---+---"
			+ "     -----+-----+-----+-----";
	private static final String Separator = "      ";
	private static final String Zline = "          z = 1              z = 2              z = 3              z = 4";

	public HumanTUI (Board s) {
		this.board = s;
		board.addObserver(this);
	}
	
	public String boardtoString(Board b){
		int height = 0 ;
		int row = 0;
		int col = 0;
		int layer = 0; 
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < board.getNoRows(); i++) {
			String row = "";
			for (int j = 0; j < board.getNoCols(); j++) {
				int xcounter = 0;
				for (int k = 0; k < board.getNoLevels(); k++){
					if (x == 0) {
						row = row + Separator + board.getField(board.getIndex(x, y, z)).toString();
						xcounter ++;
					} else if (z == 3 && x == 3) {
						row = row + " | " + board.getField(board.getIndex(x, y, z)).toString() 
						+ Separator + "(0," + y + ")" + "|" + "(1," + y + ")" + "|" + "(2," + y + ")" + "|" + "(3," + y + ")";
					} else {
						row = row + " | " + board.getField(board.getIndex(x, y, z)).toString();
					}
				}
			}
			if (s.equals("")) {
				s = "\n" + row;
			} else {
				s = s + "\n" + RowSeparator + "\n" + row;
			}
		}
		s = s + "\n" + Zline;
		return s + "\n";
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println(this.toString());

	}

	public static void main(String[] args) {
		Board s = new Board();
		HumanTUI v = new HumanTUI(s);
		b.playField(0, Mark.X);
	}
}

