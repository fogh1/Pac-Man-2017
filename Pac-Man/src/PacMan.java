import javax.swing.*;

public class PacMan extends MovableObject {

	private int score;
	private int lives;
	private Direction queuedDirection;

	public PacMan(int x, int y, Map map) {
		super(x, y, map, Direction.RIGHT, "PacManRight.png");
	}	
	
	public Direction setDirection(Direction newDirection)
	{
		if(newDirection == Direction.UP)
		{
			icon = new ImageIcon(classLoader.getResource("PacManUp.png"));
		}
		else if(newDirection == Direction.DOWN)
		{
			icon = new ImageIcon(classLoader.getResource("PacManDown.png"));
		}
		else if(newDirection == Direction.LEFT)
		{
			icon = new ImageIcon(classLoader.getResource("PacManLeft.png"));
		}
		else
		{
			icon = new ImageIcon(classLoader.getResource("PacManRight.png"));
		}
		return super.setDirection(newDirection);
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

	public boolean canMove() {
		Object adjacentObject = getMap().getAdjacentObject(this);
		if (adjacentObject instanceof Wall) {
			return false;
		}
		else {
			return true;
		}
		// true unless adjacent object is wall or door
	}

	public void move() {
		if (canMove()) {
			int x = getMap().getAdjacentLocation(this)[0];
			int y = getMap().getAdjacentLocation(this)[1];
			getMap().move(this, x, y);
		}
	}

}
