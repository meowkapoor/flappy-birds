import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        int boardwidth = 360;
        int boardheight = 640;

        JFrame frame = new JFrame("flappy birds");
        // frame.setVisible(true);

        frame.setSize(boardwidth, boardheight);
        // Directly sets the window size.
        // Tells the OS: Make this window width x height pixels.

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FlappyBirds flappyBirds = new FlappyBirds();
        frame.add(flappyBirds);
        frame.pack();
        // If you don’t use pack(), then the preferred size of components (like JPanel)
        // is ignored, unless:
        // You manually call setSize() on the frame.
        // Or you manually set size on each component and manage layout yourself.
        // The window might open very small or default size, and your panel may not even
        // show fully.
        // Because the frame has no idea how much space it should allocate for its
        // contents.

        frame.setVisible(true);

    }
}
