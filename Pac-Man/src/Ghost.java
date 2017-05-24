//import javax.swing.*;

public abstract class Ghost extends MovableObject {

	private static GhostMode currentMode;
	private Map currentMap;
	private int[][] ghostGrid;

	public Ghost(int x, int y, Map map, Direction direction, String iconPath) {
	    super(x, y, map, direction, iconPath);
	    currentMode = GhostMode.SCATTER;
	    currentMap = map;
	    ghostGrid = new int[31][28];
	    
	}

	public static GhostMode getMode() {
		return currentMode;
	}

	public static void setMode(GhostMode newMode) {
		currentMode = newMode;
	}
	
	public 

}
