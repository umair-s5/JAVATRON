package movingOval;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import net.java.games.input.Component.Identifier;

public class Second extends JPanel implements ActionListener
{
	Timer t = new Timer(7, this);
    double x = 30, y = 10, x1 = 30, y1 = 100,velx = 1, vely = 0, velx1 = 0, vely1 = 1,  deadZone = .23;
    Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();
	Controller control = null;
	Component leftStickX, leftStickY;
	char direction = '.';
    
    public Second()
    {
        t.start(); 
        setFocusable(true);

		for (int i = 0; i < controllers.length; i++) 
		{
			if (controllers[i].getName().contains("360")) 
			{
				control = controllers[i];
				break;
			}
		}
    }
   
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillOval((int)x, (int)y, 7, 7);
    }
    
    public void actionPerformed(ActionEvent e)
    {  
    	repaint();
    	
        x += velx;
        y += vely;
        
        control.poll();
        
		leftStickY = control.getComponent(Identifier.Axis.Y);
		leftStickX = control.getComponent(Identifier.Axis.X);
		
		double stickY = leftStickY.getPollData();
		double stickX = leftStickX.getPollData();
		
		if(stickX > deadZone && Math.abs(stickY) < .4 && direction  != 'l')
			right();
	    else if(stickX < -deadZone && Math.abs(stickY) < .4 && direction  != 'r')
	    	left();
	    else if(stickY > deadZone && Math.abs(stickX) < .4 && direction  != 'u')
	    	down();
	    else if(stickY < -deadZone && Math.abs(stickX) < .4 && direction  != 'd')
	    	up();
    }
    
    public void up()
    {
        velx = 0;
        vely = -1.5;
        direction = 'u';
    }
    public void down()
    {
        velx = 0;
        vely = 1.5;
        direction = 'd';
    }
    public void left()
    {
        velx = -1.5;
        vely = 0;
        direction = 'l';
    }
    public void right()
    {
        velx = 1.5;
        vely = 0;
        direction = 'r';
    }
}   
