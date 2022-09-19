package main.states.states;

import main.states.GameState;
import main.states.GameStateManager;
import main.util.KeyHandler;
import main.util.MouseHandler;

import java.awt.*;

public class Death extends GameState {

    private final Font title;
    private final Font text;

    public Death(GameStateManager gsm) {
        super(gsm);

        title = new Font("EquipmentPro", Font.PLAIN, 90);
        text = new Font("MatchupPro", Font.PLAIN, 30);
    }

    @Override
    public void update(double dt) {

    }

    @Override
    public void inputs(KeyHandler keyH, MouseHandler mouseH) {

    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(new Color(213, 213, 213));
        g2.setFont(title);
        g2.drawString("You Are Dead", GameStateManager.getXForCenteredFrameText("You Are Dead", g2), 100);
    }
}
