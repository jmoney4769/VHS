package govhs.apsc.week21;

// abstract classes may have concrete methods as well as abstract methods or
// they may be comprised of all abstract methods.

// abstract methods appearing in an abstract class must be defined by
// any class extending this abstract class


public abstract class AbstrPets
{
  private String name;
  
  public AbstrPets(String petName)
  {
    name = petName;
  }
  
 // these were unnecessary.  All methods work better in an interface as no class used the code provided by
  // the methods and, being an abstract class, no objects could be made of this one
}
