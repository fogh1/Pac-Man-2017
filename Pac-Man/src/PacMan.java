import javax.swing.ImageIcon;

public class PacMan extends MovableObject {

	private int score;
	private int lives;
	private Direction queuedDirection;

	public PacMan() {
		super();
	}

	public PacMan(int x, int y) {
		super(x, y, Direction.RIGHT, "TestPacMan.png");
		score = 0;
		lives = 3;
	}

	public Direction getQueuedDirection() {
		return queuedDirection;
	}

	public void setQueuedDirection(Direction newDirection) {
		queuedDirection = newDirection;
	}

	public int getScore() {
		return score;
	}

	public void increaseScore(int points) {
		score += points;
	}

	public void decreaseScore(int points) {
		score -= points;
	}
	
	public int getLives() {
		return lives;
	}
	
	public boolean canMove() {
		Object thing = currentMap.getAdjancentObject(this);
		if (thing instanceof Wall)
			return false;
		return true;
		// true unless adjacent object is wall or door
	}

	public void move() {
		if (canMove())
		{
			currentMap.
		}
		// ...
	}

}
