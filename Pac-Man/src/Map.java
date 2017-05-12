public class Map {

	private Object[][] map;

	public Map() {
		// ...
	}

	public Object getObjectAt(int x, int y) {
		return map[x][y];
	}

	public Object set(Object object, int x, int y) {
		Object oldOccupant = map[x][y];
		map[x][y] = object;
		return oldOccupant;
	}

	public Object move(Object object, int x, int y) {
		// moves the specified object to the specified new coordinates
	}

	public Object remove(Object object) {
		// removes the specified object from the map model
	}

	public void reset() {
		// returns all objects to the locations they occupy at the start of the game, and replaces any missing PacDots and PowerPellets
	}

}
