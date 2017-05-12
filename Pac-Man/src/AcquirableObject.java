public abstract class AcquirableObject {

	private int x;
	private int y;
	private int pointValue;
	private Image image;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImage() {
		return image;
	}

	public void acquire() {
		// called when a PacMan "eats" the object (plays a sound, removes object from the UI, updates points, et cetera, depending on the type of object)
	}

}
