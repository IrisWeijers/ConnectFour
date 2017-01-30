package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ConnectFour.Board;
import ConnectFour.LocationState;

public class BoardTest {
	
	private Board board;

	@Before
	public void setUp() {
		board = new Board();
	}

		
//	@Test
//	public void testSetLocationState(){
//		Board board = new Board(4,4,4);
//		for (int x = 0;x < 4; x++){
//			for (int y = 0;y < 4; y++){
//				for (int z = 0;z < 4; z++){
//					board.setLocationState(new Location(x,y,z), LocationState.RED);
//					assertEquals(LocationState.RED, board.getLocationState(new Location(x,y,z)));
//					
//					board.setLocationState(new Location(x,y,z), LocationState.YELLOW);
//					assertEquals(LocationState.YELLOW, board.getLocationState(new Location(x,y,z)));
//				}
//			}
//		}
//	}
////	
//	@Test
//	public void testReset(){
//	Board board = new Board (4,4,4);
//	for (int x = 0;x < 4; x++){
//		for (int y = 0;y < 4; y++){
//			for (int z = 0;z < 4; z++){
//				board.setLocationState(new Location(x,y,z), LocationState.RED);
//			}
//		}
//	}
//	System.out.println("pre-reset\n" + board);
//	board.reset();
//	System.out.println("reset\n" + board);
//	assertTrue(board.isEmpty());
	
	//}
	
	@Test
	public void testCheckHorizontal() {
		Board board = new Board();
		board.setLocation(1,0, LocationState.YELLOW);
		board.setLocation(2,0, LocationState.YELLOW);
		board.setLocation(3,0, LocationState.YELLOW);
		assertFalse(board.checkHorizontal(LocationState.YELLOW));
		
		board.setLocation(0,0, LocationState.YELLOW);
		System.out.println("Horizontal\n" );
		assertTrue(board.checkHorizontal(LocationState.YELLOW));
		assertFalse(board.checkHorizontal(LocationState.RED));
	}
	
	@Test
	public void testCheckVertical() {
		Board board = new Board();
		board.setLocation(0,1, LocationState.YELLOW);
		board.setLocation(0,2, LocationState.YELLOW);
		board.setLocation(0,3, LocationState.YELLOW);
		assertFalse(board.checkVertical(LocationState.YELLOW));
		
		board.setLocation(0,0, LocationState.YELLOW);
		System.out.println("Vertical\n" );
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
		System.out.println("Vertical\n");
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
		
		for (int x = 0;x < 4; x++){
			for (int y = 0;y < 4; y++){
				for (int z = 0;z < 4; z++){
					board.setLocation(x,y, LocationState.RED);
				}
			}
		}
		System.out.println("full\n" + board);
		assertTrue(board.isFull());
	}

}
