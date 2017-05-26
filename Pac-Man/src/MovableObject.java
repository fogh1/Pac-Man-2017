import javax.swing.*;

public abstract class MovableObject {

	private ClassLoader classLoader;
	private int x;
	private int y;
	private Map map;
	private Direction direction;
	private ImageIcon icon;

	public MovableObject(int x, int y, Map map, Direction direction, String iconPath) {
		this.classLoader = this.getClass().getClassLoader();
		this.x = x;
		this.y = y;
		this.map = map;
		this.direction = direction;
		this.icon = new ImageIcon(classLoader.getResource(iconPath));
	}

	public ClassLoader getClassLoader() {
		return classLoader;
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

	public Map getMap() {
		return map;
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

	public void move() {
		// this should be overridden by each individual subclass
	}

}
