public class PacMan extends MoveableObject {

	protected int score;
	protected int lives;
	protected Direction queuedDirection;

	public PacMan() {
		score = 0;
		lives = 3;
		Direction = UP;
	};

	public Direction getQueuedDirection() {
		return queuedDirection;    // we could use final constants rather than enums if we can't get this to compile
	}

	public void setQueuedDirection(Direction newDirection) {
		queuedDirection = newDirection;
	}

}
