import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GameOfLife extends JFrame implements ActionListener {
	
	private final int PANEL_SIZE = 10;
	private final String RESET_BUTTON_TEXT = "Reset";
	private final String STEP_BUTTON_TEXT = "Step";
	private final String RAND_BUTTON_TEXT = "Rand"; 
	private LifePanel lifePanel;
	private JButton reset;
	private JButton step;
	private JButton rand;
	
	public GameOfLife() {
		setLayout(new FlowLayout());
		
		lifePanel = new LifePanel(PANEL_SIZE);
		reset = new JButton(RESET_BUTTON_TEXT);
		step = new JButton(STEP_BUTTON_TEXT);
		rand = new JButton(RAND_BUTTON_TEXT);
		
		reset.addActionListener(this);
		step.addActionListener(this);
		rand.addActionListener(this);
		
		add(reset);
		add(step);
		add(rand);
		add(lifePanel);
		
		setSize(500, 200);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == reset) resetClickedHandler();
		if (e.getSource() == step) stepClickedHandler();
		if (e.getSource() == rand) randClickedHandler();
	}
	
	private void resetClickedHandler() {
		for (int i = 0; i < PANEL_SIZE; i++)
			for (int j = 0; j < PANEL_SIZE; j++) {
				lifePanel.cells[i][j].setAlive(false);
			}
	}
	
	private void stepClickedHandler() {
		LifeButton[][] cells = lifePanel.cells;
		for (int i = 0; i < PANEL_SIZE; i++)
			for (int j = 0; j < PANEL_SIZE; j++) {
					int aliveNeighbourCount = lifePanel.getAliveNeighbourCount(i, j);
					performStep(cells[i][j], aliveNeighbourCount);
			}
	}
	
	private void randClickedHandler() {
		for (int i = 0; i < PANEL_SIZE; i++)
			for (int j = 0; j < PANEL_SIZE; j++) {
				double randomNumber = Math.random();
				if (randomNumber <= 0.75) {
					lifePanel.cells[i][j].setAlive(false);
				} else {
					lifePanel.cells[i][j].setAlive(true);
				}
			}
	}
	
	private void performStep(LifeButton cell, int aliveNeighbourCount) {
		if (aliveNeighbourCount < 2 || aliveNeighbourCount > 3) cell.setAlive(false);
		if (aliveNeighbourCount == 3) cell.setAlive(true);
	}
	
	public static void main(String[] args) {
		new GameOfLife();
	}
}
