import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class LifePanel extends JPanel {
	
	private int size;
	public LifeButton[][] cells;
	
	public LifePanel(int panelSize) {
		size = panelSize;
		GridLayout panelLayout = new GridLayout(size, size);
		setLayout(panelLayout);
		initializeCells();
	}
	
	private void initializeCells() {
		cells = new LifeButton[size][size];
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++) {
				cells[i][j] = new LifeButton();
				add(cells[i][j]);
			}
	}
	
	public int getAliveNeighbourCount(int i, int j) {
		LifeButton[] neighbours;
		boolean isOnLeft = isOnLeft(i, j);
		boolean isOnRight = isOnRight(i, j);
		boolean isOnTop = isOnTop(i, j);
		boolean isOnBottom = isOnBottom(i, j);
		
		if (isOnLeft && isOnTop) {
			neighbours = new LifeButton[3];
			neighbours[0] = cells[i][j + 1];
			neighbours[1] = cells[i + 1][j];
			neighbours[2] = cells[i + 1][j + 1];
		}
		else if (isOnLeft && isOnBottom) {
			neighbours = new LifeButton[3];
			neighbours[0] = cells[i - 1][j];
			neighbours[1] = cells[i][j + 1];
			neighbours[2] = cells[i - 1][j + 1];
		}
		else if (isOnRight && isOnBottom) {
			neighbours = new LifeButton[3];
			neighbours[0] = cells[i - 1][j];
			neighbours[1] = cells[i][j - 1];
			neighbours[2] = cells[i - 1][j - 1];
		}
		else if (isOnRight && isOnTop) {
			neighbours = new LifeButton[3];
			neighbours[0] = cells[i][j - 1];
			neighbours[1] = cells[i + 1][j];
			neighbours[2] = cells[i + 1][j - 1];
		}
		else if (isOnLeft) {
			neighbours = new LifeButton[5];
			neighbours[0] = cells[i - 1][j];
			neighbours[1] = cells[i + 1][j];
			neighbours[2] = cells[i][j + 1];
			neighbours[3] = cells[i - 1][j + 1];
			neighbours[4] = cells[i + 1][j + 1];
		}
		else if (isOnRight) {
			neighbours = new LifeButton[5];
			neighbours[0] = cells[i - 1][j];
			neighbours[1] = cells[i + 1][j];
			neighbours[2] = cells[i][j - 1];
			neighbours[3] = cells[i - 1][j - 1];
			neighbours[4] = cells[i + 1][j - 1];
		}
		else if (isOnBottom) {
			neighbours = new LifeButton[5];
			neighbours[0] = cells[i - 1][j];
			neighbours[1] = cells[i - 1][j + 1];
			neighbours[2] = cells[i - 1][j - 1];
			neighbours[3] = cells[i][j - 1];
			neighbours[4] = cells[i][j + 1];
		}
		else if (isOnTop) {
			neighbours = new LifeButton[5];
			neighbours[0] = cells[i + 1][j];
			neighbours[1] = cells[i + 1][j - 1];
			neighbours[2] = cells[i + 1][j + 1];
			neighbours[3] = cells[i][j - 1];
			neighbours[4] = cells[i][j + 1];
		}
		else {
			neighbours = new LifeButton[8];
			neighbours[0] = cells[i][j + 1];
			neighbours[1] = cells[i][j - 1];
			neighbours[2] = cells[i + 1][j];
			neighbours[3] = cells[i - 1][j];
			neighbours[4] = cells[i + 1][j + 1];
			neighbours[5] = cells[i + 1][j - 1];
			neighbours[6] = cells[i - 1][j + 1];
			neighbours[7] = cells[i - 1][j - 1];
		}
		
		return getAliveButtonCount(neighbours);
	}
	
	private int getAliveButtonCount(LifeButton[] buttons) {
		int aliveButtonCount = 0;
		for (int i = 0; i < buttons.length; i++) {
			if (buttons[i].isAlive())
				aliveButtonCount += 1;
		}
		return aliveButtonCount;
	}
	
	private boolean isOnLeft(int i, int j) {
		return j == 0;
	}
	
	private boolean isOnRight(int i, int j) {
		return j == size - 1;
	}
	
	private boolean isOnBottom(int i, int j) {
		return i == size - 1;
	}
	
	private boolean isOnTop(int i, int j) {
		return i == 0;
	}
}
