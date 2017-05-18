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
		keyInputHandler = new KeyInputHandler(game.getMap());
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

	private void addToPanel(Object object) {
		int gridScale = 25;
		if (object instanceof MovableObject) {
			MovableObject movableObject = (MovableObject) object;
			ImageIcon icon = movableObject.getIcon();
			JLabel label = new JLabel(icon);
			int x = (gridScale * movableObject.getX()) + (gridScale / 2);
			int y = (gridScale * movableObject.getY());
			label.setBounds(x, y, icon.getIconWidth(), icon.getIconHeight());
			gamePanel.add(label);
		}
		else if (object instanceof AcquirableObject) {
			AcquirableObject acquirableObject = (AcquirableObject) object;
			ImageIcon icon = acquirableObject.getIcon();
			JLabel label = new JLabel(icon);
			int x = (gridScale * acquirableObject.getX()) + (gridScale / 2);
			int y = (gridScale * acquirableObject.getY());
			label.setBounds(x, y, icon.getIconWidth(), icon.getIconHeight());
			gamePanel.add(label);
		}
	}

	public void repaintPanel() {
		// repaints gamePanel to handle PacMan moving, eating PacDots, et cetera
		gamePanel.removeAll();
		addToPanel(game.getMap().getPacMan());
		gamePanel.revalidate();
		gamePanel.repaint();
	}

	public void actionPerformed(ActionEvent event) {
		// handles clicks from the two buttons
	}

}