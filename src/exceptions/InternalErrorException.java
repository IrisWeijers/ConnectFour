package exceptions;

import ConnectFour.Protocol;

public class InternalErrorException extends Exception {
	public InternalErrorException() {
		super("ERROR " + Protocol.Error.INTERNAL_ERROR.code + ": An internal error occured");
	}

	

}
