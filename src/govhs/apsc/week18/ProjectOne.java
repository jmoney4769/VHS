package govhs.apsc.week18; // remove this please, you do not have a package, but i does

/*
 *Tyler Shaw
 *Arrays Project 9-2
 *Spaulding High School
 *Write a program that takes 10 floating-point numbers as inputs. The program
 *displays the average of the numbers followed by all of the numbers that are
 *greater than the average. As part of your design, write a method that takes
 *an array of doubles as a parameter and returns the average of the data in
 *the array.
 */

 public class ProjectOne{

 	public static void main(String[] args){

 		double[] n = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20}; // put this here
		//calculateAverage(n); // you don't need this, it does nothing silly
		double average = calculateAverage(n); // with the parameter of n
		System.out.printf("The Average is: %.2f", average); // I like printf better


 	}

 	private static double calculateAverage(double[] n){ // and the parameter here

		
 		double total = 0;
 		for(double element : n)
 			total += element;
		double average = total / 10;
		return average;

 	}
 }