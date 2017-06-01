public class Pokey extends Ghost {

	public Pokey(int x, int y, Map map) {
		super(x, y, map, "Pokey.png");
		super.setMode(GhostMode.CHASE);
	}
	
	public void move() {
		if ((getMap().getDistanceBetween(this, getMap().getPacMan()) > 8) && getMode() == GhostMode.CHASE && isOutsideRoom()) {
			if (isAtIntersection()) {
				Direction newDirection = getDirectionTowardsTarget(getMap().getPacMan()); //wants to get to PacMan
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