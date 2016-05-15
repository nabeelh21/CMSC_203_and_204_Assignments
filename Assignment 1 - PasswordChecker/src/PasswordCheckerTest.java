import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the methods of PasswordChecker
 * @author Professor Wisniewski
 * @author Nabeel Hussain
 *
 */
public class PasswordCheckerTest {
	ArrayList<String> passwords, passwordsStudent;
	String password1, password2;
	PasswordChecker passwordChecker, passwordCheckerStudent;

	@Before
	public void setUp() throws Exception {
		String[] p = {"334455BB", "Im2cool4U", "george2ZZZ", "4sale", "bertha22", "4wardMarch", 
				"august30", "abcdef", "Applesxx", "aa11b", "pilotProject", "myPassword", 
				"myPassword2"};
		passwordChecker = new PasswordChecker();
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(p)); // puts strings into the ArrayList
		
		
		/* ************* STUDENT  ***************
		   Create another Arraylist of String to
		   use for the testValidPasswordsSTUDENT test
		*/
		
		String[] pStudent = {"alpha123PA", "weh2A", "randomPass", "4runnerss", "CAR2565895", "4eggsToday", 
				"december30", "ghijkl", "ApplesGoood12", "gg11bb45", "firstProject1", "myCurrentPassword"};
				
		passwordCheckerStudent = new PasswordChecker();
		passwordsStudent = new ArrayList<String>();
		passwordsStudent.addAll(Arrays.asList(pStudent));
	
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
		passwordsStudent = null;
	}

	/**
	 * Test if the password is less than 8 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			assertTrue(passwordChecker.isValidPassword("abcABC12"));
			passwordChecker.isValidPassword("abc12");
			assertTrue("Did not throw lengthException",false);
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a lengthExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides lengthException",false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try{
			assertTrue(passwordChecker.isValidPassword("1234567aA"));
			passwordChecker.isValidPassword("1234567a");
			assertTrue("Did not throw NoUpperAlphaException",false);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException",false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try{
			assertTrue(passwordChecker.isValidPassword("1234567Aa"));
			passwordChecker.isValidPassword("1234567A");
			assertTrue("Did not throw NoLowerAlphaException",false);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
			assertEquals(true,passwordChecker.isValidPassword("1234aaAA"));
			passwordChecker.isValidPassword("1234aAAA");
			assertTrue("Did not throw an InvalidSequenceException",false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw an InvalidSequenceExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an InvalidSequenceException",false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * One test should throw a NoUpperAlphaException
	 * TO BE IMPLEMENTED BY STUDENT
	 */
	@Test
	public void testIsValidPasswordNoUpperSTUDENT()
	{
		try{
			assertTrue(passwordCheckerStudent.isValidPassword("21nabeelHU"));
			passwordCheckerStudent.isValidPassword("21nabeelhu");
			assertTrue("Did not throw NoUpperAlphaException",false);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException",false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 * TO BE IMPLEMENTED BY STUDENT
	 */
	@Test
	public void testIsValidPasswordSuccessfulSTUDENT()
	{
		try{
			assertTrue(passwordCheckerStudent.isValidPassword("nabeelH21"));
			passwordCheckerStudent.isValidPassword("nabeelH21");
			assertTrue("Did not throw an Exception",true);
			
			passwordCheckerStudent.isValidPassword("NHUSSA10umd");
			assertTrue("Did not throw an Exception",true);
			
			passwordCheckerStudent.isValidPassword("12345Naa");
			assertTrue("Did not throw an Exception",true);
			
			passwordCheckerStudent.isValidPassword("aabbAABB1122");
			assertTrue("Did not throw an Exception",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw an Exception",false);
		}
	}
	
	/**
	 * Test the validPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testValidPasswords() {
		ArrayList<String> results;
		results = passwordChecker.validPasswords(passwords);
		Scanner scan = new Scanner(results.get(0)); //
		assertEquals(scan.next(), "334455BB");
		assertEquals(scan.nextLine(), " The password must contain at least one lowercase alphabetic character.");
		scan = new Scanner(results.get(1)); //
		assertEquals(scan.next(), "george2ZZZ");
		assertEquals(scan.nextLine(), " The password cannot contain more than two of the same character in sequence.");
		scan = new Scanner(results.get(3)); //
		assertEquals(scan.next(), "bertha22");
		assertEquals(scan.nextLine(), " The password must contain at least one uppercase alphabetic character.");
		scan = new Scanner(results.get(5)); //
		assertEquals(scan.next(), "abcdef");
		assertEquals(scan.nextLine(), " The password must be at least 8 characters long.");
		scan = new Scanner(results.get(6)); //
		assertEquals(scan.next(), "Applesxx");
		assertEquals(scan.nextLine(), " The password must contain at least one digit.");
	}
	
	/**
	 * Test the validPasswords method
	 * TO BE IMPLEMENTED BY STUDENT
	 * Additional tests with different data than testValidPasswords()
	 * 
	 * String[] pStudent = {"alpha123PA", "weh2A", "randomPass", "4runnerss", "CAR2565895", "4eggsToday", 
				"december30", "ghijkl", "ApplesGoood12", "gg11bb45", "firstProject1", "myCurrentPassword"};
	 */
	@Test
	public void testValidPasswordsSTUDENT()
	{
		ArrayList<String> resultsStudent;
		resultsStudent = passwordCheckerStudent.validPasswords(passwordsStudent);
		Scanner scan = new Scanner(resultsStudent.get(0)); //
		assertEquals(scan.next(), "weh2A");
		assertEquals(scan.nextLine(), " The password must be at least 8 characters long.");
		scan = new Scanner(resultsStudent.get(1)); //
		assertEquals(scan.next(), "randomPass");
		assertEquals(scan.nextLine(), " The password must contain at least one digit.");
		scan = new Scanner(resultsStudent.get(2)); //
		assertEquals(scan.next(), "4runnerss");
		assertEquals(scan.nextLine(), " The password must contain at least one uppercase alphabetic character.");
		scan = new Scanner(resultsStudent.get(3)); //
		assertEquals(scan.next(), "CAR2565895");
		assertEquals(scan.nextLine(), " The password must contain at least one lowercase alphabetic character.");
		scan = new Scanner(resultsStudent.get(4)); //
		assertEquals(scan.next(), "december30");
		assertEquals(scan.nextLine(), " The password must contain at least one uppercase alphabetic character.");
		scan = new Scanner(resultsStudent.get(5)); //
		assertEquals(scan.next(), "ghijkl");
		assertEquals(scan.nextLine(), " The password must be at least 8 characters long.");
		scan = new Scanner(resultsStudent.get(6)); //
		assertEquals(scan.next(), "ApplesGoood12");
		assertEquals(scan.nextLine(), " The password cannot contain more than two of the same character in sequence.");
		scan = new Scanner(resultsStudent.get(7)); //
		assertEquals(scan.next(), "gg11bb45");
		assertEquals(scan.nextLine(), " The password must contain at least one uppercase alphabetic character.");
		scan = new Scanner(resultsStudent.get(8)); //
		assertEquals(scan.next(), "myCurrentPassword");
		assertEquals(scan.nextLine(), " The password must contain at least one digit.");
	}

}