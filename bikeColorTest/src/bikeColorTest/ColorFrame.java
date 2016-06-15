package bikeColorTest;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JFrame;

public class ColorFrame extends JFrame 
{
	
	 public static void main(String args[]) throws IOException
	 {
		 JFrame f = new JFrame();
		 BikeColors tronBikeColors = new BikeColors();
		
         f.add(tronBikeColors);
         f.setBackground(Color.BLACK);
         f.setVisible(true);
         f.setExtendedState(JFrame.MAXIMIZED_BOTH);

         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
	}

}
