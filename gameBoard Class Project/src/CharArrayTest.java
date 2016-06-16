
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

public class CharArrayTest extends JFrame
{
	 public static void main(String args[]) throws IOException
	 {
		JFrame f = new JFrame();
		Gameboard grid = new Gameboard(960, 500);
		
		//Bike redBike = new Bike('r', 50, 50, 'u');	
		//grid.setVerticalWall(redBike);
		
        f.add(grid);	
        f.setBackground(Color.BLACK);
        f.setVisible(true);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);

        startBGMusic();
        
      

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		//for(int i = 0; i < game.getVerticalWallArray().length; i++) 
			//for(int j = 0; j < game.getVerticalWallArray()[0].length; j++)
				
	 }
	 
	 @SuppressWarnings("restriction")
	 public static void startBGMusic() 
	 { 
	    //Plays the background music
		//make a new AudioPlayer.
		AudioPlayer myBackgroundPlayer = AudioPlayer.player;
        ContinuousAudioDataStream myLoop = null;
         
  		//use a try block in case the file doesn't exist.
        try 
        {
	        AudioStream myBackgroundMusic = new AudioStream(new FileInputStream("Derezzed.wav"));
	        AudioData myData = myBackgroundMusic.getData();
	        myLoop = new ContinuousAudioDataStream(myData);
	    }
        catch(Exception error)
        {
        	JOptionPane.showMessageDialog(null, "Invalid file!");
        }
        
        myBackgroundPlayer.start(myLoop);
     }
}
