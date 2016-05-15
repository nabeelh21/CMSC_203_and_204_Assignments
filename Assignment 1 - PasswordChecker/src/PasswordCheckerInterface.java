import java.util.ArrayList;
/**
 * PasswordCheckerInterface specifies several key methods of PasswordChecker
 * @author Nabeel Hussain
 */
public interface PasswordCheckerInterface {

	/**
	 * Will check the validity of the password passed in, and returns true if the password is valid, or throws an exception if invalid.
	 * 
	 * The password must meet  all these requirements in order to be valid
	 * 1.	At least 8 characters long
	 * 2.	At least 1 numeric character
	 * 3.	At least 1 uppercase alphabetic character
	 * 4.	At least 1 lowercase alphabetic character
	 * 5.	No more than 2 of the same character in a sequence
	 *             Hello123 – OK
	 *             AAAbb123 – not OK
	 *             Aaabb123 – OK
	 */
	public boolean isValidPassword (String passwordString) throws LengthException, NoDigitException, NoUpperAlphaException, NoLowerAlphaException, InvalidSequenceException;
	
	
	/**
	 * Will check an ArrayList of passwords and returns an ArrayList with the status of any invalid passwords.
	 * The ArrayList of invalid passwords will be of the following format:
	 * <password><space><message of exception thrown>
	 */
	public ArrayList<String> validPasswords (ArrayList<String> passwords);

}






