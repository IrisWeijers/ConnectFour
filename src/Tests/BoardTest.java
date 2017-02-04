package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ConnectFour.Board;
import ConnectFour.LocationState;
import ConnectFour.HumanTUI;

public class BoardTest {
	
	private Board board;

	@Before
	public void setUp() {
		board = new Board();
	}

		
	@Test
	public void testDeepCopy() {
		Board dc = new Board();
		board.setLocation(1, 0, LocationState.YELLOW);
		assertNotEquals(board.getLocation(1, 0, 0), dc.getLocation(1, 0, 0));
		dc = board.deepCopy();
		assertEquals(board.getLocation(1, 0, 0), dc.getLocation(1, 0, 0));
	}
	

	

	@Test
	public void testCheckHorizontal() {
		board.setLocation(1,0, LocationState.YELLOW);
		board.setLocation(2,0, LocationState.YELLOW);
		board.setLocation(3,0, LocationState.YELLOW);
		assertFalse(board.checkHorizontal(LocationState.YELLOW));
		assertFalse(board.hasWinner());
		assertFalse(board.isWinner(LocationState.YELLOW));
		
		board.setLocation(0,0, LocationState.YELLOW);
		
		assertTrue(board.checkHorizontal(LocationState.YELLOW));
		assertTrue(board.hasWinner());
		assertTrue(board.isWinner(LocationState.YELLOW));
		
	}
	
	@Test
	public void testCheckVertical() {
		board.setLocation(0,1, LocationState.YELLOW);
		board.setLocation(0,2, LocationState.YELLOW);
		board.setLocation(0,3, LocationState.YELLOW);
		assertFalse(board.checkVertical(LocationState.YELLOW));
		
		board.setLocation(0,0, LocationState.YELLOW);
		assertTrue(board.checkVertical(LocationState.YELLOW));
		assertFalse(board.checkVertical(LocationState.RED));
		assertTrue(board.hasWinner());
		assertTrue(board.isWinner(LocationState.YELLOW));
	}
	
