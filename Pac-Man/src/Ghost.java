//import javax.swing.*;

public abstract class Ghost extends MovableObject {

	private static GhostMode currentMode;
	private Map currentMap;


	public Ghost(int x, int y, Map map, String iconPath) {
	    super(x, y, map, Direction.UP, iconPath);
	    currentMode = GhostMode.SCATTER;
	    currentMap = map;
	}

	public static GhostMode getMode() {
		return currentMode;
	}

	public static void setMode(GhostMode newMode) {
		currentMode = newMode;
	}

}
