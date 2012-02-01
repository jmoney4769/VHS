package govhs.apsc.week19; // ignore this, I use packages with eclipse to organize data, it will be removed
// in the submission

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

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
	
	//Jacob Watson
	//Precondition: all the methods are written so this method takes the reader separates stuff into arrays
	//Post: sends the student's id's and then all of their test scores 

	/*  At the end of this method, we have would have three arrays that we could not do anything with.
	 *  I (Jared Moore) will split apart the method so that we can actually get all three of the arrays.
	 *  This original method will be commented for reference and I will use as much as possible verbatum
	 *  from this method.
	public static void readFile(BufferedReader reader) throws IOException {
	
		String loop, holdkey, holdstudent;
		int i = 0;
		char[][] originalstudentArray = new char[126][10];
		char[] keyArray = new char[10];
		int[] idArray = new int [126];
		
		// Comments done by Jared Moore
		// So that he could more easily understand what is happening in this method
		 
		reader = getFile("res/answers.txt"); // get the file information
		loop = reader.readLine(); // read the first line of the file

		StringTokenizer strTkn = new StringTokenizer(loop); // split the file by the spaces kinda
		holdkey = strTkn.nextToken(); // snag the next token as a String (or the first line in this case)

		for(int w = 0; w < 10; w++)
			keyArray[w] = holdkey.charAt(w); // make an array of characters as the key array
		loop = reader.readLine(); // read the next line

		while (loop != null) { // while there is data
		
			strTkn = new StringTokenizer(loop); // take the line as a string tokenizer
			idArray[i] = Integer.parseInt(strTkn.nextToken()); // assign the first set of id's to the first 
			// spot in idArray
			// System.out.println(idArray[i]); not yet please
			holdstudent = strTkn.nextToken(); // a string for student answers
			// System.out.println(holdstudent); again, I will print at the end for organization purposes
			for (int j = 0; j < 10; j++)
				originalstudentArray[i][j] = holdstudent.charAt(j); // each row has all of the answers per student
			i++; // increment i
			loop = reader.readLine(); // read next line
			
		}
	}
	*/
	
	/* Author:  Jacob Watson (rearanged by Jared Moore to avoid the problem of no return statements
	 * Precondition:  The program does not have an array of the correct answers separated from the rest
	 * of the data.
	 * Postcondion:  The program has the answer key
	 */
	public static char[] getKey(String line) {
		
		if (line.length() != 10) {
			System.err.printf("Answer String is %d long instead of the expected 10\n", line.length());
			System.exit(1);
		}
		StringTokenizer strTkn = new StringTokenizer(line); // split the file by the spaces kinda
		String holdkey = strTkn.nextToken(); // snag the next token as a String (or the first line in this case)
		char[] keyArray = new char[10];
		
		for(int w = 0; w < 10; w++)
			keyArray[w] = holdkey.charAt(w); // make an array of characters as the key array
		
		return keyArray;
	}

	/* This method is not used as, with the other commented method, it has multiple arrays that it would
	 * need to return and that happens to be impossible.  I (Jared Moore) took each part of the method
	 * (except the initializations) and put them later in the program pretty much verbatum
	//Jacob Watson
	//Precondition: One huge array of all of the answers given
	//Post: Seperates the huge array into smaller pieces, and has the values for amount right and letter grade

	public static void seperator(char[][] originalstudentArray, char[] keyArray, int[] idArray) {
	
		char[] studentArray = new char[10];
		int[] correctArray = new int [126];
		char[] gradeArray = new char [126];

		int correct;
		for(int row = 0; row < originalstudentArray.length; row++ ) {
			for(int count = 0; count < originalstudentArray[row].length; count++)
				studentArray[count] = originalstudentArray[row][count];
			correctArray[row] = calcPoints(keyArray, studentArray);
		}
		
		for(int row2 = 0; row2 < correctArray.length; row2++) {
			correct = correctArray[row2];
			gradeArray[row2] = calcScore(correct);
		}
	}
	*/
		
	/* Author: Uday Srinivasan
	 * Precondition: One character array of 10 elements with the characters T or F from the answer key and
	 *   a parallel character array of an arbitrary student's answers WHICH DOES NOT INCLUDE THE STUDENT ID.
	 * Postcondition: A score out of 10 is assigned to the student after comparing them to the answer key.
	 */
	 public static int calcPoints(char[] keyArray, Character[] studentArray){

		String s = ""; // to convert from Character to char
		for (Character i : studentArray)
			 s += i.toString();
		char[] studentAnswerArray = s.toCharArray();
		
		if (keyArray.length == 10 && studentAnswerArray.length == 10) {//checks to make sure there are 10 responses

			int correct = 0; //"correct" is the number of correct answers
			for(int q = 0; q < 10; q++){//treating the test as if its 10 questions were labeled q0 through q9
				if(keyArray[q] == studentAnswerArray[q])
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
	/* Author:  Jared Moore (with code from Jacob's methods)
	 * Precondition:  Nothing is running
	 * Postcondition:  The program has completed successfully (in theory)
	 */
	public static void main(String[] args) {
		
		BufferedReader reader = GroupProjectOfficial.getFile("res/answers.txt"); // get the file
		String line = "";
		try { // in case of an error
			line = reader.readLine(); // read the first line		
			char[] answersArray = GroupProjectOfficial.getKey(line); // get an array of the correct answers
			
			line = reader.readLine(); // read the next line
			
			ArrayList<Integer> idArray = new ArrayList<Integer>(); // to hold an indefinate amount of students
			ArrayList<Character[]> originalStudentArray = new ArrayList<Character[]>();
			
			while (line != null) { // while there is data
				StringTokenizer strTkn = new StringTokenizer(line); // take the line as a string tokenizer
				idArray.add(Integer.parseInt(strTkn.nextToken())); // assign the first set of id's to the 
				// first spot in idArray				
				String holdstudent = strTkn.nextToken(); // a string for student answers
				Character[] tempArray = new Character[10];
				for (int j = 0; j < 10; j++) 
					tempArray[j] = Character.valueOf(holdstudent.charAt(j));
				originalStudentArray.add(tempArray);
				line = reader.readLine(); // read next line
			}
			
			ArrayList<Integer> scoreArray = new ArrayList<Integer>(originalStudentArray.size());
			for (int i = 0; i < originalStudentArray.size(); i++) // assign scores to the answers
				scoreArray.add(GroupProjectOfficial.calcPoints(answersArray, originalStudentArray.get(i)));
			ArrayList<Character> gradeArray = new ArrayList<Character>(scoreArray.size());
			for (int i = 0; i < scoreArray.size(); i++) // assign grades to the score
				gradeArray.add(GroupProjectOfficial.calcScore(scoreArray.get(i)));
			GroupProjectOfficial.printStatements(idArray, scoreArray, gradeArray); // print stuff
		}
		
		catch (IOException e) {
			System.err.println("There is a problem with the file");
			System.exit(1);
		}
	}

	/* Author:  Jared Moore
	 * Precondition:  The program has values but nothing has been printed
	 * Postcondition:  The program prints necessary data 
	 */
	private static void printStatements(ArrayList<Integer> idArray,
			ArrayList<Integer> scoreArray, ArrayList<Character> gradeArray) {
		System.out.printf("There were %d students who took the quiz\nThe students earned a class average" +
				" of %.2f\n", idArray.size(), calcAverageScore(scoreArray));
		int[] array = countLetters(gradeArray);
		System.out.printf("There were %d A's, %d B's, %d C's, %d D's, and %d F's\n", array[0], array[1],
				array[2], array[3], array[4]);
		System.out.println("Score and Grade by Student:");
		for (int i = 0; i < idArray.size(); i++) {
			System.out.printf("Student ID:  %d;\tStudent Score:  %d;\tStudent Grade %s\n",
					idArray.get(i), scoreArray.get(i), gradeArray.get(i).toString());
		}
				
	}

	/* Author:  Jared Moore
	 * Precondition:  There is no average score
	 * Postcondition:  An average of the scores is calculated
	 */
	private static double calcAverageScore(ArrayList<Integer> scoreArray) {
		int sum = 0;
		for (int i = 0; i < scoreArray.size(); i++)
			sum += scoreArray.get(i);  
		
		return ((double) sum / scoreArray.size());
	}
	
	/* Author:  Jared Moore
	 * Precondition:  The grades have not been counted
	 * Postcondition:  There is a count of each letter grade
	 */
	private static int[] countLetters(ArrayList<Character> gradeArray) {
		
		int[] array = new int[5];
		for (int i = 0; i < array.length; i++)
			array[i] = 0;
		for (int i = 0; i < gradeArray.size(); i++) {
			Character c = gradeArray.get(i);
			if (c.equals('A')) // increase the count of each letter as they appear in the array
				array[0]++;
			else if (c.equals('B'))
				array[1]++;
			else if (c.equals('C'))
				array[2]++;
			else if (c.equals('D'))
				array[3]++;
			else if (c.equals('F'))
				array[4]++;
			else {
				System.err.println("Umm, the correct character was not assigned, fix your method");
				System.exit(1);
			}
		}
		return array;
	}
}
