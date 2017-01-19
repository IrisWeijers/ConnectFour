package ConnectFour;

public class Location implements Comparable<Location> {

  private int x;
  private int y;
  private int z;
  
  /**
  create location with x, y and z coördinates
  */
  public Location (int x, int y, int z){
	  super();
	  this.x = x;
	  this.y = y;
	  this.z = z;
  }
  
  /**
  ??
  @parameter argmument
  */
  public int compareTo(Location arguement) {
		if (this.x < arguement.x)
			return -1;
		if (this.x == arguement.x && this.y < arguement.y)
			return -1;
		if (this.x == arguement.x && this.y > arguement.y)
			return +1;
		if (this.x > arguement.x)
			return +1;
		if (this.y < arguement.z)
			return -1;
		if (this.y == arguement.y && this.z < arguement.z)
			return -1;
		if (this.y == arguement.y && this.z > arguement.z)
			return +1;
		if (this.y > arguement.y)
			return +1;
		if (this.z < arguement.z)
			return -1;
		if (this.z == arguement.z && this.x < arguement.x)
			return -1;
		if (this.z == arguement.z && this.x > arguement.x)
			return +1;
		if (this.z > arguement.z)
			return +1;
		else
			return 0;
	}

  /**
  searches for the x coördinate of the location
  */
  public int getX(){
	  return x;
  }
  /**
  searches for the y coördinate of the location
  */
  public int getY(){
	  return y;
  }
  
  /**
  searches for the z coördinate of the location
  */
  public int getZ(){
	  return z;
  }
  
  /**
  set the x cooirdinate of the location
  @parameter x
  */
  public void setX(int x){
	  this.x = x;
  }
  
   /**
  set the y cooirdinate of the location
  @parameter y
  */
  public void setY(int y){
	  this.y = y;
  }
  
   /*
  set the z cooirdinate of the location
  @parameter z
  */
  public void setZ(int z){
	  this.z = z;
  }
  
  /**
  make a String of the location
  */
  @Override
	public String toString() {
		return "Location [x=" + x + ", y=" + y + ",z=" + z +"]";
	}

}
