import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameboard extends JPanel implements KeyListener, ActionListener 
{
	char[][] horizontal;
	char[][] vertical;
	
	int speed = 10; //called inside of the up, down, right, left methods.
	
	Timer t = new Timer(7, this);
	
	int x = 4, y = 32, velX = 10 , velY = 0; //starting x and y coordinates of the yellow bike path.
	int x1 = 4, y1 = 252, velX1 = 10, velY1 = 0; //starting x and y coordinates of the cyan bike path.
	
	Rectangle yellow = new Rectangle(x,y,10,0);
	Rectangle cyan = new Rectangle(x1,y1,10,0);
	
	
	
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
	
	
	//Paints the Tron Grid and the single yellow test Tron bike path
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
		//92,174,174 cyan
		//255,255,51 yellow 
		//147,74,157 purple
		//96,180,102 green
		
		//yellow bike path
		g.setColor(new Color(96,180,102)); 
		g.fillRect(x, y, 10, 15);
		
		//cyan bike path		
		g.setColor(new Color(92,174,174));
		g.fillRect(x1, y1, 10, 15);
	}

	
    public void actionPerformed(ActionEvent e)
    {
        repaint();
        x += velX;
        y += velY; 
        x1 += velX1;
        y1 += velY1; 
        
    }
    
    //following methods update the x and y velocities when called in the keyPressed() method.
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
    
    
    
    public void up1()
    {
        velX1 = 0;
        velY1 = -speed;
    }
    public void down1()
    {
        velX1= 0;
        velY1 = speed;
    }
    public void left1()
    {
        velX1= -speed;
        velY1 = 0;
    }
    public void right1()
    {
        velX1 = speed;
        velY1 = 0;
    }
    
    public static boolean collide(Rectangle a, Rectangle b)
    {	
    	return a.intersects(b);
    }
    
    public void postCollide()
    {
    	if(collide(cyan,yellow) == true)
    	{
    		t.stop();
    	}
    	
    }

    //Enables the user to move the paths with arrow keys. 
    //Also inhibts the paths from travelling on non-grid area. ---- will not be in final game product
   
    @Override  
    public void keyPressed(KeyEvent e)
	{
	     int code = e.getKeyCode();
	     
	     //Arrow Keys 
	     if (code == KeyEvent.VK_UP)
	     {
	     	up();
	     }
	     if (code == KeyEvent.VK_DOWN)
	     {
	        down();
	     }
	     if (code == KeyEvent.VK_RIGHT)
	     {
	         right();
	     }
	     if (code == KeyEvent.VK_LEFT)
	     {
	         left();
	     }	
	     
	     //WASD 
	     if (code == KeyEvent.VK_W)
	     {
	     	up1();
	     }
	     if (code == KeyEvent.VK_S)
	     {
	        down1();
	     }
	     if(code == KeyEvent.VK_D)
	     {
	        right1();
	     }
	     if (code == KeyEvent.VK_A)
	     {
	        left1();
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