import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class LowerPanel extends JPanel implements ActionListener {

	private Game game;
	private JLabel scoreLabel;
	private JLabel highScoreLabel;

	public LowerPanel(Game game) {
		super(true);
		this.game = game;
		setLayout(new GridLayout(1, 4));
		setBackground(Color.BLACK);
		updateLabels();
	}

	public void updateLabels() {
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
		highScoreLabel = new JLabel("<html>"
			+ "<div style=\"font-family: Courier; text-align: center;\">"
				+ "<p style=\"font-size: 12px; font-style: italic;\">"
					+ "<br>"
					+ "HI-SCORE"
				+ "</p>"
				+ "<p style=\"font-size: 16px\">"
					+ "3460"  // temporary test score
					+ "<br><br>"
				+ "</p>"
			+ "</div>"
		+ "</html>");
		removeAll();
		for (JLabel label : Arrays.asList(scoreLabel, highScoreLabel)) {
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