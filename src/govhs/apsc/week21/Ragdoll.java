package govhs.apsc.week21;

import java.util.ArrayList;

public class Ragdoll extends Cat {

private String whereFrom;
	
	public Ragdoll(String catName, int catWeight) {
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
		
		return "meeeow!!";
	}
	
	@Override
	public String move() {
		
		return "lay around";
	}
	
	public int sum(ArrayList<Integer> array) {
		
		int sum = 0;
		for (int i = 0; i < array.size(); i++)
			sum += array.get(i);
		return sum;
	}
}
