package main.entity.stone;

import main.Panel;
import main.entity.EntityManager;
import main.entity.GameObject;
import main.entity.Player;
import main.entity.bullet.BulletManager;
import main.maths.AABB;
import main.maths.Vector2f;
import main.states.states.Play;

public class StoneManager extends EntityManager {

    private final Play play;
    private final BulletManager bm;
    private boolean spawnEntityRatioIncrease;
    private double spawnEntityRatioIncreaseTime;
    private double spawnEntityRatioIncreaseDuration;
    private double entitySpawnTimeRandomBorder;
    private int life = 1;

    public StoneManager(Player player, BulletManager bm, Play play) {
        super(player);

        this.bm = bm;
        this.play = play;

        entitySpawnTimeRandomBorder = 1E9;

        spawnEntityRatioIncreaseDuration = 1E10;

        entityDeleteBorder = Panel.height + 100;
    }

    private int getRandom(int origin, int bounds) {
        return random.nextInt(origin, bounds);
    }

    public void addEntity() {
        int rnd = getRandom(0, Panel.width - 50);

        for (int i = 0; i < entitys.size(); i++) {
            if (entitys.get(i).getBounds().rectangleIsInside(new AABB(rnd, -100, 50, 50))) {
                rnd = getRandom(0, Panel.width - 50);
                i = 0;
            }
        }

        entitys.add(new Stone(new Vector2f(rnd, -100)));
    }
    private void checkCollision() {
        for (GameObject bulletEntity : bm.getEntitys()) {
            for (GameObject stoneEntity : entitys) {
                if (bulletEntity.getBounds().rectangleIsInside(stoneEntity.getBounds())) {
                    bulletEntity.setLife(bulletEntity.getLife() - 1);
                    play.addToHighscore(5);
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
            if (entitySpawnTimeRandomBorder <= 0.1E9) {
                entitySpawnTimeRandomBorder = 0.1E9;
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
                    if (player.getLife() <= 0) {
                        player.setLife(0);
                    }
                    player.setIsInvis(true);
                }
            }
        }

        checkCollision();
    }
}
