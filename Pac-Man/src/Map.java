import java.io.*;
import java.net.URL;
import java.util.Scanner;


public class Map {

	private Object[][] map;
	private Game currentGame;

	public Map(Game game) {
		currentGame = game;
		reset();  // for the sake of simplicity, since repopulating the map and creating it for the first time are essentially the same operation
		// ...
	}

	public Object getObjectAt(int x, int y) {
		return map[x][y];
	}
	
	public int[] getAdjacentLocation(MovableObject object)
	{
		Direction direction = object.getDirection();
		int x = object.getX();
		int y = object.getY();
		int[] location = new int[2];
		if (direction == Direction.UP) {  // Shouldn't return NullPointerException, if MovableObject ain't on border walls
			location[0] = x;
			location[1] = y + 1;
			return location;
		}
		else if (direction == Direction.DOWN) {
			location[0] = x;
			location[1] = y - 1;
			return location;
		} 
		else if (direction == Direction.LEFT) {
			location[0] = x - 1;
			location[1] = y;
			return location;
		} 
		else {
			location[0] = x + 1;
			location[1] = y;
			return location;
		}
	}

	public Object getAdjacentObject(MovableObject object) {
		Direction direction = object.getDirection();
		int x = object.getX();
		int y = object.getY();
		if (direction == Direction.UP) {  // Shouldn't return NullPointerException, if MovableObject ain't on border walls
			return getObjectAt(x, y + 1);
		}
		else if (direction == Direction.DOWN) {
			return getObjectAt(x, y - 1);
		} 
		else if (direction == Direction.LEFT) {
			return getObjectAt(x - 1, y);
		} 
		else {
			return getObjectAt(x + 1, y);
		}
	}

	public int acquirableObjectCount() {
		int count = 0;
		for (Object[] row : map) {
			for (Object object : row) {
				if (object instanceof AcquirableObject) {
					count++;
				}
			} 
		}
		return count;
	}

	public Object set(Object object, int x, int y) {
		Object oldOccupant = map[x][y];
		map[x][y] = object;
		return oldOccupant;
	}

	public Object move(Object object, int x, int y) {
		Object old = map[x][y];
		map [x][y] = object;
		if (object instanceof MovableObject)
		{
			((MovableObject)object).setX(x);
			((MovableObject)object).setY(y);
		}
		return remove(old);
		// moves the specified object to the specified new coordinates
		// need to also remove the object from its previous location to avoid duplication
	}

	public Object remove(Object object) {
		int[] location = getLocation(object);
		int row = location[0];
		int col = location[1];
		if (row == -1||col == -1)
			return null;
		Object old = map[row][col];
		map[row][col] = null;
		return old;
		// removes the specified object from the map model
	}

	public void reset() {
		// returns all objects to the locations they occupy at the start of the game, and replaces any missing PacDots and PowerPellets
		map = new Object[31][28];
		ClassLoader cldr = Map.class.getClassLoader();
		readFile(cldr.getResource("Map.csv"));
	}
	
	public int[] getLocation(Object object)
	{
		int[] location = {-1,-1};
		for (int row = 0; row < 31; row++)
		{
			for (int col = 0; col < 28; col++)
			{
				if (object == map[row][col])
				{
					location[0] = row;
					location[1] = col;
				}
			}
		}
		return location;
	}
	
	public void readFile(URL resource)//this method is reposibile for reading a CSV file that contains all the map inforamtion
	{
		try
		{
			Scanner file = new Scanner(resource.openStream());
			file.useDelimiter(",");
			while (file.hasNextLine())
			{
				int row = file.nextInt();
				int col = file.nextInt();
				String thing = file.next();
				String direction = file.nextLine();
				direction = direction.substring(1);
				Object thing2pointO = new Object();
				Direction realdirection;
				switch (direction)//this switch changes ints to Directions
				{
				case "0": realdirection = Direction.UP;
				break;
				case "90": realdirection = Direction.RIGHT;
				break;
				case "180": realdirection = Direction.DOWN;
				break;
				case "270": realdirection = Direction.LEFT;
				break;
				default: realdirection = Direction.UP;
				}
				switch (thing)//this switch turns the 
				{
				case "Wall": thing2pointO = new Wall();
				break;
				case "null": thing2pointO = null;
				break;
				case "PacDot": thing2pointO = new PacDot();
				break;
				case "PowerPellet": thing2pointO = new PowerPellet();
				break;
				case "PacMan": thing2pointO = new PacMan(row, col, currentGame);
				((PacMan)thing2pointO).setQueuedDirection(realdirection);
				break;
				case "Bashful": thing2pointO = new Bashful(row, col, currentGame);
				break;
				case "Pokey": thing2pointO = new Pokey(row, col, currentGame);
				break;
				case "Shadow": thing2pointO = new Shadow(row, col, currentGame);
				break;
				case "Speedy": thing2pointO = new Speedy(row, col, currentGame);
				break;
				}
				map[row][col] = thing2pointO;
			}
			file.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("ERROR : CSV FILE NOT FOUND");
		}
		catch(IOException e)
		{
			System.out.println("ERROR : IO EXCEPTION : " + e);
		}
	}

	public PacMan getPacMan() {
		for (Object[] row : map) {
			for (Object object : row) {
				if (object instanceof PacMan) {
					return ((PacMan) object);
				}
			}
		}
		return null;
	}

	public Shadow getShadow() {
		for (Object[] row : map) {
			for (Object object : row) {
				if (object instanceof Shadow) {
					return ((Shadow) object);
				}
			}
		}
		return null;
	}

	public Speedy getSpeedy() {
		for (Object[] row : map) {

			for (Object object : row) {
				if (object instanceof Speedy) {
					return ((Speedy) object);
				}
			}
		}
		return null;
	}

	public Bashful getBashful() {
		for (Object[] row : map) {
			for (Object object : row) {
				if (object instanceof Bashful) {
					return ((Bashful) object);
				}
			}
		}
		return null;
	}

	public Pokey getPokey() {
		for (Object[] row : map) {
			for (Object object : row) {
				if (object instanceof Pokey) {
					return ((Pokey) object);
				}
			}
		}
		return null;
	}	
}
