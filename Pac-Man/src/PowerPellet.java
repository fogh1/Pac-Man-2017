public class PowerPellet extends AcquirableObject {

	public PowerPellet(int x, int y, Map map) {
		super(x, y, map, 50, "PowerPellet.gif"); 
	}

	public void acquire() {
		super.acquire();
		for (Ghost ghost : getMap().getGhostList()) {
			ghost.setMode(GhostMode.FRIGHTENED);
			ghost.resetFrightenedTimer();
		}
	}

}
