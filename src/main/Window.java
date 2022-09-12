package main;

import javax.swing.JFrame;
import java.awt.image.BufferStrategy;

public class Window extends JFrame {
    private static Window frame = null;

    private BufferStrategy bs;
    private Panel panel;

    private Window() {
        setTitle("Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIgnoreRepaint(true);

        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void addNotify() {
        super.addNotify();

        createBufferStrategy(2);
        bs = getBufferStrategy();

        panel = new Panel(bs, 700, 800);
        setContentPane(panel);
    }

    public static Window get() {
        if (frame == null) {
            frame = new Window();
        }

        return frame;
    }
}
