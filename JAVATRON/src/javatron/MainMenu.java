package javatron;

import java.io.IOException;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;

  

@SuppressWarnings("restriction")
public class MainMenu extends Application
{
	//creates the menuItems(buttons) 
	MenuItem playGame = new MenuItem("Play Game");
	MenuItem players2 = new MenuItem("2 Players");
	MenuItem players4 = new MenuItem("4 Players");
	MenuItem instructions = new MenuItem("Instructions");
	MenuItem back = new MenuItem("Back");
	MenuItem newRound = new MenuItem("New Round");
	MenuItem drawGrid = new MenuItem("Draw Grid");
	MenuItem givePowerup = new MenuItem("Give Powerup");
	MenuItem finalDecision = new MenuItem("Final Decision");
	//creates booleans for boost and ghost
	boolean boost = false;
	boolean ghost = false;
	
	//images for boost or ghost
	ImageView boostImage;
	ImageView ghostImage;
	
	//creates three title objects that are currently null
	Title numPlayers = null;
	Title startGameTitle = null;
	Title powerupForThisRound = null;
	//keeps track of the number of rounds and the number of players
	static int roundNumber = 1;
	static int players = 0;
	
	//keeps track of each players wins
	static int player1wins = 0, player2wins = 0, player3wins = 0, player4wins = 0;

	
	private Parent createHome() //creates the homeScreen
	{
		
		Pane homeScreen = new Pane(); 
		
		//sets the size of the pane
		homeScreen.setPrefSize(1075, 750); 
		
		//adds the background image to the pane
		try (InputStream backgroundImage = Files.newInputStream(Paths.get("src/javatron/tron_bg.jpg")))
		{
			ImageView background = new ImageView(new Image(backgroundImage));
			background.setFitWidth(1075);;
			background.setFitHeight(750);
			homeScreen.getChildren().add(background);
		}
		catch (IOException e)
		{
			System.out.println("Couldnt load image");
		}
		
		//adds a title object to the pane
		Title title = new Title("JAVATRON", 400, 80, 63);
		title.setTranslateX(230);
		title.setTranslateY(100);
		
		//groups the menu items together 
		MenuBox menu = new MenuBox
				(
						playGame,
						
						instructions
			    );
		
		//positions the grouped menu item
		menu.setTranslateX(100);
		menu.setTranslateY(300);
		
		//adds the  menu item to the pane
		homeScreen.getChildren().addAll(title, menu);
		return homeScreen;
	}
	
	//creates a pane for the instructions page
	private Parent createInstructions()
	{
		
		Pane instruction = new Pane();

		//sets the size of the pane
		instruction.setPrefSize(1075, 750);
		
		//adds a background to the pane
		try (InputStream mainBackground = Files.newInputStream(Paths.get("src/javatron/tron_bg.jpg")))
		{
			ImageView background = new ImageView(new Image(mainBackground));
			
			//sets the size of the image
			background.setFitWidth(1075);; 
			background.setFitHeight(750);
			
			//blurs the background 
			background.setOpacity(.5);
			
			//adds the background to the pane
			instruction.getChildren().add(background);
		}
		catch (IOException e)
		{
			System.out.println("Couldn't load image");
		}
		
		//adds a controller image to the pane
		try (InputStream xboxImage = Files.newInputStream(Paths.get("src/javatron/controllerSmaller.png")))
		{
			ImageView controllerImage = new ImageView(new Image(xboxImage));
			
			//sets the size of the picture
			controllerImage.setFitWidth(550);
			controllerImage.setFitHeight(405);
			
			//sets the location of the picture
			controllerImage.setX(270);
			controllerImage.setY(190);
			
			//adds the picture to the pane 
			instruction.getChildren().add(controllerImage);
		}
		
		//catches the exception if the image cannot be added to the pane for whatever reason
		catch (IOException e)
		{
			System.out.println("Couldn't load image");
		}
		
		//creates a back button that will bring the user back to the home screen
		MenuBox backButton = new MenuBox
				(
						back
			    );
		
		//sets the location of the button
		backButton.setTranslateX(100);
		backButton.setTranslateY(630);
		
		//adds the button the pane
		instruction.getChildren().addAll(backButton);
		return instruction;
	}
	
