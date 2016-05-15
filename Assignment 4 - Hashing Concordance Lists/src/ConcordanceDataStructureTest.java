import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ConcordanceDataStructureTest {
	
	ConcordanceDataStructure test = new ConcordanceDataStructure();

	@Before
	public void setUp() throws Exception {
		
		test.add("Nabeel", 12);
		test.add("Apple", 14);
		test.add("Apple", 16);
		test.add("Nabeel", 20);
		
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testShowAll(){
		
		assertEquals("Apple: 14, 16, Nabeel: 12, 20", test.showAll()); // For some reason, my program is displaying each word added into a new line,
		                                                               // regardless of whether its a repeat word or not. 
	
	}

}
