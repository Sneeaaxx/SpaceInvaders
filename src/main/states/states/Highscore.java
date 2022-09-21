package main.states.states;

import main.Panel;
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

    private String[] htxtList;

    public Highscore(GameStateManager gsm) {
        super(gsm);

        title = new Font("EquipmentPro", Font.PLAIN, 90);
        text = new Font("MatchupPro", Font.PLAIN, 40);
    }

    @Override
    public void update(double dt) {
        gsm.htxt.sort();
        htxtList = gsm.htxt.getHihscoreList();
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

        g2.setFont(text);
        for (int i = 0; i < 10; i++) {
            if (htxtList[i] != null) {
                g2.drawString((i + 1) + ". " + htxtList[i].substring(0, htxtList[i].indexOf(" ")), 100, 200 + i * 50);
                String text = htxtList[i].substring(htxtList[i].indexOf(" "));
                g2.drawString(text, GameStateManager.getXForTextAlignToRight(text, Panel.width - 100, g2), 200 + i * 50);
            }
        }
    }
}
