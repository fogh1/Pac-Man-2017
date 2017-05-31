import java.util.*;
import javax.swing.ImageIcon;

public abstract class Ghost extends MovableObject {

	private GhostMode currentMode;//removed static not sure why it was nessacary
	private boolean isOutsideRoom;
	private int frightenedTimer;

	public Ghost(int x, int y, Map map, String iconPath) {
		super(x, y, map, Direction.UP, iconPath);
		isOutsideRoom = false;
		frightenedTimer = 0;
	}

	public GhostMode getMode() {
		return currentMode;
	}

	public void setMode(GhostMode newMode) {
		currentMode = newMode;
		
	}

	public ImageIcon getIcon() {
		if (currentMode == GhostMode.FRIGHTENED) {
			return new ImageIcon(getClassLoader().getResource("FrightenedGhost.png"));
		}
		else {
			return super.getIcon();
		}
	}

	public boolean isOutsideRoom() {
		return isOutsideRoom;
	}
	
	public void setIsOutsideRoom(boolean thing) {
		isOutsideRoom = thing;
	}

	public boolean canMoveOnto(Object object) {
		if (object instanceof Ghost || object instanceof Wall || (object instanceof Door && isOutsideRoom)) {
			return false;
		}
		else {
			return true;
		}
	}

	public boolean canMoveInDirection(Direction direction) {
		Object adjacentObject = getMap().getAdjacentObjectInDirection(this, direction);
		Object adjacentGhostMapObject = getMap().getAdjacentGhostMapObjectInDirection(this, direction);
		return (canMoveOnto(adjacentObject) && canMoveOnto(adjacentGhostMapObject));
	}

	public boolean canMoveInCurrentDirection() {
		return canMoveInDirection(getDirection());
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

	public boolean isAtCorner() {
		if (isAtIntersection()) {
			return false;
		}
		else {
			if ( (canMoveInDirection(Direction.UP) || canMoveInDirection(Direction.DOWN)) && (canMoveInDirection(Direction.LEFT) || canMoveInDirection(Direction.RIGHT))) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	protected Direction determineNewDirection(int targetX, int targetY) {
		if (isAtIntersection()) {
			int xDifference = this.getX() - targetX;
			int yDifference = this.getY() - targetY;
			if (Math.abs(yDifference) > Math.abs(xDifference)) {
				if (yDifference > 0 && this.canMoveInDirection(Direction.UP))
					return Direction.UP;
				if (yDifference <= 0 && this.canMoveInDirection(Direction.DOWN))
					return Direction.DOWN;
				if (xDifference > 0 && this.canMoveInDirection(Direction.LEFT))
					return Direction.LEFT;
				if (this.canMoveInDirection(Direction.RIGHT))
					return Direction.RIGHT;
			}
			else {
				if (xDifference > 0 && this.canMoveInDirection(Direction.LEFT))
					return Direction.LEFT;
				if (xDifference <= 0 && this.canMoveInDirection(Direction.RIGHT))
					return Direction.RIGHT;
				if (yDifference > 0 && this.canMoveInDirection(Direction.UP))
					return Direction.UP;
				if (this.canMoveInDirection(Direction.DOWN))
					return Direction.DOWN;
			}
		}
		return this.getDirection();
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

	public boolean moveForward() {
		if (canMoveInCurrentDirection()) {
			if (getMap().getAdjacentObjectInDirection(this, getDirection()) instanceof Door)
			{
				isOutsideRoom = true;
			}
			int x = getMap().getAdjacentLocation(this)[0];
			int y = getMap().getAdjacentLocation(this)[1];
			getMap().moveGhost(this, x, y);
			return true;
		}
		else {
			return false;
		}
	}


	public void frightenedMove() {
		if (currentMode == GhostMode.FRIGHTENED)
		{
			if (frightenedTimer > 50)
			{
				setMode(GhostMode.CHASE);
				frightenedTimer = 0;
			}
			else
			{
				frightenedTimer++;
			}
			if (frightenedTimer % 2 == 0)
				return;
		}
		if (isAtIntersection()) {
			double randomNumber = Math.random() * 2;
			if (randomNumber < 1) {
				if (!moveForward()) {
					turn();
					moveForward();
				}
			}
			else {
				turn();
				turn();
				turn();
				if (!moveForward()) {
					turn();
					turn();
					moveForward();
				}
			}
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
