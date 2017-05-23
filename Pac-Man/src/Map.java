import java.io.*;
import java.net.*;
import java.util.*;

public class Map {

	private Object[][] map;

	public Map() {
		reset();  // for the sake of simplicity, since repopulating the map and creating it for the first time are essentially the same operation
		// ...
	}

	public void createMapFromResource(URL resource) {
		try {
			Scanner file = new Scanner(resource.openStream());
			file.useDelimiter(",");
			while (file.hasNextLine()) {
				int row = file.nextInt();
				int column = file.nextInt();
				String objectAsString = file.next();
				String direction = file.nextLine();
				direction = direction.substring(1);
				Object object = new Object();
				Direction verbalDirection;
				switch (direction) {
					case "0":
						verbalDirection = Direction.UP;
						break;
					case "90":
						verbalDirection = Direction.RIGHT;
						break;
					case "180":
						verbalDirection = Direction.DOWN;
						break;
					case "270":
						verbalDirection = Direction.LEFT;
						break;
					default:
						verbalDirection = Direction.UP;
				}
				switch (objectAsString) {
					case "Wall":
						object = new Wall();
						break;
					case "null":
						object = null;
						break;
					case "PacDot":
						object = new PacDot(column, row);
						break;
					case "PowerPellet":
						object = new PowerPellet(column, row);
						break;
					case "PacMan":
						object = new PacMan(column, row, this);
						((PacMan) object).setDirection(verbalDirection);
						break;
					/*  // temporarily commented out Ghost subclass constructors so the game can be run
					case "Bashful":
						object = new Bashful();
						break;
					case "Pokey":
						object = new Pokey();
						break;
					case "Shadow":
						object = new Shadow();
						break;
					case "Speedy":
						object = new Speedy(row, column, verbalDirection, this);
						break;
					*/
				}
				map[column][row] = object;
			}
			file.close();
		}
		catch (FileNotFoundException exception) {
			System.out.println("ERROR : CSV FILE NOT FOUND");
		}
		catch (IOException exception) {
			System.out.println("ERROR : IO EXCEPTION : " + exception);
		}
	}

	public void reset() {
		// returns all objects to the locations they occupy at the start of the game, and replaces any missing PacDots and PowerPellets
		map = new Object[28][31];
		ClassLoader classLoader = this.getClass().getClassLoader();
		createMapFromResource(classLoader.getResource("Map.csv"));
	}

	public Object getObjectAt(int x, int y) {
		return map[x][y];
	}

	public int[] getAdjacentLocation(MovableObject object) {
		Direction direction = object.getDirection();
		int x = object.getX();
		int y = object.getY();
		int[] location = new int[2]; 
		if (x == 0&&y == 14&&direction == Direction.LEFT)
		{
			location[0] = 27;
			location[1] = 14;
			return location;
		}
		if (x == 27&&y == 14&&direction == Direction.RIGHT)
		{
			location[0] = 0;
			location[1] = 14;
			return location;
		}
		if (direction == Direction.LEFT) {
			location[0] = x - 1;
			location[1] = y;
			return location;
		} 
		else if (direction == Direction.RIGHT) {
			location[0] = x + 1;
			location[1] = y;
			return location;
		}
		else if (direction == Direction.UP) {  // Shouldn't return NullPointerException, if MovableObject ain't on border walls
			location[0] = x;
			location[1] = y - 1;
			return location;
		}
		else {
			location[0] = x;
			location[1] = y + 1;
			return location;
		}
	}

	public Object getAdjacentObject(MovableObject object) {
		Direction direction = object.getDirection();
		int x = object.getX();
		int y = object.getY();
		if (x == 0&&y == 14&&direction == Direction.LEFT)
		{
			return getObjectAt(27, 14);
		}
		if (x == 27&&y == 14&&direction == Direction.RIGHT)
		{
			return getObjectAt(0, 14);
		}
		if (direction == Direction.LEFT) {
			return getObjectAt(x - 1, y);
		} 
		else if (direction == Direction.RIGHT) {
			return getObjectAt(x + 1, y);
		}
		else if (direction == Direction.UP) {  // Shouldn't return NullPointerException, if MovableObject ain't on border walls
			return getObjectAt(x, y - 1);
		}
		else {
			return getObjectAt(x, y + 1);
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

	public Object move(MovableObject object, int x, int y) {
		Object oldOccupant = map[x][y];
		if (oldOccupant instanceof AcquirableObject) {
			((AcquirableObject) oldOccupant).acquire();
		}
		map [x][y] = object;
		object.setX(x);
		object.setY(y);
		return oldOccupant;
		// moves the specified object to the specified new coordinates
		// need to also remove the object from its previous location to avoid duplication
	}

	public AcquirableObject remove(AcquirableObject objectToRemove) {
		for (Object[] row : map) {
			for (Object object : row) {
				if (object == objectToRemove) {
					map[objectToRemove.getX()][objectToRemove.getY()] = null;
				}
			}
		}
		return objectToRemove;
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
