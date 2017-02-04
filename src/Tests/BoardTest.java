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
		Board board = new Board();
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
		Board board = new Board();
		board.setLocation(0,1, LocationState.YELLOW);
		board.setLocation(0,2, LocationState.YELLOW);
		board.setLocation(0,3, LocationState.YELLOW);
		assertFalse(board.checkVertical(LocationState.YELLOW));
		
		board.setLocation(0,0, LocationState.YELLOW);
		assertTrue(board.checkVertical(LocationState.YELLOW));
		assertFalse(board.checkVertical(LocationState.RED));
	}
	
	@Test
	public void testCheckLevel() {
		Board board = new Board();
		board.setLocation(0,0, LocationState.YELLOW);
		board.setLocation(0,0, LocationState.YELLOW);
		board.setLocation(0,0, LocationState.YELLOW);
		assertFalse(board.CheckLevel(LocationState.YELLOW));
		
		board.setLocation(0,0, LocationState.YELLOW);
		assertTrue(board.CheckLevel(LocationState.YELLOW));
		assertFalse(board.CheckLevel(LocationState.RED));
	}
	@Test
	public void testHasRowColumn() {
		Board board = new Board();
		board.setLocation(1, 1, LocationState.YELLOW);
		board.setLocation(2, 2, LocationState.YELLOW);
		board.setLocation(3, 3, LocationState.YELLOW);
		assertFalse(board.hasRowColumn(LocationState.YELLOW));
		board.setLocation(0, 0, LocationState.YELLOW);
		assertTrue(board.hasRowColumn(LocationState.YELLOW));
		board.reset();
		board.setLocation(0, 3, LocationState.YELLOW);
		board.setLocation(1, 2, LocationState.YELLOW);
		board.setLocation(2, 1, LocationState.YELLOW);
		assertFalse(board.hasRowColumn(LocationState.YELLOW));
		board.setLocation(3, 0, LocationState.YELLOW);
		assertTrue(board.hasRowColumn(LocationState.YELLOW));
	}
	@Test
	public void testhasRowLevel() {
		Board board = new Board();
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
	}
	
	
	@Test
	public void testHasColumnLevel() {
		Board Board = new Board();
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
	}
	@Test
	public void testHasDiagTopLeft() {
		Board Board = new Board();
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
	}
	@Test
	public void testHasDiagBottomRight() {
		Board Board = new Board();
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
	}
	@Test
	public void testHasDiagBottomLeft() {
		Board Board = new Board();
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
	}
	@Test
	public void testHasDiagTopRight() {
		Board Board = new Board();
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
	}
	
	@Test
	public void testIsFull(){
		Board board = new Board();
		
		board.setLocation(0,3, LocationState.YELLOW);
		board.setLocation(1,2, LocationState.YELLOW);
		board.setLocation(2,1, LocationState.YELLOW);
		board.setLocation(3,0, LocationState.YELLOW);
		assertFalse(board.isFull());
		assertTrue(board.hasWinner());
		assertTrue(board.gameOver());
	}

}
