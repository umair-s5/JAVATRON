public class Gameboard 
{
	char[][] horizontal;
	char[][] vertical;
	
	public Gameboard(int r, int c)
	{
		horizontal = new char[r][c+1];
		for(int i = 0; i < horizontal.length; i ++)
			for(int j = 0; j < horizontal[0].length; j++)
				horizontal[i][j] = 'e';
		
		vertical = new char[r+1][c];
		for(int i = 0; i < vertical.length; i ++)
			for(int j = 0; j < vertical[0].length; j++)
				vertical[i][j] = 'e';
	}
	
	public void setVerticalWall(Bike bike)
	{
		int x = bike.getX(), y = bike.getY();
		char color = bike.getColor(), direction = bike.getDirection();
		
		if(direction == 'l')
			vertical[x][y] = color;
		else if(direction == 'r')
			vertical[x][y-1] = color;
	}
	
	public void setHorizontalWall(Bike bike)
	{
		int x = bike.getX(), y = bike.getY();
		char color = bike.getColor(), direction = bike.getDirection();
		
		if(direction == 'u')
			vertical[x][y] = color;
		else if(direction == 'd')
			vertical[x-1][y] = color;
	}
	
	public char getHorizontalWall(int r, int c)
	{
		return horizontal[r][c];
		
	}
	
	public char getVerticalWall(int r, int c)
	{
		return vertical[r][c];
	}
	
}
