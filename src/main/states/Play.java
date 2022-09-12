package main.states;

import main.entity.Player;
import main.util.KeyHandler;
import main.util.MouseHandler;

import java.awt.*;

public class Play extends GameState {

    private Player player;

    public Play(GameStateManager gsm) {
        super(gsm);

        player = new Player(100, 100);
    }

    @Override
    public void update(double dt) {
        player.update(dt);
    }

    @Override
    public void inputs(KeyHandler keyH, MouseHandler mouseH) {
        if(keyH.escape.down) {
            gsm.addAndRemoveGameState(GameStateManager.LOBBY, GameStateManager.PLAY);
        }
        player.inputs(keyH,mouseH);
    }

    @Override
    public void render(Graphics2D g2) {
        player.render(g2);
    }
}
