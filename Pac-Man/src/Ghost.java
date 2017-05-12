import java.awt.Image;

public abstract class Ghost extends MoveableObject {
	
	public enum GhostMode 
	{
		CHASE, SCATTER, FRIGHTENED
	}

	private static GhostMode currentMode;

	public Ghost(int x, int y, Direction currentDirection, Image ghostImage) 
	{
		super(x, y, currentDirection, ghostImage);
		currentMode = CHASE;
	}

	public static GhostMode getMode() {
		return currentMode;
	}

	public static void setMode(GhostMode newMode) {
		currentMode = newMode;
	}

}
