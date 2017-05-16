public class Map {

	private Object[][] map;

	public Map() {
		reset();  // for the sake of simplicity, since repopulating the map and creating it for the first time are essentially the same operation
		// ...
	}

	public Object getObjectAt(int x, int y) {
		return map[x][y];
	}

	public int acquirableObjectCount() {
		return 0;  // temporary
		// returns the number of un-acquired AcquirableObjects in the map
	}

	public Object set(Object object, int x, int y) {
		Object oldOccupant = map[x][y];
		map[x][y] = object;
		return oldOccupant;
	}

	public Object move(Object object, int x, int y) {
		return null;  // temporary
		// moves the specified object to the specified new coordinates
	}

	public Object remove(Object object) {
		return null;  // temporary
		// removes the specified object from the map model
	}

	public void reset() {
		// returns all objects to the locations they occupy at the start of the game, and replaces any missing PacDots and PowerPellets
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
	
	
	public int findXCoordinate(Object z) 
	{ //Precondition: Moveable Object must actually be in grid
	for (int rlcv = 0; rlcv < map.length; rlcv++)
	{
		for (int clcv = 0; clcv < map.length; clcv++)
		{
			Object check = map[rlcv][clcv];
			if (check.equals(z))      //is object at location equal to what we want?
			{
				return rlcv;
			}
		}
	}
	return -1;
	}
	
	public int findYCoordinate(Object z) 
	{ //Precondition: Moveable Object must actually be in grid
		for (int rlcv = 0; rlcv < map.length; rlcv++)
		{
			for (int clcv = 0; clcv < map.length; clcv++)
			{
				Object check = map[rlcv][clcv];
				if (check.equals(z))  //is object at location equal to what we want?
				{
					return clcv;
				}
			}
		}
	return -1;
	 }

	public Object getAdjacentObject(MovableObject present){ 
		Object adjacentObject = null;
		Direction presentDirection = present.getDirection();
		int x = findXCoordinate(present);
		int y = findYCoordinate(present);
		if (presentDirection == Direction.UP)   //Shouldn't return nullpointer, if moveable object ain't on border walls
		{
			adjacentObject = getObjectAt(x, y+1);
		}
		else if (presentDirection == Direction.DOWN)
		{
			adjacentObject = getObjectAt(x, y-1);
		} 
		else if (presentDirection == Direction.LEFT)
		{
			adjacentObject = getObjectAt(x-1, y);
		} 
		else
		{
			adjacentObject = getObjectAt(x+1, y);
		}
		return adjacentObject;
		}
		

	}

