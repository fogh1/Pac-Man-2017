import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel {

    private ImageIcon backgroundIcon;
    private Image backgroundImage;

    public GamePanel() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        backgroundIcon = new ImageIcon(classLoader.getResource("Background.png"));
        backgroundImage = backgroundIcon.getImage();
        Dimension dimensions = new Dimension(backgroundImage.getWidth(null), backgroundImage.getHeight(null));
        setPreferredSize(dimensions);
        setMinimumSize(dimensions);
        setMaximumSize(dimensions);
        setSize(dimensions);
        setLayout(null);
    }

    public void paintComponent(Graphics graphics) {
        graphics.drawImage(backgroundImage, 0, 0, null);
    }

}