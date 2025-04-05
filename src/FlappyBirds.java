import java.util.ArrayList;
import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FlappyBirds extends JPanel {
    int boardwidth = 360;
    int boardheight = 640;

    FlappyBirds() {
        setPreferredSize(new Dimension(boardwidth, boardheight));
        // Tells the layout manager how big this panel wants to be.
        // It doesn’t force the size — it suggests it.
        // The layout manager may ignore it, if it wants to.

        setBackground(Color.blue);
    }
}
