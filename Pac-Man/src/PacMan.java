public class PacMan extends MoveableObject {

	private int score;
	private int lives;
	private Direction queuedDirection;

	public PacMan() {
		super();
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
		
	}

	public void move() {
		// this should be overridden by each individual subclass
	}

}
