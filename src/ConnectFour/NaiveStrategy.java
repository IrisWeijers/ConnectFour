package ConnectFour;

import ConnectFour.LocationState;

public class NaiveStrategy extends Strategy {
	
	public NaiveStrategy() {
		super();

	}

	@Override
	public String getName() {

		return "Naive";
	}

	@Override
	public int[] generateMove(LocationState player) {
		return randomMove();
	}


}
