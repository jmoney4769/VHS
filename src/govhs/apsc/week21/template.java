package govhs.apsc.week21;

/* Author:  Jared Moore (not really, just one method)
 * School:  Spaulding High School
 * Date:  	Friday 10 February, 2012
 */
import java.io.IOException;

public class template {
   
	public static void main(String[] args) throws IOException {

		//creating objects and variables	
		int lineCount;	  
		int counter = 0;
		//count how many lines in the file
		lineCount = countLines(counter); 
		String answerKey = null;
		String[] studentID = new String[lineCount];//store student id
		String[] answers = new String[lineCount];//store student answers
		int[] correct = new int[lineCount];//store number they got correct
		char[] grade = new char[lineCount];//store letter grade
		char[] key = new char[10];//holds answer key
		int[] numOfEach=new int[5];//hold number of each grade
		//initialize file
		initFile();
	
		//Page 323 tells us that if I pass arrays the actual array will be modified so I can call a //method to read in the entire file
		readFile(answers,studentID,key,lineCount);	    
		//make parallel array of number of correct answers. Send the methods answers and // //answerKey return the filled parallel array containing the number correct.
		correct = correctAnswer(answers,  answerKey);
		//Make a parallel array containing student�s letter grade.  Send correct and return parallel //array.
		grade = getGrade(correct);
		//Count how many of each grade
		numOfEach=count(grade);
		//Output the desired results
		outputResults(studentID, correct, grade);
	}

	private static int countLines(int counter) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static void outputResults(String[] studentID, int[] correct,
			char[] grade) {
		// TODO Auto-generated method stub
	
	}

	private static int[] count(char[] grade) {
		
		// char[] returnArray = new char[5]; // it would be foolish to return this instead of an int array, 
		// however, I will do as I am told...
		int[] intArray = new int[5]; // Actually nevermind.  If there is more than one digit in the total,
		// it would be impossible to return a char array.  I apologize if this inconveniences you.
		for (char i : grade) {
			switch (i) {
			case 'A':
				intArray[0]++;
				break;
			case 'B': 
				intArray[1]++;
				break;
			case 'C':
				intArray[2]++;
				break;
			case 'D':
				intArray[3]++;
				break;
			default:
				intArray[4]++;
				break;
			}
		}
		return intArray;
	}

	private static char[] getGrade(int[] correct) {
		// TODO Auto-generated method stub
		return null;
	}

	private static int[] correctAnswer(String[] answers, String answerKey) {
		// TODO Auto-generated method stub
		return null;
	}

	private static void readFile(String[] answers, String[] studentID, char[] key,
			int lineCount) {
		// TODO Auto-generated method stub
	}

	private static void initFile() {
		// TODO Auto-generated method stub
		
	}
	
}
