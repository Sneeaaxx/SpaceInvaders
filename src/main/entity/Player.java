package main.entity;

import main.states.GameStateManager;
import main.util.AABB;
import main.util.KeyHandler;
import main.util.MouseHandler;

import java.awt.*;

public class Player extends GameObject {

    public Player(int x, int y) {
        this.x = x;
        this.y = y;

        bounds = new AABB(x, y, 50, 50);
    }

    private void movement() {
        if (up) {
            y += dy;
        } else if (down) {
            y -= dy;
        }

        if (right) {
            x += dx;
        } else  if (left) {
            x -= dx;
        }
    }

    public void update(double dt) {
        movement();

    }

    public void inputs(KeyHandler keyH, MouseHandler mouseH) {
        if (keyH.up.down) {
            up = true;
        } else if (keyH.down.down) {
            down = true;
        } else {
            up = false;
            down = false;
        }

        if (keyH.right.down) {
            right = true;
        } else if (keyH.left.down) {
            left = true;
        } else {
            right = false;
            left = false;
        }
    }

    public void render(Graphics2D g2) {
        if (GameStateManager.isShowBounds()) {
            g2.setColor(Color.red);
            g2.drawRect((int) x, (int) y, bounds.getWidth(), bounds.getHeight());
        }
    }
}
