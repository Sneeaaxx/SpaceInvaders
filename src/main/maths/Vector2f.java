package main.maths;

public class Vector2f {

    private float x;
    private float y;

    public Vector2f() {
        x = 0;
        y = 0;
    }
    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public Vector2f(Vector2f vec) {
        this.x = vec.getX();
        this.y = vec.getY();
    }

    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }
    public void setVector2f(Vector2f vec) {
        setX(vec.x);
        setY(vec.y);
    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
}
