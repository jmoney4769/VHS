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
	 * 
	 */
	public static char[] setUpAnswerArray(ArrayList<String> array) {
		
		char[] array1 = array.get(0).toCharArray();
		return array1;
	}
	
	public static int checkCorrect(char[] answers, char[] student) {
		
		int sum = 0;
		if (answers.length != student.length) {
			System.err.println("Arrays are not the same size");
			System.exit(1);
		}
		for (int i = 0; i < answers.length; i++) 
			if (answers[i] == student[i])
				sum++;
		return sum;
	}
	
	public static char calcScore(int correct) {
		
		char grade = 0;
		switch (correct) {
		case 10:
			grade = 'A';
			break;
		case 9:
			grade = 'B';
			break;
		case 7:
		case 8:
			grade = 'C';
			break;
		case 5:
		case 6:
			grade = 'D';
			break;
		default:
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