	@Test
	public void testCheckLevel() {
		board.setLocation(0,0, LocationState.YELLOW);
		board.setLocation(0,0, LocationState.YELLOW);
		board.setLocation(0,0, LocationState.YELLOW);
		assertFalse(board.CheckLevel(LocationState.YELLOW));
		
		board.setLocation(0,0, LocationState.YELLOW);
		assertTrue(board.CheckLevel(LocationState.YELLOW));
		assertFalse(board.CheckLevel(LocationState.RED));
		assertTrue(board.hasWinner());
		assertTrue(board.isWinner(LocationState.YELLOW));
	}
	@Test
	public void testHasRowColumn() {
		board.setLocation(1, 1, LocationState.YELLOW);
		board.setLocation(2, 2, LocationState.YELLOW);
		board.setLocation(3, 3, LocationState.YELLOW);
		assertFalse(board.hasRowColumn(LocationState.YELLOW));
		board.setLocation(0, 0, LocationState.YELLOW);
		assertTrue(board.hasRowColumn(LocationState.YELLOW));
		assertTrue(board.hasWinner());
		assertTrue(board.isWinner(LocationState.YELLOW));
		board.reset();
		
		
		board.setLocation(0, 3, LocationState.YELLOW);
		board.setLocation(1, 2, LocationState.YELLOW);
		board.setLocation(2, 1, LocationState.YELLOW);
		assertFalse(board.hasRowColumn(LocationState.YELLOW));
		board.setLocation(3, 0, LocationState.YELLOW);
		assertTrue(board.hasRowColumn(LocationState.YELLOW));
		assertTrue(board.hasWinner());
		assertTrue(board.isWinner(LocationState.YELLOW));
	}
	@Test
	public void testhasRowLevel() {
		board.setLocation(1, 2, LocationState.YELLOW);
		board.setLocation(2, 2, LocationState.YELLOW);
		board.setLocation(3, 2, LocationState.YELLOW);
		assertFalse(board.hasRowLevel(LocationState.YELLOW));
		board.setLocation(0, 2, LocationState.YELLOW);
		board.setLocation(1, 2, LocationState.YELLOW);
		board.setLocation(2, 2, LocationState.YELLOW);
		board.setLocation(2, 2, LocationState.YELLOW);
		board.setLocation(3, 2, LocationState.YELLOW);
		board.setLocation(3, 2, LocationState.YELLOW);
		board.setLocation(3, 2, LocationState.YELLOW);
		assertTrue(board.hasRowLevel(LocationState.YELLOW));
		assertTrue(board.hasWinner());
		assertTrue(board.isWinner(LocationState.YELLOW));
		board.reset();
		
		board.setLocation(0, 3, LocationState.YELLOW);
		board.setLocation(1, 3, LocationState.YELLOW);
		board.setLocation(2, 3, LocationState.YELLOW);
		assertFalse(board.hasRowLevel(LocationState.YELLOW));
		board.setLocation(3, 3, LocationState.YELLOW);
		board.setLocation(1, 3, LocationState.YELLOW);
		board.setLocation(2, 3, LocationState.YELLOW);
		board.setLocation(2, 3, LocationState.YELLOW);
		board.setLocation(3, 3, LocationState.YELLOW);
		board.setLocation(3, 3, LocationState.YELLOW);
		board.setLocation(3, 3, LocationState.YELLOW);
		assertTrue(board.hasRowLevel(LocationState.YELLOW));
		assertTrue(board.hasWinner());
		assertTrue(board.isWinner(LocationState.YELLOW));
	}
	
	
	@Test
	public void testHasColumnLevel() {
		board.setLocation(3, 1, LocationState.YELLOW);
		board.setLocation(3, 2, LocationState.YELLOW);
		board.setLocation(3, 3, LocationState.YELLOW);
		assertFalse(board.hasColumnLevel(LocationState.YELLOW));
		board.setLocation(3, 0, LocationState.YELLOW);
		board.setLocation(3, 1, LocationState.YELLOW);
		board.setLocation(3, 2, LocationState.YELLOW);
		board.setLocation(3, 2, LocationState.YELLOW);
		board.setLocation(3, 3, LocationState.YELLOW);
		board.setLocation(3, 3, LocationState.YELLOW);
		board.setLocation(3, 3, LocationState.YELLOW);
		assertTrue(board.hasColumnLevel(LocationState.YELLOW));
		assertTrue(board.hasWinner());
		assertTrue(board.isWinner(LocationState.YELLOW));
		board.reset();
		
		board.setLocation(2, 0, LocationState.YELLOW);
		board.setLocation(2, 1, LocationState.YELLOW);
		board.setLocation(2, 2, LocationState.YELLOW);
		assertFalse(board.hasColumnLevel(LocationState.YELLOW));
		board.setLocation(2, 3, LocationState.YELLOW);
		board.setLocation(2, 1, LocationState.YELLOW);
		board.setLocation(2, 2, LocationState.YELLOW);
		board.setLocation(2, 2, LocationState.YELLOW);
		board.setLocation(2, 3, LocationState.YELLOW);
		board.setLocation(2, 3, LocationState.YELLOW);
		board.setLocation(2, 3, LocationState.YELLOW);
		assertTrue(board.hasColumnLevel(LocationState.YELLOW));
		assertTrue(board.hasWinner());
		assertTrue(board.isWinner(LocationState.YELLOW));
	}
	@Test
	public void testHasDiagTopLeft() {
		board.setLocation(0, 0, LocationState.YELLOW);
		board.setLocation(1, 1, LocationState.YELLOW);
		board.setLocation(2, 2, LocationState.YELLOW);
		assertFalse(board.hasRowColumnLevel(LocationState.YELLOW));
		board.setLocation(3, 3, LocationState.YELLOW);
		board.setLocation(1, 1, LocationState.YELLOW);
		board.setLocation(2, 2, LocationState.YELLOW);
		board.setLocation(2, 2, LocationState.YELLOW);
		board.setLocation(3, 3, LocationState.YELLOW);
		board.setLocation(3, 3, LocationState.YELLOW);
		board.setLocation(3, 3, LocationState.YELLOW);
		assertTrue(board.hasRowColumnLevel(LocationState.YELLOW));
		assertTrue(board.hasWinner());
		assertTrue(board.isWinner(LocationState.YELLOW));
	}
	@Test
	public void testHasDiagBottomRight() {
		board.setLocation(0, 3, LocationState.YELLOW);
		board.setLocation(1, 2, LocationState.YELLOW);
		board.setLocation(2, 1, LocationState.YELLOW);
		assertFalse(board.hasRowColumnLevel(LocationState.YELLOW));
		board.setLocation(3, 0, LocationState.YELLOW);
		board.setLocation(1, 2, LocationState.YELLOW);
		board.setLocation(2, 1, LocationState.YELLOW);
		board.setLocation(2, 1, LocationState.YELLOW);
		board.setLocation(3, 0, LocationState.YELLOW);
		board.setLocation(3, 0, LocationState.YELLOW);
		board.setLocation(3, 0, LocationState.YELLOW);
		assertTrue(board.hasRowColumnLevel(LocationState.YELLOW));
		assertTrue(board.hasWinner());
		assertTrue(board.isWinner(LocationState.YELLOW));
	}
	@Test
	public void testHasDiagBottomLeft() {
		board.setLocation(3, 0, LocationState.YELLOW);
		board.setLocation(2, 1, LocationState.YELLOW);
		board.setLocation(1, 2, LocationState.YELLOW);
		assertFalse(board.hasRowColumnLevel(LocationState.YELLOW));
		board.setLocation(0, 3, LocationState.YELLOW);
		board.setLocation(2, 1, LocationState.YELLOW);
		board.setLocation(1, 2, LocationState.YELLOW);
		board.setLocation(1, 2, LocationState.YELLOW);
		board.setLocation(0, 3, LocationState.YELLOW);
		board.setLocation(0, 3, LocationState.YELLOW);
		board.setLocation(0, 3, LocationState.YELLOW);
		assertTrue(board.hasRowColumnLevel(LocationState.YELLOW));
		assertTrue(board.hasWinner());
		assertTrue(board.isWinner(LocationState.YELLOW));
	}
	@Test
	public void testHasDiagTopRight() {
		board.setLocation(0, 0, LocationState.YELLOW);
		board.setLocation(1, 1, LocationState.YELLOW);
		board.setLocation(2, 2, LocationState.YELLOW);
		assertFalse(board.hasRowColumnLevel(LocationState.YELLOW));
		board.setLocation(3, 3, LocationState.YELLOW);
		board.setLocation(1, 1, LocationState.YELLOW);
		board.setLocation(2, 2, LocationState.YELLOW);
		board.setLocation(2, 2, LocationState.YELLOW);
		board.setLocation(3, 3, LocationState.YELLOW);
		board.setLocation(3, 3, LocationState.YELLOW);
		board.setLocation(3, 3, LocationState.YELLOW);
		assertTrue(board.hasRowColumnLevel(LocationState.YELLOW));
		assertTrue(board.hasWinner());
		assertTrue(board.isWinner(LocationState.YELLOW));
	}
	
	@Test
	public void testIsFull(){		
		board.setLocation(0,3, LocationState.YELLOW);
		board.setLocation(1,2, LocationState.YELLOW);
		board.setLocation(2,1, LocationState.YELLOW);
		board.setLocation(3,0, LocationState.YELLOW);
		assertFalse(board.isFull());
		assertTrue(board.hasWinner());
		assertTrue(board.gameOver());
		
		for (int j = 0; j < 4; j++){
			for (int i = 0; i < 4; i++){
				for(int k =0; k < 4; k++) {
				board.setLocation(j, i, LocationState.YELLOW);
				}
			}
		}
		assertTrue(board.isFull());
	}

}
