package exceptions;

import ConnectFour.Protocol;

public class IllegalMethodUseException extends Exception{
	
	public IllegalMethodUseException(String msg) {
		super("ERROR " + Protocol.Error.ILLEGAL_METHOD_USE.code 
				+ ": Method is not allowed at this moment: " + msg);
	}

}
