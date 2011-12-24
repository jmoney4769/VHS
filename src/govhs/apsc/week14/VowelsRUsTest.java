package govhs.apsc.week14;

import static org.junit.Assert.*;

import org.junit.Test;

public class VowelsRUsTest {
	
	String word = "XQAC", word1 = "PDAE", word2 = "SNIC";

	@Test
	public void testAddPlural() {		
		
		assertEquals("XQACCH", VowelsRUs.addPlural(word, VowelsRUs.getEnding(word)));
		assertEquals("PDAEGH", VowelsRUs.addPlural(word1, VowelsRUs.getEnding(word1)));
		assertEquals("SNIG", VowelsRUs.addPlural(word2, VowelsRUs.getEnding(word2)));
	}
	
	@Test
	public void testAddConsonantSuffix() {
		
		assertEquals("XQCZVM", VowelsRUs.addConsonantSuffix(word, "ZVM", VowelsRUs.getEnding(word)));
	}

	@Test
	public void testAddVowelSuffix() {
		
		assertEquals("PDAEAV", VowelsRUs.addVowelSuffix(word1, "AV", VowelsRUs.getEnding(word1)));
		assertEquals("SNICY", VowelsRUs.addVowelSuffix(word2, "SY", VowelsRUs.getEnding(word2)));
	}
}
