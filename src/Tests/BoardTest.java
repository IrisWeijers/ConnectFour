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
	
	@Test
	public void testCheckHorizontal() {
		Board board = new Board(4,4,4);
		board.setLocationState(new Location(1,1,1), LocationState.YELLOW);
		board.setLocationState(new Location(1,2,1), LocationState.YELLOW);
		board.setLocationState(new Location(1,3,1), LocationState.YELLOW);
		board.setLocationState(new Location(1,4,1), LocationState.YELLOW);
		
		assertTrue(board.checkHorizontal(LocationState.YELLOW, board));
		assertFalse(board.checkHorizontal(LocationState.RED, board));
	}
	
	@Test
	public void testCheckVertical() {
		Board board = new Board(4,4,4);
		board.setLocationState(new Location(1,1,1), LocationState.YELLOW);
		board.setLocationState(new Location(2,1,1), LocationState.YELLOW);
		board.setLocationState(new Location(3,1,1), LocationState.YELLOW);
		board.setLocationState(new Location(4,1,1), LocationState.YELLOW);
		
		assertTrue(board.checkVertical(LocationState.YELLOW, board));
		assertFalse(board.checkVertical(LocationState.RED, board));
	}
	
	@Test
	public void testCheckDiagLeft() {
		Board board = new Board(4,4,4);
		board.setLocationState(new Location(1,1,1), LocationState.YELLOW);
		board.setLocationState(new Location(2,2,1), LocationState.YELLOW);
		board.setLocationState(new Location(3,3,1), LocationState.YELLOW);
		board.setLocationState(new Location(4,4,1), LocationState.YELLOW);
		
		assertTrue(board.checkDiagLeft(LocationState.YELLOW, board));
		assertFalse(board.checkDiagLeft(LocationState.RED, board));
	}
	
	@Test
	public void testCheckDiagRight() {
		Board board = new Board(4,4,4);
		board.setLocationState(new Location(1,4,1), LocationState.YELLOW);
		board.setLocationState(new Location(2,3,1), LocationState.YELLOW);
		board.setLocationState(new Location(3,2,1), LocationState.YELLOW);
		board.setLocationState(new Location(4,1,1), LocationState.YELLOW);
		
		assertTrue(board.checkDiagRight(LocationState.YELLOW, board));
		assertFalse(board.checkDiagRight(LocationState.RED, board));
		
	}
	
	@Test
	public void testIsFull(){
		Board board = new Board(4,4,4);
		board.setLocationState(new Location(1,1,1), LocationState.RED);
		board.setLocationState(new Location(1,1,2), LocationState.RED);
		board.setLocationState(new Location(1,1,3), LocationState.RED);
		board.setLocationState(new Location(1,1,4), LocationState.RED);
		board.setLocationState(new Location(1,2,1), LocationState.RED);
		board.setLocationState(new Location(1,2,2), LocationState.RED);
		board.setLocationState(new Location(1,2,3), LocationState.RED);
		board.setLocationState(new Location(1,2,4), LocationState.RED);
		board.setLocationState(new Location(1,3,1), LocationState.RED);
		board.setLocationState(new Location(1,3,2), LocationState.RED);
		board.setLocationState(new Location(1,3,3), LocationState.RED);
		board.setLocationState(new Location(1,3,4), LocationState.RED);
		board.setLocationState(new Location(1,4,1), LocationState.RED);
		board.setLocationState(new Location(1,4,2), LocationState.RED);
		board.setLocationState(new Location(1,4,3), LocationState.RED);
		board.setLocationState(new Location(1,4,4), LocationState.RED);
		board.setLocationState(new Location(2,1,1), LocationState.RED);
		board.setLocationState(new Location(2,1,2), LocationState.RED);
		board.setLocationState(new Location(2,1,3), LocationState.RED);
		board.setLocationState(new Location(2,1,4), LocationState.RED);
		board.setLocationState(new Location(2,2,1), LocationState.RED);
		board.setLocationState(new Location(2,2,2), LocationState.RED);
		board.setLocationState(new Location(2,2,3), LocationState.RED);
		board.setLocationState(new Location(2,2,4), LocationState.RED);
		board.setLocationState(new Location(2,3,1), LocationState.RED);
		board.setLocationState(new Location(2,3,2), LocationState.RED);
		board.setLocationState(new Location(2,3,3), LocationState.RED);
		board.setLocationState(new Location(2,3,4), LocationState.RED);
		board.setLocationState(new Location(2,4,1), LocationState.RED);
		board.setLocationState(new Location(2,4,2), LocationState.RED);
		board.setLocationState(new Location(2,4,3), LocationState.RED);
		board.setLocationState(new Location(2,4,4), LocationState.RED);		
		board.setLocationState(new Location(3,1,1), LocationState.YELLOW);
		board.setLocationState(new Location(3,1,2), LocationState.YELLOW);
		board.setLocationState(new Location(3,1,3), LocationState.YELLOW);
		board.setLocationState(new Location(3,1,4), LocationState.YELLOW);
		board.setLocationState(new Location(3,2,1), LocationState.YELLOW);
		board.setLocationState(new Location(3,2,2), LocationState.YELLOW);
		board.setLocationState(new Location(3,2,3), LocationState.YELLOW);
		board.setLocationState(new Location(3,2,4), LocationState.YELLOW);
		board.setLocationState(new Location(3,3,1), LocationState.YELLOW);
		board.setLocationState(new Location(3,3,2), LocationState.YELLOW);
		board.setLocationState(new Location(3,3,3), LocationState.YELLOW);
		board.setLocationState(new Location(3,3,4), LocationState.YELLOW);
		board.setLocationState(new Location(3,4,1), LocationState.YELLOW);
		board.setLocationState(new Location(3,4,2), LocationState.YELLOW);
		board.setLocationState(new Location(3,4,3), LocationState.YELLOW);
		board.setLocationState(new Location(3,4,4), LocationState.YELLOW);		
		board.setLocationState(new Location(4,1,1), LocationState.YELLOW);
		board.setLocationState(new Location(4,1,2), LocationState.YELLOW);
		board.setLocationState(new Location(4,1,3), LocationState.YELLOW);
		board.setLocationState(new Location(4,1,4), LocationState.YELLOW);
		board.setLocationState(new Location(4,2,1), LocationState.YELLOW);
		board.setLocationState(new Location(4,2,2), LocationState.YELLOW);
		board.setLocationState(new Location(4,2,3), LocationState.YELLOW);
		board.setLocationState(new Location(4,2,4), LocationState.YELLOW);
		board.setLocationState(new Location(4,3,1), LocationState.YELLOW);
		board.setLocationState(new Location(4,3,2), LocationState.YELLOW);
		board.setLocationState(new Location(4,3,3), LocationState.YELLOW);
		board.setLocationState(new Location(4,3,4), LocationState.YELLOW);
		board.setLocationState(new Location(4,4,1), LocationState.YELLOW);
		board.setLocationState(new Location(4,4,2), LocationState.YELLOW);
		board.setLocationState(new Location(4,4,3), LocationState.YELLOW);
		board.setLocationState(new Location(4,4,4), LocationState.YELLOW);
		
		assertTrue(board.isFull(Player, board));
		
		
	}




}
