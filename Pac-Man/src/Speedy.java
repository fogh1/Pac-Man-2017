public class Speedy extends Ghost {

	public Speedy(int x, int y, Map map) {
		super(x, y, map, "Speedy.png");
	}
	
	public Direction getDirectionTowardsTarget(MovableObject target) {
		Direction PMD = getMap().getPacMan().getQueuedDirection();
		if(PMD == Direction.UP)
		{
			if (isAtIntersection()) {
				int xDifference = this.getX() - target.getX();
				int yDifference = this.getY() - (target.getY() - 4);
				if (Math.abs(yDifference) > Math.abs(xDifference)) {
					if (yDifference > 0 && canMoveInDirection(Direction.UP)) {
						return Direction.UP;
					}
					else if (yDifference <= 0 && canMoveInDirection(Direction.DOWN)) {
						return Direction.DOWN;
					}
					else if (xDifference > 0 && canMoveInDirection(Direction.LEFT)) {
						return Direction.LEFT;
					}
					else if (canMoveInDirection(Direction.RIGHT)) {
						return Direction.RIGHT;
					}
				}
				else {
					if (xDifference > 0 && canMoveInDirection(Direction.LEFT)) {
						return Direction.LEFT;
					}
					else if (xDifference <= 0 && canMoveInDirection(Direction.RIGHT)) {
						return Direction.RIGHT;
					}
					else if (yDifference > 0 && canMoveInDirection(Direction.UP)) {
						return Direction.UP;
					}
					else if (this.canMoveInDirection(Direction.DOWN)) {
						return Direction.DOWN;
					}
				}
			}
		}
		else if(PMD == Direction.DOWN)
		{
			if (isAtIntersection()) {
				int xDifference = this.getX() - target.getX();
				int yDifference = this.getY() - (target.getY() + 4);
				if (Math.abs(yDifference) > Math.abs(xDifference)) {
					if (yDifference > 0 && canMoveInDirection(Direction.UP)) {
						return Direction.UP;
					}
					else if (yDifference <= 0 && canMoveInDirection(Direction.DOWN)) {
						return Direction.DOWN;
					}
					else if (xDifference > 0 && canMoveInDirection(Direction.LEFT)) {
						return Direction.LEFT;
					}
					else if (canMoveInDirection(Direction.RIGHT)) {
						return Direction.RIGHT;
					}
				}
				else {
					if (xDifference > 0 && canMoveInDirection(Direction.LEFT)) {
						return Direction.LEFT;
					}
					else if (xDifference <= 0 && canMoveInDirection(Direction.RIGHT)) {
						return Direction.RIGHT;
					}
					else if (yDifference > 0 && canMoveInDirection(Direction.UP)) {
						return Direction.UP;
					}
					else if (this.canMoveInDirection(Direction.DOWN)) {
						return Direction.DOWN;
					}
				}
			}
		}
		else if(PMD == Direction.LEFT)
		{
			if (isAtIntersection()) {
				int xDifference = this.getX() - (target.getX() - 4);
				int yDifference = this.getY() - target.getY();
				if (Math.abs(yDifference) > Math.abs(xDifference)) {
					if (yDifference > 0 && canMoveInDirection(Direction.UP)) {
						return Direction.UP;
					}
					else if (yDifference <= 0 && canMoveInDirection(Direction.DOWN)) {
						return Direction.DOWN;
					}
					else if (xDifference > 0 && canMoveInDirection(Direction.LEFT)) {
						return Direction.LEFT;
					}
					else if (canMoveInDirection(Direction.RIGHT)) {
						return Direction.RIGHT;
					}
				}
				else {
					if (xDifference > 0 && canMoveInDirection(Direction.LEFT)) {
						return Direction.LEFT;
					}
					else if (xDifference <= 0 && canMoveInDirection(Direction.RIGHT)) {
						return Direction.RIGHT;
					}
					else if (yDifference > 0 && canMoveInDirection(Direction.UP)) {
						return Direction.UP;
					}
					else if (this.canMoveInDirection(Direction.DOWN)) {
						return Direction.DOWN;
					}
				}
			}
		}
		else if(PMD == Direction.RIGHT)
		{
			if (isAtIntersection()) {
				int xDifference = this.getX() - (target.getX() + 4);
				int yDifference = this.getY() - target.getY();
				if (Math.abs(yDifference) > Math.abs(xDifference)) {
					if (yDifference > 0 && canMoveInDirection(Direction.UP)) {
						return Direction.UP;
					}
					else if (yDifference <= 0 && canMoveInDirection(Direction.DOWN)) {
						return Direction.DOWN;
					}
					else if (xDifference > 0 && canMoveInDirection(Direction.LEFT)) {
						return Direction.LEFT;
					}
					else if (canMoveInDirection(Direction.RIGHT)) {
						return Direction.RIGHT;
					}
				}
				else {
					if (xDifference > 0 && canMoveInDirection(Direction.LEFT)) {
						return Direction.LEFT;
					}
					else if (xDifference <= 0 && canMoveInDirection(Direction.RIGHT)) {
						return Direction.RIGHT;
					}
					else if (yDifference > 0 && canMoveInDirection(Direction.UP)) {
						return Direction.UP;
					}
					else if (this.canMoveInDirection(Direction.DOWN)) {
						return Direction.DOWN;
					}
				}
			}
		}
		return this.getDirection();
	}
	
	public void move() {
		if (getMode() == GhostMode.CHASE) {
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
		else {
			super.move();
		}
	}
}
