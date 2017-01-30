package ConnectFour;

public enum LocationState {
  
  EMPTY, RED, YELLOW;
	
	 /*@
    ensures this == locationstate.RED ==> \result == locationstate.YELLOW;
    ensures this == locationstate.YELLOW ==> \result == locationstate.RED;
    ensures this == locationstate.EMPTY ==> \result == locationstate.EMPTY;
  */
 /**
  * Returns the other locationstate.
  * 
  * @return the other locationstate is this locationstate is not EMPTY or EMPTY
  */
	
	public LocationState next(LocationState player) {
		switch (player) {
			case YELLOW:
				return RED;
			case RED:
				return YELLOW;
			default:
				return EMPTY;

		}
	}
}
