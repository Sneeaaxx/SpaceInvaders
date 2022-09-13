package main.ui;

import main.Panel;
import main.graphics.Image;
import main.maths.Vector2f;
import main.states.GameStateManager;
import main.maths.AABB;
import main.util.KeyHandler;
import main.util.MouseHandler;

import java.awt.*;

public class Button {

    private final Image img;
    private final AABB bounds;

    private final Vector2f vec;
    private final int width;
    private final int height;

    private final String text;
    private final Font buttonFont;

    private boolean isInside;
    private int isInsideYFactor;
    private int isInsideYTextFactor;

    private boolean isClicked;

    private boolean setCenter;

    public Button(Image img, Vector2f vec, String text) {
        this.img = img;
        this.vec = vec;
        this.text = text;

        width = img.getWidth();
        height = img.getHeight() / 2;
        bounds = new AABB((int) vec.getX(), (int) vec.getY(), this.width, this.height);

        buttonFont = new Font("MatchupPro", Font.PLAIN, 25);
    }

    public void setCenter(boolean setCenter) {
        this.setCenter = setCenter;
    }

    public boolean getClicked() {
        return isClicked;
    }

    public void update(double dt) {
        if (setCenter) {
            vec.setX((float) (Panel.width / 2) - (float) (width / 2));
            bounds.setX((int) vec.getX());
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

        isClicked = isInside && mouseH.getButton() == 1;
    }

    public void render(Graphics2D g2) {
        g2.drawImage(img.getSubImage(0, isInsideYFactor, width, height), (int) vec.getX(), (int) vec.getY(), this.width, this.height, null);

        g2.setFont(buttonFont);
        g2.setColor(Color.lightGray);
        g2.drawString(text, (int) vec.getX() + GameStateManager.getXForCenteredBoxText(text, width, g2), (int) vec.getY() + isInsideYTextFactor);

        if (GameStateManager.isShowBounds()) {
            g2.setColor(Color.red);
            g2.drawRect(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());
        }
    }
}
