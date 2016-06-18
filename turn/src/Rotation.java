import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Rotation extends JPanel implements KeyListener
{
	private static BufferedImage tronBike = null;
	
	Rotation()
	{
		try 
	    {
	        tronBike = ImageIO.read(new File("blueBike.jpg"));
	    } 
	    catch (IOException e)
	    {
	     	System.out.println("ERROR!");
	    }
		  
		ImageIcon bike = new ImageIcon(tronBike);
	    JLabel l = new JLabel(bike);
	    
	    l.setSize(470, 190);
	    
	    JPanel p = new JPanel();
	    
	    p.add(l);    
	}
	
	public static BufferedImage rotateCCW(BufferedImage b)
	{
		
		int width = b.getWidth();
		int height = b.getHeight();
		
		BufferedImage rotated = new BufferedImage(height, width, b.getType());
		
		for( int i=0 ; i < width ; i++ )
		{
			for( int j=0 ; j < height ; j++ )
		    {
		        rotated.setRGB(j ,width-1-i, b.getRGB(i,j) );
		    }
		}

		return rotated;	
	}

		
	public static BufferedImage rotateCW(BufferedImage b)
	{
		
		int width = b.getWidth();
		int height = b.getHeight();
		
		BufferedImage rotated = new BufferedImage(height, width, b.getType());
		
		for( int i=0 ; i < width ; i++ )
		{
			for( int j=0 ; j < height ; j++ )
		    {
		        rotated.setRGB( height-1-j, i, b.getRGB(i,j) );
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
	
	public void keyReleased(KeyEvent e)
	{
	}
	
	public void keyTyped(KeyEvent e)
	{
	}

}


}
