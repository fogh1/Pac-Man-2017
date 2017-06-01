import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LowerPanel extends JPanel implements ActionListener {

	private Game game;
	private JLabel livesLabel;
	private JLabel scoreLabel;
	private JLabel pauseLabel;

	public LowerPanel(Game game) {
		super(true);
		this.game = game;
		setLayout(new GridLayout(1, 4));
		setBackground(Color.BLACK);
		updateLabels();
	}

	public void updateLabels() {
		livesLabel = new JLabel("<html>"
			+ "<div style=\"font-family: Courier; text-align: center;\">"
				+ "<p style=\"font-size: 12px; font-style: italic;\">"
					+ "<br>"
					+ "LIVES"
				+ "</p>"
				+ "<p style=\"font-size: 16px\">"
					+ game.getMap().getPacMan().getLives()
					+ "<br><br>"
				+ "</p>"
			+ "</div>"
		+ "</html>");
		scoreLabel = new JLabel("<html>"
			+ "<div style=\"font-family: Courier; text-align: center;\">"
				+ "<p style=\"font-size: 12px; font-style: italic;\">"
					+ "<br>"
					+ "SCORE"
				+ "</p>"
				+ "<p style=\"font-size: 16px\">"
					+ game.getMap().getPacMan().getScore()
					+ "<br><br>"
				+ "</p>"
			+ "</div>"
		+ "</html>");
		pauseLabel = new JLabel("<html>"
				+ "<div style=\"font-family: Courier; text-align: center;\">"
					+ "<p style=\"font-size: 11px;\">"
						+ "PRESS "
						+ "<span style=\"font-size: 16px; font-style: normal; color: rgb(0, 255, 216);\">"
							+ "P"
						+ "</span>"
						+ " TO"
						+ "<br>"
						+ "TOGGLE PAUSE"
						+ "<br><br>"
					+ "</p>"
				+ "</div>"
			+ "</html>");
		removeAll();
		for (JLabel label : Arrays.asList(livesLabel, scoreLabel, pauseLabel)) {
			label.setForeground(Color.WHITE);
			label.setHorizontalAlignment(JLabel.CENTER);
			add(label);
		}
		revalidate();
	}

	public void actionPerformed(ActionEvent event) {
		// handles clicks from the two buttons
	}

}
