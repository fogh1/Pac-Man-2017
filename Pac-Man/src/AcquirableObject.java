import javax.swing.*;

public abstract class AcquirableObject {

	private ClassLoader classLoader;
	private int x;
	private int y;
	private int pointValue;
	private ImageIcon icon;

	public AcquirableObject(int x, int y, int pointValue, String iconPath) {
		this.classLoader = this.getClass().getClassLoader();
		this.x = x;
		this.y = y;
		this.pointValue = pointValue;
		this.icon = new ImageIcon(classLoader.getResource(iconPath));
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public int acquire() {		
		// called when a PacMan "eats" the object (plays a sound, removes object from the UI, updates points, et cetera, depending on the type of object)
		// Map removes acquirable
		return pointValue;
	}

}
