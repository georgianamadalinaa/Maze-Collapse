package pro;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Level3 extends JFrame {

    private static final int ROWS = 6;
    private static final int COLS = 6;

    private int[][] maze = {
            {1, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1},
            {1, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 1, 1},
            {1, 0, 0, 0, 0, 0}
    };

    private int playerRow = 0;
    private int playerCol = 0;

    private int startRow = 0;
    private int startCol = 0;

    private int finishRow = 5;
    private int finishCol = 5;
    private int obsRow=3;
    private int obsCol=2;
    private int obsRow1=1;
    private int obsCol1=0;
    private int obsRow2=0;
    private int obsCol2=5;
    private int monRow=0;
    private int monCol=4;

    private Image startImage;
    private Image finishImage;
    private Image playerImage;

    private JPanel mazePanel;
    private Image backgroundImage;
    private List<Point> playerHistory = new ArrayList<>();
    private Image obstacleImage;
    private Image moneyImage;
    private Clip backgroundMusic;
    private Level decoratedLevel;
	private Level level;
	private int score = 160;

    public Level3(Level level) {
    	this.level = level;
    	decoratedLevel = new PointsDecorator(new BaseLevel());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        initializeComponents();
        addComponentsToFrame();

        // Încarcă imaginile în constructor
        backgroundImage = new ImageIcon("C:\\Users\\ga214\\Eclipse-JAVA-2022-09-workspace\\Proiect\\backg.jpg").getImage();
        startImage = new ImageIcon("C:\\Users\\ga214\\Eclipse-JAVA-2022-09-workspace\\Proiect\\st.jpg").getImage();
        finishImage = new ImageIcon("C:\\Users\\ga214\\Eclipse-JAVA-2022-09-workspace\\Proiect\\finish.jpg").getImage();
        obstacleImage = new ImageIcon("obstacol.png").getImage();
        playerImage = new ImageIcon("C:\\Users\\ga214\\Eclipse-JAVA-2022-09-workspace\\Proiect\\om.png").getImage();
        moneyImage = new ImageIcon("ban.jpg").getImage();


        playerHistory.add(new Point(startCol, startRow)); // Adăugăm poziția de start în istoricul jucătorului

        setVisible(true);
    }

    public Level3() {
		// TODO Auto-generated constructor stub
	}

	private void initializeComponents() {
        mazePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawBackground(g);
                drawMaze(g);
                drawPlayer(g);
                drawScore(g);
            }
        };
        mazePanel.setBackground(Color.WHITE);
        mazePanel.setFocusable(true);
        mazePanel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                movePlayer(e.getKeyCode());
                checkWin();
                mazePanel.repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    private void addComponentsToFrame() {
        setLayout(new BorderLayout());
        add(mazePanel, BorderLayout.CENTER);
    }

    private void drawMaze(Graphics g) {
        int cellSize = Math.min(getWidth() / COLS, getHeight() / ROWS);

        // Desenează spațiile libere cu contur alb
        g.setColor(Color.WHITE);
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (maze[i][j] == 0) {
                    g.setColor(Color.WHITE);
                    g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
                } 
            }
        }
       
        // Desenează imaginea pentru start
        g.drawImage(startImage, startCol * cellSize, startRow * cellSize, cellSize, cellSize, this);

        // Desenează imaginea pentru finish
        g.drawImage(finishImage, finishCol * cellSize, finishRow * cellSize, cellSize, cellSize, this);
        g.drawImage(obstacleImage, obsCol* cellSize, obsRow * cellSize, cellSize, cellSize, this);
        g.drawImage(obstacleImage, obsCol1* cellSize, obsRow1 * cellSize, cellSize, cellSize, this);
        g.drawImage(obstacleImage, obsCol2* cellSize, obsRow2 * cellSize, cellSize, cellSize, this);
        g.drawImage(moneyImage, monCol* cellSize, monRow * cellSize, cellSize, cellSize, this);
    }

    private void drawPlayer(Graphics g) {
        int cellSize = Math.min(getWidth() / COLS, getHeight() / ROWS);
        int x = playerCol * cellSize;
        int y = playerRow * cellSize;
        int width = cellSize;
        int height = cellSize;
        g.drawImage(playerImage, x, y, width, height, this);
    }

    private void movePlayer(int keyCode) {
        int newPlayerRow = playerRow;
        int newPlayerCol = playerCol;

        // Păstrăm o copie a poziției curente
        int currentRow = playerRow;
        int currentCol = playerCol;

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

        if (newPlayerRow >= 0 && newPlayerRow < ROWS && newPlayerCol >= 0 && newPlayerCol < COLS) {
            // Verificăm coliziunea cu obstacolele
            if ((newPlayerRow == obsRow && newPlayerCol == obsCol) ||
                (newPlayerRow == obsRow1 && newPlayerCol == obsCol1) ||
                (newPlayerRow == obsRow2 && newPlayerCol == obsCol2)) {
                // Jucătorul a atins un obstacol
                playerRow = currentRow;
                playerCol = currentCol;
                mazePanel.repaint();
                JOptionPane.showMessageDialog(this, "Ai atins un obstacol. Ai pierdut!");
            } else if (newPlayerRow == monRow && newPlayerCol == monCol) {
                // Jucătorul a ajuns pe poziția bonus
                playerRow = newPlayerRow;
                playerCol = newPlayerCol;
                mazePanel.repaint();
                JOptionPane.showMessageDialog(this, "Ai câștigat un bonus!");
                // Poți adăuga acțiuni suplimentare asociate câștigării bonusului
            } else if (maze[newPlayerRow][newPlayerCol] == 0 && !playerHistory.contains(new Point(newPlayerCol, newPlayerRow))) {
                // Mutăm jucătorul la noua poziție validă
                playerRow = newPlayerRow;
                playerCol = newPlayerCol;

                playerHistory.add(new Point(currentCol, currentRow));
                mazePanel.repaint();
                updateScore(10);
            } else {
                // Revenim la poziția anterioară dacă mutarea nu este validă
                playerRow = currentRow;
                playerCol = currentCol;
                mazePanel.repaint();

                JOptionPane.showMessageDialog(this, "Ai atins peretele labirintului sau ai revenit la o poziție anterioară. Ai pierdut!");
            }
        }
    }


    private void checkWin() {
        if (playerRow == finishRow && playerCol == finishCol) {
            mazePanel.repaint();
            int levelPoints = 10; // sau orice altă valoare pe care o dorești pentru nivel
            decoratedLevel.addPoints(levelPoints);
            JOptionPane.showMessageDialog(this, "Ai câștigat! Bravo!");
            dispose(); 
        }
    }

    private void resetPlayerPosition() {
        playerRow = startRow;
        playerCol = startCol;
    }
    public int getPoints() {
        // Returnează punctele acumulate
        return decoratedLevel.getPoints();
    }
    public int getScore() {
        return score;
    }
    public void updateScore(int points) {
        score += points;
        System.out.println("Scor actualizat: " + score);
    }
    
    private void drawScore(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Score: " + score, 15, 350);
    }
    private void drawBackground(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
   /* public void playMusic() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\ga214\\Eclipse-JAVA-2022-09-workspace\\P1\\SSound.wav"));
            backgroundMusic = AudioSystem.getClip();
            backgroundMusic.open(audioInputStream);
            backgroundMusic.start();
            backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    public static void main(String[] args) {
    	BaseLevel baseLevel = new BaseLevel();  // Creezi nivelul de bază
        PointsDecorator pointsDecorator = new PointsDecorator(baseLevel);
        SwingUtilities.invokeLater(() -> new Level3(pointsDecorator));
    }
}

