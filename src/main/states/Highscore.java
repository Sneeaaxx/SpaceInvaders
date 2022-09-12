package main.states;

import main.util.HighscoreTXT;
import main.util.KeyHandler;
import main.util.MouseHandler;
import main.util.HighscoreTXT;

import java.awt.*;

public class Highscore extends GameState {

    private HighscoreTXT hst;
    private String[] highscore;

    public Highscore(GameStateManager gsm) {
        super(gsm);

        hst = new HighscoreTXT("D:\\Dev\\Java\\Java 2D Games\\Self Made\\SpaceInvaders\\res\\text\\high-score.txt");
        hst.lesen();

        highscore = hst.getHighscores();
    }

    @Override
    public void update(double dt) {

    }

    @Override
    public void inputs(KeyHandler keyH, MouseHandler mouseH) {

    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(Color.green);

        for (int i = 0; i < highscore.length; i++) {
            if (highscore[i] != null) {
                g2.drawString((i + 1) + ". " + highscore[i].substring(0, highscore[i].indexOf(" ")), 60, i * 50 + 50);
                g2.drawString(highscore[i].substring(highscore[i].indexOf(" ")), 200, i * 50 + 50);
            }
        }
    }
}
