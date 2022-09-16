package main.entity;

import main.graphics.Image;
import main.maths.AABB;
import main.maths.Vector2f;
import main.util.KeyHandler;
import main.util.MouseHandler;

import java.awt.*;

public abstract class GameObject {

    protected float dx;
    protected float dy;

    protected boolean up;
    protected boolean down;
    protected boolean right;
    protected boolean left;

    protected int life;
    protected boolean dead;
    protected double invisTime;
    protected double invisCooldown;
    protected boolean isInvis;

    protected float invisAlpha;

    protected AABB bounds;
    protected Image img;
    protected Vector2f vec;

    protected GameObject(Vector2f vec) {
        this.vec = vec;
    }


    public void setLife(int life) {
        this.life = life;
    }
    public void setIsInvis(boolean isInvis) { this.isInvis = isInvis; }

    public Vector2f getVec() { return vec; }
    public AABB getBounds() { return bounds; }
    public float getY() {
        return (int) vec.getY();
    }
    public boolean getDead() { return dead; }
    public boolean getIsInvis() { return isInvis; }
    public int getLife() { return life; }

    public void update(double dt) {
        bounds.setX(vec.getX());
        bounds.setY(vec.getY());

        if (life <= 0) {
            dead = true;
        }
    }
    public void inputs(KeyHandler keyH, MouseHandler mouseH) {

    }
    public void render(Graphics2D g2) {
        g2.setColor(Color.red);
        g2.drawRect((int) bounds.getX(), (int) bounds.getY(), (int) bounds.getWidth(), (int) bounds.getHeight());
    }
}
