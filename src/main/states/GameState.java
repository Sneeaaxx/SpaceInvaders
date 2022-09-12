package main.states;

import main.util.KeyHandler;
import main.util.MouseHandler;

import java.awt.*;

public abstract class GameState {

    protected GameStateManager gsm;

    public GameState(GameStateManager gsm) {
        this.gsm = gsm;
    }

    public abstract void update(double dt);
    public abstract void inputs(KeyHandler keyH, MouseHandler mouseH);
    public abstract void render(Graphics2D g2);
}
