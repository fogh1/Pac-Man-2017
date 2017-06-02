import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UI  {

	private Game game;
	private Map map;
	private JFrame frame;
	private GamePanel gamePanel;
	private LowerPanel lowerPanel;
	private KeyInputHandler keyInputHandler;

	public UI(Game game) {
		this.game = game;
		this.map = game.getMap();
		this.frame = new JFrame("Pac-Man 2017");
		this.gamePanel = new GamePanel();
		this.lowerPanel = new LowerPanel(game);
		this.keyInputHandler = new KeyInputHandler(game);
		setUpFrame();
	}

	private void setUpFrame() {
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.BLACK);
		contentPane.add(gamePanel, BorderLayout.CENTER);
		contentPane.add(lowerPanel, BorderLayout.SOUTH);
		frame.addKeyListener(keyInputHandler);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

	public void repaintPanels() {
		gamePanel.removeAll();
		addToPanel(map.getPacMan());
		for (Ghost ghost: map.getGhostList()) {
			addToPanel(ghost);
		}
		for (int row = 0; row < 28; row++) {
			for (int column = 0; column < 31; column++) {
				Object object = map.getObjectAt(row, column);
				if (!(object instanceof PacMan || object instanceof Ghost)) {
					addToPanel(object);
				}
			}
		}
		gamePanel.repaint();
		lowerPanel.updateLabels();
	}

	public void closeFrame() {
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}

}
