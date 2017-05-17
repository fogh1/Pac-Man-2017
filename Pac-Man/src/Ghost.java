import javax.swing.ImageIcon;

public abstract class Ghost extends MovableObject {

	private static GhostMode currentMode;

	public Ghost(int x, int y, Direction direction, ImageIcon icon, Map thisMap) {
	    super(x, y, direction, icon, thisMap);
	    currentMode = GhostMode.SCATTER;
	}
	
	public static GhostMode getMode() {
		return currentMode;
	}

	public static void setMode(GhostMode newMode) {
		currentMode = newMode;
	}

}
