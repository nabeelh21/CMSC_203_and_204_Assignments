import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ConcordanceDataElementTest {
	
	ConcordanceDataElement word = new ConcordanceDataElement("Nabeel");

	@Before
	public void setUp() throws Exception {
		
		word.addPage(5);
		word.addPage(12);
		word.addPage(12);
		word.addPage(25);
	}

	@After
	public void tearDown() throws Exception {
		word = null;	
	}

	@Test
	public void testToString() {		
		
		assertEquals("Nabeel: 5, 12, 25", word.toString());
	}

}
