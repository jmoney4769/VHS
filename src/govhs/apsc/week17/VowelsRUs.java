package govhs.apsc.week17;
/* Jared Moore
 * AP Computer Science
 * Spaulding High School
 * Wednesday, December 14, 2011
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import chapter.five.Student;

public class VowelsRUs {

	private static final char[]  VOWELS = {'A', 'C', 'S', 'L', 'a', 'c', 's', 'l'}; // list of vowels

	public static boolean[] getEnding(String word) { // get the ending to determine what to do with word

		boolean w = false, s = false;
		char array[] = word.toCharArray(); // I like arrays
		for (int i = 0; i < VOWELS.length; i++) {
			if (array[array.length - 1] == VOWELS[i])
				w = true; // checking if last letter is vowel
			if (array[array.length - 2] == VOWELS[i])
				s = true; // checking if second-last letter is vowel
		}
		boolean[] ar = {w, s};
		return ar;
	}

	public static String addPlural(String word, boolean[] ar) {

		char[] array = word.toCharArray(); // I like arrays
		if (((ar[0]) && (ar[1])) || (!(ar[0]) && !(ar[1]))) // if word ends in 2 VOWELS or consonants
			word = (word + Character.toString(array[array.length - 1]) + "H");
		else if (ar[0]) // if word ends in a vowel
			word = (word.substring(0, (word.length() - 1)) + "G");
		else // if word ends in a consonant
			word = (word + "GH");
		return word;
	}

	public static String addConsonantSuffix(String word, String suffix, boolean[] ar) { // called when adding a consonant suffix

		char[] array = suffix.toCharArray(); // I like arrays
		char[] array1 = word.toCharArray(); // I like arrays
		if (((ar[0]) && (ar[1])) || (!(ar[0]) && !(ar[1]))) // same conditions as previous method
			word = (word.substring(0, (word.length() - 2)) +
					Character.toString(array1[array1.length -1])+ suffix);
		else if (ar[0])
			word = (word + Character.toString(array[0]) + suffix);
		else
			word = (word + suffix);
		return word;
	}

	public static String addVOWELSuffix(String word, String suffix, boolean[] ar) { // called when adding a vowel suffix

		char[] array = suffix.toCharArray(); // I like arrays
		if (((ar[0]) && (ar[1])) || (!(ar[0]) && !(ar[1]))) // same conditions
			word = (word + Character.toString(array[0]) + suffix);
		else if (ar[0])
			word = (word + suffix.substring(1));
		else
			word = (word + suffix);
		return word;
	}

	public static BufferedReader getInfo() { // initialize the file reader

		BufferedReader reader = null;
		try {

			InputStreamReader inReader = new InputStreamReader(new FileInputStream(
					"res/VOWELS.txt")); //file path will vary, I included in /res folder of project
			reader = new BufferedReader(inReader);
		}
		catch (FileNotFoundException e) { // properly handle possible exceptions
			System.err.println("File does not exist");
			System.exit(1);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Line in file was too long, correct error in file");
			System.exit(1);
		}
		return reader;
	}

	public static void main(String[] args) {

		try {
		BufferedReader reader = VowelsRUs.getInfo();
		String line = reader.readLine(); // read first line
		while (line != null) {
				String array[] = line.split(" "); // split the line into two Strings at the character " "
				boolean array2[] = VowelsRUs.getEnding(array[0]); // get the ending of the word
				System.out.printf("Original String : %s %s\n", array[0], array[1]);
				System.out.printf("Plural : %s\n", VowelsRUs.addPlural(array[0], array2));

				boolean array3[] = VowelsRUs.getEnding(array[1].substring(0,2)); // get the "ending" of the suffix
				if (array3[1])
					System.out.printf("Suffix : %s\n\n",
							VowelsRUs.addVOWELSuffix(array[0], array[1], array2));
				else
					System.out.printf("Suffix : %s\n\n",
							VowelsRUs.addConsonantSuffix(array[0], array[1], array2));
				line = reader.readLine(); // read next line
			}
		}
		catch (IOException e) {
			System.err.println("Problem with file");
			System.exit(1);
		}
	}
}
