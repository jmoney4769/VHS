package govhs.apsc.week19;

import static org.junit.Assert.*;

import org.junit.Test;

public class GroupProjectOfficialTest {

	@Test
	public void test() {
		String answerString = "TFTFTFTFTF";
		char[] array = answerString.toCharArray();
		String testString = "TFTFTFFTFT";
		Character[] testArray = new Character[10];
		for (int i = 0; i < testString.length(); i++) {
			testArray[i] = Character.valueOf(testString.charAt(i));
		}
		assertEquals(6, GroupProjectOfficial.calcPoints(array, testArray));
		
		for (int i = 0; i <= 10; i++) {
			if (i < 5)
				assertEquals('F', GroupProjectOfficial.calcScore(i));
			else if ((i == 6) || (i == 5))
				assertEquals('D', GroupProjectOfficial.calcScore(i));
			else if ((i == 7) || (i == 8))
				assertEquals('C', GroupProjectOfficial.calcScore(i));
			else if (i == 9)
				assertEquals('B', GroupProjectOfficial.calcScore(i));
			else if (i == 10)
				assertEquals('A', GroupProjectOfficial.calcScore(i));

		}
	}

}
