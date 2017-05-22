import javax.swing.*;

public abstract class Ghost extends MovableObject {

	private static GhostMode currentMode;

	public Ghost(int x, int y, Map map, Direction direction, String iconPath) {
	    super(x, y, map, direction, iconPath);
	}

	public static GhostMode getMode() {
		return currentMode;
	}

	public static void setMode(GhostMode newMode) {
		currentMode = newMode;
	}

}
