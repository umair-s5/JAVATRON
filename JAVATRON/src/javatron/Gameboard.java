package javatron;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Gameboard extends JPanel
{
	char[][] horizontal;
	char[][] vertical;
	
	//constructor
	public Gameboard(int r, int c)
	{
		horizontal = new char[r][c+1];
		for(int i = 0; i < horizontal.length; i++)
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
			vertical[x][y-1] = color;
		else if(direction == 'r')
			vertical[x][y] = color;
	}
	
	public void setHorizontalWall(Bike bike)
	{
		int x = bike.getX(), y = bike.getY();
		char color = bike.getColor(), direction = bike.getDirection();
		
		if(direction == 'u')
			vertical[x-1][y] = color;
		else if(direction == 'd')
			vertical[x][y] = color;
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
			for(int j = 0; j < vertical[0].length; j++)
			{
				switch(vertical[i][j])
				{
				case 'c':
					g.drawLine(j*10 + 10, i*10 + 10, j*10 + 10,  i*10 + 20);
					g.setColor(new Color(92,174,174));
				case 'y':				
					g.drawLine(j*10 + 10, i*10 + 10, j*10 + 10,  i*10 + 20);
					g.setColor(new Color(255,255,51));
				case 'p':				
					g.drawLine(j*10 + 10, i*10 + 10, j*10 + 10,  i*10 + 20);
					g.setColor(new Color(147,74,157));
				case 'g':				
					g.drawLine(j*10 + 10, i*10 + 10, j*10 + 10,  i*10 + 20);
					g.setColor(new Color(96,180,102));
					
				case 'e':
					g.drawLine(j*10 + 10, i*10 + 10, j*10 + 10,  i*10 + 20);
					g.setColor(Color.BLUE);
				}
			}
		}
	
		for(int i = 0; i < horizontal.length; i++)
		{
			for(int j = 0; j < horizontal[0].length; j++)
			{
				switch(horizontal[i][j])
				{
				case 'c': //cyan bike trail
					g.drawLine(i*10 + 10, j*10 + 10, i*10 + 10,  j*10 + 20);
					g.setColor(new Color(92,174,174));
				case 'y': //yellow bike trail		
					g.drawLine(i*10 + 10, j*10 + 10, i*10 + 10,  j*10 + 20);
					g.setColor(new Color(255,255,51));
				case 'p': //purple bike trail				
					g.drawLine(i*10 + 10, j*10 + 10, i*10 + 10,  j*10 + 20);
					g.setColor(new Color(147,74,157));
				case 'g': //green bike trail				
					g.drawLine(i*10 + 10, j*10 + 10, i*10 + 10,  j*10 + 20);
					g.setColor(new Color(96,180,102));	
				case 'e': //tron grid line 
					g.drawLine(i*10 + 10, j*10 + 10, i*10 + 10,  j*10 + 20);
					g.setColor(Color.BLUE);
				}
			}
		}
	}
	
	public void removeTrail(char color)
	{
		for(int i = 0; i < horizontal.length; i++)
			for(int j = 0; j < horizontal[0].length; j++)
				if(horizontal[i][j] == color)
					horizontal[i][j] = 'e';
		
		for(int i = 0; i < vertical.length; i ++)
			for(int j = 0; j < vertical[0].length; j++)
				if(vertical[i][j] == color)
					vertical[i][j] = 'e';
	}
}