package main.states;

import main.Panel;
import main.graphics.FontF;
import main.states.states.*;
import main.util.KeyHandler;
import main.util.MouseHandler;

import java.awt.*;

public class GameStateManager {

    private final GameState[] gs;
    public static final int LOBBY = 0;
    public static final int PLAY = 1;
    public static final int OPTIONS = 4;
    public static final int HIGHSCORE = 2;
    public static final int PAUSE = 3;
    public static final int DEATH = 5;

    public static FontF fontF;

    private static boolean showBounds;

    public GameStateManager() {
        gs = new GameState[10];

        fontF = new FontF();
        fontF.loadFont("fonts/Stackedpixel.ttf", "MeatMadness");
        fontF.loadFont("fonts/GravityBold8.ttf", "GravityBold8");
        fontF.loadFont("fonts/ExpressionPro.ttf", "ExpressionPro");
        fontF.loadFont("fonts/EquipmentPro.ttf", "EquipmentPro");
        fontF.loadFont("fonts/CompassPro.ttf", "CompassPro");
        fontF.loadFont("fonts/FutilePro.ttf", "FutilePro");
        fontF.loadFont("fonts/MatchupPro.ttf", "MatchupPro");

        addGameState(LOBBY);
    }

    public boolean isState(int i) {
        return gs[i] != null;
    }
    public GameState getState(int i) { return gs[i]; }

    public void addAndRemoveGameState(int add, int remove) {
        addGameState(add);
        removeGameState(remove);
    }

    public void removeGameState(int num) {
        if (num > gs.length) {
            System.out.println("ERROR-GameStateManager: The '" + num + "' doesn't exists");
            return;
        }
        if (gs[num] == null) {
            System.out.println("ERROR-GameStateManager: The GameState '" + num + "' is already null");
            return;
        }

        gs[num] = null;
    }

    public void addGameState(int num) {
        if (num > gs.length) {
            System.out.println("ERROR-GameStateManager: The '" + num + "' doesn't exists");
            return;
        }
        if (gs[num] != null) {
            System.out.println("ERROR-GameStateManager: The '" + num + "' GameState already exists");
            return;
        }

        System.out.println("LOADING-GameState: '" + num + "'");

        switch (num) {
            case LOBBY -> {
                gs[num] = new Lobby(this);
            }
            case OPTIONS -> {
                gs[num] = new Options(this);
            }
            case HIGHSCORE -> {
                gs[num] = new Highscore(this);
            }
            case PLAY -> {
                gs[num] = new Play(this);
            }
            case PAUSE -> {
                gs[num] = new Pause(this);
            }
            case DEATH -> {
                gs[num] = new Death(this);
            }
            default -> System.out.println("ERROR-GameStateManager: There is no GameState with this num: '" + num + "'");
        }
    }

    public void update(double dt) {
        for (GameState g : gs) {
            if (g != null) {
                g.update(dt);
            }
        }
    }

    public void inputs(KeyHandler keyH, MouseHandler mouseH) {

        if (showBounds) {
            showBounds = false;
        }
        if (keyH.F1.down) {
            showBounds = true;
        }

        for (GameState g : gs) {
            if (g != null) {
                g.inputs(keyH, mouseH);
            }
        }
    }

    public void render(Graphics2D g2) {
        for (GameState g : gs) {
            if (g != null) {
                g.render(g2);
            }
        }
    }

    public static boolean isShowBounds() {
        return showBounds;
    }

    public static int getXForCenteredFrameText(String text, Graphics2D g2) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return Panel.width / 2 - length / 2;
    }

    public static int getXForTextAlignToRight(String text, int width, Graphics2D g2) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return width - length - 20;
    }

    public static int getXForCenteredBoxText(String text, int width, Graphics2D g2) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return width / 2 - length / 2;
    }
}
