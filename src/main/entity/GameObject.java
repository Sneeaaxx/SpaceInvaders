package main.entity;

import main.graphics.Image;
import main.maths.AABB;
import main.maths.Vector2f;

public abstract class GameObject {

    protected float x;
    protected float y;
    protected float dx;
    protected float dy;

    protected boolean up;
    protected boolean down;
    protected boolean right;
    protected boolean left;

    protected AABB bounds;
    protected Image img;
    protected Vector2f vec;

    protected GameObject(Vector2f vec) {
        this.vec = vec;
    }

}
