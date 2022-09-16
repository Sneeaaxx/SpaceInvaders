package main.entity.stone;

import main.Panel;
import main.entity.EntityManager;
import main.entity.GameObject;
import main.entity.Player;
import main.entity.bullet.BulletManager;
import main.maths.Vector2f;

public class StoneManager extends EntityManager {

    private final BulletManager bm;

    public StoneManager(Player player, BulletManager bm) {
        super(player);

        this.bm = bm;

        entityDeleteBorder = Panel.height + 100;
    }

    public void addEntity() {
        entitys.add(new Stone(new Vector2f(random.nextInt(10, Panel.width - 50), -100)));
    }
    private void checkCollision() {
        for (GameObject entity : bm.getEntitys()) {
            entitys.removeIf(stone -> entity.getBounds().rectangleIsInside(stone.getBounds()));
        }
    }

    public void update(double dt) {
        super.update(dt);

        if (canSpawnEntity) {
            entitySpawnTime = dt;
            canSpawnEntity = false;
        } else {
            if (!spawnedEntity) {
                addEntity();
                spawnedEntity = true;
            }

            if (dt > entitySpawnTime + entitySpawnCooldown) {
                canSpawnEntity = true;
                spawnedEntity = false;
                entitySpawnCooldown = random.nextDouble(0, 1E9);
            }
        }

        for (GameObject entity : entitys) {
            if (player.getBounds().rectangleIsInside(entity.getBounds())) {
                System.out.println("Is Inside");
            }
        }

        checkCollision();
    }
}
