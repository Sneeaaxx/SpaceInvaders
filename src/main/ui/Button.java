package main.ui;

import main.Panel;
import main.graphics.Image;
import main.states.GameStateManager;
import main.util.AABB;
import main.util.KeyHandler;
import main.util.MouseHandler;

import java.awt.*;

public class Button {

    private final Image img;
    private final AABB bounds;

    private int x;
    private final int y;
    private final int width;
    private final int height;

    private final String text;
    private final Font buttonFont;

    private boolean isInside;
    private int isInsideYFactor;
    private int isInsideYTextFactor;

    private boolean isClicked;

    private boolean setCenter;

    public Button(Image img, int x, int y, String text) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.text = text;

        width = img.getWidth();
        height = img.getHeight() / 2;
        bounds = new AABB(this.x, this.y, this.width, this.height);

        buttonFont = new Font("MatchupPro.ttf", Font.PLAIN, 20);
    }

    public void setCenter(boolean setCenter) {
        this.setCenter = setCenter;
    }

    public boolean getClicked() {
        return isClicked;
    }

    public void update(double dt) {
        if (setCenter) {
            x = (Panel.width / 2) - (width / 2);
            bounds.setX(x);
            setCenter = false;
        }

        if (isInside) {
            isInsideYFactor = height;
            isInsideYTextFactor = 40;
        } else {
            isInsideYFactor = 0;
            isInsideYTextFactor = 35;
        }
    }

    public void inputs(KeyHandler keyH, MouseHandler mouseH) {
        isInside = bounds.mouseIsInside(mouseH.getX(), mouseH.getY());

        if (isInside && mouseH.getButton() == 1) {
            isClicked = true;
        } else {
            isClicked = false;
        }
    }

    public void render(Graphics2D g2) {
        g2.drawImage(img.getSubImage(0, isInsideYFactor, width, height), x, y, this.width, this.height, null);

        g2.setFont(buttonFont);
        g2.setColor(Color.lightGray);
        g2.drawString(text, x + GameStateManager.getXForCenteredBoxText(text, width, g2), y + isInsideYTextFactor);

        if (GameStateManager.isShowBounds()) {
            g2.setColor(Color.red);
            g2.drawRect(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());
        }
    }
}
