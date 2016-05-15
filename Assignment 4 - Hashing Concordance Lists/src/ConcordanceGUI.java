import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
* This program will implement a GUI application for creating a concordance from a file or text that has been input by the user, 
* 
* Name: Nabeel Hussain
* Class: CMSC203
* Professor: Jeannette Myers Kartchner
* Assignment 4 - Concordance
* Date: 3/10/2016
* 
* @author Nabeel Hussain
*/
public class ConcordanceGUI extends Application  {
	
	// Will hold the input and output files the user selects to perform the concordance. 
	File selectedInputFile, selectedOutputFile;  	
	
	// The labels for the radiobox options the user will have to choose from
	String [] selectionLabels = {"Create Concordance from File", "Create Concordance from Text"};  

	// Declares an array variable of RadioButton to hold the radio buttons
	RadioButton[] radioButtons;   
	
	// Buttons which will be used in the GUI by the user to perform a concordance or exit the application. 
	Button createConcordanceButton;  
	Button selectInputButton;  			
	Button selectOutputButton;  
	Button clearButton;    
	Button exitButton;        
		
	
	TextArea displayTextArea;   // Creates a textbox that will be used by the user to enter some text, if they choose to create a concordance from text. 
	
	ConcordanceDataManager mgr = new ConcordanceDataManager(); // Instance of the data manager class
	

	/**
	 * Sets the layout of the GUI, with all the labels, textfields, and buttons that the Pete's Pets application
	 * will need to perform all its functions. 
	 */
	public void start(Stage stage)
	{
		
		// Initialize the buttons that will be used in the GUI
		createConcordanceButton = new Button("Create Concordance");		
		selectInputButton = new Button("Select Input File");		
		selectOutputButton = new Button("Select Output File");		
		clearButton = new Button("Clear");		
		exitButton = new Button("Exit");	
		
		
		// Sets event handlers on each button, which will perform different actions, depending on which button the user clicks. 
		createConcordanceButton.setOnAction(new CreateConcordanceEventHandler());
		selectInputButton.setOnAction(new SelectInputEventHandler());
		selectOutputButton.setOnAction(new SelectOutputEventHandler());
		clearButton.setOnAction(new ClearEventHandler());
		exitButton.setOnAction(new ExitEventHandler());
       
		
		// Create the text area box, which will be used by the user to input some text to create a concordance on. 
		displayTextArea = new TextArea();
		displayTextArea.setPrefWidth(650);
		displayTextArea.setPrefHeight(250);
		displayTextArea.setPadding(new Insets(10,10,10,10));
		displayTextArea.setDisable(true);

			
		// Will create a horizontal box pane to nest the radio buttons 
		HBox concordanceRadioBox = new HBox(15);
		concordanceRadioBox.setAlignment(Pos.CENTER_LEFT);
		// Create the radio buttons and set their toggleGroup property. 
		ToggleGroup radiosGroup = new ToggleGroup();
		radioButtons = new RadioButton[selectionLabels.length];
		
		// Loop through the array, and create a radio button for each of the 2 selection options in the selectionLabels array. 
		for( int i = 0; i < radioButtons.length; i++)
		{
			radioButtons[i] = new RadioButton(selectionLabels[i]);
			radioButtons[i].setToggleGroup(radiosGroup);
			
			radioButtons[i].setOnAction(e-> ButtonClicked(e));
		}
		// Add the radio buttons to the children of the employeeRadioBox horizontal box
		concordanceRadioBox.getChildren().addAll(radioButtons);
		
		
		// Create a TitledPane, which will be used to nest the radio button options that were created.
		TitledPane radioBoxPane = new TitledPane("Please Select from Following Options:",concordanceRadioBox  );
		radioBoxPane.setCollapsible(false);
		
		
		// Create a TitledPane, which will be used to have the user enter some text, if they choose the "Create Concordance from Text" radio button.
		TitledPane displayTextPane = new TitledPane("Enter Text:",displayTextArea  );
		displayTextPane.setCollapsible(false);
		
		
        // Stack the pane holding the sumOfVotes and the gridpane containing all the votes for the teams.
        // This will help with the display when the user switches back and forth between the Rank Teams and Show Details buttons. 
        StackPane stack = new StackPane();
        stack.getChildren().addAll(displayTextPane);
        
        
		// Create a horizontal box that will display all the buttons side by side 
		HBox buttonPane = new HBox();
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.setPadding(new Insets(0,5,0,5));
		// Add the buttons to the children of the buttonPane horizontal box
		buttonPane.getChildren().addAll(createConcordanceButton,selectInputButton,selectOutputButton,clearButton,exitButton);		
		
		
		// Create a vertical box that will nest the radio buttons on top, followed by the text input area section, and then the buttons on the bottom.   
		VBox contentPane = new VBox();
		contentPane.setAlignment(Pos.CENTER);
		contentPane.getChildren().addAll(radioBoxPane,displayTextPane,buttonPane);
		
		
		// Create a BorderPane to place the contentPane into the center of the GUI display.
		// contentPane contains all the nested Hbox's and Vbox's that were created to properly organize and display the contents of the GUI application.  
		BorderPane displayPane = new BorderPane();
		displayPane.setCenter(contentPane);
		
		
		// Place the displayPane onto the scene of the stage, and set the title of the stage
		Scene scene = new Scene(displayPane);
		stage.setTitle("Concordance Generator");
		stage.setScene(scene);
		stage.show();	
	}
	
