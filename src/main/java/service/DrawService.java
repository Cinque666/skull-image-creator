package service;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawService {

    private static final int START_X = 0;
    private static final int START_Y = 0;

    public void drawImage(Graphics graphic, BufferedImage image) {
        graphic.drawImage(image, START_X, START_Y, null);
    }
}
