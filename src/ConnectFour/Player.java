package ConnectFour;



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
 private LocationState playerState;
 // Player has an enum which is a colour
 
	public Player(LocationState playerState) {
		super();
		this.playerState = playerState;

<<<<<<< HEAD
  /**
Creates a new Player object
*/  
  public Player player(String name, LocationState ls){
  }
  
  /**
  get name of player
  */
  public String getName() {
    return name;
  }
  
  /**
  get playing color of player
  */
  public LocationState getLocationState() {
        return ls;
  }
=======
	}
 


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
		return playerState;
	}
	
	/**
	 * @param playerState
	 */
	public void setPlayerState(LocationState playerState) {
		this.playerState = playerState;
	}

	@Override
	public String toString() {
		return playerState.toString();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



>>>>>>> branch 'master' of https://github.com/IrisWeijers/ConnectFour.git
    
 

}
