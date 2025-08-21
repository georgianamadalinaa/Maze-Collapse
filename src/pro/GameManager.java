package pro;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

// Singleton class for managing game state
public class GameManager {
    private static GameManager instance;

    private int playerRow;
    private int playerCol;
    private List observers;
  

    public GameManager() {
        // Initialize game state
        playerRow = 0;
        playerCol = 0;
        observers = new ArrayList<>();
    }

  
	public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public int getPlayerRow() {
        return playerRow;
    }

    public int getPlayerCol() {
        return playerCol;
    }

    public void movePlayer(int keyCode) {
        int newPlayerRow = playerRow;
        int newPlayerCol = playerCol;

        switch (keyCode) {
            case KeyEvent.VK_UP:
                newPlayerRow--;
                break;
            case KeyEvent.VK_DOWN:
                newPlayerRow++;
                break;
            case KeyEvent.VK_LEFT:
                newPlayerCol--;
                break;
            case KeyEvent.VK_RIGHT:
                newPlayerCol++;
                break;
        }

        if (isValidMove(newPlayerRow, newPlayerCol)) {
            playerRow = newPlayerRow;
            playerCol = newPlayerCol;
            notifyObservers();
        } else {
            JOptionPane.showMessageDialog(null, "Ai atins peretele labirintului. Ai pierdut!");
            resetPlayerPosition();
            // Aici poți adăuga acțiuni suplimentare pentru tratarea pierderii
        }
    }


	private void notifyObservers() {
		// TODO Auto-generated method stub
		
	}

	private boolean isValidMove(int row, int col) {
        int[][] maze = {
                {1, 0, 1, 1, 1, 1},
                {1, 0, 0, 0, 1, 1},
                {1, 0, 0, 1, 0, 1},
                {1, 1, 0, 1, 1, 1},
                {1, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 1}
        };

        return row >= 0 && row < maze.length && col >= 0 && col < maze[0].length && maze[row][col] == 0;
    }

    private void resetPlayerPosition() {
        playerRow = 0;
        playerCol = 0;
    }
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }


}

