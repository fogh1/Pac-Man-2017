import javax.swing.ImageIcon;

public abstract class AcquirableObject {

	private int x;
	private int y;
	private int pointValue;
	private ImageIcon icon;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void acquire() {
		// called when a PacMan "eats" the object (plays a sound, removes object from the UI, updates points, et cetera, depending on the type of object)
	}

}