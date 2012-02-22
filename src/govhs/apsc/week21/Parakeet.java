package govhs.apsc.week21;

public class Parakeet extends Bird {

private String whereFrom;
	
	public Parakeet(String petName, int petWeight) {
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
		
		return "chirp chirp";
	}
	
	@Override
	public String move() {
		
		return "fly around";
	}
}
