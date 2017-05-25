public abstract class Ghost extends MovableObject {

	private static GhostMode currentMode;

	public Ghost(int x, int y, Map map, String iconPath) {
	    super(x, y, map, Direction.UP, iconPath);
	}

	public static GhostMode getMode() {
		return currentMode;
	}

	public static void setMode(GhostMode newMode) {
		currentMode = newMode;
	}

	public void move() {
		// this probably needs to be overridden by each subclass
	}

}
