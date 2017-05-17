public class Map {

	private Object[][] map;

	public Map() {
		reset();  // for the sake of simplicity, since repopulating the map and creating it for the first time are essentially the same operation
		// ...
	}

	public Object getObjectAt(int x, int y) {
		return map[x][y];
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
		map [x][y] = object;
		// moves the specified object to the specified new coordinates
		// need to also remove the object from its previous location to avoid duplication
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
}