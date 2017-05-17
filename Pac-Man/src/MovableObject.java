import javax.swing.ImageIcon;

public abstract class MovableObject {

	private ClassLoader classLoader;
	private int x;
	private int y;
	private Direction currentDirection;
	private ImageIcon icon;

	public MovableObject(int x, int y, Direction direction, String iconPath) {
		classLoader = this.getClass().getClassLoader();
		this.x = x;
		this.y = y;
		currentDirection = direction;
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

	public Direction getDirection() {
		return currentDirection;
	}

	public Direction setDirection(Direction newDirection) {
		currentDirection = newDirection;
		return currentDirection;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public boolean canMove() {
		return false;
		// this should be overridden by each individual subclass
	}

	public void move() {
		// this should be overridden by each individual subclass
	}

}
