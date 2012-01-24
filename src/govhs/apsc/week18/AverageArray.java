package govhs.apsc.week18;
/* Author:  Jared Moore
 * School:  Spaulding High School
 * Assignment:  Project 9-2
 */

import java.util.ArrayList;

public class AverageArray {

	public static void getAverage(double[] array) {
		
		int sum = 0; // sum of values
		ArrayList<Double> bigArray = new ArrayList<Double>(); // to hold the numbers bigger than the average
		for (double i : array) {
			sum += i; // sums the values
		}
		double average = (double) sum / array.length; // calc average
		System.out.printf("Average is:  %.2f\n", average); // print the values
		
		for (double i : array) {
			if (i > average) // if the number is larger than the average, add it to the array
				bigArray.add(i);
		}
		System.out.print("Numbers larger than average are: "); 
		for (int i = 0; i < bigArray.size(); i++) // print the values
			System.out.print(bigArray.get(i) + ", ");
	}
	public static void main(String[] args) {
		double array[] = {3, 2, 4, 5, 6, 7, 8, 9, 1, 2};
		AverageArray.getAverage(array);
	}
}
