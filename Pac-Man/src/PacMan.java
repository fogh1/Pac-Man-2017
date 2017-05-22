import javax.swing.*;

public class PacMan extends MovableObject {

	private int score;
	private int lives;
	private Direction currentDirection;
	private Direction queuedDirection;

	public PacMan()//a temporary contructor to get the testing phases working
	 {
		super();
	}
	public PacMan(int x, int y, Direction direction, Map map)
	{
		super(x, y, Direction.RIGHT, "TestPacMan.png", map);
		currentDirection = direction;
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
		Object thing = currentMap.getAdjacentObject(this);
		if (thing instanceof Wall)
			return false;
		return true;
		// true unless adjacent object is wall or door
	}

	public void move() {
		if (canMove())
		{
			currentMap.move(this, currentMap.getAdjacentLocation(this)[0], currentMap.getAdjacentLocation(this)[1]);
		}
		// ...
	}

}
