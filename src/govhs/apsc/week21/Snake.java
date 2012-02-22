package govhs.apsc.week21;

public class Snake  extends  AbstrPets {


  private int length;
  
  public Snake (String snakeName, int snakeLength) {
  
    super(snakeName);
    length = snakeLength;
  }
  
  public int getLength() {
  
    return length;
  }
  
  public String toString () {// the closest toString method to the object
                            // is in play.  If this toString was absent,
                            // the obejct would use the toString in super.
  
    return super.toString () + " is a snake, " + length + " feet long";
  }
  
  public String speak()  {// defines abstract method   speak   for Snake
    return "hiss !!";
  }
  
  public String move()  // defines abstract method  move  for Snake
  {
    return "slither";
  }

public String getName() {
	// TODO Auto-generated method stub
	return null;
}
}