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
		// ...
	}

	public void start() {
		// starts or restarts the game
	}

	public boolean togglePause() {
		isPaused = !isPaused;
		return isPaused;
		// pauses or unpauses the game
	}

	public boolean isPaused() {
		return isPaused;
	}

	public void gameLoop() {
		// performs tasks like updating the model and UI on set intervals (controlled by the Timer)
	}

}
