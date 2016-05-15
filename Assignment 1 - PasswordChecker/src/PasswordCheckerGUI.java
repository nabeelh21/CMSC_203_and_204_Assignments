/**
 * This program will implement a GUI application for testing passwords.   
 * 
 * Name: Nabeel Hussain
 * Class: CMSC204
 * Professor: Jeannette Myers Kartchner
 * Assignment 1 - Password Checker
 * Date: 1/27/2016
 * 
 * @author Nabeel Hussain
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class PasswordCheckerGUI extends Application {
	
	Label passwordRulesLabel;             // Declares variable to display the rules of setting a valid password 
	Label passwordLabel; 				  // Declares variable to hold the "Password" Label
	Label retypePasswordLabel;            // Declares variable to hold the "Re-type Password" Label
	
	TextField passwordTextField;     	// Declares variable to hold the "Password" entry textfield 
	TextField retypePasswordTextField;    // Declares variable to hold the "Re-type Password" entry textfield

	Button checkPasswordButton;         // Declares variable to hold the "Check Password" button
	Button checkFilePasswordsButton;    // Declares variable to hold the "Check Passwords in File" button
	Button exitButton;                  // Declares variable to hold the "Exit" button
	
	// Creates an instance of the PasswordChecker class to use in order to validate the passwords
	PasswordChecker check = new PasswordChecker(); 
	
	/**
	 * Sets the layout of the GUI, with all the labels, textfields, and buttons that the password checker application
	 * will need to perform all its functions. 
	 */
	@Override
	public void start(Stage stage)
	{	
		// Create the label that will display the rules of creating a password	
		passwordRulesLabel = new Label("Use the following rules when creating your passwords\n"
								+ "1. Length must be greater than 8\n"
								+ "2. Must contain at least one upper case alpha character\n"
								+ "3. Must contain at least on lower case alpha character\n"
								+ "4. Must contain at least one numeric character\n"
								+ "5. May not have more than 2 of the same character in sequence ");		
		
		
		// Create the password and re-type password labels to let the user know where to enter their desired password 
		passwordLabel = new Label("Password");
		retypePasswordLabel = new Label("Re-typePassword");
		
		
		// Create the textfields to allow the user to enter their desired password   
		passwordTextField = new TextField();
		passwordTextField.setPrefWidth(210);
		
		retypePasswordTextField = new TextField();
		retypePasswordTextField.setPrefWidth(210);
	
		
		// Create the buttons that will be used by the password application to perform its functions.
		
		checkPasswordButton = new Button("_Check Password");
		// Assign the C key as the mnemonic for the "Check Password" button
		checkPasswordButton.setMnemonicParsing(true);
		// Add a tooltip to the "Check Password" button
		checkPasswordButton.setTooltip(new Tooltip("Click here to check if the desired password is valid."));
		checkPasswordButton.setPadding(new Insets(5, 18, 5, 18));
	
		checkFilePasswordsButton = new Button("Check Passwo_rds in File");
		// Assign the R key as the mnemonic for the "Check Passwords in File" button
		checkFilePasswordsButton.setMnemonicParsing(true);
		// Add a tooltip to the "Check Passwords in File" button
		checkFilePasswordsButton.setTooltip(new Tooltip("Click here to select the file containing the passwords."));
		checkFilePasswordsButton.setPadding(new Insets(5, 18, 5, 18));
		
		exitButton = new Button("_Exit");
		// Assign the E key as the mnemonic for the "Exit" button
		exitButton.setMnemonicParsing(true);
		// Add a tooltip to the "Exit" button
		exitButton.setTooltip(new Tooltip("Click here to exit."));
		exitButton.setPadding(new Insets(5, 18, 5, 18));
		
		// Sets event handlers on each button, which will perform different actions, depending on which button the user clicks. 
		checkPasswordButton.setOnAction(new CheckPasswordButtonEventHandler());
		checkFilePasswordsButton.setOnAction(new CheckFilePasswordsButtonEventHandler());
		exitButton.setOnAction(new ExitButtonEventHandler());
		
		
		// Create a horizontal box that will hold the "Password" label and textfield in one row
		HBox passwordInput = new HBox(10);
		passwordInput.setAlignment(Pos.CENTER);
		passwordInput.getChildren().addAll(passwordLabel,passwordTextField);
		
		// Create a horizontal box that will hold the "Re-type Password" label and textfield in one row
		HBox retypePasswordInput = new HBox(10);
		retypePasswordInput.setAlignment(Pos.CENTER);
		retypePasswordInput.getChildren().addAll(retypePasswordLabel,retypePasswordTextField);
		
		// Create a verticle box, that will nest the passwordInput and retypePasswordInput panes on top of each other. 
		VBox passwordInfoPane = new VBox(10);
		passwordInfoPane.setPadding(new Insets(20, 0, 40, 0));
		passwordInfoPane.setAlignment(Pos.CENTER);
		// Add the buttons to the children of the buttonPane horizontal box
		passwordInfoPane.getChildren().addAll(passwordInput,retypePasswordInput);				
		
		
		// Create a horizontal box, that will place all the buttons next to each other, that will be used in the GUI.
		HBox buttonPane = new HBox(25);
		buttonPane.setAlignment(Pos.CENTER);
		// Add the buttons to the children of the buttonPane horizontal box
		buttonPane.getChildren().addAll(checkPasswordButton,checkFilePasswordsButton,exitButton);			


		// Create a vertical box that will nest the passwordRulesLabel on top, followed by the passwordInfoPane, and then the buttonPane at the bottom.   
		VBox contentPane = new VBox(30);
		contentPane.setAlignment(Pos.CENTER);
		contentPane.setPadding(new Insets(15, 50, 10, 50));
		contentPane.getChildren().addAll( passwordRulesLabel,passwordInfoPane, buttonPane);
		
		
		// Create a BorderPane to place contentPane into the center of the GUI display.
		// contentPane contains all the nested Hbox's and Vbox's that were created to properly organize and display the contents of the GUI application.  
		BorderPane displayPane = new BorderPane();
		// Place the contentPane in the center region of the BorderPane.
		displayPane.setCenter(contentPane); 
		
		// Set displayPane as root of scene and set the scene on the stage
		Scene scene = new Scene(displayPane);
		stage.setTitle("Password Checker");
		stage.setScene(scene);
		stage.show();	
	}

	// Will check to see if the password that is entered by the user is valid, and it will catch the appropriate exception thrown if it's not. 
	class CheckPasswordButtonEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			String password = null;
        	String retypedPassword = null;
			
			// Extract the password and retyped password from the input textfields
        	password = passwordTextField.getText().trim();
        	retypedPassword = retypePasswordTextField.getText().trim();
        	
        	try
        	{
        		// If the password and re-typed passwords are not the same, then throw an UnmatchedException.
        		if(!password.equals(retypedPassword)) 
            	{        			
        			 UnmatchedException exception = new UnmatchedException ("The passwords do not match");
        			 throw exception;
            	}
        		
        		// Use the object created from the instance of the PasswordChecker class to call the isValidPassword method, and determine whether the password entered is valid or not.
        		// If the passwrod is not valid, then it will throw an exception.
        		check.isValidPassword(password);
        		
        		// If no exception is thrown, then display to user that password is valid. 
        		JOptionPane.showMessageDialog(null, "Password is valid", "Password Status", JOptionPane.INFORMATION_MESSAGE);		
        	}
        	
        	// If the isValidPassword method from the PasswordChecker class throws a UnmatchedException, then catch it and display the appropriate message.
        	catch (UnmatchedException exception)
        	{
    			JOptionPane.showMessageDialog(null, "UnmatchedException: The passwords do not match.", "Password Status", JOptionPane.INFORMATION_MESSAGE);
        		exception.printStackTrace();
        	}
        	// If the isValidPassword method from the PasswordChecker class throws a LengthException, then catch it and display the appropriate message.
        	catch (LengthException e) {
    			JOptionPane.showMessageDialog(null, "LengthException: The password must be at least 8 characters long.", "Password Error", JOptionPane.INFORMATION_MESSAGE);
				e.printStackTrace();
			}
        	// If the isValidPassword method from the PasswordChecker class throws a NoDigitException, then catch it and display the appropriate message.
        	catch (NoDigitException e) {
    			JOptionPane.showMessageDialog(null, "NoDigitException: The password must contain at least one digit.","Password Error", JOptionPane.INFORMATION_MESSAGE);
				e.printStackTrace();
			}
        	// If the isValidPassword method from the PasswordChecker class throws a NoUpperAlphaException, then catch it and display the appropriate message.
        	catch (NoUpperAlphaException e) {
    			JOptionPane.showMessageDialog(null, "NoUpperAlphaException: The password must contain at least one uppercase alphabetic character.", "Password Error", JOptionPane.INFORMATION_MESSAGE);
				e.printStackTrace();
			}
        	// If the isValidPassword method from the PasswordChecker class throws a NoLowerAlphaException, then catch it and display the appropriate message.
        	catch (NoLowerAlphaException e) {
    			JOptionPane.showMessageDialog(null, "NoLowerAlphaException: The password must contain at least one lowercase alphabetic character.","Password Error", JOptionPane.INFORMATION_MESSAGE);
				e.printStackTrace();
			}
        	// If the isValidPassword method from the PasswordChecker class throws a InvalidSequenceException, then catch it and display the appropriate message.
        	catch (InvalidSequenceException e) {
    			JOptionPane.showMessageDialog(null, "InvalidSequenceException: The password cannot contain more than two of the same character in sequence.","Password Error", JOptionPane.INFORMATION_MESSAGE);
				e.printStackTrace();
			}
		}
	}
	
	// It will check to see which passwords are invalid from the file that is read in, and also display its error status.
	class CheckFilePasswordsButtonEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			
			File selectedFile = null;
			Scanner inputFile;
			ArrayList<String> passwordList = new ArrayList<>();   // Declares a String ArrayList to hold the contents of the file being read.
			ArrayList<String> illegalList = new ArrayList<>();   // Declares a String ArrayList to hold all the invalid passwords from the file that was read in.

			
			// Will display a window box allowing the user to select a file from their computer to open, in order to read its list of passwords. 
			JFileChooser fileChooser = new JFileChooser();
			int status = fileChooser.showOpenDialog(null);
			
			if (status == JFileChooser.APPROVE_OPTION)
			{
				selectedFile = fileChooser.getSelectedFile();
			}
			
			try
			{
				inputFile = new Scanner(selectedFile);
				
				// Read each password, line by line from the .txt file into a String ArrayList
				while (inputFile.hasNext())
				{
					passwordList.add(inputFile.nextLine());
				}
				
				// Call the validPasswords method from the PasswordChecker class, which will return an ArrayList of all the invalid passwords with their error status.
				// Place these invalid passwords in a new Arraylist
				illegalList = check.validPasswords(passwordList);
				
				// A string that will display all the invalid passwords and their error status messages one by one in a new row. 
				String illegal = "";
				
				// Loop through the illegalList ArrayList and place each invalid password one by one in a new row in the string. 
				for(int i =0; i < illegalList.size(); i++)
				{
					illegal += illegalList.get(i) + "\n";
				}
		
				// Display a message to the user showing all the invalid passwords that were read from the file, along with their error status message. 
				JOptionPane.showMessageDialog(null, illegal, "Illegal passwords", JOptionPane.INFORMATION_MESSAGE);
				
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();	
			}
		}
	}

	// Will exit the program, if user clicks the "Exit" button. 
	class ExitButtonEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			System.exit(0);		
		}
	}
	
	// Will launch the GUI for the PasswordChecker application. 
	public static void main(String[] args) {
        launch(args);
    }
	
}
