package v2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameBodyTest {
	GameBody gmb = new GameBody();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testLetterInTheWorTrued() throws Exception {
		gmb.lettersToGuess.add('t');
		gmb.lettersToGuess.add('e');
		gmb.lettersToGuess.add('s');
		gmb.lettersToGuess.add('t');
		assertEquals(true, gmb.letterInTheWord('t', gmb.lettersToGuess));
	}
	
	@Test
	void testLetterInTheWordFalse() throws Exception {
		gmb.lettersToGuess.add('t');
		gmb.lettersToGuess.add('e');
		gmb.lettersToGuess.add('s');
		gmb.lettersToGuess.add('t');
		assertEquals(false, gmb.letterInTheWord('a', gmb.lettersToGuess));
	}
	
	
	@Test
	void tespickLetterTrue() throws Exception {//баг
		gmb.lettersGuessed.add('t');
		gmb.lettersGuessed.add('e');
		gmb.lettersGuessed.add('s');
		gmb.lettersGuessed.add('t');
		//gmb.Wrongletters.add('l');
		assertEquals(true, gmb.pickLetter('t'));
	}
	
	@Test
	void tespickLetterFalse1() throws Exception {
		gmb.lettersGuessed.add('t');
		gmb.lettersGuessed.add('e');
		gmb.lettersGuessed.add('s');
		gmb.lettersGuessed.add('t');
		//gmb.Wrongletters.add('l');
		assertEquals(false, gmb.pickLetter('t'));
	}
	
	@Test
	void teToGuessLetters() throws Exception {
		gmb.showWordToGuess("Test", gmb.lettersGuessed);
		Set<Character> testing = new HashSet<Character>();
		testing.add('*');
		testing.add('*');
		testing.add('*');
		testing.add('*');
		assertEquals(testing, gmb.wordGuessed);
	}
	
	

}
