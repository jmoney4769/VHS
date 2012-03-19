package govhs.apsc.week26;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

// Case Study 9.1: Student class
// I think this is the correct version, there were a bunch so I picked the latest
public class Student implements Comparable<Student>{

   private String firstName;
   private String lastName;
   private int[] tests;   
   private int average;

   // Default: Name is "" and 3 scores are 0
   public Student(){
      this("", "");
   }
    
   // Name is first and last and 3 scores are 0
   public Student(String first, String last){
      this(first, last, 3);
   }

   // Name is first and last and n scores are 0
   public Student(String first, String last, int n){
      firstName = first;
      lastName = last;
      tests = new int[n];
      for (int i = 0; i < tests.length; i++)
         tests[i] = 0;
      setAverage();
   }

   // Name is first and last and scores are in t
   public Student(String first, String last, int[] t){
	   firstName = first;
	   lastName = last;
	   tests = new int[t.length];
	   for (int i = 0; i < tests.length; i++)
		   tests[i] = t[i];
	   setAverage();
   }
    
   // Builds a copy of s
   public Student(Student s){
      this(s.firstName, s.lastName, s.tests);
      setAverage();
   }
    
   public void setName (String first, String last){
	   firstName = first;
	   lastName = last;
   }
   
   public void setAverage() {
	   int sum = 0;
       for (int score : tests)
          sum += score;
       average = sum / tests.length;
}
    
   public String getName (){
      return (firstName + " " + lastName);
   }
    
   public void setScore (int i, int score){
      tests[i - 1] = score;
   }

   public int getScore (int i){
        return tests[i - 1];
   }
   
   public int getAverage(){
        return this.average;
   }
   
   public String getLastName() {
	return lastName;
}
    
   public int getHighScore(){
      int highScore = 0;
      for (int score : tests)
         highScore = Math.max (highScore, score);
      return highScore;
   }
    
   public String toString(){
      String str = "Name:    " + firstName + " " + lastName + "\n";
      for (int i = 0; i < tests.length; i++)
         str += "test " + i + ":  " + tests[i] + "\n";
      str += "Average: " + getAverage();
      return str;
   } 

   //Returns null if there are no errors else returns
   //an appropriate error message.
   public String validateData(){
      if (firstName.equals (""))
    	  return "SORRY: name required";
      for (int score : tests){
         if (score < 0 || score > 100){
            String str = "SORRY: must have "+ 0
                         + " <= test score <= " + 100;  
            return str;
         }
      }
      return null;
   }  
   
   private static BufferedReader getInfo() { // initialize the file reader

		BufferedReader reader = null;
		try {

			InputStreamReader inReader = new InputStreamReader(new FileInputStream(
					"res/student.txt")); //file path will vary, I included in /res folder of project
			reader = new BufferedReader(inReader);
		}
		catch (FileNotFoundException e) { // properly handle possible exceptions
			System.err.println("File does not exist");
			System.exit(1);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Line in file was too long, correct error in file");
			System.exit(1);
		}
		return reader;
	}
   
   	public ArrayList<Object> readInfo() {

   		ArrayList<Object> array = new ArrayList<Object>();
   		BufferedReader reader = getInfo();
   		try {
   			String line = reader.readLine();
   			while (line != null) {
   				Scanner input = new Scanner(line);
   				array.add(input.next()); // first name
   				array.add(input.next()); // last name 
   				array.add(input.nextInt()); // 1st score
   				array.add(input.nextInt()); // 2nd score
   				array.add(input.nextInt()); // 3rd score
   				// if there are less, an error will be thrown
   				// this program assumes integrity of the data file
   				line = reader.readLine();
   			}
   		} 
   		catch (IOException e) {
   			System.err.println("Problem with file, maybe line is too short?");
   		}
   		return array;
   	}
   
