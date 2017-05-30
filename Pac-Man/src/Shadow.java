public class Shadow extends Ghost {
	
	public Shadow(int x, int y, Map map) {
		super(x, y, map, "Shadow.png");
		super.setIsOutsideRoom(true);
		super.setMode(GhostMode.CHASE);
	}
	public void move()
	{
		if(getMode() == GhostMode.CHASE)
		{
			chaseMove();
		}
		//if(getMode() == GhostMode.SCATTER)
		//{
		//	scatterMove();
		//}
		else
		{
			super.move();
		}
	}
	
	public void chaseMove()
	{
			if (isAtIntersection()) {
				Direction newDirection = determineNewDirection(getMap().getPacMan().getX(), getMap().getPacMan().getY()); //wants to get to PacMan
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