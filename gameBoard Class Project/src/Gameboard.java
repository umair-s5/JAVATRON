import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Gameboard extends JPanel
{
	char[][] horizontal;
	char[][] vertical;
	
	public Gameboard(int r, int c)
	{
		horizontal = new char[r][c+1];
		for(int i = 0; i < horizontal.length; i ++)
			for(int j = 0; j < horizontal[0].length; j++)
				horizontal[i][j] = 'e';
		
		vertical = new char[r+1][c];
		for(int i = 0; i < vertical.length; i ++)
			for(int j = 0; j < vertical[0].length; j++)
				vertical[i][j] = 'e';
	}
	
	public void setVerticalWall(Bike bike)
	{
		int x = bike.getX(), y = bike.getY();
		char color = bike.getColor(), direction = bike.getDirection();
		
		if(direction == 'l')
			vertical[x][y] = color;
		else if(direction == 'r')
			vertical[x][y-1] = color;
	}
	
	public void setHorizontalWall(Bike bike)
	{
		int x = bike.getX(), y = bike.getY();
		char color = bike.getColor(), direction = bike.getDirection();
		
		if(direction == 'u')
			vertical[x][y] = color;
		else if(direction == 'd')
			vertical[x-1][y] = color;
	}
	
	public char getHorizontalWall(int r, int c)
	{
		return horizontal[r][c];
		
	}
	
	public char getVerticalWall(int r, int c)
	{
		return vertical[r][c];
	}
	
	public char[][] getHorizontalWallArray()
	{
		return horizontal;
		
	}
	
	public char[][] getVerticalWallArray()
	{
		return vertical;
	}
	
	public void paint(Graphics g)
	{
		for(int i = 0; i < vertical.length; i++)
		{
			for(int j = 0; j < vertical[0].length; j+= 4)
			{
				switch(vertical[i][j])
				{
					case 'r':
						g.setColor(Color.RED);
				}
				g.drawLine(j*10 + 10, i*10 + 10, j*10 + 10,  i*10 + 20);
				g.setColor(new Color(77,77,255));
				//77,173,212 --- more retro shade of neon blue
				//77,77,255 --- more modern shade of neon blue
				
			}
		}
		
		for(int i = 0; i < horizontal.length; i++)
		{
			for(int j = 0; j < horizontal[0].length; j+= 4)
			{
				switch(horizontal[i][j])
				{
					case 'r':
						g.setColor(Color.RED);
				}
				g.drawLine(i*10 + 10, j*10 + 10, i*10 + 20, j*10 + 10);
				g.setColor(new Color(77,77,255));
				//77,173,212 --- more retro shade of neon blue
				//77,77,255 --- more modern shade of neon blue
				
			}	
		}
	}
}