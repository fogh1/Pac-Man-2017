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
	
	public void chaseMove()
	{
		PacMan p = getMap().getPacMan();
		int x = p.getX();
		int y = p.getY();
		Direction pDirection = p.getDirection();
		if(pDirection == Direction.LEFT && x >= 4)
		{
			x=x-4;
		}
		else if(pDirection == Direction.RIGHT && x < 24)
		{
			x=x+4;
		}
		else if(pDirection == Direction.DOWN && y < 24)
		{
			y = y+4;
		}
		else if(pDirection == Direction.UP && y >= 4)
		{
			y = y-4;
		}
		if (isAtIntersection()) {
			Direction newDirection = getDirectionTowardsTarget(x, y); //wants to get to PacMan
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
