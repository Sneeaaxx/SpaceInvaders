package main.states.states;

import main.Panel;
import main.graphics.Image;
import main.maths.Vector2f;
import main.states.GameState;
import main.states.GameStateManager;
import main.ui.Button;
import main.util.KeyHandler;
import main.util.MouseHandler;
import main.util.StringInputBuilder;

import java.awt.*;

public class Death extends GameState {

    private final Font title;
    private final Font text;
    private StringInputBuilder sib;
    private float alphaValue;
    private double alphaValueTimer;
    private final double alphaValueCounter;
    private boolean updateAlphaValueTimer;
    private final int highscore;
    private Button mainMenu;
    private Button submitHighscore;

    public Death(GameStateManager gsm) {
        super(gsm);

        alphaValue = 0f;
        alphaValueCounter = 1E7;
        updateAlphaValueTimer = true;

        title = new Font("EquipmentPro", Font.PLAIN, 90);
        text = new Font("MatchupPro", Font.PLAIN, 40);

        highscore = gsm.getState(GameStateManager.PLAY).getHighscore();
        sib = new StringInputBuilder();

        mainMenu = new Button(new Image("ui/GrayLargeButton6.png"), new Vector2f(100,570), "Main Menu");
        submitHighscore = new Button(new Image("ui/GrayLargeButton6.png"), new Vector2f(400,570), "Add Highscore");
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

        mainMenu.update(dt);
        submitHighscore.update(dt);

        if (mainMenu.getClicked()) {
            if (gsm.isState(GameStateManager.PLAY)) gsm.removeGameState(GameStateManager.PLAY);
            gsm.addAndRemoveGameState(GameStateManager.LOBBY, GameStateManager.DEATH);
        }

        if (alphaValue == 1f && gsm.isState(GameStateManager.PLAY)) {
            gsm.removeGameState(GameStateManager.PLAY);
        }
    }

    @Override
    public void inputs(KeyHandler keyH, MouseHandler mouseH) {
        sib.inputs(keyH, mouseH);

        mainMenu.inputs(keyH, mouseH);
        submitHighscore.inputs(keyH, mouseH);
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

        g2.drawString("Enter You'r Name", GameStateManager.getXForCenteredFrameText("Enter You'r Name", g2), 300);

        if (sib.getFinalString() != null) {
            g2.drawString(sib.getFinalString(), GameStateManager.getXForCenteredFrameText(sib.getFinalString(), g2), 450);
        }

        mainMenu.render(g2);
        submitHighscore.render(g2);
    }

    private void setAlpha(Graphics2D g2, float v) {
        AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, v);
        g2.setComposite(alphaComposite);
    }
}
