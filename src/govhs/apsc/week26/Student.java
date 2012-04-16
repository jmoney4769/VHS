package govhs.apsc.week26;
/* Author:	Jared Moore
 * School:	Spaulding High School
 * Date:	Monday 19 March, 2012
 * Student Project
 */

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
   
   	public static ArrayList<Object> readInfo() {

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
   
   	public static Student[] readArray(ArrayList<Object> objects) {
		
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
   		
   		for (int i = 0; i < array.size() - 1; i++) {
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
		else if (this.getLastName().compareTo(o.getLastName()) >= 1)
			return 1;
		else 
			return -1; // no other possibilities
	}
	
	/*public static Student[] sortByLast(Student[] array) { // bogo sort, wildly inefficient
		// please do not use with large arrays
		// worst case - array will never be sorted
		// average case - O(n * n!) the extra n is for checking the array
		// best case - O(n) not run once, the n is for checking the array
		// see http://en.wikipedia.org/wiki/Bogosort for documentation
		// essentially checks if sorted and, if not, shuffles the array.  Rinse and repeat
		Student[] studentArray = new Student[array.length];
		ArrayList<Student> arrayList = new ArrayList<Student>(array.length);
		
		for (int i = 0; i < array.length; i++) {
			arrayList.add(array[i]);
			System.out.println(array[i]);
		}

		System.out.println("This will take a while (possibly forever), go and get a coffee");
		System.out.println("On average, it will take about 36288000 iterations for students.txt to be sorted");
		System.out.println("You have been warned");
		while (!isNameSorted(arrayList)) { // always check before 
			Collections.shuffle(arrayList); // pretty much "throw the deck of cards in the air"
			for (int i = 0; i < arrayList.size(); i++) { // print array
				System.out.println(arrayList.get(i));
			}
		}
		
		for (int i = 0; i < arrayList.size(); i++)
			studentArray[i] = arrayList.get(i);// transpose arraylist into an array
		return studentArray;
	}*/
	
	/* public static Student[] sortByAverage(Student[] array) { // Bozo sort, slightly more efficient than bogo sort
		// still should not be used with large arrays
		// worst case - never will be sorted
		// average case - O(n!) see the slight improvement?
		// best case - O(n)
		// see the bozo sort note on the webpage provided for bogo sort
		
		Student[] studentArray = new Student[array.length];
		ArrayList<Student> arrayList = new ArrayList<Student>(array.length);
		
		for (int i = 0; i < array.length; i++) {
			arrayList.add(array[i]);
			System.out.println(array[i]); // print array
		}

		System.out.println("This will take a long time, go and do a jig");		
		System.out.println("On average, it will take 3628800 iterations for students.txt to complete");
		System.out.println("You have been warned");
		while (!isAverageSorted(arrayList)) { // randomly switch two values
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
		
		
		for (int i = 0; i < arrayList.size(); i++)
			studentArray[i] = arrayList.get(i); // transpose arraylist into an array
		return studentArray;
	}*/
	
	public static int menu(Student[] array) { // display a menu of options
		
		Scanner input = new Scanner(System.in);
		int choice = 0;
		while (choice == 0) {
			System.out.println("What would you like to do?\n1:  Sort by last name\n2:  Sort by average\n" +
					"3:  Search by last name\n4:  Search by average\n5:  Exit");
			choice = input.nextInt();
			choice = ((choice >= 1) && (choice <= 5) ? choice : 0); // to prevent problems
			if (choice == 0)
				System.out.println("You must choose a number between 1 and 4");
		}		
		return choice;
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		Student[] array = Student.readArray(Student.readInfo());
		while (true) {
			switch (Student.menu(array)) {
			case 1:
				Student.sortByLast(array);
				break;
			case 2:
				Student.sortByAverage(array);
				break;
			case 3:
				System.out.println("What is the name of the student you are looking for?");
				String search = input.next();
				Student.binaryNameSearch(array, search);
				break;
			case 4:
				System.out.println("What is the average of the student you are looking for?");
				int searchNumber = input.nextInt();
				Student.binaryAverageSearch(array, searchNumber);
				break;
			case 5:
				System.exit(0); // only way to exit the program, this way you can choose multiple options
			}
		}
	}

	public static void binaryNameSearch(Student[] array, String search) {
		
		sortByLast(array); // will not sort if already sorted, it will just check
		if ((array[0].getLastName().compareTo(search) >= 1) || (array[array.length - 1]
				.getLastName().compareTo(search) <= -1)) {
			System.out.println("Student was not found");
			return;
		}
		int comparator = 1;
		int currentIndex = array.length / 2;
		while (comparator != 0) {
			comparator = search.compareTo(array[currentIndex].getLastName());
			
			if (comparator <= -1) // Search was less than index
				currentIndex /= 2; // find half distance between currentIndex and zero 
			else if (comparator >= 1) // Search was more than index
				currentIndex = (array.length + currentIndex) / 2; // find half distance between currentIndex and end
			
			else if ((((currentIndex == 0) || (currentIndex == array.length)) && (comparator != 0))) {
				System.out.println("Student was not found");
				return; // exit, as the student will not be in the list
			}
		}
		System.out.println(array[currentIndex]); // print the student
	}

	public static void binaryAverageSearch(Student[] array, int searchNumber) {
		
		sortByAverage(array); // will not sort if already sorted, it will just check
		if ((array[0].getAverage() > searchNumber) || (array[array.length - 1]
				.getAverage() < searchNumber)) {
			System.out.println("Student was not found");
			return;
		}
		int currentIndex = array.length / 2;
		while (true) {
			
			if (searchNumber == array[currentIndex].getAverage())
				break;
			if (searchNumber < array[currentIndex].getAverage()) // String was more than search 
				currentIndex /= 2; // find half distance between currentIndex and zero 
			else if (searchNumber > array[currentIndex].getAverage()) // String was less than search
				currentIndex = (array.length + currentIndex) / 2; // find half distance between currentIndex and end
			
			else if ((currentIndex == 0) || (currentIndex == array.length)) {
				System.out.println("Student was not found");
				return; // exit, as the student will not be in the list
			}
		}
		System.out.println(array[currentIndex]); // print the student
	}
	
	public static Student[] sortByLast(Student[] array) { // comb sort
		// similar to bubble sort but more efficient
		// see http://en.wikipedia.org/wiki/Comb_sort for reference
		// I wrote this based on the psuedocode provided
		printArray(array, true);
		int gap = array.length;
		boolean swapped = true;
		
		while (gap != 1 || swapped) {
			
			gap = (int) (gap / 1.247330950103979); // see reference for explanation of the number
			// it has to do with e and the golden ratio
			if (gap < 1)
				gap = 1;
			
			int i = 0;
			swapped = false;
			
			while (i + gap < array.length) {
				if (array[i].getLastName().compareTo(array[i + gap].getLastName()) > 0) {
					Student temp = array[i];
					array[i] = array[i + gap];
					array[i + gap] = temp;
					swapped = true;
				}
				i++;	
				printArray(array, true);
			}
		}
		return array;
	}
	
	public static Student[] sortByAverage(Student[] array) { // shell sort
		// works similarly to a combination of insertion sort and bubble sort
		// see http://en.wikipedia.org/wiki/Shellsort for reference
		// I wrote this based on the code written by the nice people at
		// http://www.java2s.com/Code/Java/Collections-Data-Structure/Shellsort.htm
		printArray(array, false);
		int length = array.length;
		int h = 1, inner;
		
		while (h <= length / 3) 
			h = h * 3 + 1;
		
		while (h > 0) {
			for (int outer = h; outer < length; outer++) {
				Student temp = array[outer];
				inner = outer;
				while (inner > h - 1 && array[inner - h].getAverage() >= temp.getAverage()) {
					array[inner] = array[inner - h];
					inner -= h;
				}
				array[inner] = temp;
			}
			h = (h - 1) / 3;
			printArray(array, false);
		}
		return array;
	}
	public static void printArray(Student[] array, boolean lastOrAverage) { // print array
		
		for (int i = 0; i < array.length; i++)
			if (lastOrAverage) // decide whether to print the averages or the last names
				System.out.print(array[i].getLastName() + " ");
			else 
				System.out.print(array[i].getAverage() + " ");
		System.out.println();
	}

}

