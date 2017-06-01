public class Pokey extends Ghost {

	public Pokey(int x, int y, Map map) {
		super(x, y, map, "Pokey.png");
	}
	
	public void move()
	{
		if(getMode() == GhostMode.CHASE && isOutsideRoom())
		{
			chaseMove();
		}
		else if(getMode() == GhostMode.SCATTER && isOutsideRoom())
		{
			scatterMove(30, 2);
		}
		else
		{
			super.move();
		}
	}
	
	public void chaseMove()
	{
		if ((getMap().getDistanceBetween(this, getMap().getPacMan()) > 8) && getMode() == GhostMode.CHASE && isOutsideRoom()) {
			if (isAtIntersection()) {
				Direction newDirection = getDirectionTowardsTarget(getMap().getPacMan()); //wants to get to PacMan
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
		else {
			super.move();
		}
	}

}
