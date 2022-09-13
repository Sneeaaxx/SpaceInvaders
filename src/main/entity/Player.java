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

        dx = 0.5f;
        dy = 0.5f;

        bounds = new AABB((int) vec.getX(), (int) vec.getY(), 50, 50);
    }

    private void movement() {
        if (vec.getY() - dy > 0 && up) {
            vec.setY(vec.getY() - dy);
        } else if (vec.getY() + dy < Panel.height && down) {
            vec.setY(vec.getY() + dy);
        }

        if (vec.getX() - dx > 0 && left) {
            vec.setX(vec.getX() - dx);
        } else if (vec.getX() + dx < Panel.width && right) {
            vec.setX(vec.getX() + dx);
        }
    }

    public void update(double dt, Stone stone) {
        super.update(dt);

        if (!bounds.rectangleIsInside(stone.bounds)) {
            movement();
        }
    }

    public void inputs(KeyHandler keyH, MouseHandler mouseH) {
        up = keyH.up.down;
        down = keyH.down.down;
        right = keyH.right.down;
        left = keyH.left.down;

        if (up && down) {
            up = false;
            down = false;
        }
        if (right && left) {
            right = false;
            left = false;
        }
    }

    public void render(Graphics2D g2) {
        g2.setColor(Color.red);
        g2.drawRect((int) bounds.getX(), (int) bounds.getY(), (int) bounds.getWidth(), (int) bounds.getHeight());
    }
}
