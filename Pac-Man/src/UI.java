import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UI implements ActionListener {

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
		gamePanel = new GamePanel();
        frame = new JFrame("Pac-Man 2017");
        setUpFrame();
	}

	private void setUpFrame() {
		Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout(15, 15));
        contentPane.add(gamePanel, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		// handles clicks from the two buttons
	}
	
	public void remove(Object object) {
		// removes an object (like a PacDot) from the UI
	}

}
