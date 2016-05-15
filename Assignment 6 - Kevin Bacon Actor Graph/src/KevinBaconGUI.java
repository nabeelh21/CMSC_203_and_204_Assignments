import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * This program will implement a GUI application to simulate the Kevin Bacon Application, which will determine the connection of one actor to another. 
 * 
 * Name: Nabeel Hussain
 * Class: CMSC204
 * Professor: Jeannette Myers Kartchner
 * Assignment 6 - Actor Graphs
 * Date: 4/16/2016
 * 
 * @author Nabeel Hussain
 */
public class KevinBaconGUI extends Application {
	
	// Declares variables to hold the Labels
	Label actorNameLabel;
	Label movieNameLabel;
	Label fromLabel;
	Label toLabel;
	
	
	// Declares variables to hold the Textfields
	TextField actorNameTextField;
	TextField movieNameTextField;

	// Declares variables to hold the combobox dropdown lists, which will contain all the actor names added. 
	ComboBox<String> addActorToMovieBox;
	ComboBox<String> firstActorConnectionBox;
	ComboBox<String> secondActorConnectionBox;
	
	
	TextArea messageTextArea;        // Declares variable to display the messages of which volunteer delivered what package to which recipient. 

	Button addActorButton;       	// Declares variable to hold the "Add Actor" button
	Button addMovieButton;    		// Declares variable to hold the "Add Movie" button
	Button addActorToMovieButton;    		// Declares variable to hold the "Add Actor to Movie" button
	Button doneButton;    		// Declares variable to hold the "Done" button
	
	Button findConnectionButton;    // Declares variable to hold the "Find Connection" button
	Button readFileButton;		    // Declares variable to hold the "Read File" button
	Button exitButton;              // Declares variable to hold the "Exit" button
	
	// Creates an instance of the ActorGraphManagerclass to perform all the operations of this application.
	ActorGraphManager mgr = new ActorGraphManager();
	
	String movieAddTitle;
	String actor1Add;
	String actor2Add;
	ArrayList<String> sortedActors = new ArrayList<String>();


