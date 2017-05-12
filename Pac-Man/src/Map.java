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
	
	public PacMan getPacMan()
	{
		for (Object o : map)
		{
			if (o instanceof PacMan)
				return (PacMan)o;
		}
		return null;
	}
	
	public Shadow getShadow()
	{
		for (Object o : map)
		{
			if (o instanceof Shadow)
				return (Shadow)o;
		}
		return null;
	}
	
	public Pokey getPokey()
	{
		for (Object o : map)
		{
			if (o instanceof Pokey)
				return (Pokey)o;
		}
		return null;
	}
	
	public Speedy getSpeedy()
	{
		for (Object o : map)
		{
			if (o instanceof Speedy)
				return (Speedy)o;
		}
		return null;
	}
	
	public Bashful getBashful()
	{
		for (Object o : map)
		{
			if (o instanceof Bashful)
				return (Bashful)o;
		}
		return null;
	}

}
