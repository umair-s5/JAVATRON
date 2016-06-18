

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class TrailMove extends JPanel implements ActionListener, KeyListener 
{
    Timer t = new Timer(7, this);
    int x = 480, y = 400, velX, velY;
    
    Rectangle bike = new Rectangle((int)x,(int) y,10,10);     
    
    public TrailMove()
    {
        t.start(); 
        addKeyListener(this);
        setFocusable(true);
  
    }
    
    //Creates tron yellow path
    public void paintComponent(Graphics g)
    {
    	
    	g.setColor(new Color(255,255,51)); 
		g.fillRect(x, y, 10, 10);
    }
    
    //adds the velocity to the pixel coordinates so that path increases in length
    public void actionPerformed(ActionEvent e)
    {
        repaint();
        x += velX;
        y += velY;
      
        //checks to see if checkCollide() is true or not. Then outputs a message to the console.
       // if(checkCollide(cyan, magenta))
       // {
        //	System.out.println("Collision!");
        	
       // }
    }
    
    //checks if the areas of the Rectangle objects intersect with the help of the intersect method.
    //public static boolean checkCollide(Rectangle a, Rectangle b) 
    //{
    	//Area areaA = new Area(a);
    	//areaA.intersect(new Area(b));
    	//return !areaA.isEmpty();
    //}
    
    // following methods change the velcoity of path when called inside the KeyEvent if-statements.
    public void up()
    {
        velX = 0;
        velY = -2;
    }
    public void down()
    {
        velX = 0;
        velY = 2;
    }
    public void left()
    {
        velX = -2;
        velY = 0;
    }
    public void right()
    {
        velX = 2;
        velY = 0;
    }
     
    public void keyPressed(KeyEvent e)
    {
        int code = e.getKeyCode();
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
    }
    public void keyTyped(KeyEvent e){}
    public void keyReleased(KeyEvent e) {}
}
