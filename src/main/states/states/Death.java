package main.states.states;

import main.Panel;
import main.states.GameState;
import main.states.GameStateManager;
import main.util.KeyHandler;
import main.util.MouseHandler;

import java.awt.*;

public class Death extends GameState {

    private final Font title;
    private final Font text;
    private float alphaValue;
    private double alphaValueTimer;
    private final double alphaValueCounter;
    private boolean updateAlphaValueTimer;
    private final int highscore;

    public Death(GameStateManager gsm) {
        super(gsm);

        alphaValue = 0f;
        alphaValueCounter = 1E7;
        updateAlphaValueTimer = true;

        title = new Font("EquipmentPro", Font.PLAIN, 90);
        text = new Font("MatchupPro", Font.PLAIN, 40);

        highscore = gsm.getState(GameStateManager.PLAY).getHighscore();
    }

    @Override
    public void update(double dt) {
        if (alphaValue != 1f) {
            if (updateAlphaValueTimer) {
                alphaValueTimer = dt;
                updateAlphaValueTimer = false;
            } else {
                if (dt > alphaValueTimer + alphaValueCounter) {
                    alphaValue += 0.01f;
                    if (alphaValue > 1f) {
                        alphaValue = 1f;
                    }
                    updateAlphaValueTimer = true;
                }
            }
        }

        if (alphaValue == 1f && gsm.isState(GameStateManager.PLAY)) {
            gsm.removeGameState(GameStateManager.PLAY);
        }
    }

    @Override
    public void inputs(KeyHandler keyH, MouseHandler mouseH) {

    }

    @Override
    public void render(Graphics2D g2) {
        setAlpha(g2, alphaValue);
        g2.setColor(new Color(38, 34, 34));
        g2.fillRect(0, 0, Panel.width, Panel.height);

        setAlpha(g2, 1f);

        g2.setColor(new Color(213, 213, 213));
        g2.setFont(title);
        g2.drawString("You Are Dead", GameStateManager.getXForCenteredFrameText("You Are Dead", g2), 100);

        g2.setFont(text);
        g2.drawString("Highscore: " + highscore, GameStateManager.getXForCenteredFrameText("Highscore: " + highscore, g2), 200);
    }

    private void setAlpha(Graphics2D g2, float v) {
        AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, v);
        g2.setComposite(alphaComposite);
    }
}
