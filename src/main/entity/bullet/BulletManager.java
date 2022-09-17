package main.entity.bullet;

import main.entity.EntityManager;
import main.entity.GameObject;
import main.entity.Player;
import main.maths.Vector2f;
import main.util.KeyHandler;
import main.util.MouseHandler;

public class BulletManager extends EntityManager {


    public BulletManager(Player player) {
        super(player);

        entitySpawnCooldown = 0.5E9;
        entityDeleteBorder = -20;
    }

    public void addEntity() {
        entitys.add(new Bullet(new Vector2f(player.getVec().getX() + ((player.getBounds().getWidth() / 2) - 5), player.getVec().getY())));
    }

    public void update(double dt) {
        super.update(dt);

        entitys.removeIf(bullet -> bullet.getLife() <= 0);

        if (canSpawnEntity) {
            entitySpawnTime = dt;
        } else {
            if (!spawnedEntity) {
                addEntity();
                spawnedEntity = true;
            }

            if (dt > entitySpawnCooldown + entitySpawnTime) {
                canSpawnEntity = true;
                spawnedEntity = false;
            }
        }

        entitys.removeIf(bullet -> bullet.getY() < entityDeleteBorder);
    }

    public void inputs(KeyHandler keyH, MouseHandler mouseH) {
        keyH.tick();

        for (GameObject entity : entitys) {
            entity.inputs(keyH, mouseH);
        }

        if (canSpawnEntity && keyH.space.clicked) {
            canSpawnEntity = false;
        }
    }
}
