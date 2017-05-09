
public class PacMan extends MoveableObject
{
	protected int score;
	protected int lives;
	protected Direction queuedDirection;
	public PacMan()
	{
		public Direction getQueuedDirection ()
		{
			return queuedDirection;    //we could use final constants rather than enums if we can't get this to compile
		}
		
		public void setQueuedDirection(Direction g)
		{
			queuedDirection = g;
		}
	}
	
}
