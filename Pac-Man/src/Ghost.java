import javax.swing.ImageIcon;

public abstract class Ghost extends MovableObject {

	private static GhostMode currentMode;

	public Ghost(int x, int y, Direction direction, String iconPath) {
	    super(x, y, direction, iconPath);
	}

	public static GhostMode getMode() {
		return currentMode;
	}

	public static void setMode(GhostMode newMode) {
		currentMode = newMode;
	}

}