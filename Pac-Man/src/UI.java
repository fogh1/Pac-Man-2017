import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

import javax.swing.event.*;

public class UI implements ActionListener, KeyListener
{
	private JFrame frame;
	private Container window;
	private JPanel gamePanel;
	private JButton pauseButton;
	private JButton resetButton;
	private JLabel scoreLabel;
	private JLabel highScoreLabel;
	private JLabel scoreTitleLabel;
	private JLabel highScoreTitleLabel;
	
	public UI()
	{
		frame = new JFrame();
		frame.setVisible(true);
		window = frame.getContentPane();
		window.setLayout(new BorderLayout());
		 
	}
	
	public void keyPressed(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	
	
	public void keyTyped(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	
	public void remove(Object obj)
	{
		//...
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
