package exceptions;

import ConnectFour.Protocol;

public class UnknownMethodException extends Exception {
	public UnknownMethodException() {
		super("ERROR " + Protocol.Error.UNKNOWN_METHOD.code + ": Unknown method");
	}

}
