import java.awt.Image;

import java.awt.*;

public abstract class Ghost extends MovableObject {
	
	public enum GhostMode 
	{
		CHASE, SCATTER, FRIGHTENED
	}

	private static GhostMode currentMode;

	public Ghost(int x, int y, Direction currentDirection, Image ghostImage) 
	{
		super(x, y, currentDirection, ghostImage);
		currentMode = CHASE;
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
