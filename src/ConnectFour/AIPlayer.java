package ConnectFour;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import ConnectFour.Strategy;
import ConnectFour.LocationState;




/**
* Computer Player
* 
*/
public class AIPlayer extends Player {
	private Strategy strategy;

	public AIPlayer(LocationState locationstate, Strategy strategy) {
		super(locationstate, strategy.getName() + "-" + locationstate);
		this.strategy = strategy;
	}
	
	@Override
	public int[] determineMove() {
		System.out.println(getName() + " is generating move...");
		return strategy.generateMove(getLocationState());
	}
	
	public Strategy getStrategy() {
		return strategy;
	}


}

  
  

