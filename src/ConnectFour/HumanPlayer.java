package ConnectFour;

import java.util.Scanner;

import ConnectFour.Strategy;
import ConnectFour.SmartStrategy;
import ConnectFour.LocationState;
import ConnectFour.Board;
import exceptions.InvalidInputException;
/**
 * This class extends IPlayer and this human player
 * makes their moves by user input 
 * via the console or the GUI
 * @author Sam
 */
public class HumanPlayer extends Player {
	private Scanner in;

	public HumanPlayer(LocationState player, String n) {
		super(player, n);
	}

	@Override
	public int[] determineMove() {
		int[] coordinate = new int[2];
		System.out.println(getName() + "(" + getLocationState() + ")" + ", your turn!");
		in = new Scanner(System.in);
		System.out.println("Get a  hint? Y/N");
		boolean valid = false;
		while (!valid) {
			try {
				String input = in.nextLine();
				input = input.toLowerCase();
				if (input.equals("n")) {
					valid = true;
				} else if (input.equals("y")) {
					getHint();
					valid = true;
				} else { 
					throw new InvalidInputException();
				}
			} catch (InvalidInputException e) {
				System.out.println(e.getMessage() + "Write either N or Y");
				valid = false;
			}
		}
		System.out.println("Enter a column number (starting at 0)");
		coordinate[0] = -1;
		while (coordinate[0] < 0) {
			try {
				String input = in.nextLine();
				coordinate[0] = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println("Invalid input, Enter a valid column number");
				coordinate[0] = -1;
			}
		}

		System.out.println("Enter a row number (starting at 0)");
		coordinate[1] = -1;
		while (coordinate[1] < 0) {
			try {
				String input = in.nextLine();
				coordinate[1] = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println("Invalid input, Enter a valid row number");
				coordinate[1] = -1;
			}
		}
		return coordinate;
	}
	
	public void getHint() {
		Strategy smart = new SmartStrategy();
		int[] moves = new int[2];
		moves = smart.generateMove(LocationState.EMPTY);
		System.out.println(
				"Have you considered the move" + " j:" + moves[0] + ", i:" + moves[1] + "?");
	}

	@Override
	public int getMove(Board board) {

		return 0;
	}

}


  
  

