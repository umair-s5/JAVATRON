import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Rotate extends JPanel implements KeyListener
{
	BufferedImage tronBike  = null;
	
	Rotate()
	{
		try 
		{	
		    tronBike = ImageIO.read(new File("blueBike.jpg"));
		} 
		catch (IOException e) 
		{
			System.out.println("ERROR");
			
		}
		
		ImageIcon bike = new ImageIcon(tronBike);
		JLabel l = new JLabel(bike);
		JPanel p  = new JPanel();
		
		p.setPreferredSize(new Dimension(470,190));
		
		p.add(l);
	}
	

	public static BufferedImage rotateCCW(BufferedImage b)
	{
		int width = b.getWidth();
		int height = b.getHeight();
		
		BufferedImage rotated = new BufferedImage( height, width, b.getType());
	
		for( int x = 0; x < width; x++ ) 
		{
			for( int y = 0; y < height; y++ ) 
			{
				rotated.setRGB(y, width - 1 - x, b.getRGB( x, y));
			}
		}
		
		return rotated;
	}
	
	public static BufferedImage rotateCW(BufferedImage b)
	{
		int width = b.getWidth();
		int height = b.getHeight();
		
		BufferedImage rotated = new BufferedImage( height, width, b.getType());
	
		for( int x = 0; x < width; x++ ) 
		{
			for( int y = 0; y < height; y++ ) 
			{
				rotated.setRGB(height - 1 - y, x, b.getRGB(x, y));
			}
		}
		
		return rotated;
	}
	
	public void keyPressed(KeyEvent e)
    {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_RIGHT)
        {
        	rotateCW(tronBike);
     
        }
        if(code == KeyEvent.VK_LEFT)
        {
        	rotateCCW(tronBike);
        }
    }
}
