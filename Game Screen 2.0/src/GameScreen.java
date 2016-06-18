
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

import java.io.FileInputStream;
import java.io.IOException;

import java.awt.Color;

public class GameScreen extends JFrame
{
	 public static void main(String args[]) throws IOException
	 {
		JFrame f = new JFrame();
		//TrailMove m = new TrailMove();
		//f.add(m);
		GameboardCharArray grid = new GameboardCharArray(960, 500);
		f.add(grid);
		//Bike redBike = new Bike('r', 50, 50, 'u');	
		//grid.setVerticalWall(redBike);
        f.setBackground(Color.BLACK);
        f.setVisible(true);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		//for(int i = 0; i < game.getVerticalWallArray().length; i++) 
			//for(int j = 0; j < game.getVerticalWallArray()[0].length; j++)		
	 }	
}

