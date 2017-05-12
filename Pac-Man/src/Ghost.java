import java.awt.*;

public abstract class Ghost extends MoveableObject {

	private static GhostMode currentMode;

	public Ghost(int x, int y, Direction direction, Image image) {
		// ...
	}

	public static GhostMode getMode() {
		return currentMode;
	}

	public static void setMode(GhostMode newMode) {
		currentMode = newMode;
	}

}
