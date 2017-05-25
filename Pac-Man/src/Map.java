import java.io.*;
import java.net.*;
import java.util.*;

public class Map {

	private Object[][] map;
	private Ghost[][] ghostMap;

	public Map() {
		reset(); // for the sake of simplicity, since repopulating the map and creating it for the first time are essentially the same operation
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
					case "null":
						object = null;
						break;
					case "Wall":
						object = new Wall();
						break;
					case "Door":
						object = new Door();
						break;
					case "PacDot":
						object = new PacDot(column, row, this);
						break;
					case "PowerPellet":
						object = new PowerPellet(column, row, this);
						break;
					case "PacMan":
						object = new PacMan(column, row, this);
						((PacMan) object).setDirection(verbalDirection);
						break;
					case "Shadow":
						object = new Shadow(column, row, this);
						break;
					case "Speedy":
						object = new Speedy(column, row, this);
						break;
					case "Bashful":
						object = new Bashful(column, row, this);
						break;
					case "Pokey":
						object = new Pokey(column, row, this);
						break;
				}
				map[column][row] = object;
			}
			createGhostMap();
			file.close();
		}
		catch (FileNotFoundException exception) {
			System.out.println("ERROR : CSV FILE NOT FOUND");
		}
		catch (IOException exception) {
			System.out.println("ERROR : IO EXCEPTION : " + exception);
		}
	}
	
	public void createGhostMap()
	{
		ghostMap = new Ghost[28][31];
		for (int col = 0; col < 28; col++)
		{
			for (int row = 0; row < 31; row++)
			{
				if (map[col][row] instanceof Ghost)
				{
					ghostMap[col][row] = (Ghost)map[col][row];
					remove((MovableObject)map[col][row]);
				}
				else
				{
					ghostMap[col][row] = null;
				}
			}
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
		if (x == 0 && y == 14 && direction == Direction.LEFT) {
			location[0] = 27;
			location[1] = 14;
			return location;
		}
		else if (x == 27 && y == 14 && direction == Direction.RIGHT) {
			location[0] = 0;
			location[1] = 14;
			return location;
		}
		else if (direction == Direction.LEFT) {
			location[0] = x - 1;
			location[1] = y;
			return location;
		}
		else if (direction == Direction.RIGHT) {
			location[0] = x + 1;
			location[1] = y;
			return location;
		}
		else if (direction == Direction.UP) { // Shouldn't return NullPointerException, if MovableObject ain't on border walls
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
		if (x == 0 && y == 14 && direction == Direction.LEFT) {
			return getObjectAt(27, 14);
		}
		else if (x == 27 && y == 14 && direction == Direction.RIGHT) {
			return getObjectAt(0, 14);
		}
		else if (direction == Direction.LEFT) {
			return getObjectAt(x - 1, y);
		}
		else if (direction == Direction.RIGHT) {
			return getObjectAt(x + 1, y);
		}
		else if (direction == Direction.UP) { // Shouldn't return NullPointerException, if MovableObject ain't on border walls
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
				if (object instanceof PacMan) {
					((AcquirableObject) oldOccupant).acquire();
				}
			}
			map[x][y] = object;
			object.setX(x);
			object.setY(y);
			return oldOccupant;
		}
		// moves the specified object to the specified new coordinates
		// need to also remove the object from its previous location to avoid duplication
	

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
	
	public MovableObject remove(MovableObject objectToRemove) {
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
