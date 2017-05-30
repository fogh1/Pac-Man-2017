import java.util.*;

public abstract class Ghost extends MovableObject {

	private static GhostMode currentMode;
	private boolean isOutsideRoom;

	public Ghost(int x, int y, Map map, String iconPath) {
		super(x, y, map, Direction.UP, iconPath);
		isOutsideRoom = false;
	}

	public static GhostMode getMode() {
		return currentMode;
	}

	public static void setMode(GhostMode newMode) {
		currentMode = newMode;
	}

	public boolean isOutsideRoom() {
		return isOutsideRoom;
	}

	public boolean canMoveOnto(Object object) {
		if (object instanceof Wall || (object instanceof Door && isOutsideRoom)) {
			return false;
		}
		else {
			return true;
		}
	}

	public boolean canMoveInDirection(Direction direction) {
		Object adjacentObject = getMap().getAdjacentObjectInDirection(this, direction);
		return canMoveOnto(adjacentObject);
	}

	public boolean canMoveInCurrentDirection() {
		Object adjacentObject = getMap().getAdjacentObject(this);
		return canMoveOnto(adjacentObject);
	}

	public boolean isAtIntersection() {
		int blockedSideCount = 0;
		for (Direction direction : Arrays.asList(Direction.UP, Direction.DOWN, Direction.LEFT, Direction.RIGHT)) {
			Object adjacentObject = getMap().getAdjacentObjectInDirection(this, direction);
			if (canMoveOnto(adjacentObject)) {
				blockedSideCount++;
			}
		}
		return (blockedSideCount > 2);
	}
		
	protected Direction determineNewDirection(int targetX, int targetY) {
		if (isAtIntersection()) {
			int xDifference = this.getX() - targetX;
			int yDifference = this.getY() - targetY;
			if (Math.abs(xDifference) > Math.abs(yDifference)) {
				if (xDifference > 0 && this.canMoveInDirection(Direction.UP)) {
					return Direction.UP;
				}
				else {
					if (this.canMoveInDirection(Direction.DOWN))
					return Direction.DOWN;
				}
			}
			else {
				if (yDifference > 0 && this.canMoveInDirection(Direction.RIGHT)) {
					return Direction.RIGHT;
				}
				else {
					if (this.canMoveInDirection(Direction.LEFT))
					return Direction.LEFT;
				}
			}
		}
		return this.getDirection();
	}

	public boolean isAtCorner() {
		if (isAtIntersection()) {
			return false;
		}
		else {
			if ((canMoveInDirection(Direction.UP) || canMoveInDirection(Direction.DOWN)) && (canMoveInDirection(Direction.LEFT) || canMoveInDirection(Direction.RIGHT))) {
				return true;
			}
			else {
				return false;
			}
		}
	}

	public void turn() {
		// turns clockwise
		if (getDirection() == Direction.UP) {
			setDirection(Direction.RIGHT);
		}
		else if (getDirection() == Direction.DOWN) {
			setDirection(Direction.LEFT);
		}
		else if (getDirection() == Direction.LEFT) {
			setDirection(Direction.UP);
		}
		else {
			setDirection(Direction.DOWN);
		}
	}

	public void moveForward() {
		int x = getMap().getAdjacentLocation(this)[0];
		int y = getMap().getAdjacentLocation(this)[1];
		getMap().move(this, x, y);
	}

	public void move() {
		if (isAtIntersection()) {
			double randomNumber = Math.random() * 2;
			if (randomNumber < 1) {
				if (canMoveInCurrentDirection()) {
					moveForward();
				}
				else {
					turn();
					moveForward();
				}
			}
			else {
				turn();
				turn();
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
