package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ConnectFour.Board;
import ConnectFour.Location;
import ConnectFour.LocationState;
import ConnectFour.HumanTUI;

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
//	
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
		board.setLocation(new Location(0,0,0), LocationState.YELLOW);
		board.setLocation(new Location(0,1,0), LocationState.YELLOW);
		board.setLocation(new Location(0,2,0), LocationState.YELLOW);
		assertFalse(board.checkHorizontal(LocationState.YELLOW, board));
		
		board.setLocation(new Location(0,3,0), LocationState.YELLOW);
		System.out.println("Horizontal\n" + board);
		assertTrue(board.checkHorizontal(LocationState.YELLOW, board));
		assertFalse(board.checkHorizontal(LocationState.RED, board));
	}
	
	@Test
	public void testCheckVertical() {
		Board board = new Board();
		board.setLocation(new Location(0,0,0), LocationState.YELLOW);
		board.setLocation(new Location(1,0,0), LocationState.YELLOW);
		board.setLocation(new Location(2,0,0), LocationState.YELLOW);
		assertFalse(board.checkVertical(LocationState.YELLOW, board));
		
		board.setLocation(new Location(3,0,0), LocationState.YELLOW);
		System.out.println("Vertical\n" + board);
		assertTrue(board.checkVertical(LocationState.YELLOW, board));
		assertFalse(board.checkVertical(LocationState.RED, board));
	}
	
//	@Test
//	public void testCheckDiagLeft() {
//		Board board = new Board();
//		board.setLocationState(new Location(0,0,0), LocationState.YELLOW);
//		board.setLocationState(new Location(1,1,0), LocationState.YELLOW);
//		board.setLocationState(new Location(2,2,0), LocationState.YELLOW);
//		assertFalse(board.checkDiagLeft(LocationState.YELLOW, board));
//		
//		board.setLocationState(new Location(3,3,0), LocationState.YELLOW);
//		System.out.println("DiagLeft\n" + board);
//		assertTrue(board.checkDiagLeft(LocationState.YELLOW, board));
//		assertFalse(board.checkDiagLeft(LocationState.RED, board));
//	}
//	
//	@Test
//	public void testCheckDiagRight() {
//		Board board = new Board();
//		board.setLocationState(new Location(0,3,0), LocationState.YELLOW);
//		board.setLocationState(new Location(1,2,0), LocationState.YELLOW);
//		board.setLocationState(new Location(2,1,0), LocationState.YELLOW);
//		assertFalse(board.checkDiagRight(LocationState.YELLOW, board));
//		
//		board.setLocationState(new Location(3,0,0), LocationState.YELLOW);
//		System.out.println("DiagRight\n" + board);
//		assertTrue(board.checkDiagRight(LocationState.YELLOW, board));
//		assertFalse(board.checkDiagRight(LocationState.RED, board));
//		
//	}
	
//	@Test
//	public void testIsFull(){
//		Board board = new Board();
//		
//		board.setLocationState(new Location(0,3,0), LocationState.YELLOW);
//		board.setLocationState(new Location(1,2,0), LocationState.YELLOW);
//		board.setLocationState(new Location(2,1,0), LocationState.YELLOW);
//		board.setLocationState(new Location(3,0,0), LocationState.YELLOW);
//		assertFalse(board.isFull(null, board));
//		
//		for (int x = 0;x < 4; x++){
//			for (int y = 0;y < 4; y++){
//				for (int z = 0;z < 4; z++){
//					board.setLocationState(new Location(x,y,z), LocationState.RED);
//				}
//			}
//		}
//		System.out.println("full\n" + board);
//		assertTrue(board.isFull(null, board));
//	}

}
