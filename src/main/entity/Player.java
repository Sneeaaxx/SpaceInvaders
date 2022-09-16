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

        dx = 3f;
        dy = 3f;

        life = 3;

        bounds = new AABB((int) vec.getX(), (int) vec.getY(), 50, 50);
    }

    public AABB getBounds() {
        return bounds;
    }

    private void movement() {
        if (vec.getY() - dy > 0 && up) {
            vec.setY(vec.getY() - dy);
        } else if (vec.getY() + dy < Panel.height - bounds.getHeight() && down) {
            vec.setY(vec.getY() + dy);
        }

        if (vec.getX() - dx > 0 && left) {
            vec.setX(vec.getX() - dx);
        } else if (vec.getX() + dx < Panel.width - bounds.getWidth() && right) {
            vec.setX(vec.getX() + dx);
        }
    }

    public void update(double dt) {
        super.update(dt);

        movement();
    }

    public void inputs(KeyHandler keyH, MouseHandler mouseH) {
        up = keyH.w.down;
        left = keyH.a.down;
        down = keyH.s.down;
        right = keyH.d.down;


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
