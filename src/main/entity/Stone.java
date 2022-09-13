package main.entity;

import main.maths.AABB;
import main.maths.Vector2f;
import main.util.KeyHandler;
import main.util.MouseHandler;

import java.awt.*;

public class Stone extends GameObject {
    public Stone(Vector2f vec) {
        super(vec);

        this.dy = 0.3f;

        bounds = new AABB(vec.getX(), vec.getY(), 50, 50);
    }

    @Override
    public void update(double dt) {
        super.update(dt);

        vec.setY(vec.getY() + dy);
    }

    @Override
    public void inputs(KeyHandler keyH, MouseHandler mouseH) {

    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(Color.green);
        g2.drawRect((int) bounds.getX(), (int) bounds.getY(), (int) bounds.getWidth(), (int) bounds.getHeight());
    }
}
