public class Shadow extends Ghost {
	
	public Shadow(int x, int y, Map map) {
		super(x, y, map, "Shadow.png");
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
				if (canMoveInCurrentDirection()) {
					moveForward();
				}
				else {
					turn();
					turn();
					moveForward();
				}
			}
			else {
				moveForward();
			}
	}

}