	//creates the pane to start the game
	private Parent createStartGame()
	{
		
		Pane startGame = new Pane();

		//sets the size of the pane
		startGame.setPrefSize(1075,  750);
		
		//adds a background image to the pane
		try (InputStream backgroundImage = Files.newInputStream(Paths.get("src/javatron/tron_bg.jpg")))
		{
			ImageView background = new ImageView(new Image(backgroundImage));
			
			//sets the size of the image 
			background.setFitWidth(1075);;
			background.setFitHeight(750);
			
			//sets the opacity of the image
			background.setOpacity(.5);
			
			//adds the image to the pane
			startGame.getChildren().add(background);
		}
		
		//catches the exception if the image cannot be added for whatever reason
		catch (IOException e)
		{
			System.out.println("Couldn't load image");
		}
		
		//creates a title 
		Title title = new Title("Start Round: " + roundNumber, 500, 80, 63);
		
		//sets the location of the title
		title.setTranslateX(230);
		title.setTranslateY(100);
		
		//creates a back button
		startGame.getChildren().addAll(title);
		
		//creates a grouping of the menuItems for 2 players or 4 players
		MenuBox playersButtonGrouping = new MenuBox
				(
						players2, players4
			    );
		
		//adds the grouping to the pane
		startGame.getChildren().addAll(playersButtonGrouping);
		playersButtonGrouping.setTranslateX(200);
		playersButtonGrouping.setTranslateY(283);
		//creates a new final decision button
			MenuBox finalDecisionButton = new MenuBox
				(
						finalDecision
				);
				
		//creates a give powerup button
		MenuBox givePowerupButton = new MenuBox
				(
						givePowerup
				);
		
		
				
		//creates a new round button
		MenuBox newRoundButton = new MenuBox
				(
						newRound
			    );
		
		
		
		//gives instructions for what to do if the new round button is clicked
		newRound.setOnMouseClicked(event -> {
			Title player1win =  new Title("Player 1 has : " + player1wins +" wins", 200, 30, 15);
			//sets the location of the title
			player1win.setTranslateX(424);
			player1win.setTranslateY(450);
			Title player2win =  new Title("Player 2 has : " + player2wins +" wins", 200, 30, 15);
			//sets the location of the title
			player2win.setTranslateX(424);
			player2win.setTranslateY(520);
			Title player3win =  new Title("Player 3 has : " + player3wins +" wins", 200, 30, 15);
			//sets the location of the title
			player3win.setTranslateX(424);
			player3win.setTranslateY(590);
			Title player4win =  new Title("Player 4 has : " + player4wins +" wins", 200, 30, 15);
			//sets the location of the title
			player4win.setTranslateX(424);
			player4win.setTranslateY(660);
			
			
			startGame.getChildren().removeAll(player1win, player2win, player3win, player4win);
			
			
			//increments the number of rounds 
			roundNumber ++; 
			
			//makes sure that buttons to pick the number of players or powerups are not displayed if the game has already passed the initial round
			if (roundNumber != 1)
			{
				
				startGame.getChildren().removeAll(playersButtonGrouping, newRoundButton, boostImage, ghostImage, powerupForThisRound);	
				startGame.getChildren().addAll(givePowerupButton);	
			}
			
			//updates the status of the title to match the round number
			startGame.getChildren().removeAll(title);
			startGame.getChildren().removeAll(startGameTitle);
			startGameTitle = new Title("Start Round: " + roundNumber, 500, 80, 63);
			
			//sets the location of the title
			startGameTitle.setTranslateX(230);
			startGameTitle.setTranslateY(100);
			
			//adds the title to the pane
			startGame.getChildren().addAll(startGameTitle);
			
			//creates the game when the new round button is clicked
			//Game game = new Game(); //THIS WILL BE CHANGED DEPENDING ON THE NEW CODE
			
			//adds the number of wins titles
			startGame.getChildren().addAll(player1win, player2win, player3win, player4win);

			});

		//instructions for what to do when the give powerup
		givePowerup.setOnMouseClicked(event -> {
			boost = false;
			ghost = false;
			 
			startGame.getChildren().removeAll(playersButtonGrouping, givePowerupButton, newRoundButton);	
			
			//adds the new round button button to the pane
			startGame.getChildren().addAll(newRoundButton);
			
			powerupForThisRound =  new Title("This round's powerup is : " , 200, 30, 15);
			//sets the location of the title
			powerupForThisRound.setTranslateX(224);
			powerupForThisRound.setTranslateY(350);
			//randomly generates this rounds powerup
			int randomNum1 = (int )(Math. random() * 2);
			if (randomNum1 == 1)
				boost = true;
			else 
				ghost = true;
				//images for this rounds powerup
				try (InputStream is2 = Files.newInputStream(Paths.get("src/javatron/boost.jpg")); InputStream is3 = Files.newInputStream(Paths.get("src/javatron/ghost.jpg")); )
				{
									
					boostImage = new ImageView(new Image(is2));
					boostImage.setFitWidth(100);;
					boostImage.setFitHeight(100);
					boostImage.setX(475);
					boostImage.setY(340);
										
					ghostImage = new ImageView(new Image(is3));
					ghostImage.setFitWidth(100);;
					ghostImage.setFitHeight(100);
					ghostImage.setX(475);
					ghostImage.setY(340);
					
					startGame.getChildren().remove(boostImage);	
					startGame.getChildren().remove(ghostImage);	
					
						//adding images to pane depending on if boost is true or now
						if (boost ==true)
							startGame.getChildren().addAll(boostImage, powerupForThisRound);
						else if (ghost ==true)
							startGame.getChildren().addAll(ghostImage, powerupForThisRound);
			
				}
				catch (IOException e)
				{
					System.out.println("Couldn't load image");
				}
				

				
			
		});
		
		//instructions for what to do when the final decision button is clicked
		finalDecision.setOnMouseClicked(event -> {
							
				
			startGame.getChildren().removeAll(playersButtonGrouping, finalDecisionButton, givePowerupButton);	
					
					
							
			//adds the new final decision button to the pane
			startGame.getChildren().addAll(givePowerupButton);
							
					
				});
				
		//instructions for what to do when the 2 player button is clicked
		players2.setOnMouseClicked(event -> {
			
			//makes sure that the new round button is not displayed until an option of number of players is clicked 
			startGame.getChildren().removeAll(numPlayers, finalDecisionButton);
			
			//sets the number of players to 2
			players = 2; 
			
			//adds the new round button to the pane
			startGame.getChildren().addAll(finalDecisionButton);
			
			
			//sets the title numPlayers to display that there is *x* players
			numPlayers = new Title("There are " + players + " players.", 300, 30, 16);
			
			//sets the location of this title
			numPlayers.setTranslateX(330);
			numPlayers.setTranslateY(200);
			
			//adds this title to the pane
			startGame.getChildren().addAll(numPlayers);
		});
		
		//instructions for what to do when the 2 player button is clicked
		players4.setOnMouseClicked(event -> {
			//makes sure that the new round button is not displayed until an option of number of players is clicked 
			startGame.getChildren().removeAll(numPlayers, finalDecisionButton);
			
			//sets the number of players to 4
			players = 4; 
			
			//adds the new round button to the pane
			startGame.getChildren().addAll(finalDecisionButton);
			
			//sets the title numPlayers to display that there is *x* players
			numPlayers = new Title("There are " + players + " players.", 300, 30, 16);
			
			//sets the location of this title
			numPlayers.setTranslateX(330);
			numPlayers.setTranslateY(200);
			
			//adds this title to the pane
			startGame.getChildren().addAll(numPlayers);
		});
		
		//creates the back button
		MenuBox backButton = new MenuBox
				(
						back
			    );
		
		//sets the location of the back button
		backButton.setTranslateX(750/2 +50);
		backButton.setTranslateY(700); 
		
		//sets the location of the final decision button
		finalDecisionButton.setTranslateX(750/2 +50);
		finalDecisionButton.setTranslateY(300);

		//sets the location of the give powerups button
		givePowerupButton.setTranslateX(750/2 +50);
		givePowerupButton.setTranslateY(300);
		
		//sets the location of the new round button
		newRoundButton.setTranslateX(750/2 +50);
		newRoundButton.setTranslateY(300);
		
		//adds the back button to the pane
		startGame.getChildren().addAll(backButton);
		return startGame;
	}	
	

