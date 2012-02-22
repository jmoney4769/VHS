package govhs.apsc.week21;

// Dog IS A pet
// Dog extends AbstrPets by defining the abstract methods as concrete

public class Dog  extends  AbstrPets implements InterPets  
{
   private int weight;
   
   public Dog (String dogName, int dogWeight)
   {
    super (dogName);  //  invokes the concrete constructor in the 
                      // abstract class  AbstrPets
    weight = dogWeight;
  }
  
  public int getWeight()
  {
    return weight;
  }
  
  public String toString()  // the closest toString method to the object
                            // is in play.  If this toString was absent,
                            // the obejct would use the toString in super.
  {
    return (super.toString() + " is a dog, weighing " + weight + " pounds");
  }
  
  public String speak()  // defines abstract method speak for Dog
  {
    return "woof !!";
  } 
  
  public String move()  // defines abstract method  move  for Dog
  {
    return  "run";
  }

@Override
public String getName() {
	return null;
}
  
  
}