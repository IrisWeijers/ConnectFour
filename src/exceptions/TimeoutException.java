package exceptions;

import ConnectFour.Protocol;

public class TimeoutException extends Exception {
	
	public TimeoutException() {
		super("ERROR " + Protocol.Error.TIMEOUT.code + ": A timeout occured");
	}

}
