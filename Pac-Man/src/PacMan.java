import javax.swing.ImageIcon;

public class PacMan extends MovableObject {

	private int score;
	private int lives;
	private Direction queuedDirection;

	public PacMan(int x, int y, Direction direction, ImageIcon icon, Map thisMap) {
	    super(x, y, direction, icon, thisMap);
		score = 0;
		lives = 3;
		setDirection(Direction.RIGHT);
	}

	public Direction getQueuedDirection() {
		return queuedDirection;  // we could use final constants rather than enums if we can't get this to compile
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
		return true;  // temporary
		// ...
	}

	public void move() {
		// ...
	}

}
