import java.awt.Image;



public class Speedy extends Ghost {
	
	public Speedy() //can we keep the constructors without parameters for simplicity, unless we need to, location is stored in the map class, and direction should be a parameter i guess.
	{
		super();
	public Speedy(int x, int y, Direction currentDirection) {
		super(x, y, Direction.UP, "Speedy.png");
	}

	public static void getMove() { 
		int projectedX = 0;
		int projectedY = 0;
		// get Pac-Man location in terms of x and y
		// get Pac-Man direction in terms of Direction Enum
		// switch(Pac-man direction) {
		// case UP: projectedY-=4; if(projectedY <= 0){projectedY = 1;} check if projectedX and projectedY is valid location, or add 1 to projectedY (need some subsitute)
		// case DOWN: projectedY+=4; if(projectedY >= max map y){projectedY = max map y-1;} check if projectedX and projectedY is valid location, or add 1 to projectedY (need some subsitute)
		// case LEFT: projectedX-=4; if(projectedX <= 0){projectedX = 1;} check if projectedX and projectedY is valid location, or add 1 to projectedY (need some subsitute)
		// case RIGHT: projectedX+=4; if(projectedX >= max map x){projectedX = max map x-1;} check if projectedX and projectedY is valid location, or add 1 to projectedY (need some subsitute)
	}

}