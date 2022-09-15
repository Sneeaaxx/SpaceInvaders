package main.entity.stone;

import main.Panel;
import main.entity.Player;
import main.maths.Vector2f;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class StoneManager {

    private ArrayList<Stone> stones;
    private Random random;
    private Player player;

    public StoneManager(Player player) {
        stones = new ArrayList<>();
        random = new Random();

        this.player = player;
    }

    public void addStone() {
        stones.add(new Stone(new Vector2f(random.nextInt(10, Panel.width - 50), -100)));
    }

    public void update(double dt) {
        for (Stone stone : stones) {
            stone.update(dt);
            if (player.getBounds().rectangleIsInside(stone.getBounds())) {
                System.out.println("Is Inside");
            }
        }

        addStone();
    }

    public void render(Graphics2D g2) {
        g2.setColor(Color.green);
        for (Stone stone : stones) {
            g2.drawRect((int) stone.getBounds().getX(), (int) stone.getBounds().getY(), (int) stone.getBounds().getWidth(), (int) stone.getBounds().getHeight());
        }
    }
}
