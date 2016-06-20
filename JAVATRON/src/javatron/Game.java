package javatron;

import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import net.java.games.input.Component.Identifier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener
{
	//rows and cols
	private final int ROWS = 10, COLS = 10;
	//all connected controllers
	Controller[] controllers;
	//array of xBox controllers
	private Controller[] xBoxController;
	
	private int numPlayers, numRounds;
	private int[] roundWins; // stores each player’s wins and is updated by the checkRoundStatus() method.
	Timer gameTimer = new Timer(7, this);
	private Gameboard gameboard = new Gameboard(ROWS, COLS);
	private Bike[] bikes;
	private Component[] stickX, stickY, powerUpButton;
	private double deadZone = .23;
	
	//constructor
	public Game(int p)
	{
		numPlayers = p;
		roundWins = new int[numPlayers];
		numRounds = 0; 
		controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();
		xBoxController = new Controller[p+1 / 2];
		stickX = new Component[numPlayers];
		stickY = new Component[numPlayers];
		powerUpButton = new Component[numPlayers];
		bikes = new Bike[numPlayers];
		
		//get all xBoxControllers
		int count = 0;
		for (int i = 0; i < controllers.length; i++) 
		{
			if (controllers[i].getName().contains("360") || controllers[i].getName().contains("Controller")) 
			{
				xBoxController[count] = controllers[i];
				count ++;
			}
		}
		
		//initilize bike!
		for(int i = 0; i < numPlayers; i++)
		{
			switch(i)
			{
			case 0:
				//first bike set to cyan, facing right
				bikes[i] = new Bike('c', 1, 1, 'r');
			case 1:
				//2nd set to green, facing left
				bikes[i] = new Bike('g', 2, 2, 'l');
			case 2:
				//3rd set to yellow, facing right
				bikes[i] = new Bike('y', 3, 3, 'r');
			case 3:
				//4th set to purple, facing left
				bikes[i] = new Bike('p', 4, 4, 'l');
			}
		}
		
		gameTimer.start();
	}
	// updates status of game: checks amount of derezzed bikes
	// if derezzed == bikes - 1, there is a winner for that round 
	// a point is added to that bike. 
	public void checkRoundStatus()
	{
		int derezzed = 0, winner = 0;
		
		for(int i = 0; i < bikes.length; i++)
			//derezzed bikes
			if(bikes[i].isDerezzed())
				derezzed++;
			//winner for that round(will be checked if it's actually the winner in the next if statemenet) 
			else
				winner = i;
		
		if (derezzed == bikes.length - 1)
			roundWins[winner]++;
	}
	
	// numRounds ++
	// generates a new round with all four bikes ready to play.
	public void newRound()
	{
		numRounds++;
	}
	
 	//Checks the roundWins array to see if a specific element equals 3.          
    //If so, displays the end game GUI. 
	public boolean checkEndGame()
	{
		int winner = 0; 
		for(int i = 0; i < numPlayers; i++)
			if(roundWins[i] == 3)
			{
				winner = i;
				//display end game gui(takes in the winner??) 
				return true;
			}
		return false;
	}
	
	
	public void actionPerformed(ActionEvent e)
    {
		for(int i = 0; i < xBoxController.length - 1; i++)
		{
			xBoxController[i].poll();
			for(int j = 0; j < numPlayers; j++)
			{
				//left sticks & button
				if(j % 2 == 0)
				{
					stickX[j] = xBoxController[i].getComponent(Identifier.Axis.X);
				    stickY[j] = xBoxController[i].getComponent(Identifier.Axis.Y);
				    powerUpButton[j] = xBoxController[i].getComponent(Identifier.Button._4);
				}
				//right sticks & button
				else
				{
					stickX[j] = xBoxController[i].getComponent(Identifier.Axis.RX);
				    stickY[j] = xBoxController[i].getComponent(Identifier.Axis.RY);
				    powerUpButton[j] = xBoxController[i].getComponent(Identifier.Button._5);
				}
			}
		}
		
		 
		for(int i = 0; i < numPlayers ; i++)
		{
			//if the bike is NOT derezzed & the game has NOT ended
			if(!bikes[i].isDerezzed() && !checkEndGame())
			{
				//wall collision
				if(checkCollideWithWalls(bikes[i]))
				{
					bikes[i].setDerezzed();
					gameboard.removeTrail(bikes[i].getColor());
				}
				//trail collision (only if ghost isn't activated)
				else if(!bikes[i].ghost() && checkCollideWithTrails(bikes[i]))
				{
					bikes[i].setDerezzed();
					gameboard.removeTrail(bikes[i].getColor());
				}
				else
				{
					//up
					if(stickY[i].getPollData() > deadZone && Math.abs(stickX[i].getPollData() ) < .4 && bikes[i].getDirection()  != 'd')
					{
						gameboard.setVerticalWall(bikes[i]);
						bikes[i].setDirection('u');
					}
					//down
					else if(stickY[i].getPollData() < -deadZone && Math.abs(stickX[i].getPollData() ) < .4 && bikes[i].getDirection()  != 'u')
					{
						gameboard.setHorizontalWall(bikes[i]);
						bikes[i].setDirection('d');
					}
					//left
					else if(stickX[i].getPollData()  < -deadZone && Math.abs(stickY[i].getPollData()) < .4 && bikes[i].getDirection()  != 'r')
					{
						gameboard.setHorizontalWall(bikes[i]);
						bikes[i].setDirection('l');
					}
					//right
					else if(stickX[i].getPollData() > deadZone && Math.abs(stickY[i].getPollData()) < .4 && bikes[i].getDirection()  != 'l')
					{
						gameboard.setHorizontalWall(bikes[i]);
						bikes[i].setDirection('r');
					}
		    
					bikes[i].move();
					gameboard.repaint();
				}
			}
		}
    }
	
	public boolean checkCollideWithTrails(Bike bike)
	{
		// check if location of bike is on a char that is not 'e' in either horizontal or 
		// vertical char arrays(decides which array to check by checking the direction of 
		// the bike)
		
		//check horizontal arrays:
		if(bike.getDirection() == 'l')
		{
			if(gameboard.getHorizontalWall(bike.getX(), bike.getY()-1) != 'e')
				return true;
		}
		else if(bike.getDirection() == 'r')
		{
			gameboard.getHorizontalWall(bike.getX(), bike.getY());
			return true;
		}
		
		//check vertical arrays:
		if(bike.getDirection() == 'd')
		{
			gameboard.getVerticalWall(bike.getX(), bike.getY());
			return true;
		}
		else if(bike.getDirection() == 'u')
		{ 
			gameboard.getVerticalWall(bike.getX() - 1, bike.getY());
			return true;
		}
		return false;
	}
	
	public boolean checkCollideWithWalls(Bike bike)
	{
		switch(bike.getDirection())
		{
			case 'l':
				if(bike.getX() == 0)
					return true;
			case 'u':
				if(bike.getY() == 0)
					return true;
			case 'r':
				if(bike.getX() == gameboard.getHorizontalWallArray().length - 1)
					return true;
			case 'd':
				if(bike.getY() == gameboard.getVerticalWallArray().length - 1)
					return true;
		}
		return false;
	}
}