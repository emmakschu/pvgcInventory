/*
 * StartPage.java
 * 
 * Author:   Michael K Schumacher
 * Created:  22 March 2017 
 * Modified: 22 March 2017
 */

import java.util.*;
import java.sql.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.event.*;


/**
 * StartPage class
 * 
 * This class will create a start page to load on GUI app launch
 * 
 * @author michael
 *
 */
public class StartPage extends Application {
	
	BorderPane borderPane = new BorderPane();
	GridPane mainGrid = new GridPane();
	
	@Override
	
	public void start(Stage primaryStage) {
		
		mainGrid.setAlignment(Pos.CENTER);
		mainGrid.setPadding(new Insets(30,30,30,30));
		mainGrid.setHgap(10);
		mainGrid.setVgap(10);
		
		Text welcomeMsg = new Text("Welcome to the PVGC Maintenance Inventory App");
		mainGrid.add(welcomeMsg, 0, 0);
		
		Image pvgcLogo = new Image("images/logos/pvgcLogo1.jpg");
		ImageView pvgcLogoView = new ImageView(pvgcLogo);
		mainGrid.add(pvgcLogoView, 1, 0);
		
		
		
		// Place main GridPane in a ScrollPane to enable scrolling
		ScrollPane mainScroll = new ScrollPane(mainGrid);
		
		/*
		 * Begin creating menu toolbar for top of window
		 */		
		MenuBar menuToolbar = new MenuBar();
		
		// Create file menu with its items, add to menu toolbar
		Menu menuFile = new Menu("File");
		
		MenuItem menuProperties = new MenuItem("Properties");
		
		MenuItem fileQuit = new MenuItem("Quit");
		CloseWindowHandler fileQuitAct = new CloseWindowHandler();
		fileQuit.setOnAction(fileQuitAct);
		
		menuFile.getItems().add(menuProperties);
		menuFile.getItems().add(fileQuit);
		
		menuToolbar.getMenus().add(menuFile);
		
		// Create edit menu with its items, add to menu toolbar
		Menu menuEdit = new Menu("Edit");
		
		MenuItem editPreferences = new MenuItem("Preferences");
		
		menuEdit.getItems().add(editPreferences);
		
		menuToolbar.getMenus().add(menuEdit);
		
		/*
		 * Begin populating the BorderPane which is the parent window object
		 */
		borderPane.setTop(menuToolbar);
		borderPane.setCenter(mainScroll);
		
		/*
		 * Begin creating scene and stage to show to screen
		 */
		Scene scene = new Scene(borderPane);
		primaryStage.setTitle("PVGC Inventory App");
		primaryStage.setScene(scene);
		primaryStage.show();		
	}
	
	public static void main(String[] args) {
		System.out.println("Pleasant View Golf Course maintenance database");
		System.out.println("Version 0.1");
		System.out.println("");
		System.out.println("Starting");
		
		Application.launch(args);
	}

}

class CloseWindowHandler implements EventHandler<ActionEvent> {
	
	@Override
	
	public void handle(ActionEvent e) {
		System.out.println("Exiting");
		Platform.exit();
	}
}
