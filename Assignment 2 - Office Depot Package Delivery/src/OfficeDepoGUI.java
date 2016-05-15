/**
 * This program will implement a GUI application to simulate volunteers delivering packages from a container to recipients.     
 * 
 * Name: Nabeel Hussain
 * Class: CMSC204
 * Professor: Jeannette Myers Kartchner
 * Assignment 2 - Office Depo Package Delivery
 * Date: 2/08/2016
 * 
 * @author Nabeel Hussain
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

import javax.swing.JOptionPane;


public class OfficeDepoGUI extends Application {
	
	int size = 5;
	
	// Declares variables to hold the volunteer names, who will be delivering the packages. There can be only 5 volunteers at a time
	TextField[] volunteerQueue = new TextField[size];
	
	// Declares variables to hold the recipient names of the colleges, who will be receiving the packages. There can be only 5 recipients at a time
	TextField[] recipientQueue = new TextField[size];
	
	
	// Declares variables to hold the package names. There can be only 5 packages in the container at a time
	TextField[] packageStack = new TextField[size];
	
	TextArea messageTextArea;           // Declares variable to display the messages of which volunteer delivered what package to which recipient. 

	Button stackNewPackageButton;       // Declares variable to hold the "Stack a New Package" button
	Button newVolunteerButton;    		// Declares variable to hold the "New Volunteer" button
	Button newRecipientButton;          // Declares variable to hold the "New Recipient" button
	Button donatePackageButton;		    // Declares variable to hold the "Donate Package" button
	Button exitButton;                  // Declares variable to hold the "Exit" button
	
	// Creates an instance of the DonationManager class to perform all the operations of this application to donatge packages. 
	DonationManager x = new DonationManager();

	/**
	 * Sets the layout of the GUI, with all the labels, textfields, and buttons that the donation application
	 * will need to perform all its functions. 
	 */
	@Override
	public void start(Stage stage)
	{
		// Create the textfield boxes for each of the 5 possible volunteers, recipients, and packages that will be entered.
		
		for(int i  = 0; i < size; i++)
		{
			volunteerQueue[i] = new TextField();
			volunteerQueue[i].setPrefWidth(150);
		}
		
		for(int i  = 0; i < size; i++)
		{
			recipientQueue[i] = new TextField();
			recipientQueue[i].setPrefWidth(150);
		}
		
		for(int i  = 0; i < size; i++)
		{
			packageStack[i] = new TextField();
			packageStack[i].setPrefWidth(150);
		}


		// Create the text area box, Which will be used to display the messages of which volunteer delivered what package to which recipient. 
		messageTextArea = new TextArea();
		messageTextArea.setPrefWidth(700);
		messageTextArea.setPrefHeight(250);
		
		
		// Create the buttons that will be used by the delivery application to perform its functions.
		stackNewPackageButton = new Button("Stack a New Package");
		stackNewPackageButton.setPadding(new Insets(5, 18, 5, 18));
	
		newVolunteerButton = new Button("New Volunteer");
		newVolunteerButton.setPadding(new Insets(5, 18, 5, 18));
		
		newRecipientButton = new Button("New Recipient");
		newRecipientButton.setPadding(new Insets(5, 18, 5, 18));
		
		donatePackageButton = new Button("Donate Package");
		donatePackageButton.setPadding(new Insets(5, 18, 5, 18));
		
		exitButton = new Button("Exit");
		exitButton.setPadding(new Insets(5, 18, 5, 18));
		
	
		// Sets event handlers on each button, which will perform different actions, depending on which button the user clicks. 
		stackNewPackageButton.setOnAction(new StackNewPackageButtonEventHandler());
		newVolunteerButton.setOnAction(new NewVolunteerButtonEventHandler());
		newRecipientButton.setOnAction(new NewRecipientButtonEventHandler());
		donatePackageButton.setOnAction(new DonatePackageButtonEventHandler());
		exitButton.setOnAction(new ExitButtonEventHandler());	
		
		
		// Create a horizontal box, that will place all the buttons next to each other, that will be used in the GUI.
		HBox buttonPane = new HBox(45);
		buttonPane.setAlignment(Pos.CENTER_LEFT);
		// Add the buttons to the children of the buttonPane horizontal box
		buttonPane.getChildren().addAll(stackNewPackageButton,newVolunteerButton,newRecipientButton,donatePackageButton,exitButton );
		
		
		// Create horizontal box to place all the volunteer queue textfields side by side in a row. 
		HBox volunteerPane = new HBox(10);
		volunteerPane.setAlignment(Pos.CENTER_LEFT);
		volunteerPane.setPadding(new Insets(15,25,15,15));
		volunteerPane.setStyle("-fx-border-color: gray;");
		// Add the buttons to the children of the volunteerPane horizontal box
		volunteerPane.getChildren().addAll(volunteerQueue[4], volunteerQueue[3], volunteerQueue[2], volunteerQueue[1], volunteerQueue[0] );			
		// Place the volunteerPane textfield inside a TitledPane, so it will have its own section in the GUI
		TitledPane volunteerQueuePane = new TitledPane("Queue of Volunteers",volunteerPane );
		volunteerQueuePane.setCollapsible(false);
		
		
		// Create horizontal box to place all the recipient queue textfields side by side in a row. 
		HBox recipientsPane = new HBox(10);
		recipientsPane.setAlignment(Pos.CENTER_LEFT);
		recipientsPane.setPadding(new Insets(15,25,15,15));
		recipientsPane.setStyle("-fx-border-color: gray;");
		// Add the buttons to the children of the recipientsPane horizontal box
		recipientsPane.getChildren().addAll(recipientQueue[4], recipientQueue[3], recipientQueue[2], recipientQueue[1], recipientQueue[0]);
		// Place the recipientsPane textfield inside a TitledPane, so it will have its own section in the GUI
		TitledPane recipientsQueuePane = new TitledPane("Queue of Recipients",recipientsPane );
		recipientsQueuePane.setCollapsible(false);
		

		// Create vertical box to place all the package queue textfields on top of each other in a single column 
		VBox containerPane = new VBox(10);
		containerPane.setAlignment(Pos.CENTER_LEFT);
		containerPane.setPadding(new Insets(15,60,15,15));
		containerPane.setStyle("-fx-border-color: gray;");
		// Add the buttons to the children of the containerPane vertical box
		containerPane.getChildren().addAll(packageStack[0], packageStack[1], packageStack[2], packageStack[3], packageStack[4] );
		// Place the containerPane textfield inside a TitledPane, so it will have its own section in the GUI
		TitledPane packageContainerPane = new TitledPane("Packages in the Container",containerPane );
		packageContainerPane.setCollapsible(false);

		
		// Create horizontal box to nest the packageContainerPane and the TextArea box side by side  
		HBox bottomRow = new HBox(15);
		bottomRow.setAlignment(Pos.TOP_LEFT);
		// Add the buttons to the children of the bottomRow horizontal box
		bottomRow.getChildren().addAll(packageContainerPane, messageTextArea );

		
		// Create a vertical box that will nest the buttonPane on top, followed by the volunteerQueuePane in the second row, followed by
		// the recipientsQueuePane in the third row, and bottomRow pane at the bottom.   
		VBox contentPane = new VBox(20);
		contentPane.setAlignment(Pos.CENTER_LEFT);
		contentPane.setPadding(new Insets(15, 20, 80, 20));
		contentPane.getChildren().addAll(buttonPane,volunteerQueuePane,recipientsQueuePane,bottomRow );
		
		
		// Create a BorderPane to place contentPane into the center of the GUI display.
		// contentPane contains all the nested Hbox's and Vbox's that were created to properly organize and display the contents of the GUI application.  
		BorderPane displayPane = new BorderPane();
		// Place the contentPane in the center region of the BorderPane.
		displayPane.setCenter(contentPane); 
		
		// Set displayPane as root of scene and set the scene on the stage
		Scene scene = new Scene(displayPane);
		stage.setTitle("Office Depo");
		stage.setScene(scene);
		stage.show();	
	}

	// An event handler for the "Stack a New Package" button, which will ask user to enter the contents of a package and its weight, and then add it to the container.
	// The weight of a package must be less than 20 lbs. 
	class StackNewPackageButtonEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			String packageDescription =  JOptionPane.showInputDialog("Enter the name of the package: ");
			String weight = JOptionPane.showInputDialog("Enter weight of the package in lb's: ");
			double packageWeight =  Double.parseDouble(weight);
			
			// If the user enters a weight over 20 lb's, then keep asking them to re-enter a weight that is appropriate. 
			while(packageWeight > 20)
			{
				JOptionPane.showMessageDialog(null, "The package cannot be greater then 20 lbs. Please try again.");
				weight = JOptionPane.showInputDialog("Enter weight of the package in lb's: ");
				packageWeight =  Double.parseDouble(weight);
			}
			
			// Use the description name of the package that was entered to create a new donation package
			DonationPackage newPackage = new DonationPackage(packageDescription, packageWeight);
					
				try {
					
					// Add the package into the container, and place the updated container package names onto the GUI's package textfields
					x.ManagerLoadcontainer(newPackage);
	
					for(int i = 0; i < size; i++)
					{
						packageStack[i].setText(x.contentArray()[i].toString());
						
					}		
				}
				// If the package container is full, then it will not allow the user to add more. 
				catch (ContainerException e) {
					e.printStackTrace();
					
					JOptionPane.showMessageDialog(null, "ContainerException: Container is full");
				}	
		}
	}
	
	// An event handler for the "New Volunteer" button, which will ask user to enter the name of a volunteer, and then add them to the Volunteer Queue. 
	class NewVolunteerButtonEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			// Use a JOptionPane to ask user the name of the volunteer to add into the queue
			String volunteerName =  JOptionPane.showInputDialog("Enter the name of the volunteer: ");
			
			// Use the name entered to create a new volunteer. 
			Volunteer newVolunteer = new Volunteer(volunteerName);		
			
				try {
					
					// Add the volunteer into the volunteer queue, and place the updated volunteer names onto the GUI's volunteer textfields
					x.ManagerQueueVolunteer(newVolunteer);
					
					for(int i = 0; i < x.volArray().length; i++)
					{					
						volunteerQueue[i].setText(x.volArray()[i].toString());					
					}
			
				}
				// If the volunteer queue is full, then it will not allow the user to add more. 
				catch (VolunteerException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "VolunteerException: Volunteer Line is full");
				}	
		}
	}
	
	// An event handler for the "New Recipient" button, which will ask user to enter the name of the recipient, and then add them to the recipient Queue. 
	class NewRecipientButtonEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			// Use a JOptionPane to ask user the name of the recipient to add into the queue
			String recipientName =  JOptionPane.showInputDialog("Enter the name of the recipient: ");
			
			// Use the name entered to create a new recipient. 
			Recipient newRecipient = new Recipient(recipientName);
	
				try {
					
					// Add the recipient into the recipient queue, and place the updated recipient names onto the GUI's recipient textfields				
					x.ManagerQueueRecipient(newRecipient);
					
					for(int i = 0; i < x.recipArray().length; i++)
					{						
						recipientQueue[i].setText(x.recipArray()[i].toString());						
					}			
				}
				// If the recipient queue is full, then it will not allow the user to add more. 
				catch (RecipientException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "RecipientException: Recipient Line is full");
				}			
		}
	}
	
	
	// An event handler for the "Donate Package" button, which will determine if there are enough volunteers, packages, and recipients for the donation to keep going. 
	class DonatePackageButtonEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			// If there is at least one volunteer, package, and recipient, then donation will occur, and display the message of which volunteer donated what package to what recipient. 
			if(x.donatePackage() == 0)
			{
				// The package donated will always be at the top of the stack, and the volunteer and recipient will always be at the front of the queue. 
				messageTextArea.setText(volunteerQueue[0].getText() + " delivered " + packageStack[0].getText() + " package to " + recipientQueue[0].getText() );
				
				// After a donation has occurred, rearrange the textfields in the GUI so the appropriate package, volunteer, and recipient are at the top of the list. 
				for(int i = 0; i < size; i++)
				{
					packageStack[i].clear();
					volunteerQueue[i].clear();
					recipientQueue[i].clear();
					
					packageStack[i].setText(x.contentArray()[i].toString());
					recipientQueue[i].setText(x.recipArray()[i].toString());
					volunteerQueue[i].setText(x.volArray()[i].toString());
				}
			
			}
			// If there is no volunteer in the queue, then display the appropriate message in the text area box
			else if (x.donatePackage() == 1)
			{
				messageTextArea.setText("There is no Volunteer for donation");
			}
			// If there is no recipient in the queue, then display the appropriate message in the text area box
			else if (x.donatePackage() == 2)
			{
				messageTextArea.setText("There is no Recipient for donation");
			}
			// If there is no package in the container, then display the appropriate message in the text area box
			else if (x.donatePackage() == 3)
			{
				messageTextArea.setText("There is no Package for donation");
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
	
	
	/**
	 * Will launch the GUI for the PasswordChecker application.
	 */
	public static void main(String[] args) {
        launch(args);
    }
	
}
