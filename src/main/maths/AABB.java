package main.maths;

public class AABB {

    private float x;
    private float y;
    private float width;
    private float height;

    public AABB(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean mouseIsInside(float x, float y) {
        return x > this.x && x < this.x + width && y > this.y && y < this.y + height;
    }

    public boolean rectangleIsInside(AABB rect) {
        return this.x + this.width >= rect.x && this.x <= rect.x + rect.width &&
                this.y + this.height >= rect.y && this.y <= rect.y + rect.height;
    }


    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public float getWidth() {
        return width;
    }
    public float getHeight() {
        return height;
    }

    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }
    public void setWidth(float width) {
        this.width = width;
    }
    public void setHeight(float height) {
        this.height = height;
    }
}
