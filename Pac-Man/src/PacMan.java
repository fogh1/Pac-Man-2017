import javax.swing.ImageIcon;

public class PacMan extends MovableObject {

	private int score;
	private int lives;
	private Direction queuedDirection;

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
		return true;  // temporary
		// true unless adjacent object is wall or door
	}

	public void move() {
		// ...
	}

}
