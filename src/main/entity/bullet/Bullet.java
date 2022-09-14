package main.entity.bullet;

import main.entity.GameObject;
import main.maths.AABB;
import main.maths.Vector2f;
import main.util.KeyHandler;
import main.util.MouseHandler;

import java.awt.*;

public class Bullet extends GameObject {

    public Bullet(Vector2f vec) {
        super(vec);

        dy = -4f;
        bounds = new AABB(vec.getX(), vec.getY(), 10, 10);
    }

    public float getY() {
        return (int) vec.getY();
    }

    public void update(double dt) {
        super.update(dt);

        vec.setY(vec.getY() + dy);
    }

    @Override
    public void inputs(KeyHandler keyH, MouseHandler mouseH) {

    }

    public void render(Graphics2D g2) {
        g2.setColor(Color.blue);
        g2.drawRect((int) bounds.getX(), (int) bounds.getY(), (int) bounds.getWidth(), (int) bounds.getHeight());
    }
}
