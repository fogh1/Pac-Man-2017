public class Map {

	private Object[][] map;

	public Map() {
		// ...
	}

	public Object getObjectAt(int x, int y) {
		return map[x][y];
	}

	public void reset() {
		// returns all objects to the locations they occupy at the start of the game, and replaces any missing PacDots and PowerPellets
	}

}
