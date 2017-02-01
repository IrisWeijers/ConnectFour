package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ConnectFour.SmartStrategy;
import ConnectFour.NaiveStrategy;
import ConnectFour.Game;
import ConnectFour.LocationState;
import ConnectFour.AIPlayer;
import ConnectFour.Player;

	public class GameTest {
		public static void main(String[] args) {
			Player p1 = new AIPlayer(LocationState.YELLOW, new NaiveStrategy());
			Player p2 = new AIPlayer(LocationState.RED, new SmartStrategy());
			Game game = new Game(p1, p2, true);
			game.run();
		}
	}


