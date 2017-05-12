public class KeyInputHandler implements KeyListener {

	private Game game;
	private UI ui;

	public KeyInputHandler() {
		// ...
	}

	public void keyTyped(KeyEvent event) {
		// handles arrow key presses
	}

	// we don't need these methods to do anything, but the compiler throws a fit if they aren't in the class
	public void keyPressed(KeyEvent event) {}
	public void keyReleased(KeyEvent event) {}

}
