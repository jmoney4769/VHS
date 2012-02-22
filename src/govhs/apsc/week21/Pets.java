package govhs.apsc.week21;

// Adapted from Java Software Solutions by Lewis/Loftus/Cocking

// Demonstrates the useof Abstract Classes

// Instantiates objects of type pet and prints information
public class Pets
{
  public static void main(String Args[])
  {
    Dog fido =new Dog ("Fido", 45);
    Snake sam = new Snake("Sam", 6);
    
    System.out.println(fido);
    System.out.println(fido.getName() + " " + "says " + fido.speak());
    System.out.println(fido.move() + " " + fido.getName() + " " + fido.move());
    System.out.println();
    
    System.out.println(sam);
    System.out.println(sam.getName() + " " + "says " + sam.speak());
    System.out.println(sam.move() + " " + sam.getName() + " " + sam.move());
    System.out.println();
    
    
    Chihuahua pero  = new Chihuahua ("El Guapo", 2);
    pero.setPlace("Ciudad Juarez");
    System.out.println(pero + " from " + pero.cityOfOrigin());
    System.out.println(pero.getName() + " " + "says " + pero.speak());
    System.out.println(pero.move() + " " + pero.getName() + " " + pero.move());
    System.out.println();
    
  }
}
    
     
   
