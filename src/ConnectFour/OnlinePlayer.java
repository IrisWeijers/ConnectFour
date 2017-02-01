package ConnectFour;


import ConnectFour.LocationState;
import ConnectFour.Player;

public class OnlinePlayer extends Player {
	private int[] moveBuffer;

	public OnlinePlayer(LocationState player, String n) {
		super(player, n);
		moveBuffer = new int[2];
		moveBuffer[0] = -1;

	}

	@Override
	public int[] determineMove() {
		return moveBuffer;
	}

	public void setMoveBuffer(int[] moveBuffer) {
		this.moveBuffer = moveBuffer;
	}
	
	public int getMoveBuffer() {
		return moveBuffer[0];
	}

	@Override
	public int getMove(Board board) {
		return 0;
	}
}