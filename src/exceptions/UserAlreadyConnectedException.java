package exceptions;

import ConnectFour.Protocol;


public class UserAlreadyConnectedException extends Exception{

	
	public UserAlreadyConnectedException() {
		super("ERROR " + Protocol.Error.USER_ALREADY_CONNECTED.code 
				+ ": User with this name already connected");
	}
	
}
