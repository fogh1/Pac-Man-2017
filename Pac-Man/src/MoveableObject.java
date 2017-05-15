import java.awt.Image;

import java.awt.*;

public abstract class MoveableObject {

	private int x;
	private int y;
	private Direction currentDirection;
	private Image image;
	protected map

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

	public boolean canMove() {
		return false;
		// this should be overridden by each individual subclass
	}

	public void move() {
		// this should be overridden by each individual subclass
	}

}
