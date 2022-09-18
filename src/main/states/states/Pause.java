package main.states.states;

import main.maths.Vector2f;
import main.states.GameState;
import main.states.GameStateManager;
import main.ui.Button;
import main.util.KeyHandler;
import main.util.MouseHandler;

import java.awt.*;

public class Pause extends GameState {

    private Button[] button;
    public Pause(GameStateManager gsm) {
        super(gsm);

        button = new Button[3];

        button[0] = new Button(new main.graphics.Image("ui/GrayLargeButton6.png"), new Vector2f(100,270), "Resume");
        button[0].setCenter(true);
        button[1] = new Button(new main.graphics.Image("ui/GrayLargeButton6.png"), new Vector2f(100,370), "Options");
        button[1].setCenter(true);
        button[2] = new Button(new main.graphics.Image("ui/GrayLargeButton6.png"), new Vector2f(100,470), "Main Menu");
        button[2].setCenter(true);
    }

    @Override
    public void update(double dt) {
        if (!gsm.isState(GameStateManager.OPTIONS)) {
            for (Button b : button) {
                b.update(dt);
            }

            if (button[0].getClicked()) {
                gsm.removeGameState(GameStateManager.PAUSE);
            }
            if (button[1].getClicked()) {
                gsm.addGameState(GameStateManager.OPTIONS);
            }
            if (button[2].getClicked()) {
                gsm.addAndRemoveGameState(GameStateManager.LOBBY, GameStateManager.PLAY);
                gsm.removeGameState(GameStateManager.PAUSE);
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
            for (Button b : button) {
                b.render(g2);
            }
        }
    }
}
