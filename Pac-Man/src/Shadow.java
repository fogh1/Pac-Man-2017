public class Shadow extends Ghost {

	public Shadow(int x, int y, Map map) {
		super(x, y, map, "Shadow.png");
		setOutsideRoom(true);
	}

	public void move() {
		if (getMode() == GhostMode.CHASE && isOutsideRoom()) {
			chaseMove();
		}
		else if(getMode() == GhostMode.SCATTER && isOutsideRoom())
		{
		scatterMove(5,1);
		}
		else {
			super.move();
		}
	}

	public void chaseMove() {
		if (isAtIntersection()) {
			Direction newDirection = getDirectionTowardsTarget(getMap().getPacMan());
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
