package main.states.states;

import main.states.GameState;
import main.states.GameStateManager;
import main.util.KeyHandler;
import main.util.MouseHandler;

import java.awt.*;

public class Options extends GameState {

    private final Font title;
    private final Font text;

    public Options(GameStateManager gsm) {
        super(gsm);

        title = new Font("EquipmentPro", Font.PLAIN, 90);
        text = new Font("MatchupPro", Font.PLAIN, 30);
    }

    @Override
    public void update(double dt) {

    }

    @Override
    public void inputs(KeyHandler keyH, MouseHandler mouseH) {
        if (keyH.escape.down) {
            gsm.removeGameState(GameStateManager.OPTIONS);
        }
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setFont(title);
        g2.setColor(new Color(213, 213, 213));;
        g2.drawString("Options", GameStateManager.getXForCenteredFrameText("Options", g2), 100);
        g2.setFont(text);

        g2.drawString("Move Up: ", 250, 200); g2.drawString("W", 400, 200);
        g2.drawString("Move Right: ", 250, 230); g2.drawString("A", 400, 230);
        g2.drawString("Move Down: ", 250, 260); g2.drawString("S", 400, 260);
        g2.drawString("Move Left: ", 250, 290); g2.drawString("D", 400, 290);

        g2.drawString("Shoot: ", 250, 350); g2.drawString("SPACE", 400, 350);
        g2.drawString("Go Back: ", 250, 380); g2.drawString("ESC", 400, 380);
    }
}
