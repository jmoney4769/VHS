package govhs.apsc.week25;
/* Author: Jared Moore
 * School:  Spualding High School
 * Date:  Friday 9 March, 2012
 * Recursion Project
 */

public class RecursivePractice {

	public static int sumBetweenBounds(int lower, int upper) { // generic method, both lower and upper must be
		// of a class that supports the + operator
		System.out.printf("Parameters:  lower = %d, upper = %d\n", lower, upper); // to print the parameters
		if (upper == lower) // stopping step
			return lower; // add the lower bound to the total, finishing the loop
		else 
			return (upper + sumBetweenBounds(lower, upper - 1)); // add the upper value to the total
	}
}
