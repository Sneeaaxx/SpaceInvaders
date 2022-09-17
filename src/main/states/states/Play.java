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

    private Player player;
    private final BulletManager bm;
    private StoneManager sm;

    public Play(GameStateManager gsm) {
        super(gsm);

        player = new Player(new Vector2f(100, 100));

        bm = new BulletManager(player);
        sm = new StoneManager(player, bm);
    }

    @Override
    public void update(double dt) {
        if (!gsm.isState(GameStateManager.PAUSE)) {
            if (!player.getDead()) {
                player.update(dt);
            } else {
                gsm.addAndRemoveGameState(GameStateManager.LOBBY, GameStateManager.PLAY);
            }

            bm.update(dt);
            sm.update(dt);
        }
    }

    @Override
    public void inputs(KeyHandler keyH, MouseHandler mouseH) {
        if (!gsm.isState(GameStateManager.PAUSE)) {
            if (keyH.escape.down) {
                gsm.addGameState(GameStateManager.PAUSE);
            }
            player.inputs(keyH, mouseH);
            bm.inputs(keyH, mouseH);
        }
    }

    @Override
    public void render(Graphics2D g2) {
        player.render(g2);
        bm.render(g2);
        sm.render(g2);
    }
}
