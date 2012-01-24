package govhs.apsc.week18;
/* Author:  Jared Moore
 * School:  Spaulding High School
 * Assignment:  Project 9-3
 */

public class ModeOfArray {

	public static <E> E getMode(E[] array) { // Generic Method 
		
		int secondArray[] = new int[array.length]; // create parallel array
		for (int i = 0; i < secondArray.length; i++) // fill array with values of zero
			secondArray[i] = 0;
		
		for (int i = 0; i < array.length; i++) 
			for (int j = i + 1; j < array.length; j++) // search generic array for repeating values
				if (array[i] == array[j])
					secondArray[i]++; // increment the array for each repeating values
		
		int max = 0, index = 0;
		for (int i = 0; i < secondArray.length; i++) // find the maximum 
			if (max < secondArray[i]) {
				max = secondArray[i];
				index = i;
			}
		return array[index];
	}
	
	public static void main(String[] args) {
		
		Integer[] intArray = {1, 1, 2, 2, 2, 3, 4}; // to show the effectiveness of a generic method
		Double[] doubleArray = {1.0, 1.0, 1.5, 2.0, 2.3}; 
		
		System.out.printf("Mode of intArray is: %d\nMode of DoubleArray is: %.2f",
				ModeOfArray.getMode(intArray), ModeOfArray.getMode(doubleArray)); // print the modes
	}
}
