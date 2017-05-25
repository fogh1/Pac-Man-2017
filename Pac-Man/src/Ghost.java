public abstract class Ghost extends MovableObject {

	private static GhostMode currentMode;
	protected boolean outsideRoom;

	public Ghost(int x, int y, Map map, String iconPath) {
	    super(x, y, map, Direction.UP, iconPath);
	    outsideRoom = false;
	}

	public static GhostMode getMode() {
		return currentMode;
	}

	public static void setMode(GhostMode newMode) {
		currentMode = newMode;
	}

	public void move() {
		// this probably needs to be overridden by each subclass
	}
	
	protected boolean atIntersection()
	{
		int counter = 0;
		Direction facing = getDirection();
		setDirection(Direction.DOWN);
		if (canMoveOn(getMap().getAdjacentObject(this)))
		{
			counter++;
		}
		setDirection(Direction.UP);
		if (canMoveOn(getMap().getAdjacentObject(this)))
		{
			counter++;
		}
		setDirection(Direction.RIGHT);
		if (canMoveOn(getMap().getAdjacentObject(this)))
		{
			counter++;
		}
		setDirection(Direction.LEFT);
		if (canMoveOn(getMap().getAdjacentObject(this)))
		{
			counter++;
		}
		setDirection(facing);
		if (counter > 2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	protected boolean canMoveOn(Object object)
	{
		if (object instanceof Wall||(object instanceof Door&&outsideRoom))
		{
			return false;
		}
		else
		{
			return true;
		}
	}

}
