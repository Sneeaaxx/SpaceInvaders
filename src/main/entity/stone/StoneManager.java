package main.entity.stone;

import main.Panel;
import main.entity.EntityManager;
import main.entity.GameObject;
import main.entity.Player;
import main.entity.bullet.BulletManager;
import main.maths.Vector2f;

public class StoneManager extends EntityManager {

    private final BulletManager bm;
    private boolean spawnEntityRatioIncrease;
    private double spawnEntityRatioIncreaseTime;
    private double spawnEntityRatioIncreaseDuration;
    private double entitySpawnTimeRandomBorder;
    private int life = 1;

    public StoneManager(Player player, BulletManager bm) {
        super(player);

        this.bm = bm;

        entitySpawnTimeRandomBorder = 1E9;

        spawnEntityRatioIncreaseDuration = 1E10;

        entityDeleteBorder = Panel.height + 100;
    }

    public void addEntity() {
        entitys.add(new Stone(new Vector2f(random.nextInt(10, Panel.width - 50), -100)));
    }
    private void checkCollision() {
        for (GameObject bulletEntity : bm.getEntitys()) {
            for (GameObject stoneEntity : entitys) {
                if (bulletEntity.getBounds().rectangleIsInside(stoneEntity.getBounds())) {
                    bulletEntity.setLife(bulletEntity.getLife() - 1);
                }
            }
            entitys.removeIf(stone -> bulletEntity.getBounds().rectangleIsInside(stone.getBounds()));
        }
    }

    public void update(double dt) {
        super.update(dt);

        if (spawnEntityRatioIncrease) {
            spawnEntityRatioIncreaseTime = dt;
            spawnEntityRatioIncrease = false;
        } else if (dt > spawnEntityRatioIncreaseDuration + spawnEntityRatioIncreaseTime) {
            entitySpawnTimeRandomBorder -= 0.05E9;
            if (entitySpawnTimeRandomBorder <= 0.4E9) {
                entitySpawnTimeRandomBorder = 0.4E9;
            }
            System.out.println(entitySpawnTimeRandomBorder);
            spawnEntityRatioIncrease = true;
        }

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
                entitySpawnCooldown = random.nextDouble(0, entitySpawnTimeRandomBorder);
            }
        }

        boolean gotHit = false;
        for (GameObject entity : entitys) {
            if (player.getBounds().rectangleIsInside(entity.getBounds())) {
                if (!player.getIsInvis()) {
                    player.setLife(player.getLife() - 1);
                    player.setIsInvis(true);
                }
            }
        }

        checkCollision();
    }
}
