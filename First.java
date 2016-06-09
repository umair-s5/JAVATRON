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
 
public class First 
{
    public static void main(String args[]) throws IOException
    {
        JFrame f = new JFrame();
        Second s = new Second();
        f.add(s);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800, 600);
        f.setBackground(Color.BLACK);
    }
}
