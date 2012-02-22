package govhs.apsc.week21;

public class Rattlesnake extends Snake {

	private String whereFrom;
	
	public Rattlesnake(String catName, int catWeight) {
		super(catName, catWeight);
		
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
		
		return "hisssssssssssssssssss";
	}
	
	@Override
	public String move() {
		
		return "slide and slither";
	}
}
