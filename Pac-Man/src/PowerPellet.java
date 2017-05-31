public class PowerPellet extends AcquirableObject {

	public PowerPellet(int x, int y, Map map) {
		super(x, y, map, 50, "PowerPellet.gif"); 
	}
	
	public void acquire()
	{
		super.acquire();
		//TODO what to do when powerpellet is eaten
		getMap().setAllGhostMode(GhostMode.FRIGHTENED);
	}

}