	//creates the home scene and what to do if any button is clicked
	public void start(Stage primaryStage) throws Exception
	{
		//create a scene for the home screen using the pane that was made
		Scene homeScene = new Scene(createHome());
		primaryStage.setTitle("Javatron Main Menu");
		primaryStage.setScene(homeScene);
		primaryStage.show();
		
		//instructions for what to do when the instruction button is clicked
		instructions.setOnMouseClicked(event -> {
			Scene instructionScene = new Scene(createInstructions());
			primaryStage.setTitle("Controls");
			primaryStage.setScene(instructionScene);
			primaryStage.show();   
		});
		
		//instructions for what to do when the play game button is clicked
		playGame.setOnMouseClicked(event -> {
			Scene startGameScene = new Scene(createStartGame());
			primaryStage.setTitle("Game");
			primaryStage.setScene(startGameScene);
			primaryStage.show();   
		});
		
		//brings up the home screen when the back button is clicked
		back.setOnMouseClicked(event -> {
			try {
				start(primaryStage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			});
		
	}
	
	//class to create title object
	private static class Title extends StackPane
	{
		//takes in three parameters, the text in the title, the width of the border  
		public Title(String name, int width, int height, int fontSize)
		{
			//creates the borders
			Rectangle border = new Rectangle(width, height);
			border.setStroke(Color.WHITE);
			border.setStrokeWidth(2);
			border.setFill(null);
			
			//creates the text 
			Text text = new Text(name);
			text.setFill(Color.WHITE);
			text.setFont(Font.font("Tw Cen MT Condensed", FontWeight.BOLD, fontSize));
			setAlignment(Pos.CENTER);
			getChildren().addAll(border, text);
			
		}
	}
	
	private static class MenuBox extends VBox 
	{
		//creates a MenuBox to group all the menu items 
		public MenuBox(MenuItem...items)
		{
			getChildren().add(createSeparator());
			
			for (MenuItem item : items)
			{
				getChildren().addAll(item, createSeparator());
			}
		}
		
		private Line createSeparator()
		{
			//adds a line separator between each button
			Line seperator = new Line();
			seperator.setEndX(200);
			seperator.setStroke(Color.WHITE);
			return seperator;
		}
	}
	
	private static class MenuItem extends StackPane
	{
		//creates the individual menu item 
		public MenuItem(String name)
		{
			LinearGradient gradient = new LinearGradient (0,0,1,0, true, CycleMethod.NO_CYCLE, new Stop[]
					{
							//array of stops for where to stop painting each color. Used to create the effect of the blue highlight
						new Stop(0, Color.CYAN),
						new Stop(0.1, Color.BLACK),
						new Stop(0.9, Color.BLACK),
						new Stop(1, Color.CYAN)
					});
			
			//makes the background of the button transparent
			Rectangle buttonBackground = new Rectangle(200,30);
			buttonBackground.setOpacity(.7);
		
			Text text = new Text(name);
			text.setFill(Color.WHITE);
			text.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 22));
		
			setAlignment(Pos.CENTER);
			getChildren().addAll(buttonBackground,text);
		
			//if the mouse hovers over the button, the background of the button become the linear gradient
			setOnMouseEntered(event -> 
			{
				buttonBackground.setFill(gradient);
				text.setFill(Color.WHITE);
			});
			
			//when the mouse is not hovering over the button anymore, the background of the button becomes black
			setOnMouseExited(event ->
			{
				buttonBackground.setFill(Color.BLACK);
				text.setFill(Color.WHITE);
			});
			
			//if the button is pressed it fills the button with a cyan background
			setOnMousePressed(event ->
			{
				buttonBackground.setFill(Color.CYAN);
			});
			
			//when the button is let go, the color becomes the linear gradient again
			setOnMouseReleased(event ->
			{
				buttonBackground.setFill(gradient);
			});
		
		}
	
	}
	
	//the main method that launches all the code
	public static void main(String[] args) 
		{
		  	launch(args);
		}
	
}