   	public Student[] readArray(ArrayList<Object> objects) {
		
   		Student[] array = new Student[objects.size() / 5]; // five elements per student
   		
   		for (int i = 0; i < objects.size(); i += 5) {
   			int[] tests = {(Integer) objects.get(i + 2), (Integer) objects.get(i + 2),  
   					(Integer) objects.get(i + 2)}; // make an array of the tests
   			array[i / 5] = new Student((String) objects.get(i), (String) objects.get(i + 1), tests); 
   			// create an array of the info, I think the casting should work
   		}
   		
		return array;
	}
   	
   	public static boolean isAverageSorted(ArrayList<Student> array) {
		
   		boolean isSorted = true;
   		
   		for (int i = 0; i < array.size() - 1; i++) {
			if (array.get(i).compareTo(array.get(i + 1)) == -1) { // the first one would be less than the next
				isSorted = false;
				break; // no need to keep testing
			}
		}
   		return isSorted;
	}
   	
   	public static boolean isNameSorted(ArrayList<Student> array) {
		
   		boolean isSorted = true;
   		
   		for (int i = 0; i < array.size(); i++) {
   			if (array.get(i).compareStringsTo(array.get(i + 1)) == 1) { // the first one would be greater than the next
   				isSorted = false;
   				break; // no need to keep testing
   			}
   		}
   		return isSorted;
	}

	@Override
	public int compareTo(Student o) {
		
		if (this.getAverage() == o.getAverage())
			return 0; // averages are the same
		else if (this.getAverage() > o.getAverage())
			return 1;
		else
			return -1; // no other possibilities
	}
	
	public int compareStringsTo(Student o) {
		
		if (this.getLastName().compareTo(o.getLastName()) == 0)
			return 0;
		else if (this.getLastName().compareTo(o.getLastName()) == 1)
			return 1;
		else 
			return -1; // no other possibilities
	}
	
	public Student[] sortByLast(Student[] array) { // bogo sort, wildly inefficient
		// please do not use with large arrays
		// worst case - array will never be sorted
		// average case - O(n * n!) the extra n is for checking the array
		// best case - O(n) not run once, the n is for checking the array
		// see http://en.wikipedia.org/wiki/Bogosort for documentation
		// essentially checks if sorted and, if not, shuffles the array.  Rinse and repeat
		Student[] studentArray = new Student[array.length];
		ArrayList<Student> arrayList = new ArrayList<Student>(array.length);
		
		for (int i = 0; i < array.length; i++) {
			arrayList.set(i, array[i]);
			System.out.println(array[i]);
		}

		System.out.println("This may take a while, go and get a coffee");
		while (!isNameSorted(arrayList)) { // always check before 
			Collections.shuffle(arrayList); // pretty much "throw the deck of cards in the air"
			for (int i = 0; i < arrayList.size(); i++) { // print array
				System.out.println(arrayList.get(i));
			}
		}
		
		for (int i = 0; i < arrayList.size(); i++)
			studentArray[i] = arrayList.get(i);
		return studentArray;
	}
	
	public Student[] sortByAverage(Student[] array) { // Bozo sort, slightly more efficient than bogo sort
		// still should not be used with large arrays
		// worst case - never will be sorted
		// average case - O(n!) see the slight improvement?
		// best case - O(n)
		
		Student[] studentArray = new Student[array.length];
		ArrayList<Student> arrayList = new ArrayList<Student>(array.length);
		
		for (int i = 0; i < array.length; i++) {
			arrayList.set(i, array[i]);
			System.out.println(array[i]);
		}

		System.out.println("This may take a while, go and get a coffee");		
		while (!isAverageSorted(arrayList)) {
			Random number = new Random();
			int number1 = number.nextInt(arrayList.size());
			int number2 = number.nextInt(arrayList.size());
			Student temp = arrayList.get(number1);
			arrayList.set(number1, arrayList.get(number2));
			arrayList.set(number2, temp);
			for (int i = 0; i < arrayList.size(); i++) { // print array
				System.out.println(arrayList.get(i));
			}
		}
		return studentArray;
	}
}

