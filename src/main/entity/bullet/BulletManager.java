package main.entity.bullet;

import main.entity.Player;
import main.maths.Vector2f;
import main.util.KeyHandler;
import main.util.MouseHandler;

import java.awt.*;
import java.util.ArrayList;

public class BulletManager {

    private final ArrayList<Bullet> bullets;
    private final Player player;
    private boolean canSpawnBullet;
    private boolean spawnedBullet;
    private final double bulletSpawnCooldown;
    private double bulletSpawnTime;

    public BulletManager(Player player) {
        this.player = player;
        bullets = new ArrayList<>();

        canSpawnBullet = true;
        bulletSpawnCooldown = 0.5E9;
    }

    private void addBullet() {
        bullets.add(new Bullet(new Vector2f(player.getVec().getX() + ((player.getBounds().getWidth() / 2) - 5), player.getVec().getY())));
    }

    public void update(double dt) {
        for (Bullet bullet : bullets) {
            bullet.update(dt);
        }
        bullets.removeIf(bullet -> bullet.getY() < -20);

        if (canSpawnBullet) {
            bulletSpawnTime = dt;
        } else {
            if (!spawnedBullet) {
                addBullet();
                spawnedBullet = true;
            }

            if (dt > bulletSpawnCooldown + bulletSpawnTime) {
                canSpawnBullet = true;
                spawnedBullet = false;
            }
        }
    }

    public void inputs(KeyHandler keyH, MouseHandler mouseH) {
        keyH.tick();

        for (Bullet bullet : bullets) {
            bullet.inputs(keyH, mouseH);
        }

        if (canSpawnBullet && keyH.space.clicked) {
            canSpawnBullet = false;
        }
    }

    public void render(Graphics2D g2) {
        g2.setColor(Color.blue);
        for (Bullet bullet : bullets) {
            g2.drawRect((int) bullet.getBounds().getX(), (int) bullet.getBounds().getY(), (int) bullet.getBounds().getWidth(), (int) bullet.getBounds().getHeight());
        }
    }
}
