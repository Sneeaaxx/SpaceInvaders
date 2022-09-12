package main.entity;

import main.graphics.Image;
import main.util.AABB;

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

}
