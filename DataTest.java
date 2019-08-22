package v2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.Assert.*;

class DataTest {
	 Data data = new Data();
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
	void testSetOriginalWord() {
		assertEquals(true, data.SetOriginalWord("Test"));
	}
	
	@Test
	void testGetOriginalWordFalse() {
		assertEquals("Test", data.GetOriginalWord());
	}
	@Test
	void testSetGuessWord() {
		assertEquals(true, data.SetGuessWord());
	}
	
	
	

}
