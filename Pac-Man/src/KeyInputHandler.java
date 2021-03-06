import java.awt.event.*;

public class KeyInputHandler implements KeyListener {

	private Game game;

	public KeyInputHandler(Game game) {
		this.game = game;
	}

	public void keyPressed(KeyEvent event) {
		if (!game.isPaused()) {
			PacMan pacMan = game.getMap().getPacMan();
			if (event.getKeyCode() == KeyEvent.VK_LEFT) {
				pacMan.setQueuedDirection(Direction.LEFT);
			}
			else if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
				pacMan.setQueuedDirection(Direction.RIGHT);
			}
			else if (event.getKeyCode() == KeyEvent.VK_UP) {
				pacMan.setQueuedDirection(Direction.UP);
			}
			else if (event.getKeyCode() == KeyEvent.VK_DOWN) {
				pacMan.setQueuedDirection(Direction.DOWN);
			}
		}
		if (event.getKeyCode() == KeyEvent.VK_P) {
			game.togglePause();
		}
	}

	// we don't need these methods to do anything, but the compiler throws a fit if they aren't in the class
	public void keyTyped(KeyEvent event) {}
	public void keyReleased(KeyEvent event) {}

}