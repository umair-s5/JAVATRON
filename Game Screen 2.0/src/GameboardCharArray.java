import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GameboardCharArray extends JPanel implements KeyListener, ActionListener 
{
	char[][] horizontal;
	char[][] vertical;
	
	int speed = 10;
	
	Timer t = new Timer(7, this);
	
	int x = 4, y = 26, velX = 10 , velY = 0;
	
	public GameboardCharArray(int r, int c)
	{
		horizontal = new char[r][c+1];
		for(int i = 0; i < horizontal.length; i ++)
			for(int j = 0; j < horizontal[0].length; j++)
				horizontal[i][j] = 'e';
		
		vertical = new char[r+1][c];
		for(int i = 0; i < vertical.length; i ++)
			for(int j = 0; j < vertical[0].length; j++)
				vertical[i][j] = 'e';
		
		t.start();
		addKeyListener(this);
	    setFocusable(true);
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
			for(int j = 0; j < vertical[0].length; j+= 2)
			{
				g.drawLine(j*10 + 10, i*10 + 10, j*10 + 10,  i*10 + 20);
				g.setColor(Color.BLUE);
				//77,173,212 --- more retro shade of neon blue
				//77,77,255 --- more modern shade of neon blue
				
			}
		}
		
		for(int i = 0; i < horizontal.length; i++)
		{
			for(int j = 0; j < horizontal[0].length; j+= 2)
			{
				
				g.drawLine(i*10 + 10, j*10 + 10, i*10 + 20, j*10 + 10);
				g.setColor(Color.BLUE);			
			}	
		}	
		
		g.setColor(new Color(96,180,102 )); 
		//92,174,174 cyan
		//255,255,51 yellow 
		//147,74,157 purple
		//96,180,102 green
		g.fillRect(x, y, 10, 10);
	}

	
    public void actionPerformed(ActionEvent e)
    {
        repaint();
        x += velX;
        y += velY; 
    }
    
    public void up()
    {
        velX = 0;
        velY = -speed;
    }
    public void down()
    {
        velX = 0;
        velY = speed;
    }
    public void left()
    {
        velX = -speed;
        velY = 0;
    }
    public void right()
    {
        velX = speed;
        velY = 0;
    }

	
    //Enables the user to move the path with arrow keys. 
    //Also inhibts the path to travel on non-grid area.
    public void keyPressed(KeyEvent e)
	{
	     int code = e.getKeyCode();
	        if (code == KeyEvent.VK_UP && vertical[0].length % 4 == 0)
	        {
	        	up();
	        }
	        if (code == KeyEvent.VK_DOWN && vertical[0].length % 4 == 0)
	        {
	            down();
	        }
	        if (code == KeyEvent.VK_RIGHT &&  horizontal.length % 4 == 0)
	        {
	            right();
	        }
	        if (code == KeyEvent.VK_LEFT &&  horizontal.length % 4 == 0)
	        {
	            left();
	        }	
	}
	
	@Override
	public void keyTyped(KeyEvent e)
	{	
	}
	@Override
	public void keyReleased(KeyEvent e)
	{	
	}

}