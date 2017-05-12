import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
	private static JFrame frame;
	private static GamePanel gamePanel;

	public static void setUpFrame() {
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout(15, 15));
		contentPane.add(gamePanel, BorderLayout.CENTER);
		frame.addKeyListener(new KeyInputHandler());
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		gamePanel = new GamePanel();
		frame = new JFrame("Pac-Man 2017");
		setUpFrame();
	}

}