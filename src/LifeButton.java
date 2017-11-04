import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class LifeButton extends JButton implements ActionListener {
	
	private boolean isAlive;
	
	public LifeButton() {
		super("");
		isAlive = false;
		setAlive(isAlive);
		addActionListener(this);
	}
	
	public boolean isAlive() {
		return isAlive;
	}
	
	public void setAlive(boolean alive) {
		isAlive = alive;
		Color currentColor = alive ? Color.black : Color.white;
		setBackground(currentColor);
	}
	
	public void actionPerformed(ActionEvent e) {
		isAlive = !isAlive;
		setAlive(isAlive);
	}

}
