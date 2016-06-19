
public class Bike 
{
	private int x, y;
	private char direction, c; 
	private boolean derezzed, hasGhost; 
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
	public void setDerezzed()
	{
		derezzed = true;
	}
	public boolean ghost()
	{
		return hasGhost;
	}
}
