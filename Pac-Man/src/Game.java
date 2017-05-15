import java.util.*;

public class Game {

	private Timer timer;
	private Map map;
	private UI ui;
	private PacMan pacMan;
	private Shadow shadow;
	private Speedy speedy;
	private Bashful bashful;
	private Pokey pokey;
	private boolean isPaused;
	private int[] highScores;
	private String[] highScorers;

	public Game() {
		timer = new Timer();
		timer.schedule(gameLoop(), 1000);
		ui = new UI(this);  // UI is responsible for displaying a JFrame and interpreting the map to display the game properly
		resetMap();  // constructs map and initializes related instance variables
		highScores = new int[3];
		highScorers = new String[3];
	}

	private void resetMap() {
		map = new Map();  // the Map class constructor is responsible for constructing all objects present on the map (ie. pacman, pacdots, walls, ghosts)
		pacMan = map.getPacMan();
		shadow = map.getShadow();
		speedy = map.getSpeedy();
		bashful = map.getBashful();
		pokey = map.getPokey();
	}

	public void start() {
		togglePause();
		resetMap();
		// ...
		togglePause();
	}

	public boolean togglePause() {
		isPaused = !isPaused;
		return isPaused;
		// pauses or unpauses the game
	}

	public boolean isPaused() {
		return isPaused;
	}

	public TimerTask gameLoop() {
		// performs tasks like updating the model and UI on set intervals (controlled by the Timer)
		return new TimerTask() {
			public void run() {
				// input all periodic tasks per tick
				if (isPaused) {
					// ui.displayPaused();  // TODO write method in UI class to display a "paused" screen if the method is called
					return;
				}
			}
		};
	}

}