
import java.awt.Color;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class CharArrayTest extends JFrame
{
	 public static void main(String args[]) throws IOException
	 {
		JFrame f = new JFrame();
		Gameboard game = new Gameboard(960, 500);
		//game.setBackground(Color.BLACK);
		Bike redBike = new Bike('r', 50, 50, 'u');	
		game.setVerticalWall(redBike);
		
        f.add(game);
        f.setBackground(Color.BLACK);
        f.setVisible(true);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		//for(int i = 0; i < game.getVerticalWallArray().length; i++) 
			//for(int j = 0; j < game.getVerticalWallArray()[0].length; j++)
				
	}
}
