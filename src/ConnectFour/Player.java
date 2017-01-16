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
 private LocationState ls;

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
    
  /**
   Determines the field for the next move.
   
  @param board
             the current game board
  @return the player's choice
  */
  public abstract int determineMove(Board board);
   
    /**
    Makes a move on the board.
    @parameter board
    */
  public void makeMove(Board board) {
  }
    
    

}
