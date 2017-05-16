import javax.swing.ImageIcon;

public abstract class MovableObject {

	private int x;
	private int y;
	private Direction currentDirection;
	private ImageIcon icon;

	public MovableObject(int x, int y, Direction direction, ImageIcon icon) {
		this.x = x;
		this.y = y;
		currentDirection = direction;
		this.icon = icon;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
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
