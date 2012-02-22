package govhs.apsc.week21;

public class Lab extends Dog {

	private String whereFrom;
	
	public Lab(String dogName, int dogWeight) {
		super(dogName, dogWeight);
		
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
		
		return "woof";
	}
	
	@Override
	public String move() {
		
		return "walk";
	}

}
