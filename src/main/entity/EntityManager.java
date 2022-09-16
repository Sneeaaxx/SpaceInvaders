package main.entity;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public abstract class EntityManager {

    protected ArrayList<GameObject> entitys;
    protected Random random;
    protected Player player;

    protected boolean canSpawnEntity;
    protected boolean spawnedEntity;
    protected double entitySpawnCooldown;
    protected double entitySpawnTime;

    protected int entityDeleteBorder;

    protected EntityManager(Player player) {
        this.player = player;

        entitys = new ArrayList<>();
        random = new Random();

        entitySpawnCooldown = 1E9;
        canSpawnEntity = true;
    }

    public ArrayList<GameObject> getEntitys() {
        return entitys;
    }

    public abstract void addEntity();

    public void update(double dt) {
        if (!entitys.isEmpty()) {
            for (GameObject entity : entitys) {
                entity.update(dt);
            }
        }
    }

    public void render(Graphics2D g2) {
        g2.setColor(Color.green);
        for (GameObject entity : entitys) {
            g2.drawRect((int) entity.getBounds().getX(), (int) entity.getBounds().getY(), (int) entity.getBounds().getWidth(), (int) entity.getBounds().getHeight());
        }
    }
}
