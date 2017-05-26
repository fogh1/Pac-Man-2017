import javax.swing.*;

public class PacMan extends MovableObject {

	private int score;
	private int lives;
	private Direction queuedDirection;

	public PacMan(int x, int y, Map map) {
		super(x, y, map, Direction.RIGHT, "PacManRight.png");
	}

	public ImageIcon getIcon() {
		if (getDirection() == Direction.UP) {
			return new ImageIcon(getClassLoader().getResource("PacManUp.png"));
		}
		else if (getDirection() == Direction.DOWN) {
			return new ImageIcon(getClassLoader().getResource("PacManDown.png"));
		}
		else if (getDirection() == Direction.LEFT) {
			return new ImageIcon(getClassLoader().getResource("PacManLeft.png"));
		}
		else {
			return new ImageIcon(getClassLoader().getResource("PacManRight.png"));
		}
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

	public void loseLife() {
		lives--;
	}

	public boolean canMoveOnto(Object object) {
		if (object instanceof Wall || object instanceof Door) {
			return false;
		}
		else {
			return true;
		}
	}

	public boolean canMoveInCurrentDirection() {
		Object adjacentObject = getMap().getAdjacentObject(this);
		return canMoveOnto(adjacentObject);
	}

	public boolean canMoveInQueuedDirection() {
		if (queuedDirection == null) {
			return false;
		}
		else {
			Object adjacentObject = getMap().getAdjacentObjectInDirection(this, queuedDirection);
			return canMoveOnto(adjacentObject);
		}
	}

	public void move() {
		if (canMoveInQueuedDirection()) {
			setDirection(queuedDirection);
			queuedDirection = null;
		}
		if (canMoveInCurrentDirection()) {
			int x = getMap().getAdjacentLocation(this)[0];
			int y = getMap().getAdjacentLocation(this)[1];
			getMap().move(this, x, y);
		}
	}

}
