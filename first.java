package movingOval;

import javax.swing.JFrame;
import java.awt.Color;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
 


public class first 
{
    static String IMG_PATH="C:\\Users\\Agent\\Desktop\\trongrid.png";
    public static void main(String args[]) throws IOException
    {
        JFrame f = new JFrame();
        second s = new second();
        f.add(s);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800, 600);
        f.setBackground(Color.BLACK);
        
        BufferedImage img = ImageIO.read(new File(IMG_PATH));
        ImageIcon icon = new ImageIcon(img);
        JLabel label = new JLabel(icon);
        f.add(label);  
        
        f.setVisible(true);
        
        
        
    }
    
}

