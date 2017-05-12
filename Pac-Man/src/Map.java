public class Map {

	private Object[][] map;

	public Map() {
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

}
