import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MorseCodeConverterTest {
	File inputFile;
	
	File inputFileSTUDENT;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPrintTree()
	{
		//Note the extra space between j and b - that is because there is an empty string that
		//is the root, and in the LNR traversal, the root would come between the right most
		//child of the left tree (j) and the left most child of the right tree (b).
		String correctResult = "h s v i f u e l r a p w j  b d x n c k y t z g q m o";
		String s = MorseCodeConverter.printTree();
		s = s.trim(); // take off preceeding or succedding spaces
		assertEquals(correctResult, s);
	}
	
	@Test
	public void testConvertToEnglishString() {	
		String converter1 = MorseCodeConverter.convertToEnglish(".... . .-.. .-.. --- / .-- --- .-. .-.. -.. ");
		assertEquals("hello world",converter1);
		
		@SuppressWarnings("unused")
		String test2="i love you";		
		String converter2 = MorseCodeConverter.convertToEnglish(".. / .-.. --- ...- . / -.-- --- ..- ");
		assertEquals("i love you", converter2);
	}

	
	// My student test for testConvertToEnglishString
	@Test
	public void testConvertToEnglishStringSTUDENT() {	
		String converter1STUDENT = MorseCodeConverter.convertToEnglish("-- -.-- / -. .- -- . / .. ... / -. .- -... . . .-.. ");
		assertEquals("my name is nabeel",converter1STUDENT);
		
		
		String converter2STUDENT = MorseCodeConverter.convertToEnglish(". ...- . .-. -.-- -.. .- -.-- / .. ... / .- / --. .-. . .- - / -.. .- -.-- / - --- / -... . / .- .-.. .. ...- . ");
		assertEquals("everyday is a great day to be alive", converter2STUDENT);
	}
	
	
	
	@Test
	public void testConvertToEnglishFile() throws FileNotFoundException {
		String test1="how do i love thee let me count the ways";		
		getFile("howDoILoveThee.txt");
		String converter1 = MorseCodeConverter.convertToEnglish(inputFile);
		assertEquals(test1,converter1);
		
		String test2="love looks not with the eyes but with the mind";		
		getFile("LoveLooksNot.txt");
		String converter2 = MorseCodeConverter.convertToEnglish(inputFile);
		assertEquals(test2,converter2);

	}
	
	public void getFile(String in) throws FileNotFoundException {		
		JFileChooser chooser = new JFileChooser();
		int status;

		chooser.setDialogTitle("Select Input File - " + in);
		status = chooser.showOpenDialog(null);

		if(status == JFileChooser.APPROVE_OPTION)
		{
			try
			{
				inputFile = chooser.getSelectedFile();
				// readFile();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null, "There is a problem with this file", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	
	
	// My student test for testConvertToEnglishFile
	@Test
	public void testConvertToEnglishFileSTUDENT() throws FileNotFoundException {
		String test1STUDENT = "this is my student test file one";		
		getFileSTUDENT("StudentTestFile1.txt");
		String converter1STUDENT = MorseCodeConverter.convertToEnglish(inputFileSTUDENT);
		assertEquals(test1STUDENT,converter1STUDENT);
		
		String test2STUDENT = "this is my student test file two";		
		getFileSTUDENT("StudentTestFile2.txt");
		String converter2STUDENT = MorseCodeConverter.convertToEnglish(inputFileSTUDENT);
		assertEquals(test2STUDENT,converter2STUDENT);

	}
	
	public void getFileSTUDENT(String in) throws FileNotFoundException {		
		JFileChooser chooser = new JFileChooser();
		int status;

		chooser.setDialogTitle("Select Input File - " + in);
		status = chooser.showOpenDialog(null);

		if(status == JFileChooser.APPROVE_OPTION)
		{
			try
			{
				inputFileSTUDENT = chooser.getSelectedFile();
				// readFile();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null, "There is a problem with this file", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}