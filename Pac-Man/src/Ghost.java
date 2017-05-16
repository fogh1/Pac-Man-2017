import javax.swing.ImageIcon;

public abstract class Ghost extends MovableObject {

	private static GhostMode currentMode;

	public static GhostMode getMode() {
		return currentMode;
	}

	public static void setMode(GhostMode newMode) {
		currentMode = newMode;
	}

}
