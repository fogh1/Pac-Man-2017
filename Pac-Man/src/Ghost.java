public abstract class Ghost extends MoveableObject {

	private static GhostMode currentMode;

	public Ghost() {
		// ...
	}

	public static GhostMode getMode() {
		return currentMode;
	}

	public static void setMode(GhostMode newMode) {
		currentMode = newMode;
	}

}
