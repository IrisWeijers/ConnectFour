package ConnectFour;


import java.util.ArrayList;
import java.util.List;

import ConnectFour.Board;
import ConnectFour.LocationState;

public class SmartStrategy extends Strategy {

	public SmartStrategy() {
		super();
	}

	@Override
	public String getName() {
		return "Smart";
	}

	@Override
	public int[] generateMove(LocationState player) {
		List<int[]> myList = getPossibleMoves(getBoard());
		Board board = getBoard();
		// check if you have a winning move
		for (int i = 0; i < myList.size(); i++) {
			Board tmp = board.deepCopy();
			tmp.setLocation(myList.get(i)[0], myList.get(i)[1], player);
			if (tmp.isWinner(player)) {
				return myList.get(i);
			}
		}
		// check if the enemy has a winning move
		for (int i = 0; i < myList.size(); i++) {
			Board tmp = board.deepCopy();
			tmp.setLocation(myList.get(i)[0], myList.get(i)[1], player.next(player));
			if (tmp.isWinner(player.next(player))) {
				return myList.get(i);
			}
		}
		// for all possible moves, check if the move you're going to make
		// creates a win condition for the enemy
		List<int[]> smartMoves = new ArrayList<int[]>();
		for (int i = 0; i < myList.size(); i++) {
			Board tmp = board.deepCopy();
			tmp.setLocation(myList.get(i)[0], myList.get(i)[1], player);
				List<int[]> futureList = getPossibleMoves(tmp);
				boolean valid = true;
				for (int j = 0; j < futureList.size(); j++) {
					tmp.setLocation(futureList.get(j)[0], futureList.get(j)[1], player.next(player));
					if (tmp.isWinner(player.next(player))) {
						valid = false;
					}
				}
					if (valid) {
						smartMoves.add(myList.get(i));
					}
			}
		if(smartMoves.size() < 1) {
			return randomMove();
		} else {
			return (smartMoves.get((int) (Math.random() * smartMoves.size())));
		}
	}
}
