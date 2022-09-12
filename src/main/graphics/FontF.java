package main.graphics;

import java.awt.Font;
import java.awt.*;
import java.util.HashMap;
import java.util.Objects;

public class FontF {

    private HashMap<String, Font> fonts;

    public FontF() {
        fonts = new HashMap<String, Font>();
    }

    public void loadFont(String path, String name) {
        try {
            System.out.println("LOADING-FontF: '" + path + "'");
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(path)));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

            Font font = new Font(name, Font.PLAIN, 32);

            fonts.put(name, font);
        } catch (Exception e) {
            System.out.println("ERROR-FontF: Can't load font '" + path + "'");
            e.printStackTrace();
        }
    }

    public Font getFont(String name) {
        return fonts.get(name);
    }
}
