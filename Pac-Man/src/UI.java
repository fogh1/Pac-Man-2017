import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class UI implements ActionListener, KeyListener {

	private Game game;
	private JFrame frame;
	private GamePanel gamePanel;  // the GamePanel class is not in the project now, but it has been created already
	private JButton pauseButton;
	private JButton resetButton;
	private JLabel scoreTitleLabel;
	private JLabel scoreLabel;
	private JLabel highScoreTitleLabel;
	private JLabel highScoreLabel;
	private KeyInputHandler keyInputHandler;

	public UI() {
		// ...
	}

	public void setUpFrame() {
		// creates the frame and fills it with components
	}

	public void actionPerformed(ActionEvent event) {
		// handles clicks from the two buttons
	}
	
	public void remove(Object object) {
		// removes an object (like a PacDot) from the UI
	}

}
