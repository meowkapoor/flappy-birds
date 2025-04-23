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
    int pipeWidth = 64;
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

    class Pipe {
        int x = pipeX;
        int y = pipeY;
        int w = pipeWidth;
        int h = pipeHeight;
        boolean passed = false;
        Image img;

        Pipe(Image img) {
            this.img = img;
        }
    }

    // game logic
    Bird bird;
    int velocityX = -4;
    int velocityY = -9;
    int gravity = 1;

    ArrayList<Pipe> pipes;

    Timer gameLoop;
    Timer placePipesTimer;

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
        pipes = new ArrayList<>();

        placePipesTimer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placePipes();
            }
        });
        placePipesTimer.start();

        gameLoop = new Timer(1000 / 60, this);
        gameLoop.start();
    }

    public void move() {
        // bird
        velocityY += gravity;
        bird.y += velocityY;
        // bird.y = (bird.y < 0) ? 0 : bird.y;
        bird.y = Math.max(bird.y, 0);

        // pipe
        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            pipe.x += velocityX;
        }
    }

    public void placePipes() {
        int randomPipeY = (int) (pipeY - pipeHeight / 4 - (Math.random() * pipeHeight / 2));
        int oppeningPipe = boardheight / 4;
        Pipe topPipe = new Pipe(topPipeImg);
        topPipe.y = randomPipeY;
        pipes.add(topPipe);
        Pipe bottomPipe = new Pipe(bottomPipeImg);
        bottomPipe.y = topPipe.y + pipeHeight + oppeningPipe;
        pipes.add(bottomPipe);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        // background
        g.drawImage(backgroundImg, 0, 0, boardwidth, boardheight, null);

        // bird
        g.drawImage(birdImg, bird.x, bird.y, bird.w, bird.h, null);

        // toppipe
        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            g.drawImage(pipe.img, pipe.x, pipe.y, pipe.w, pipe.h, null);
        }
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
