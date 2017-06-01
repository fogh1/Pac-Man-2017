public class Speedy extends Ghost {

	public Speedy(int x, int y, Map map) {
		super(x, y, map, "Speedy.png");
	}
	
	public void move() {
		if (getMode() == GhostMode.CHASE && isOutsideRoom()) {
			chaseMove();
		}
		else if(getMode() == GhostMode.SCATTER && isOutsideRoom())
		{
		scatterMove(30,27);
		}
		else {
			super.move();
		}
	}

}
