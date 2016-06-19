import java.io.IOException;

import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import net.java.games.input.Component.Identifier;

public class DirectionTest 
{
	public static void main(String[] args) throws IOException
	{
		Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();
		Controller control = null;
		Component leftStickX, leftStickY, rightStick, leftBumper, rightBumper;
		boolean pressed = false;
		String direction = "NONE", temp = "NONE";

		double leftStickYData = 0, leftStickXData = 0, rightStickData = 0, deadZone = .23;
		
		for (int i = 0; i < controllers.length; i++) 
		{
			System.out.println(controllers[i].getName());
			/*
			if (controllers[i].getName().contains("360")) 
			{
				control = controllers[i];
				
				break;
			}
			*/
		}

		double y, x;

		// outputs UP, DOWN, LEFT, RIGHT, NONE when the left stick changes direction
		// direction
		
		/*
		while (true) 
		{
			control.poll();

			leftStickY = control.getComponent(Identifier.Axis.Y);
			leftStickX = control.getComponent(Identifier.Axis.X);
			y = leftStickY.getPollData();
			x = leftStickX.getPollData();
			
			// going to the right!
			 if(x > deadZone && Math.abs(y) < .4)
				System.out.println("RIGHT");
			//going to the left
		    else if(x < -deadZone && Math.abs(y) < .4)
		    	System.out.println("LEFT");
		    else if(y > deadZone && Math.abs(x) < .4)
		    	System.out.println("DOWN");
		    else if(y < -deadZone && Math.abs(x) < .4)
		    	System.out.println("UP");
		    else
		    	System.out.println("Dead zones");
		}
		*/
	}
}

