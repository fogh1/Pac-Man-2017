import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UI implements ActionListener {

	private Game game;
	private Map map;
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
		this.map = game.getMap();
		this.frame = new JFrame("Pac-Man 2017");
		this.gamePanel = new GamePanel();
		this.keyInputHandler = new KeyInputHandler(game.getMap());
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUpFrame();
	}

	private void setUpFrame() {
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout(15, 15));
		contentPane.add(gamePanel, BorderLayout.CENTER);
		frame.addKeyListener(keyInputHandler);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			int xAsPixels = (gridScale * movableObject.getX());
			int yAsPixels = (gridScale * movableObject.getY());
			label.setBounds(xAsPixels, yAsPixels, icon.getIconWidth(), icon.getIconHeight());
			gamePanel.add(label);
		}
		else if (object instanceof AcquirableObject) {
			AcquirableObject acquirableObject = (AcquirableObject) object;
			ImageIcon icon = acquirableObject.getIcon();
			JLabel label = new JLabel(icon);
			int xAsPixels = (gridScale * acquirableObject.getX());
			int yAsPixels = (gridScale * acquirableObject.getY());
			label.setBounds(xAsPixels, yAsPixels, icon.getIconWidth(), icon.getIconHeight());
			gamePanel.add(label);
		}
	}

	public void repaintPanel() {
		// repaints gamePanel to handle PacMan moving, eating PacDots, et cetera
		gamePanel.removeAll();
		addToPanel(map.getPacMan());
		for (int row = 0; row < 28; row++) {
			for (int column = 0; column < 31; column++) {
				Object object = map.getObjectAt(row, column);
				if (object instanceof PacDot || object instanceof PowerPellet) {
					addToPanel(object);
				}
			}
		}
		gamePanel.repaint();
	}

	public void actionPerformed(ActionEvent event) {
		// handles clicks from the two buttons
	}

}
