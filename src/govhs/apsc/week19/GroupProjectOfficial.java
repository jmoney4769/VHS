package govhs.apsc.week19; // ignore this, I use packages with eclipse to organize data, it will be removed
// in the submission

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class GroupProjectOfficial {

	/* Author:  Jared Moore
	 * Precondition:  The program does not have a file from which it can snag information
	 * Postcondition:  The program has a file from which it can snag information
	 */ 
	private static BufferedReader getFile(String path) {
		
		BufferedReader reader = null; // initializing variable so that it can be used outside the try block
		try {

			InputStreamReader inReader = new InputStreamReader(new FileInputStream(
					path)); //file path will vary, I will include in /res folder of project
			reader = new BufferedReader(inReader);
		}
		catch (FileNotFoundException e) { // properly handle possible exceptions
			System.err.println("File does not exist"); 
			System.exit(1); // if the file is not there, it would be pointless to continue
		}
		return reader;
	}	
		
	/* Author: Uday Srinivasan
	 * Precondition: One character array of 10 elements with the characters T or F from the answer key and
	 *   a parallel character array of an arbitrary student's answers WHICH DOES NOT INCLUDE THE STUDENT ID.
	 * Postcondition: A score out of 10 is assigned to the student after comparing them to the answer key.
	 */
	 public static int calcPoints(char[] keyArray, char[] studentArray){

		 if(keyArray.length==10 && studentArray.length==10) {//checks to make sure there are 10 responses

			 int correct = 0; //"correct" is the number of correct answers

			 for(int q = 0; q < 10; q++){//treating the test as if its 10 questions were labelled q0 through q9
				 if(keyArray[q] == studentArray[q])
					 correct++; //tallies number of correct answers
			 }

			 return correct; //the method output is the student's score out of 10.

		 }
		 else {
			 System.out.println("There have to be 10 responses."); //makes sure that the student has 10 responses
			 //before the intended function of the method is executed.
			 return 0;
		 }
	 }
	 
	 /* Author:  Jared Moore
	 * Precondition:  There is a score for student answers but it doesn't have a grade
	 * Postcondition:  An appropriate grade is assigned to each student
	 */
	public static char calcScore(int correct) {// correct being the number of correct answers
			
		correct = ((correct >= 0) && (correct <= 10)) ? correct : 0; // conditional statement. ensures data 
		// integrity.  If correct is not between 0 and 10 inclusive, it gets the value of 0
		char grade;
		switch (correct) { // an amazing tool we have yet to learn
		case 10: // if correct == 10
			grade = 'A';
			break; // exit the block, break can be used in any statement in braces (not classes or methods),
			// to exit the block of code
		case 9: // if correct == 9
			grade = 'B';
			break;
		case 7: // if correct is between 7
		case 8: // and 8 inclusive
			grade = 'C';
			break;
		case 5: // if correct is between 5
		case 6: // and 6
			grade = 'D';
			break;
		default: // all other possibilities, basically anything less than 5
			grade = 'F';
			break;			
		}
		return grade;
	}
		
	public static void main(String[] args) {
		
	}
}
