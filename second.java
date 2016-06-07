package movingOval;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class second extends JPanel implements ActionListener, KeyListener
{
    Timer t = new Timer(7, this);
    double x = 30, y = 10, x1 = 30, y1 = 100,velx = 1, vely = 0, velx1 = 0, vely1 = 1;
    
    public second()
    {
        t.start(); 
        addKeyListener(this);
        setFocusable(true);
  
    }
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.CYAN);
        g.fillOval((int)x, (int)y, 7, 7);
        g.setColor(Color.MAGENTA);
		g.fillRect((int)x1, (int)y1, 7, 7);
    }
    public void actionPerformed(ActionEvent e)
    {
        repaint();
        x += velx;
        y += vely;
        x1 += velx1;
        y1 += vely1;
    }
    public void up()
    {
        velx = 0;
        vely = -1.5;
    }
    public void down()
    {
        velx = 0;
        vely = 1.5;
    }
    public void left()
    {
        velx = -1.5;
        vely = 0;
    }
    public void right()
    {
        velx = 1.5;
        vely = 0;
    }
    public void up1()
    {
        velx1 = 0;
        vely1 = -1.5;
    }
    public void down1()
    {
        velx1 = 0;
        vely1 = 1.5;
    }
    public void left1()
    {
        velx1 = -1.5;
        vely1 = 0;
    }
    public void right1()
    {
        velx1 = 1.5;
        vely1 = 0;
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
        
        if (code == KeyEvent.VK_W)
        {
			up1();
		} 
		if (code == KeyEvent.VK_S) 
		{
			down1();
		} 
		if (code == KeyEvent.VK_D) 
		{
			right1();
		} 
		if (code == KeyEvent.VK_A) 
		{
			left1();
		}
        
    }
    public void keyTyped(KeyEvent e){}
    public void keyReleased(KeyEvent e) {}
}   