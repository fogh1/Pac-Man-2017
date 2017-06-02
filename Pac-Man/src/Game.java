import java.util.*;
import java.util.Timer;

public class Game {

	private Timer timer;
	private Map map;
	private UI ui;
	private PacMan pacMan;
	private boolean isPaused;

	public Game() {
		isPaused = false;
		createMap();
		ui = new UI(this);
		timer = new Timer();
		timer.scheduleAtFixedRate(gameLoop(), 125, 125);
	}

	public Map getMap() {
		return map;
	}

	public void createMap() {
		// starts or restarts the game
		togglePause(); // pauses game to prevent any grid action during grid setup
		map = new Map(); // reconstructs new map for new game, then reassigns all instance variables pointing to grid objects
		pacMan = map.getPacMan();
		togglePause();
	}

	public boolean isPaused() {
		return isPaused;
	}

	public boolean togglePause() {
		isPaused = !isPaused;
		return isPaused;
		// pauses or unpauses the game
	}

	public TimerTask gameLoop() {
		// performs tasks like updating the model and UI on set intervals
		// (controlled by the Timer)
		return new TimerTask() {
			public void run() {
				if (!isPaused()) {
					if (map.getAcquirableObjectCount() <= 0) {
						togglePause();
						ui.showEndOfGamePrompt("You win!");
					}
					else if (map.getPacMan() != null && map.getPacMan().getLives() <= 0) {
						togglePause();
						ui.showEndOfGamePrompt("Game over!");
					}
					else {
						for (Ghost ghost : map.getGhostList()) {
							ghost.move();
						}
						pacMan.move();
					}
					ui.repaintPanels();
				}
			}
		};
	}

}
