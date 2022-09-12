package main.entity;

import main.Panel;
import main.util.AABB;
import main.util.KeyHandler;
import main.util.MouseHandler;

import java.awt.*;

public class Player extends GameObject {

    public Player(int x, int y) {
        this.x = x;
        this.y = y;

        dx = 0.5f;
        dy = 0.5f;

        bounds = new AABB(x, y, 50, 50);
    }

    private void movement() {
        if (y - dy > 0 && up) {
            y -= dy;
        } else if (y + dy < Panel.height && down) {
            y += dy;
        }

        if (x - dx > 0 && left) {
            x -= dx;
        } else if (x + dx < Panel.width && right) {
            x += dx;
        }
    }

    public void update(double dt) {
        movement();
    }

    public void inputs(KeyHandler keyH, MouseHandler mouseH) {
        up = keyH.up.down;
        down = keyH.down.down;
        right = keyH.right.down;
        left = keyH.left.down;
    }

    public void render(Graphics2D g2) {
        g2.setColor(Color.red);
        g2.drawRect((int) x, (int) y, bounds.getWidth(), bounds.getHeight());
    }
}
