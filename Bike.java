import java.awt.Color;

import javax.swing.Timer;

public class Bike 
{
	public static final double NORMAL = .5; //normal velocity; all bikes have this velocity. CONSTANT so does not change, unless hasBoost (temporary).
	public static final double BOOSTED = NORMAL * 2; //(2 x NORMAL)
	private int velocity;
	private boolean hasGhost;
	private boolean hasBoost;
	private int points, x, y;
	private char direction, c; 
	private boolean derezzed; //status of bike(derezzed or not)
	private Timer timeBoost = new Timer(3, null);
	private Timer timeGhost = new Timer(3, null);

	//creates new bike with certain color, starting point and direction
	public Bike(char color, int x1, int y1, char d)
	{
		c = color; 
		x = x1;
		y = y1;
		direction = d;
	}
	
	public void move()
	{
		switch(direction)
		{
			case 'u':
				x-=1;
				break;
			case 'd':
				x+=1;
				break;
			case 'l':
				y-=1;
				break;
			case 'r':
				y+=1;
		}
		
	}

	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public char getColor()
	{
		return c;
	}
	public char getDirection()
	{
		return direction;
	}
	public void setDirection(char d)
	{
		direction = d;
	}
	
	public boolean isDerezzed()
	{
		return derezzed;
	}
	public void setDerezzed(boolean bool)
	{
		derezzed = true;
	}
}
