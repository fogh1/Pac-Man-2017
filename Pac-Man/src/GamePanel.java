import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel {

    private ImageIcon backgroundIcon;

    public GamePanel() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        backgroundIcon = new ImageIcon(classLoader.getResource("TestBackground.png"));
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