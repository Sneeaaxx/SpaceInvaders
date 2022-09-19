package main.states.states;

import main.entity.bullet.BulletManager;
import main.entity.Player;
import main.entity.stone.StoneManager;
import main.maths.Vector2f;
import main.states.GameState;
import main.states.GameStateManager;
import main.util.KeyHandler;
import main.util.MouseHandler;

import java.awt.*;

public class Play extends GameState {

    private final Player player;
    private final BulletManager bm;
    private final StoneManager sm;
    private Font text;

    public Play(GameStateManager gsm) {
        super(gsm);

        player = new Player(new Vector2f(100, 100));

        bm = new BulletManager(player);
        sm = new StoneManager(player, bm);
        text = new Font("MatchupPro", Font.PLAIN, 30);
    }

    @Override
    public void update(double dt) {
        if (!gsm.isState(GameStateManager.PAUSE) && !gsm.isState(GameStateManager.DEATH)) {
            if (!player.getDead()) {
                player.update(dt);
            } else {
                gsm.addGameState(GameStateManager.DEATH);
            }

            bm.update(dt);
            sm.update(dt);
        }
    }

    @Override
    public void inputs(KeyHandler keyH, MouseHandler mouseH) {
        if (!gsm.isState(GameStateManager.PAUSE) && !gsm.isState(GameStateManager.DEATH)) {
            if (keyH.escape.down) {
                gsm.addGameState(GameStateManager.PAUSE);
            }
            player.inputs(keyH, mouseH);
            bm.inputs(keyH, mouseH);
        }
    }

    @Override
    public void render(Graphics2D g2) {
        if (gsm.isState(GameStateManager.PAUSE) || gsm.isState(GameStateManager.OPTIONS) ) {
            setAlpha(g2, 0.2f);
        }
        bm.render(g2);
        sm.render(g2);

        setAlpha(g2, player.getInvisAlpha());
        player.render(g2);

        setAlpha(g2, 1f);

        g2.setColor(new Color(213, 213, 213));;
        g2.setFont(text);
        g2.drawString("Lifes: " + player.getLife(), 10, 30);
    }

    private void setAlpha(Graphics2D g2, float v) {
        AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, v);
        g2.setComposite(alphaComposite);
    }
}
