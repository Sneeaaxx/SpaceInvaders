package main.entity;

import main.entity.bullet.Bullet;
import main.maths.Vector2f;
import main.states.GameState;
import main.states.GameStateManager;
import main.util.KeyHandler;
import main.util.MouseHandler;

import java.awt.*;
import java.util.ArrayList;

public class BulletManager {

    private ArrayList<Bullet> bullets;
    private Player player;
    private boolean canSpawnBullet;
    private boolean spawnedBullet;
    private double bulletSpawnCooldown;
    private double bulletSpawnTime;

    public BulletManager(Player player) {
        this.player = player;
        bullets = new ArrayList<>();
        bulletSpawnCooldown = 1E9;
    }

    private void addBullet() {
        bullets.add(new Bullet(new Vector2f(player.vec.getX() + ((player.getBounds().getWidth() / 2) - 5), player.vec.getY())));
    }

    public void update(double dt) {
        for (Bullet bullet : bullets) {
            bullet.update(dt);
        }

        bullets.removeIf(bullet -> bullet.getY() < 40);

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
        for (Bullet bullet : bullets) {
            bullet.render(g2);
        }
    }
}
