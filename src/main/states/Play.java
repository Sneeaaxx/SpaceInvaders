package main.states;

import main.entity.bullet.BulletManager;
import main.entity.Player;
import main.entity.stone.StoneManager;
import main.maths.Vector2f;
import main.util.KeyHandler;
import main.util.MouseHandler;

import java.awt.*;

public class Play extends GameState {

    private final Player player;
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
        player.update(dt);
        bm.update(dt);
        sm.update(dt);
    }

    @Override
    public void inputs(KeyHandler keyH, MouseHandler mouseH) {
        if(keyH.escape.down) {
            gsm.addAndRemoveGameState(GameStateManager.LOBBY, GameStateManager.PLAY);
        }
        player.inputs(keyH, mouseH);
        bm.inputs(keyH, mouseH);
    }

    @Override
    public void render(Graphics2D g2) {
        player.render(g2);
        bm.render(g2);
        sm.render(g2);
    }
}
