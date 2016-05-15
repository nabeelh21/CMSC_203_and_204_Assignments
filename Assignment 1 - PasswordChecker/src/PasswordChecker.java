import java.util.ArrayList;

/**
* This is the "Data Manager" class, and will contain the methods that will help the password checker application determine if a password is valid or not.    
* @author Nabeel Hussain 
*/ 

public class PasswordChecker implements PasswordCheckerInterface {
	
	private String password;                     // Will hold the string that is passed into the isValidPassword method. 
	private ArrayList<String> illegalPasswords;  // Will hold the list of passwords that are found to be invalid from the list that is passed into the validPasswords method. 
	
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
	 *  
	 * @param passwordString the password which needs to be checked for validity
	 * 
	 * @return true if the password meets all the requirements and is valid
	 * 
	 * @exception LengthException is thrown if password is not at least 8 characters.
	 * @exception NoDigitException is thrown if password doesn't contain at least 1 numeric character.
	 * @exception NoUpperAlphaException is thrown if password doesn't contain at least 1 uppercase alpha character.
	 * @exception NoLowerAlphaException is thrown if password doesn't contain at least 1 lowercase alpha character.
	 * @exception InvalidSequenceException is thrown if password contains more than 2 of the same character in sequence.
	 */
	public boolean isValidPassword (String passwordString) throws LengthException, NoDigitException, NoUpperAlphaException, NoLowerAlphaException, InvalidSequenceException
	{
		password = passwordString;
		
		// Declare are char variable and initialize it to be the first character in the password the user enters.
		// This will be used in screening whether the rest of the password contains digits, upper-case, or lower-case characters.
		char ch = password.charAt(0); 
	
		// If the password is less than 8 characters, then throw the lengthException.
		if( password.length() < 8) 
		{
			throw new LengthException ("The password must be at least 8 characters long.");	
		}
		
		// If the first character in the password is not a numeric character, then check to see if the rest of the password contains at least one numeric character. 
		if(!Character.isDigit(ch))
		{
			// Set the initial value of hasDigit to be false
			boolean hasDigit = false;
			
			// Loop through the length of the password, and if there is a character that has a digit, then the variable hasDigit will be true. 
			for (int i = 0; i < password.length(); i++)
			{	
				ch = password.charAt(i);
				
				if(Character.isDigit(ch))
				{
					hasDigit = true;
				}
			}
			
			// If there is no digit, then throw the NoDigitException
			if(!hasDigit)
			{
				throw new NoDigitException ("The password must contain at least one digit.");	
			}		
		}
		
		// If the first character in the password is not upper case, then check to see if the rest of the password contains at least one upper case letter. 
		if(!Character.isUpperCase(ch))
		{
			// If the password is equal to the password changed to all lowercase characters, then it doesn't have any uppercase characters.
			// As a result, set the hasUppercase boolean variable to the above statement not being true.
			boolean hasUppercase = !password.equals(password.toLowerCase());
			
			//If the password does not have uppercase, then throw the NoUpperAlphaException. 
			if(!hasUppercase)
			{
			throw new NoUpperAlphaException ("The password must contain at least one uppercase alphabetic character.");
			}
		}
		
		// If the first character in the password is not lower case, then check to see if the rest of the password contains at least one lower case letter. 
		if(!Character.isLowerCase(ch))
		{
			// If the password is equal to the password changed to all uppercase characters, then it doesn't have any lowercase characters.
			// As a result, set the hasLowercase boolean variable to the above statement not being true. 
			boolean hasLowercase = !password.equals(password.toUpperCase());
			
			//If the password does not have lowercase, then throw the NoLowerAlphaException. 
			if(!hasLowercase)
			{
			throw new NoLowerAlphaException ("The password must contain at least one lowercase alphabetic character.");
			}
		}
		
		// If the first character in the password is either a lower case, upper case, or numeric character, then check to see if the password does not contain more than 2 of the same character in sequence.  
		if(Character.isLowerCase(ch) || Character.isUpperCase(ch) || Character.isDigit(ch) )
		{
			// Loop through the length of the password all the way up until its length minus 2
			for (int i = 0; i < password.length() - 2; i++)
			{
				// If the password at character i is equal to its next two characters, then throw the InvalidSequenceException.
				if( (password.charAt(i) == password.charAt(i + 1))   &&  (password.charAt(i) == password.charAt(i+2)) )
				{
					throw new InvalidSequenceException ("The password cannot contain more than two of the same character in sequence.");	
				}				
			}		
		}
		return true;
	}

	/**
	 * Will check an ArrayList of passwords and returns an ArrayList with the status of any invalid passwords.
	 * The ArrayList of invalid passwords will be of the following format:
	 * <password><space><message of exception thrown>
	 *  
	 * @param passwords an ArrayList of passwords that were read in from a file. 
	 * 
	 * @return an ArrayList with the status of any invalid passwords.
	 */
	public ArrayList<String> validPasswords(ArrayList<String> passwords)
	{
		// an ArrayList to hold all the invalid passwords found
		illegalPasswords = new ArrayList<String>();
		
		// A string that will hold the error status message of an invalid password that is found in the ArrayList
		String errorMessage = null;
		
		// Loop through the ArrayList of passwords and use the isValidPassword method to determine which passwords in the list are invalid.
		// If any are found to be invalid, then display the appropriate error status message after the password. 
		for(int i = 0; i < passwords.size(); i++)
		{
			try
			{
				isValidPassword(passwords.get(i));
			}
			
			// If a password is found to have a LengthException, then display the password along with its error status message next to it in the errorMessage string. 
			catch (LengthException e) 
            {
				errorMessage = passwords.get(i) + " The password must be at least 8 characters long.";
				// Add the invalid password into the illegalPasswords ArrayList
                illegalPasswords.add(errorMessage);
            }
			// If a password is found to have a NoDigitException, then display the password along with its error status message next to it in the errorMessage string. 
        	catch (NoDigitException e) {
				errorMessage = passwords.get(i) + " The password must contain at least one digit.";
				// Add the invalid password into the illegalPasswords ArrayList
	            illegalPasswords.add(errorMessage);
			}
			// If a password is found to have a NoUpperAlphaException, then display the password along with its error status message next to it in the errorMessage string. 
        	catch (NoUpperAlphaException e) {
				errorMessage = passwords.get(i) + " The password must contain at least one uppercase alphabetic character."; 
				// Add the invalid password into the illegalPasswords ArrayList
	            illegalPasswords.add(errorMessage);
			}
			// If a password is found to have a NoLowerAlphaException, then display the password along with its error status message next to it in the errorMessage string. 
        	catch (NoLowerAlphaException e) {
				errorMessage = passwords.get(i) + " The password must contain at least one lowercase alphabetic character."; 
				// Add the invalid password into the illegalPasswords ArrayList
	            illegalPasswords.add(errorMessage);
			}
			// If a password is found to have a InvalidSequenceException, then display the password along with its error status message next to it in the errorMessage string. 
        	catch (InvalidSequenceException e) {
				errorMessage = passwords.get(i) + " The password cannot contain more than two of the same character in sequence."; 
				// Add the invalid password into the illegalPasswords ArrayList
	            illegalPasswords.add(errorMessage);
			}
		}
		
		//Return the ArrayList that contains all the invalid passwords only
		return illegalPasswords;
	}	
}
