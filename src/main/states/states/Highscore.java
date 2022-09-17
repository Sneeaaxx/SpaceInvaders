package main.states.states;

import main.states.GameState;
import main.states.GameStateManager;
import main.util.HighscoreTXT;
import main.util.KeyHandler;
import main.util.MouseHandler;
import main.util.HighscoreTXT;

import java.awt.*;

public class Highscore extends GameState {

    private Font title;
    private Font text;

    public Highscore(GameStateManager gsm) {
        super(gsm);

        title = new Font("EquipmentPro", Font.PLAIN, 90);
        text = new Font("MatchupPro", Font.PLAIN, 20);
    }

    @Override
    public void update(double dt) {

    }

    @Override
    public void inputs(KeyHandler keyH, MouseHandler mouseH) {
        if (keyH.escape.down) {
            gsm.addAndRemoveGameState(GameStateManager.LOBBY, GameStateManager.HIGHSCORE);
        }
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setFont(title);
        g2.setColor(new Color(213, 213, 213));;
        g2.drawString("Highscore", GameStateManager.getXForCenteredFrameText("Highscore", g2), 100);
    }
}
