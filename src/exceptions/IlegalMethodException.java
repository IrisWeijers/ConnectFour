package exceptions;

import ConnectFour.Protocol;

public class IlegalMethodException extends Exception {
	
	public IlegalMethodException() {
		super("ERROR " + Protocol.Error.ILLEGAL_SYNTAX.code + ": Illegal method syntax");
	}

}
