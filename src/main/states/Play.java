package main.states;

import main.entity.BulletManager;
import main.entity.Player;
import main.entity.Stone;
import main.maths.Vector2f;
import main.util.KeyHandler;
import main.util.MouseHandler;

import java.awt.*;

public class Play extends GameState {

    private final Player player;
    private final Stone stone;
    private BulletManager bm;

    public Play(GameStateManager gsm) {
        super(gsm);

        player = new Player(new Vector2f(100, 100));
        stone = new Stone(new Vector2f(100,200));
        bm = new BulletManager(player);
    }

    @Override
    public void update(double dt) {
        player.update(dt, stone);
        stone.update(dt);
        bm.update(dt);
    }

    @Override
    public void inputs(KeyHandler keyH, MouseHandler mouseH) {
        if(keyH.escape.down) {
            gsm.addAndRemoveGameState(GameStateManager.LOBBY, GameStateManager.PLAY);
        }
        player.inputs(keyH, mouseH);
        stone.inputs(keyH, mouseH);
        bm.inputs(keyH, mouseH);
    }

    @Override
    public void render(Graphics2D g2) {
        player.render(g2);
        stone.render(g2);
        bm.render(g2);
    }
}
