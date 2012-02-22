package govhs.apsc.week21;

public class Burmese extends Cat {

	private String whereFrom;

	public Burmese(String petName, int weight) {
		super(petName, weight);
		
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
		
		return "meeow";
	}
	
	@Override
	public String move() {
		
		return "trot";
	}

}
