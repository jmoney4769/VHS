package govhs.apsc.week18;
/* Author:  Jared Moore
 * School:  Spaulding High School
 * Assignment:  Program 3
 */

import java.util.Random;

public class TwoDimensional {

	public static int[][] makeArray() {
		
		int[][] array = new int[5][4];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) // make a new array filled with random values
			for (int j = 0; j < array[i].length; j++)
				array[i][j] = (1 + random.nextInt(9));
		return array;
	}
	
	public static int[] sumRows(int[][] array) {
		
		int[] returnArray = new int[5]; 
		for (int i = 0; i < array.length; i++) { // sum all of the values in the rows
			int sum = 0;
			for (int j = 0; j < array[i].length; j++)
				sum += array[i][j];
			returnArray[i] = sum;
		}		
		return returnArray;
	}
	
	public static int[] sumColumns(int[][] array) {
		
		int[] returnArray = new int[4];
		for (int i = 0; i < 4; i++) {  // sum all of the values in the columns
			int sum = 0;
			for (int j = 0; j < 5; j++)
				sum += array[j][i]; // in order to traverse along the columns instead of rows
			returnArray[i] = sum;
		}		
		return returnArray;
	}
	
	public static void main(String[] args) {
		
		int[][] array = TwoDimensional.makeArray(); // set up arrays
		int[] rowArray = TwoDimensional.sumRows(array), columnArray = TwoDimensional.sumColumns(array);
		
		System.out.print("Original Array:"); // print all values
		for (int i = 0; i < array.length; i++) {
			System.out.println();
			for (int j = 0; j < array[i].length; j++)
				System.out.print(array[i][j] + " ");
		}
		
		System.out.println("\nSum of rows:");
		for (int i = 0; i < rowArray.length; i++)
			System.out.println(rowArray[i]);
		
		System.out.println("Sum of Columns:");
		for (int i = 0; i < columnArray.length; i++)
			System.out.println(columnArray[i]);
	}
}
