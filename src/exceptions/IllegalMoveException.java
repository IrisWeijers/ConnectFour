package exceptions;

import ConnectFour.Protocol;

public class IllegalMoveException extends Exception{
	
	public IllegalMoveException() {
		super("ERROR " + Protocol.Error.ILLEGAL_MOVE.code + ": Illegal move");
	}

}
