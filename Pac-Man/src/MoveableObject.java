public abstract class MoveableObject {

	private int x;
	private int y;
	private Direction currentDirection;
	private Image image;

	public MoveableObject(int x, int y, Direction direction, Image image) {
		this.x = x;
		this.y = y;
		currentDirection = direction;
		this.image = image;
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

	public Image getImage() {
		return image;
	}

	private boolean canMove() {
		// 
	}

	public boolean move() {
		if (canMove()) {
			// ...
		}
		else {
			return false;
		}
	}
}
