package main.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Image {

    private BufferedImage image;
    private String path;

    public Image(String path) {
        this.path = path;

        loadImage(path);
    }

    private void loadImage(String path) {
        image = null;
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(path)));
        } catch (Exception e) {
            System.out.println("ERROR-Image: Could not load file: " + path);
        }
    }

    public BufferedImage getImage() {
        return image;
    }
    public BufferedImage getSubImage(int x, int y, int width, int height) {
        return image.getSubimage(x, y, width, height);
    }
    public int getWidth() {
        return image.getWidth();
    }
    public int getHeight() {
        return image.getHeight();
    }
}
