package main;

import main.states.GameStateManager;
import main.util.KeyHandler;
import main.util.MouseHandler;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Panel extends JPanel implements Runnable {

    // Size
    public static int width;
    public static int height;

    // Thread
    public static int oldFrameCount;
    public static int oldTickCount;
    public static int tickCount;
    public static int updateCount;
    private boolean running;
    private Thread gameThread;

    // Graphics
    private BufferStrategy bs;
    private BufferedImage img;
    private Graphics2D g;

    // Inputs
    private KeyHandler keyH;
    private MouseHandler mouseH;

    // GameStateManager
    private GameStateManager gsm;

    public Panel(BufferStrategy bs, int width, int height) {
        Panel.width = width;
        Panel.height = height;
        this.bs = bs;

        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocus();
    }

    @Override
    public void addNotify() {
        super.addNotify();

        if (gameThread == null) {
            gameThread = new Thread(this, "GameThread");
            gameThread.start();
        }
    }

    private void init() {
        running = true;

        // Graphics
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g = (Graphics2D) img.getGraphics();

        // Inputs
        keyH = new KeyHandler(this);
        mouseH = new MouseHandler(this);

        // GameStateManager
        gsm = new GameStateManager();
    }

    @Override
    public void run() {
        init();

        final double GAME_HERTZ = 60.0;
        final double TBU = 1000000000 / GAME_HERTZ; //Time Before Update

        final double MUBR = 5; // Must Update Before render

        double lastUpdateTime = System.nanoTime();
        double lastRenderTime;

        final double TARGET_FPS = 10000;
        final double TTBR = 1000000000 / TARGET_FPS; // Total time before render

        int framesCount = 0;
        int lastSecondTime = (int) (lastUpdateTime / 1000000000);
        oldFrameCount = 0;

        tickCount = 0;
        oldTickCount = 0;

        while(running){

            double now = System.nanoTime();
            updateCount = 0;
            while (((now - lastUpdateTime) > TBU) && (updateCount < MUBR)) {
                update(now);
                inputs(keyH, mouseH);
                lastUpdateTime += TBU;
                updateCount++;
                tickCount++;
                // ^^^^^^ this variable is used for displaying it in PlayState
            }

            if(now - lastUpdateTime > TBU){
                lastUpdateTime = now - TBU;
            }

            inputs(keyH, mouseH);
            render();
            draw();
            lastRenderTime = now;
            framesCount++;

            int thisSecond = (int) (lastUpdateTime / 1000000000);
            if (thisSecond > lastSecondTime){
                if (framesCount != oldFrameCount){
                    System.out.println("NEW SECOND " + thisSecond + " " + framesCount);
                    oldFrameCount = framesCount;
                }
                if (tickCount != oldTickCount) {
                    System.out.println("NEW SECOND (T) " + thisSecond + " " + tickCount);
                    oldTickCount = tickCount;
                }
                tickCount = 0;
                framesCount = 0;
                lastSecondTime = thisSecond;
            }

            while (now - lastRenderTime < TTBR && now -lastUpdateTime < TBU){
                Thread.yield();

                try {
                    Thread.sleep(1);
                } catch(Exception e){
                    System.out.println("ERROR: yielding thread");
                }

                now = System.nanoTime();
            }
        }
    }

    private void update(double dt) {
        gsm.update(dt);
    }

    private void inputs(KeyHandler keyH, MouseHandler mouseH) {
        gsm.inputs(keyH, mouseH);
    }

    private void render() {
        if(g != null) {
            g.setColor(new Color(38, 34, 34));
            g.fillRect(0, 0, width, height);
            gsm.render(g);
        }
    }

    private void draw() {
        do {
            Graphics g2 = (Graphics2D) bs.getDrawGraphics();
            g2.drawImage(img, 3, 26, width + 10, height + 10, null); // true 8, 31
            g2.dispose();
            bs.show();
        } while(bs.contentsLost());
    }
}
