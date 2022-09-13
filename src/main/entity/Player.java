package main.entity;

import main.Panel;
import main.maths.AABB;
import main.maths.Vector2f;
import main.util.KeyHandler;
import main.util.MouseHandler;

import java.awt.*;

public class Player extends GameObject {

    public Player(Vector2f vec) {
        super(vec);

        this.x = vec.getX();
        this.y = vec.getY();

        dx = 0.5f;
        dy = 0.5f;

        bounds = new AABB((int) x, (int) y, 50, 50);
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

        vec.setX(x);
        vec.setY(y);
    }

    public void inputs(KeyHandler keyH, MouseHandler mouseH) {
        up = keyH.up.down;
        down = keyH.down.down;
        right = keyH.right.down;
        left = keyH.left.down;
    }

    public void render(Graphics2D g2) {
        g2.setColor(Color.red);
        g2.drawRect((int) vec.getX(), (int) vec.getY(), bounds.getWidth(), bounds.getHeight());
    }
}
