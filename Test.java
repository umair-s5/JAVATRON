import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

public class Test 
{

	
    public static void main(String[] args)
	{
		Image black = null;
		
		try
		{
			URL imageUrl = new URL("http://www.tedmontgomery.com/tutorial/squares/squrblck.jpg");
			black = ImageIO.read(imageUrl);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	    JFrame demo = new JFrame("Demo");
		demo.setSize(300,300);
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		demo.setVisible(true);
		demo.pack();
		
		ImageIcon blackBox = new ImageIcon(black);
		JLabel box = new JLabel(blackBox);
		
			
		demo.add(box);
	}
 



}
