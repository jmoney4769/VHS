package govhs.apsc.week21;

public class Bird extends AbstrPets implements InterPets {

private int weight;
	
	public Bird(String petName, int weight) {
		super(petName);
		
		this.weight = weight;
	}

	public int getWeight()
	  {
	    return weight;
	  }
	  
	@Override
	  public String toString()  // the closest toString method to the object
	                            // is in play.  If this toString was absent,
	                            // the obejct would use the toString in super.
	  {
	    return (super.toString() + " is a bird, weighing " + weight + " pounds");
	  }
	  
	@Override
	  public String speak()  // defines abstract method speak for Dog
	  {
	    return "chirp";
	  } 
	  
	@Override
	  public String move()  // defines abstract method  move  for Dog
	  {
	    return  "fly";
	  }

	@Override
	public String getName() {
		
		return null;
	}
}
