package govhs.apsc.week21;

public class Parrot extends Bird {

private String whereFrom;
	
	public Parrot(String petName, int petWeight) {
		super(petName, petWeight);
		
	}
	
	 public void setPlace(String location)
	  {
	    whereFrom = location;
	  }
	 
	 public String cityOfOrigin()
	  {
	    return whereFrom;
	  }
	
	@Override
	public String speak() {
		
		return "polly";
	}
	
	@Override
	public String move() {
		
		return "flap wings";
	}
}
