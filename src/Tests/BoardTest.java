package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ConnectFour.Board;
import ConnectFour.Location;
import ConnectFour.LocationState;

public class BoardTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testSetLocationState(){
		Board board = new Board(4,4,4);
		for (int x = 0;x < 4; x++){
			for (int y = 0;y < 4; y++){
				for (int z = 0;z < 4; z++){
					board.setLocationState(new Location(x,y,z), LocationState.RED);
					assertEquals(LocationState.RED, board.getLocationState(new Location(x,y,z)));
					
					board.setLocationState(new Location(x,y,z), LocationState.YELLOW);
					assertEquals(LocationState.YELLOW, board.getLocationState(new Location(x,y,z)));
				}
			}
		}
	}

}
