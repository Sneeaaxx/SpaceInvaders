package main.entity;

import main.entity.bullet.Bullet;
import main.maths.Vector2f;
import main.util.KeyHandler;
import main.util.MouseHandler;

import java.awt.*;
import java.util.ArrayList;

public class BulletManager {

    private ArrayList<Bullet> bullets;

    public BulletManager() {
        bullets = new ArrayList<>();
    }

    private void addBullet() {
        bullets.add(new Bullet(new Vector2f(100, 100)));
    }

    public void update(double dt) {
        for (Bullet bullet : bullets) {

            bullet.update(dt);

            if (bullet.getY() < -50) {
                bullets.remove(bullet);
            }
        }

        addBullet();
    }

    public void inputs(KeyHandler keyH, MouseHandler mouseH) {
        for (Bullet bullet : bullets) {
            bullet.inputs(keyH, mouseH);
        }
    }

    public void render(Graphics2D g2) {
        for (Bullet bullet : bullets) {
            bullet.render(g2);
        }
    }
}
