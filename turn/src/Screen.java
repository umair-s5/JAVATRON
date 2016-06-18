import java.awt.Color;
import java.io.IOException;
import javax.swing.JFrame;

public class Screen extends JFrame

{	
	public static void main(String[] args) throws IOException
	{
		JFrame f = new JFrame("Turn");
		Rotate r = new Rotate();
		f.add(r);

		f.setSize(1000,1000);
		f.setBackground(Color.BLACK);
        f.setVisible(true);
        f.pack();
	}
	
	
	




}
