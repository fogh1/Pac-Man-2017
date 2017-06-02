public class Speedy extends Ghost {

	public Speedy(int x, int y, Map map) {
		super(x, y, map, "Speedy.png");
	}

	public void move() {
		if (getMode() == GhostMode.CHASE && isOutsideRoom()) {
			chaseMove();
		}
		else if (getMode() == GhostMode.SCATTER && isOutsideRoom()) {
			scatterMove(30, 27);
		}
		else {
			super.move();
		}
	}

	public void chaseMove() {
		PacMan pacMan = getMap().getPacMan();
		int x = pacMan.getX();
		int y = pacMan.getY();
		Direction direction = pacMan.getDirection();
		if (direction == Direction.LEFT && x >= 4) {
			x -= 4;
		}
		else if (direction == Direction.RIGHT && x < 24) {
			x += 4;
		}
		else if (direction == Direction.DOWN && y < 24) {
			y += 4;
		}
		else if (direction == Direction.UP && y >= 4) {
			y -= 4;
		}
		if (isAtIntersection()) {
			Direction newDirection = getDirectionTowardsTarget(pacMan);
			setDirection(newDirection);
			moveForward();
		}
		else if (isAtCorner()) {
			turn();
			if (!moveForward()) {
				turn();
				turn();
				moveForward();
			}
		}
		else {
			if (!moveForward()) {
				turn();
				if (!moveForward()) {
					turn();
					moveForward();
				}
			}
		}
	}

}
