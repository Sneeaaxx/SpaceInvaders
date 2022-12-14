package main.states.states;

import main.entity.Player;
import main.graphics.Image;
import main.maths.Vector2f;
import main.states.GameState;
import main.states.GameStateManager;
import main.util.KeyHandler;
import main.util.MouseHandler;
import main.ui.Button;

import java.awt.*;

public class Lobby extends GameState {

    private final Font titleFont;
    private final Button[] button;
    private Player player;

    public Lobby(GameStateManager gsm) {
        super(gsm);

        titleFont = new Font("EquipmentPro", Font.PLAIN, 90);

        button = new Button[4];
        button[0] = new Button(new Image("ui/GrayLargeButton6.png"), new Vector2f(100,270), "Play");
        button[0].setCenter(true);
        button[1] = new Button(new Image("ui/GrayLargeButton6.png"), new Vector2f(100,370), "Options");
        button[1].setCenter(true);
        button[2] = new Button(new Image("ui/GrayLargeButton6.png"), new Vector2f(100,470), "Highscore");
        button[2].setCenter(true);
        button[3] = new Button(new Image("ui/GrayLargeButton6.png"), new Vector2f(100,570), "Exit");
        button[3].setCenter(true);
    }

    @Override
    public void update(double dt) {
        if (!gsm.isState(GameStateManager.OPTIONS)) {
            for (Button b : button) {
                b.update(dt);
            }

            if (button[0].getClicked()) {
                gsm.addAndRemoveGameState(GameStateManager.PLAY, GameStateManager.LOBBY);
            }
            if (button[1].getClicked()) {
                gsm.addGameState(GameStateManager.OPTIONS);
            }
            if (button[2].getClicked()) {
                gsm.addAndRemoveGameState(GameStateManager.HIGHSCORE, GameStateManager.LOBBY);
            }
            if (button[3].getClicked()) {
                System.exit(0);
            }
        }
    }

    @Override
    public void inputs(KeyHandler keyH, MouseHandler mouseH) {
        if (!gsm.isState(GameStateManager.OPTIONS)) {
            for (Button b : button) {
                b.inputs(keyH, mouseH);
            }
        }
    }

    @Override
    public void render(Graphics2D g2) {
        if (!gsm.isState(GameStateManager.OPTIONS)) {
            g2.setFont(titleFont);
            g2.setColor(new Color(213, 213, 213));
            g2.drawString("SpaceInvaders", GameStateManager.getXForCenteredFrameText("SpaceInvaders", g2), 140);

            for (Button b : button) {
                b.render(g2);
            }
        }
    }
}
