import javax.swing.*;

public abstract class AcquirableObject {

	private ClassLoader classLoader;
	private int x;
	private int y;
	private Map map;
	private int pointValue;
	private ImageIcon icon;

	public AcquirableObject(int x, int y, Map map, int pointValue, String iconPath) {
		this.classLoader = this.getClass().getClassLoader();
		this.x = x;
		this.y = y;
		this.map = map;
		this.pointValue = pointValue;
		this.icon = new ImageIcon(classLoader.getResource(iconPath));
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Map getMap() {
		return map;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void acquire() {
		if (map.getPacMan() != null)
		{
		map.getPacMan().increaseScore(pointValue);
		}
	}

}
