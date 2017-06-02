import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {

	private ImageIcon backgroundIcon;

	public GamePanel() {
		super(true);
		ClassLoader classLoader = this.getClass().getClassLoader();
		backgroundIcon = new ImageIcon(classLoader.getResource("Background.png"));
		Dimension dimensions = new Dimension(backgroundIcon.getIconWidth(), backgroundIcon.getIconHeight());
		setPreferredSize(dimensions);
		setMinimumSize(dimensions);
		setMaximumSize(dimensions);
		setSize(dimensions);
		setLayout(null);
	}

	public void paintComponent(Graphics graphics) {
		graphics.drawImage(backgroundIcon.getImage(), 0, 0, null);
	}

}