	/**
	 * Sets the layout of the GUI, with all the labels, textfields, and buttons that the donation application
	 * will need to perform all its functions. 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void start(Stage stage)
	{
		// Create the text for the Labels, that will be shown next to the input textfields
		actorNameLabel = new Label("Actor's Name (Last, First)");
		movieNameLabel = new Label("Movie Name");
		fromLabel = new Label("From");
		toLabel = new Label("To");
		
		
		// Declares variables to hold the Textfields that will be shown next to the labels. 
		actorNameTextField = new TextField();
		//actorNameTextField.setPrefWidth(150);

		movieNameTextField = new TextField();
		//movieNameTextField.setPrefWidth(150);

		
		// Create the text area box, which will be used to display the connections of the actors
		messageTextArea = new TextArea();
		messageTextArea.setPrefWidth(200);
		
		
		// Create the buttons that will be used by the delivery application to perform its functions.
		addActorButton = new Button("Add Actor");
		//addActorButton.setPadding(new Insets(5, 18, 5, 18));
	
		addMovieButton = new Button("Add Movie");
		//addMovieButton.setPadding(new Insets(5, 18, 5, 18));
		
		addActorToMovieButton = new Button("Add Actor to Movie");
		//addActorToMovieButton.setPadding(new Insets(5, 18, 5, 18));
				
		doneButton = new Button("Done");
		//done.setPadding(new Insets(5, 18, 5, 18));
		
		findConnectionButton = new Button("Find Connection");
		//findConnectionButton.setPadding(new Insets(5, 18, 5, 18));
		
		readFileButton = new Button("_Read File");
		// Assign the R key as the mnemonic for the "Read File" button
		readFileButton.setMnemonicParsing(true);
		// Add a tooltip to the "Read File" button
		readFileButton.setTooltip(new Tooltip("Click here to read a file."));
		//readFileButton.setPadding(new Insets(5, 18, 5, 18));
		
		exitButton = new Button("_Exit");
		// Assign the E key as the mnemonic for the "Exit" button
		exitButton.setMnemonicParsing(true);
		// Add a tooltip to the "Exit" button
		exitButton.setTooltip(new Tooltip("Click here to exit."));
		//exitButton.setPadding(new Insets(5, 18, 5, 18));
		
	
		// Sets event handlers on each button, which will perform different actions, depending on which button the user clicks. 
		addActorButton.setOnAction(new AddActorButtonEventHandler());
		addMovieButton.setOnAction(new AddMovieButtonEventHandler());	
		addActorToMovieButton.setOnAction(new AddActorToMovieButtonEventHandler());
		addActorToMovieButton.setVisible(false);
		doneButton.setOnAction(new DoneButtonEventHandler());
		doneButton.setVisible(false);	
		findConnectionButton.setOnAction(new FindConnectionButtonEventHandler());
		readFileButton.setOnAction(new ReadFileButtonEventHandler());
		exitButton.setOnAction(new ExitButtonEventHandler());	
		

		HBox bottomButtonPane = new HBox(15);
		bottomButtonPane.setAlignment(Pos.CENTER);
		// Add the buttons to the children of the bottomButtonPane horizontal box
		bottomButtonPane.getChildren().addAll(readFileButton,exitButton);
		
	
		// Create a horizontal box, that will place the actorNameLabel and actorNameTextField next to each other.
		HBox actorNameRow = new HBox(15);
		actorNameRow.setAlignment(Pos.CENTER);
		// Add the buttons to the children of the actorNameRow horizontal box
		actorNameRow.getChildren().addAll(actorNameLabel,actorNameTextField);
		
		// Create vertical box to place the addActorButton below the actorNameRow
		VBox addActorPane = new VBox(15);
		addActorPane.setAlignment(Pos.CENTER);
		addActorPane.setPadding(new Insets(15,70,15,70));
		addActorPane.setStyle("-fx-border-color: gray;");
		// Add the buttons to the children of the addActorPane vertical box
		addActorPane.getChildren().addAll( actorNameRow,addActorButton);	
		
		// Place the addActorPane inside a TitledPane, so it will have its own "Add Actor" section in the GUI
		TitledPane addActorBoxPane = new TitledPane("Add Actor", addActorPane );
		addActorBoxPane.setCollapsible(false);
		
				
		// Create a horizontal box, that will place the movieNameLabel, movieNameTextField, and addMovieButton next to each other.
		HBox movieNameRow = new HBox(15);
		movieNameRow.setAlignment(Pos.CENTER);
		// Add the buttons to the children of the movieNameRow horizontal box
		movieNameRow.getChildren().addAll(movieNameLabel, movieNameTextField, addMovieButton);
		
		
		// Create a ComboBox, which will be used to hold the list of actors available to add an edge to. 
		addActorToMovieBox = new ComboBox<String>();
		addActorToMovieBox.setPrefWidth(220);
		addActorToMovieBox.setPrefHeight(45);
		addActorToMovieBox.setVisible(false);
		
		// Create a horizontal box, that will place the addActorToMovieBox, addActorToMovieButton, and doneButton next to each other.
		HBox addActorToMovieRow = new HBox(10);
		addActorToMovieRow.setAlignment(Pos.CENTER);
		// Add the buttons to the children of the addActorToMovieRow horizontal box
		addActorToMovieRow.getChildren().addAll( addActorToMovieBox, addActorToMovieButton, doneButton);
		
		
		// Create vertical box to nest the movieNameRow and addActorToMovieRow panes to make up the "Add Movie" section of the GUI. 
		VBox addMoviePane = new VBox(15);
		addMoviePane.setAlignment(Pos.CENTER);
		addMoviePane.setPadding(new Insets(15,15,60,15));
		addMoviePane.setStyle("-fx-border-color: gray;");
		// Add the buttons to the children of the addMoviePane vertical box
		addMoviePane.getChildren().addAll( movieNameRow,addActorToMovieRow);	
		
		// Place the addMoviePane inside a TitledPane, so it will have its own section in the GUI
		TitledPane addMovieBoxPane = new TitledPane("Add Movie", addMoviePane );
		addMovieBoxPane.setCollapsible(false);		
		
		
		// Create a ComboBox, which will be used to hold the source actor, to find a connection to the destination actor which will be selected. 
		firstActorConnectionBox = new ComboBox<String>();
		firstActorConnectionBox.setPrefWidth(250);
		firstActorConnectionBox.setPrefHeight(45);
		
		// Create a ComboBox, which will be used to hold select the destination actor, to find a connection to it from the source actor.
		secondActorConnectionBox = new ComboBox<String>();
		secondActorConnectionBox.setPrefWidth(250);
		secondActorConnectionBox.setPrefHeight(45);
		
		
		// Create a horizontal box, that will place the fromLabel, firstActorConnectionBox, toLabel, and secondActorConnectionBox next to each other.
		HBox connectionsRow = new HBox(15);
		connectionsRow.setAlignment(Pos.CENTER);
		// Add the buttons to the children of the connectionsRow horizontal box
		connectionsRow.getChildren().addAll(fromLabel, firstActorConnectionBox, toLabel, secondActorConnectionBox);

		
		// Create vertical box to nest the connectionsRow, messageTextArea, and findConnectionButton panes to make up the "Find Connection" section of the GUI. 
		VBox findConnectionPane = new VBox(15);
		findConnectionPane.setAlignment(Pos.CENTER);
		findConnectionPane.setPadding(new Insets(30,50,30,50));
		findConnectionPane.setStyle("-fx-border-color: gray;");
		// Add the buttons to the children of the findConnectionPane horizontal box
		findConnectionPane.getChildren().addAll( connectionsRow, messageTextArea, findConnectionButton);	
		
		// Place the findConnectionPane inside a TitledPane, so it will have its own section in the GUI
		TitledPane findConnectionBoxPane = new TitledPane("Find Connection", findConnectionPane );
		findConnectionBoxPane.setCollapsible(false);	
		
		
		// Create a vertical box that will nest the addActorBoxPane on top, followed by the addMovieBoxPane at the bottom. 
		VBox contentPane = new VBox(20);
		contentPane.setAlignment(Pos.CENTER);
		contentPane.setPadding(new Insets(15, 50, 0, 50));
		contentPane.getChildren().addAll(addActorBoxPane,addMovieBoxPane);
		
		
		// Create a vertical box that will nest the contentPane on top, followed by the findConnectionBoxPane in the second row, followed by
		// the bottomButtonPane at the bottom.   
		VBox contentPane2 = new VBox(20);
		contentPane2.setAlignment(Pos.CENTER);
		contentPane2.setPadding(new Insets(0, 20, 30, 20));
		contentPane2.getChildren().addAll(contentPane,findConnectionBoxPane, bottomButtonPane);
		
		
		// Create a BorderPane to place contentPane into the center of the GUI display.
		// contentPane contains all the nested Hbox's and Vbox's that were created to properly organize and display the contents of the GUI application.  
		BorderPane displayPane = new BorderPane();
		// Place the contentPane in the center region of the BorderPane.
		displayPane.setCenter(contentPane2); 
		
		// Set displayPane as root of scene and set the scene on the stage
		Scene scene = new Scene(displayPane);
		stage.setTitle("6 Degrees of Kevin Bacon");
		stage.setScene(scene);
		stage.show();	
	}

	// An event handler for adding a actor or vertice to the graph.  
	class AddActorButtonEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			// Extract the actors name from the actor name textfield
			String nameInput = actorNameTextField.getText().trim();
			//System.out.println(nameInput);
			mgr.addActor(nameInput);
			
			sortedActors = mgr.allActors();
			ObservableList<String> list = FXCollections.observableArrayList (sortedActors);
			addActorToMovieBox.setItems(list);
			firstActorConnectionBox.setItems(list);
			secondActorConnectionBox.setItems(list);
			
			actorNameTextField.clear();
			
		}
	}
	
	
	// An event handler for adding the movie name, which will be the edge.  
	class AddMovieButtonEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			
			// Extract the movie title from the Movie Name textfield
			movieAddTitle = movieNameTextField.getText().trim();
			//System.out.println(movieAddTitle);

			movieNameTextField.setEditable(false);
			addActorToMovieBox.setVisible(true);
			addActorToMovieButton.setVisible(true);
			doneButton.setVisible(true);	
		}
	}
	
	int AddActorButtonCount = 0; 
	
	// An event handler for the "Add Actor To MovieButton," which will select two actors to which a movieEdge will be created.  
	class AddActorToMovieButtonEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			if(AddActorButtonCount == 0)
			{
				actor1Add= addActorToMovieBox.getValue().toString();
				//System.out.println(actor1Add);
				AddActorButtonCount++;
				
			}
			else if(AddActorButtonCount == 1)
			{
				addActorToMovieBox.getValue().toString();
				actor2Add= addActorToMovieBox.getValue().toString();
				
				//System.out.println(actor2Add);
				AddActorButtonCount++;
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Cannot add more than two actors per single movie connection.");
			}
		}
	}
	
	
	// An event handler for the "Done" button, which will add the movie edge to the graph given the two actors selected.  
	class DoneButtonEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			mgr.addMovie(actor1Add, actor2Add, movieAddTitle);

			AddActorButtonCount = 0;
			
			addActorToMovieBox.setVisible(false);
			addActorToMovieButton.setVisible(false);
			doneButton.setVisible(false);
			
			movieNameTextField.clear();
			movieNameTextField.setEditable(true);
		}
	}
	
	
	// An event handler for the "Find Connection Button" which will display the connection between actors through there movies. 
	class FindConnectionButtonEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{	
			String actor1 = firstActorConnectionBox.getValue().toString();

			String actor2 = secondActorConnectionBox.getValue().toString();
			
			ArrayList<String> path = new ArrayList<String>();
			
			path = mgr.getPath(actor1, actor2);
	
			String displayPath = "";
			
			for(int i =0; i < path.size(); i ++)
			{
				displayPath += path.get(i) + "\n";
			}
			
			messageTextArea.setText(displayPath);
		}
	}
	
	
	// An event handler for the "Donate Package" button, which will 
	class ReadFileButtonEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			ArrayList<String> fileData = new ArrayList<String>();
			String[] content; // will hold each singular actor name or movie title

			
			// Will display a window box allowing the user to select a file from their computer to open, in order to read its data. 
			JFileChooser fileChooser = new JFileChooser();
			int status = fileChooser.showOpenDialog(null);
			if (status == JFileChooser.APPROVE_OPTION)
			{
				File selectedFile = fileChooser.getSelectedFile();
				
				try
				{
					Scanner inputFile = new Scanner(selectedFile);
					
					// Read each content, line by line from the .txt file into a String ArrayList
					while (inputFile.hasNext())
					{	
						fileData.add(inputFile.nextLine());
					}
					
					inputFile.close();
					
					// loop through the ArrayList containing all the lines
					for(int i = 0; i < fileData.size(); i++)
					{
						
						// split the movie title and actor names from each line using the ";" delimiter, and place into a new array. 
						content = fileData.get(i).split(";");

							String movieTitle = content[0];
							String actorName1 = content[1];
							String actorName2 = content[2];
							
							
							mgr.addActor(actorName1);
							mgr.addActor(actorName2);
							
							mgr.addMovie(actorName1, actorName2, movieTitle);
					}	
					
					sortedActors = mgr.allActors();
					ObservableList<String> list = FXCollections.observableArrayList (sortedActors);
					addActorToMovieBox.setItems(list);
					firstActorConnectionBox.setItems(list);
					secondActorConnectionBox.setItems(list);
				}
			
				catch (FileNotFoundException e)
				{
					e.printStackTrace();
				}			
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
	 * Will launch the GUI for the Actor Graph application.
	 */
	public static void main(String[] args) {
        launch(args);
    }
	
}
