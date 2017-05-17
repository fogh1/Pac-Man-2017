import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UI implements ActionListener {

	private Game game;
	private JFrame frame;
	private GamePanel gamePanel;
	private KeyInputHandler keyInputHandler;
	private JButton pauseButton;
	private JButton resetButton;
	private JLabel scoreTitleLabel;
	private JLabel scoreLabel;
	private JLabel highScoreTitleLabel;
	private JLabel highScoreLabel;

	public UI(Game game) {
		this.game = game;
		frame = new JFrame("Pac-Man 2017");
		gamePanel = new GamePanel();
		keyInputHandler = new KeyInputHandler(game);
		setUpFrame();
	}

	private void setUpFrame() {
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout(15, 15));
		contentPane.add(gamePanel, BorderLayout.CENTER);
		frame.addKeyListener(keyInputHandler);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public void repaintPanel() {
		// repaints gamePanel to handle PacMan moving, eating PacDots, et cetera
	}

	public void actionPerformed(ActionEvent event) {
		// handles clicks from the two buttons
	}

	public void remove(Object object) {
		// removes an object (like a PacDot) from the UI
	}

}