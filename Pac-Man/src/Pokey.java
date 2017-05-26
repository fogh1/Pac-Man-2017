public class Pokey extends Ghost {

	public Pokey(int x, int y, Map map) {
		super(x, y, map, "Pokey.png");
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