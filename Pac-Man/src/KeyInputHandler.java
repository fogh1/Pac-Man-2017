import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyInputHandler implements KeyListener {

	private Map map;

	public KeyInputHandler(Map map) {
		this.map = map;
	}

	public void keyPressed(KeyEvent event) {
		PacMan pacMan = map.getPacMan();
		if (event.getKeyCode() == KeyEvent.VK_LEFT) {
			pacMan.setDirection(Direction.LEFT);
		}
		else if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
			pacMan.setDirection(Direction.RIGHT);
		}
		else if (event.getKeyCode() == KeyEvent.VK_UP) {
			pacMan.setDirection(Direction.UP);
		}
		else if (event.getKeyCode() == KeyEvent.VK_DOWN) {
			pacMan.setDirection(Direction.DOWN);
		}
	}

	// we don't need these methods to do anything, but the compiler throws a fit if they aren't in the class
	public void keyTyped(KeyEvent event) {}
	public void keyReleased(KeyEvent event) {}

}