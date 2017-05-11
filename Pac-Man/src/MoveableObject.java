
public abstract class MoveableObject {
int x;
int y;
Direction currentDirection;

public MoveableObject()
{
	this.x=0;
	this.y=0;
	this.currentDirection=UP;
}

public int getX()
{
	return x;
}

public int getY()
{
	return y;
}

public Direction getDirection()
{
	return currentDirection;
}

public Direction setDirection(Direction newDirection)
{
	currentDirection = newDirection;
	return currentDirection;
}

private boolean canMove()
{
	
}

public void move()
{
	if(canMove())
	{
		
	}
}
}

