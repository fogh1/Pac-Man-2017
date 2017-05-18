import javax.swing.*;

public abstract class MovableObject {

	private ClassLoader classLoader;
	private int x;
	private int y;
	private Direction direction;
	private ImageIcon icon;
	
	//TEMP
	public MovableObject()
	{
		
	}
	//TEMP

	public MovableObject(int x, int y, Direction direction, String iconPath) {
		classLoader = this.getClass().getClassLoader();
		this.x = x;
		this.y = y;
		this.direction = direction;
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
		return direction;
	}

	public Direction setDirection(Direction newDirection) {
		direction = newDirection;
		return direction;
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
