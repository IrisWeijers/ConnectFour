package exceptions;

import ConnectFour.Protocol;

public class UserNotSupportingExtensionException extends Exception {
	
	public UserNotSupportingExtensionException() {
		super("ERROR " + Protocol.Error.USER_NOSUPPORT_EXTENSION.code 
				+ ": User does not support required extension");
	}

}
