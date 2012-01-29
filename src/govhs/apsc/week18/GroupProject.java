package govhs.apsc.week18;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GroupProject {

	/* Author:  Jared Moore
	 * Precondition:  The program does not have a file from which it can snag information
	 * Postcondition:  The program has a file from which it can snag information
	 */ 
	private static BufferedReader getFile(String path) {
		
		BufferedReader reader = null; // initializing variable so that it can be used outside the try block
		try {

			InputStreamReader inReader = new InputStreamReader(new FileInputStream(
					"res/VOWELS.txt")); //file path will vary, I included in /res folder of project
			reader = new BufferedReader(inReader);
		}
		catch (FileNotFoundException e) { // properly handle possible exceptions
			System.err.println("File does not exist");
			System.exit(1);
		}
		return reader;
	}
	
	/* Author:  Jared Moore
	 * Precondition:  The program does not have any information stored locally
	 * Postcondition:  The program has an ArrayList of the answers and students
	 */
	public static ArrayList<String> getArray() {
		
		BufferedReader reader = getFile("res/answers.txt"); // get the file, I have a /res folder where I
		// keep files I need for the project in the project directory
		ArrayList<String> array = new ArrayList<String>(); // to hold the file contents
		try {
			String line = reader.readLine(); // assign each index to a line in the program
			while (line != null) {
				array.add(line);
				line = reader.readLine();
			}
		} 
		catch (IOException e) {
			System.err.println("Error with file");
			System.exit(1);
		}
		return array;
	}
	
	/* Author:  Jared Moore
	 * Precondition:  There is an ArrayList with the answers and the students
	 * Postcondition:  A correct answers array is created
	 */
	public static char[] setUpAnswerArray(ArrayList<String> array) {
		
		char[] array1 = array.get(0).toCharArray();
		return array1;
	}
	
	/* Author:  Jared Moore
	 * Precondition:  There is an array of student answers but they have not been scored
	 * Postcondition:  A score is set for each set of answers
	 */
	public static int checkCorrect(char[] answers, char[] student) {
		
		int sum = 0;
		if (answers.length != student.length) {
			System.err.println("Arrays are not the same size");
			System.exit(1);
		}
		for (int i = 0; i < answers.length; i++) // check the answers by the character
			if (answers[i] == student[i]) // for each answer that is the same as the correct one
				sum++; // increment the sum
		return sum;
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
		
		ArrayList<String> array = GroupProject.getArray();
		char[] answers = GroupProject.setUpAnswerArray(array);
		
		String[] studentArray = new String[array.size() - 1];
		for (int i = 0; i < (array.size() - 1); i++) 
			studentArray[i] = array.get(i + 1);
		String[] answerArray = new String[studentArray.length], idArray = new String[studentArray.length];
		
		for (int i = 0; i < studentArray.length; i++) {
			String[] tempArray = studentArray[i].split(" ");
			idArray[i] = tempArray[0];
			answerArray[i] = tempArray[0];
		}
		
		int[] scoreArray = new int[answerArray.length];
		for (int i = 0; i < answerArray.length; i++) 
			scoreArray[i] = GroupProject.checkCorrect(answers, answerArray[i].toCharArray());
		
		char[] gradeArray = new char[scoreArray.length];
		for (int i = 0; i < scoreArray.length; i++) 
			gradeArray[i] = GroupProject.calcScore(scoreArray[i]);
		
	}
}
