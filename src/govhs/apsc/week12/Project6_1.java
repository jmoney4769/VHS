package govhs.apsc.week12;

/**@(#)Project6_1.java
 * Spaulding High School
 * Jared Moore
 * @version 1.00 2011/11/16
 */

// This program will generate a random number and have the user guess it, recording the number of guesses
import java.util.Random;
import java.util.Scanner;
public class Project6_1 {
   public static void main(String args[]) {
   		Scanner input = new Scanner(System.in);
   		Random generator = new Random();
   		int guess = 0; // value of the user's guess
   		int answer = (1 + generator.nextInt(100));  // choose a random number 1-100
   		int counter = 0; // count guesses
   		while (guess != answer) {
   			while ((guess <= 0) ^ (guess > 100)) { // check for equality
   			System.out.println("Enter your guess between 1 and 100 inclusive: ");
   			guess = input.nextInt();
   			}
   			if (guess > answer) // tell user if they were high or low
   				System.out.println("Your guess was greater than the number!");
   			else
   				System.out.println("Your guess was less than the number!");
   			System.out.println("Enter your guess between 1 and 100 inclusive: ");
   			guess = input.nextInt();
   			counter++;
   		}
   		System.out.printf("You guessed it in %d tries! The number was %d",counter, answer); // print info
   }
}