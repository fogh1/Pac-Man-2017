public class Bashful extends Ghost {

	public Bashful(int x, int y, Map map) {
		super(x, y, map, "Bashful.png");
	}

	public void move() {
		if (atIntersection())
		{
			//TODO main AI for ghosts
			double random = Math.random() * 2;
			if (random < 1)
			{
				if (canMoveOn(getMap().getAdjacentObject(this)))
				{
					moveForward();
				}
				else
				{
					turn();
					moveForward();
				}
			}
			else
			{
				turn();
				turn();
				turn();
				if (canMoveOn(getMap().getAdjacentObject(this)))
				{
					moveForward();
				}
				else
				{
					turn();
					turn();
					moveForward();
				}
			}
		}
		else if (atCorner())
		{
			turn();
			if (canMoveOn(getMap().getAdjacentObject(this)))
			{
				moveForward();
			}
			else
			{
				turn();
				turn();
				moveForward();
			}
		}
		else
		{
			moveForward();
		}
	}

}
