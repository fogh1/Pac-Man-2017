public class Bashful extends Ghost {

	public Bashful(int x, int y, Map map) {
		super(x, y, map, "Bashful.png");
	}
	
	public void move() {
		if (getMode() == GhostMode.CHASE && isOutsideRoom()) {
			chaseMove();
		}
		else if(getMode() == GhostMode.SCATTER && isOutsideRoom())
		{
		scatterMove(1,30);
		}
		else {
			super.move();
		}
	}

}
