package main.entity.stone;

import main.entity.GameObject;
import main.maths.AABB;
import main.maths.Vector2f;
import main.util.KeyHandler;
import main.util.MouseHandler;

public class Stone extends GameObject {

    private int size;
    public Stone(Vector2f vec, int size) {
        super(vec);

        this.size = size;

        this.dy = 3f;

        bounds = new AABB(vec.getX(), vec.getY(), size, size);
    }

    @Override
    public void update(double dt) {
        super.update(dt);

        vec.setY(vec.getY() + dy);
    }

    @Override
    public void inputs(KeyHandler keyH, MouseHandler mouseH) {

    }
}
