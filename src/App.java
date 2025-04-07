import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        int boardwidth = 360;
        int boardheight = 640;

        JFrame frame = new JFrame("flappy birds");
        // frame.setVisible(true);

        frame.setSize(boardwidth, boardheight);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FlappyBirds flappyBirds = new FlappyBirds();
        frame.add(flappyBirds);
        frame.pack();
        frame.requestFocus();
        frame.setVisible(true);

    }
}
