import javax.swing.*;

public abstract class AcquirableObject {

	private ClassLoader classLoader;
	private int x;
	private int y;
	private int pointValue;
	private ImageIcon icon;

	public AcquirableObject(int x, int y, int pointValue, String iconPath) {
		classLoader = this.getClass().getClassLoader();
		this.x = x;
		this.y = y;
		this.pointValue = pointValue;
		icon = new ImageIcon(classLoader.getResource(iconPath));
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int newX) {
		x = newX;
	}

	public void setY(int newY) {
		y = newY;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void acquire() {
		// called when a PacMan "eats" the object (plays a sound, removes object from the UI, updates points, et cetera, depending on the type of object)
		// map removes acquirable
		//passes value to map(?) update pac-man score
	}

}