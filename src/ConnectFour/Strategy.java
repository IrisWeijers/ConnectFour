package ConnectFour;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import ConnectFour.LocationState;
import ConnectFour.Board;

public abstract class Strategy implements Observer {
	
	private Board board;

	public abstract String getName();

	public abstract int[] generateMove(LocationState player);

	public Strategy() {
		board = new Board();
	}

	public Board getBoard() {
		return board;
	}

	public int[] randomMove() {
		List<int[]> myList = getPossibleMoves(getBoard());
		return myList.get((int) (Math.random() * myList.size()));
	}

	public List<int[]> getPossibleMoves(Board tmp) {
		List<int[]> myList = new ArrayList<int[]>();
		for (int col = 0; col < tmp.getDIM(); col++) {
			for (int row = 0; row < tmp.getDIM(); row++) {
				
				if (tmp.getLocation(col, row, tmp.getDIM() - 1) == LocationState.EMPTY) {
					int[] move = new int[2];
					move[0] = col;
					move[1] = row;
					myList.add(move);
				}
			}
		}
		return myList;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		board = (Board) arg0;
	}


}
