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
		isPaused = true;  //pauses game to prevent any grid action during grid setup
		timer = new Timer();
		timer.scheduleAtFixedRate(gameLoop(), 125, 125);
		map = new Map(this);  // the map class constructor is responsible for constructing all objects present on the map (ie. pacman, pacdots, walls, ghosts)
		ui = new UI(this);  // UI is responsible for displaying a JFrame and interpreting the map to dipslay the game properly
		pacMan = map.getPacMan();
		shadow = map.getShadow();
		speedy = map.getSpeedy();
		bashful = map.getBashful();
		pokey = map.getPokey();
		highScores = new int[100];
		highScorers = new String[100];
		togglePause();
		start();
	}

	public Map getMap() {
		return map;
	}

	public boolean togglePause() {
		isPaused = !isPaused;
		return isPaused;
		// pauses or unpauses the game
	}

	public boolean isPaused() {
		return isPaused;
	}

	public void start() {
		// starts or restarts the game
		togglePause();  // pauses game to prevent any grid action during grid setup
		map = new Map();  // reconstructs new map for new game, then reassigns all instance variables pointing to grid objects
		pacMan = map.getPacMan();
		shadow = map.getShadow();
		speedy = map.getSpeedy();
		bashful = map.getBashful();
		pokey = map.getPokey();
		togglePause();
	}

	public TimerTask gameLoop() {
		// performs tasks like updating the model and UI on set intervals (controlled by the Timer)
		return new TimerTask() {
			public void run() {
				if (pacMan.canMove()) {
					pacMan.move();
				}
				ui.repaintPanel();
			}
		};
	}
	
	public Map getMap()
	{
		return map;
	}

}
