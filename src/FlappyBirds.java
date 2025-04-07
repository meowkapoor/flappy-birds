import java.util.ArrayList;
import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FlappyBirds extends JPanel implements ActionListener, KeyListener {
    int boardwidth = 360;
    int boardheight = 640;

    // IMAGES
    Image backgroundImg;
    Image bottomPipeImg;
    Image topPipeImg;
    Image birdImg;

    int birdX = boardwidth / 8;
    int birdY = boardheight / 2;
    int birdWidth = 34;
    int birdHeihgt = 24;

    int pipeX = boardwidth;
    int pipeY = 0;
    int pipeWidth = 34;
    int pipeHeight = 512;

    class Bird {
        int x = birdX;
        int y = birdY;
        int w = birdWidth;
        int h = birdHeihgt;
        Image img;

        Bird(Image img) {
            this.img = img;
        }
    }

    // game logic
    Bird bird;
    int velocityX = -4;
    int velocityY = -9;
    int gravity = 1;

    Timer gameLoop;

    FlappyBirds() {

        setPreferredSize(new Dimension(boardwidth, boardheight));

        setFocusable(true);
        addKeyListener(this);

        setBackground(Color.blue);

        // LOAD IMAGES
        backgroundImg = new ImageIcon(getClass().getResource("./flappybirdbg.png")).getImage();
        birdImg = new ImageIcon(getClass().getResource("./flappybird.png")).getImage();
        topPipeImg = new ImageIcon(getClass().getResource("./toppipe.png")).getImage();
        bottomPipeImg = new ImageIcon(getClass().getResource("./bottompipe.png")).getImage();

        bird = new Bird(birdImg);

        gameLoop = new Timer(1000 / 60, this);
        gameLoop.start();
    }

    public void move() {
        // bird
        velocityY += gravity;
        bird.y += velocityY;
        // bird.y = (bird.y < 0) ? 0 : bird.y;
        bird.y = Math.max(bird.y, 0);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        // baclground
        g.drawImage(backgroundImg, 0, 0, boardwidth, boardheight, null);

        // bird
        g.drawImage(birdImg, bird.x, bird.y, bird.w, bird.h, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            velocityY = -9;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
