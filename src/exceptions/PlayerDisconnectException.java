package exceptions;

import ConnectFour.Protocol;

public class PlayerDisconnectException extends Exception {
	
	public PlayerDisconnectException() {
		super("ERROR " + Protocol.Error.PLAYER_DISCONNECT.code + ": Player Disconnected");
	}

}
