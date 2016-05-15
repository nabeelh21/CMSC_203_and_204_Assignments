import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class GradeBookTester {

	private GradeBook gradeBook1, gradeBook2;
	
	@Before
	public void setUp() throws Exception {
		 gradeBook1 = new GradeBook(5);
		 gradeBook2 = new GradeBook(5);
		 
		 gradeBook1.addScore(95);
		 gradeBook1.addScore(100);
		 gradeBook1.addScore(98);
		 
		 gradeBook2.addScore(100);
		 gradeBook2.addScore(77);
		 gradeBook2.addScore(65);
		 gradeBook2.addScore(87);
	}

	@After
	public void tearDown() throws Exception {
		gradeBook1 = null;
		gradeBook2 = null;
	}

	@Test
	public void testAddScore() {
		assertTrue(gradeBook1.toString().equals("95.0 100.0 98.0 "));
		assertEquals(3, gradeBook1.getScoreSize());
		gradeBook1.addScore(99);
		assertTrue(gradeBook1.toString().equals("95.0 100.0 98.0 99.0 "));
		assertEquals(4, gradeBook1.getScoreSize());
		
		assertTrue(gradeBook2.toString().equals("100.0 77.0 65.0 87.0 "));
		assertEquals(4, gradeBook2.getScoreSize());
	}

	@Test
	public void testSum() {
		assertEquals(293, gradeBook1.sum(), .0001);
		assertEquals(329, gradeBook2.sum(), .0001);
	}

	@Test
	public void testMinimum() {
		assertEquals(95, gradeBook1.minimum(), .001);
		assertEquals(65, gradeBook2.minimum(), .001);
	}

	@Test
	public void testFinalScore() {
		assertEquals(198, gradeBook1.finalScore(), .001);
		assertEquals(264, gradeBook2.finalScore(), .001);
	}

	@Test
	public void testGetScoreSize() {
		assertEquals(3, gradeBook1.getScoreSize(), .0001);
		assertEquals(4, gradeBook2.getScoreSize(), .0001);
	}

	@Test
	public void testToString() {
		assertEquals("95.0 100.0 98.0 ", gradeBook1.toString());
		assertEquals("100.0 77.0 65.0 87.0 ", gradeBook2.toString());
	}
}
