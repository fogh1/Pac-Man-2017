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
		isPaused = true;//pauses game to prevent any grid action during grid setup
		timer = new Timer();
		timer.scheduleAtFixedRate(gameLoop(), 500, 500);
		map = new Map();  // the map class constructor is responsible for constructing all objects present on the map (ie. pacman, pacdots, walls, ghosts)
		ui = new UI();  // UI is responsible for displaying a JFrame and interpreting the map to dipslay the game properly
		pacMan = map.getPacMan();  // TODO write get Pac Man method in map class to return constructed Pac Man
		shadow = map.getShadow();  // TODO write get Shadow method like the getPacMan method
		speedy = map.getSpeedy();  // TODO write get Speedy method like the getPacMan method
		bashful = map.getBashful();  // TODO write get Bashful method like the getPacMan method
		pokey = map.getPokey();  // TODO write getPokey method like the getPacMan method
		highScores = new int[100];
		highScorers = new String[100];
		togglePause();
		start();
	}

	public void start() {
		// starts or restarts the game
		togglePause();//pauses game to prevent any grid action during grid setup
		map = new Map();//reconstructs new map for new game, then reassigns all instance variables pointing to grid objects
		pacMan = map.getPacMan();
		shadow = map.getShadow();
		speedy = map.getSpeedy();
		bashful = map.getBashful();
		pokey = map.getPokey();
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
					ui.displayPaused();  // TODO write method in UI class to display a "paused" screen if the method is called
					return;
				}
				
			}
		};
	}

}