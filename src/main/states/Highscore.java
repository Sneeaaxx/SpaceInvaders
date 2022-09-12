package main.states;

import main.util.KeyHandler;
import main.util.MouseHandler;
import main.util.ReadHighScore;

import java.awt.*;

public class Highscore extends GameState {

    private ReadHighScore rhs;

    public Highscore(GameStateManager gsm) {
        super(gsm);

        rhs = new ReadHighScore("text/highscore.txt");
    }

    @Override
    public void update(double dt) {

    }

    @Override
    public void inputs(KeyHandler keyH, MouseHandler mouseH) {

    }

    @Override
    public void render(Graphics2D g2) {

    }
}
