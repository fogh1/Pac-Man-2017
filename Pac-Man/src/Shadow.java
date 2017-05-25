public class Shadow extends Ghost {
	
	private int[] prevLoc;

	public Shadow(int x, int y, Map map) {
		super(x, y, map, "Shadow.png");
		prevLoc = new int[2];
		prevLoc[0] = x;
		prevLoc[1] = y;
		outsideRoom = true;
	}

	public void move() {
		int[] prev = prevLoc;
		prevLoc[0] = getX();
		prevLoc[1] = getY();
		if (atIntersection())
		{
			
		}
	}

}