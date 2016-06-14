import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import movingOval.Second;

public class CharArrayTest extends JFrame
{
	 public static void main(String args[]) throws IOException
	 {
		JFrame f = new JFrame();
		Gameboard game = new Gameboard(60, 60);
		Bike redBike = new Bike('r', 50, 50, 'u');
		game.setVerticalWall(redBike);
        f.add(game);
        f.setVisible(true);
        f.setSize(900,900);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		//for(int i = 0; i < game.getVerticalWallArray().length; i++)
			//for(int j = 0; j < game.getVerticalWallArray()[0].length; j++)
				
	}
}
