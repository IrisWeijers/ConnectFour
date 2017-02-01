package exceptions;

import ConnectFour.Protocol;


public class UserAlreadyConnectedException extends Exception{

	
	public UserAlreadyConnectedException() {
		super("ERROR " + Protocol.Error.USER_ALREADY_CONNECTED.code 
				+ ": User with this name already connected");
	}
	
	public UserAlreadyConnectedException(String[] data) {
		super("ERROR " + Protocol.Error.USER_ALREADY_CONNECTED.code 
				+ ": User with this name already connected \n NAME USED BY CLIENT: " + data[0] +
				"\n NAME GIVEN BY YOU: " + data[1] + "\n CLIENT EXIST: " + data[2]);
	}
}
