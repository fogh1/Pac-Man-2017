import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyInputHandler implements KeyListener {

	private Game game;

	public KeyInputHandler(Game game) {
		this.game = game;
	}

	public void keyPressed(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_D) {
			// ...
		}
	}

	// we don't need these methods to do anything, but the compiler throws a fit if they aren't in the class
	public void keyTyped(KeyEvent event) {}
	public void keyReleased(KeyEvent event) {}

}