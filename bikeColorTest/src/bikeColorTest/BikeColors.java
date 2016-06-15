package bikeColorTest;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class BikeColors extends JPanel
{
	public void paint(Graphics g)
	{
		
		
		for(int i = 0; i < 6; i++)
		{
			g.drawLine(480,400,1440,400);
			g.setColor(Color.BLUE);
		}
		//Tron Grid Line Example (Comparing it to Tron Path)
		
	    for(int i = 0; i < 11; i++)
		{
	    	g.drawLine(480,90 + i, 1440, 90 + i);
			g.setColor(Color.GREEN); 
		}
	    // neon Green Bike
	    for(int i = 0; i < 11; i++)
		{
		    g.drawLine(480, 120 + i, 1440, 120 + i);
		    g.setColor(new Color(111,195,223)); 
		}
	    // neon Blue Bike
		 
		for(int i = 0; i < 11; i++)
		{
		   g.drawLine(480,150 + i, 1440,150 + i);
		   g.setColor(new Color(127,0,255));
		}
	    // neon Purple Bike
		
		for(int i = 0; i < 11; i++)
		{
	       g.drawLine(480,180 + i, 1440, 180 + i);
		   g.setColor(new Color(255,255,51)); 
		}
	    // neon Yellow Bike
	 }
}