	// An event handler for the radio buttons which will enable the correct buttons to be visible, depending on the radio button the user selects.  
	public void ButtonClicked(ActionEvent e)
    {
		// If the user clicks on the "Create Concordance from File" radio button,
		// then disable the "Create Concordance" button until an input file and output file is selected. 
        if (e.getSource() == radioButtons[0])
        {
			displayTextArea.setVisible(false);
			selectInputButton.setDisable(false);
			selectOutputButton.setDisable(false);
			displayTextArea.setDisable(true);
			
			// Set the "Create Concordance"
			createConcordanceButton.setDisable(true);
        }
        
        else if (e.getSource() == radioButtons[1])
        {	
			selectInputButton.setDisable(true);
			selectOutputButton.setDisable(true);
			displayTextArea.setVisible(true);
			createConcordanceButton.setDisable(false);
			displayTextArea.setDisable(false);
        }
    }
	
	// Will perform the concordance on a file that the user inputs, or text typed by the user.  
	class CreateConcordanceEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			String selectedPosition = null;
			
			// Determine which radio button option is selected, in order to perform the concordance on the correct file or text input.  

			for(RadioButton rb : radioButtons)
			{
				if(rb.isSelected())
				{
					selectedPosition = rb.getText();
				}	
			}
			
			// If the "Create Concordance from File" option is selected, then read in the text from an input file the user selects,
			// and then use it to perform the concordance. 
			if(selectedPosition.equals("Create Concordance from File"))
			{
				// If no file was selected or it was an invalid file, then it will throw an exception
				try {
					
					// Call the createConcordanceFile method from the ConcordanceDataManager class to perform the concordance. 
					mgr.createConcordanceFile(selectedInputFile, selectedOutputFile);				
				}
				catch (FileNotFoundException e)
				{
					e.printStackTrace();
				}	
			}
			
			// If the "Create Concordance from Text" option is selected, then read in the text from the text area box, in order to perform the concordance. 
			else if(selectedPosition.equals("Create Concordance from Text"))
			{
				ArrayList<String> data = new ArrayList<String>();				
				String textData = displayTextArea.getText();
				String concordanceText = "";

				// Call the createConcordanceArray method from the ConcordanceDataManager class to perform the concordance. 
				data = mgr.createConcordanceArray(textData);
				
				
				for( int i = 0; i < data.size(); i++)
				{
					concordanceText += data.get(i);	
				}
				
				displayTextArea.setText(concordanceText);
			}
		}
	}
	
	// Will ask the user to select a file in order to create a concordance. 
	class SelectInputEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{			
			// Will display a window box allowing the user to select a file from their computer to open, in order to read its data. 
			JFileChooser fileChooser = new JFileChooser();
			int status = fileChooser.showOpenDialog(null);
			
			if (status == JFileChooser.APPROVE_OPTION)
			{
				selectedInputFile = fileChooser.getSelectedFile();
			}	
			
			// If the user already selected an output file, then enable the "Create Concordance" button,
			// since now both an input and output file have been selected. 
			if(selectedOutputFile != null)
			{
				createConcordanceButton.setDisable(false);
			}
		}
	}
	
	// Will ask the user to select a file to output all the words that have been arranged in concordance. 
	class SelectOutputEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			
			// Will display a window box allowing the user to select an output file 
			JFileChooser fileChooser = new JFileChooser();
			int status = fileChooser.showOpenDialog(null);
			
			if (status == JFileChooser.APPROVE_OPTION)
			{
				selectedOutputFile = fileChooser.getSelectedFile();
			}
			
			// If the user already selected an input file, then enable the "Create Concordance" button,
			// since now both an input and output file have been selected. 
			if(selectedInputFile != null)
			{
				createConcordanceButton.setDisable(false);
			}
		}
	}
	
	// Will clear the text area box of all the words contined in it. 
	class ClearEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			displayTextArea.clear();		
		}
	}
		
	// Will exit the application. 
	class ExitEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			System.exit(0);		
		}
	}
	
	// Will launch the GUI for the Concordance application. 
	public static void main(String[] args) {
        launch(args);
    }
}