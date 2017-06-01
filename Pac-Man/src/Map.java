import java.io.*;
import java.net.*;
import java.util.*;

public class Map {

	private Object[][] map;
	private Ghost[][] ghostMap;

	public Map() {
		reset();
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
			file.close();
		}
		catch (FileNotFoundException exception) {
			System.out.println("ERROR : CSV FILE NOT FOUND");
		}
		catch (IOException exception) {
			System.out.println("ERROR : IO EXCEPTION : " + exception);
		}
	}

	public void createGhostMap() {
		ghostMap = new Ghost[28][31];
		for (int column = 0; column < 28; column++) {
			for (int row = 0; row < 31; row++) {
				if (map[column][row] instanceof Ghost) {
					ghostMap[column][row] = (Ghost) map[column][row];
					remove((MovableObject) map[column][row]);
				}
				else {
					ghostMap[column][row] = null;
				}
			}
		}
	}

	public void reset() {
		// returns all objects to the locations they occupy at the start of the game, and replaces any missing PacDots and PowerPellets
		map = new Object[28][31];
		ClassLoader classLoader = this.getClass().getClassLoader();
		createMapFromResource(classLoader.getResource("Map.csv"));
		createGhostMap();
	}
	
	public void resetMovableObjects() {
		Shadow shadow = getShadow();
		Speedy speedy = getSpeedy();
		Bashful bashful = getBashful();
		Pokey pokey = getPokey();
		move(shadow, 14, 11);
		moveGhost(shadow, 14, 11);
		move(speedy, 12, 14);
		moveGhost(speedy, 12, 14);
		move(bashful, 14, 14);
		moveGhost(bashful, 14, 14);
		move(pokey, 16, 14);
		moveGhost(pokey, 16, 14);
		shadow.setDirection(Direction.LEFT);
		bashful.setDirection(Direction.UP);
		speedy.setDirection(Direction.DOWN);
		pokey.setDirection(Direction.UP);
		pacMan.setDirection(Direction.RIGHT);
		move(pacMan, 13, 23);
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

	public Object getObjectAt(int x, int y) {
		return map[x][y];
	}

	public Object getGhostMapObjectAt(int x, int y) {
		return ghostMap[x][y];
	}

	public Object getAdjacentObjectInDirection(MovableObject object, Direction direction) {
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
		else if (direction == Direction.UP) { 
			return getObjectAt(x, y - 1);
		}
		else {
			return getObjectAt(x, y + 1);
		}
	}

	public Object getAdjacentObject(MovableObject object) {
		return getAdjacentObjectInDirection(object, object.getDirection());
	}

	public Object getAdjacentGhostMapObjectInDirection(Ghost ghost, Direction direction) {
		int x = ghost.getX();
		int y = ghost.getY();
		if (x == 0 && y == 14 && direction == Direction.LEFT) {
			return getGhostMapObjectAt(27, 14);
		}
		else if (x == 27 && y == 14 && direction == Direction.RIGHT) {
			return getGhostMapObjectAt(0, 14);
		}
		else if (direction == Direction.LEFT) {
			return getGhostMapObjectAt(x - 1, y);
		}
		else if (direction == Direction.RIGHT) {
			return getGhostMapObjectAt(x + 1, y);
		}
		else if (direction == Direction.UP) { 
			return getGhostMapObjectAt(x, y - 1);
		}
		else {
			return getGhostMapObjectAt(x, y + 1);
		}
	}

	public Object getAdjacentGhostMapObject(Ghost ghost) {
		return getAdjacentGhostMapObjectInDirection(ghost, ghost.getDirection());
	}

	public int getAcquirableObjectCount() {
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

	public Object move(MovableObject object, int x, int y) {
		Object oldOccupant = map[x][y];
		if (oldOccupant instanceof AcquirableObject) {
			if (object instanceof PacMan) {
				((AcquirableObject) oldOccupant).acquire();
			}
		}
		remove(object);
		map[x][y] = object;
		object.setX(x);
		object.setY(y);
		return oldOccupant;
	}

	public void moveGhost(Ghost ghost, int x, int y) {
		Object oldOccupant = map[x][y];
		removeGhost(ghost);
		if (oldOccupant instanceof PacMan) {
			getPacMan().loseLife();
		}
		ghostMap[x][y] = ghost;
		ghost.setX(x);
		ghost.setY(y);
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
	
	public Ghost removeGhost(Ghost ghostToRemove) {
		for (Object[] row : ghostMap) {
			for (Object object : row) {
				if (object == ghostToRemove) {
					ghostMap[ghostToRemove.getX()][ghostToRemove.getY()] = null;
				}
			}
		}
		return ghostToRemove;
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
		for (Object[] row : ghostMap) {
			for (Object object : row) {
				if (object instanceof Shadow) {
					return ((Shadow) object);
				}
			}
		}
		return null;
	}

	public Speedy getSpeedy() {
		for (Object[] row : ghostMap) {
			for (Object object : row) {
				if (object instanceof Speedy) {
					return ((Speedy) object);
				}
			}
		}
		return null;
	}

	public Bashful getBashful() {
		for (Object[] row : ghostMap) {
			for (Object object : row) {
				if (object instanceof Bashful) {
					return ((Bashful) object);
				}
			}
		}
		return null;
	}

	public Pokey getPokey() {
		for (Object[] row : ghostMap) {
			for (Object object : row) {
				if (object instanceof Pokey) {
					return ((Pokey) object);
				}
			}
		}
		return null;
	}

}
