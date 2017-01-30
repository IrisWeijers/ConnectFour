package ConnectFour;

import ConnectFour.Strategy;

/**
Abstract class for keeping a player in the Connect Four game.
*/
public abstract class Player {

/**
player's name
*/
 private String name;


/**
player's color
*/
 private LocationState playerstate;
 // Player has an enum which is a colour
 
 /**
Creates a new Player object
*/
	public Player(LocationState player, String n) {
		
		 playerstate = player;
		 name = n;
	}
	
	public Player(LocationState player, Strategy strategy){
		playerstate = player;
		name = strategy.getName();
	}


  /**
  get name of player
  */
  public String getName() {
    return name;
  }
  
	
	/**
	 * This method returns the location state (i.e. colour) associated with the
	 * player.
	 * 
	 * @return playerState - colour of players piece as LocationState.
  /**
  get playing color of player
  */
  public LocationState getLocationState() {
        return playerstate;
  }



	public abstract int[] determineMove();

	/**
	 * This method should return the next move for a Connect 4 game. Assume
	 * columns go from 1 to 4. Move computed from board parameter using suitable
	 * algorithm.
	 * 
	 * @param board
	 *            - Connect 4 board as type Board
	 * @return column number for next turn as integer.
	 */
	public abstract int getMove(Board board);


	
	
	/**
	 * This method returns the location state (i.e. colour) associated with the
	 * player.
	 * 
	 * @return playerState - colour of players piece as LocationState.
	 */
	public LocationState getPlayerState() {
		return playerstate;
	}
	
	/**
	 * @param playerState
	 */
	public void setPlayerState(LocationState playerstate) {
		this.playerstate = playerstate;
	}

	@Override
	public String toString() {
		return playerstate.toString();
	}
	
	public void setName(String name) {
		this.name = name;
	}
 

}
