package govhs.apsc.week21;

public class Chihuahua extends Dog  // concrete classes as well as
                                    // abstract classes can be extended by 
                                    // another class
{
  private String whereFrom;
  
  public Chihuahua (String dogName, int weight)
  {
    super (dogName,weight);
  }
  
  public void setPlace(String location)
  {
    whereFrom = location;
  }
  
  public String speak()  // overwrites speak in Dog
  {
    return "chalupa!!";
  } 
  
  public String move()  // overwrites move in Dog
  {
    return  "little tiny steps";
  }
  
  public String cityOfOrigin()
  {
    return whereFrom;
  }  
  
}