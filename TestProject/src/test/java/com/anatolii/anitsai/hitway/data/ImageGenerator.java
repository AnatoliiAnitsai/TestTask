package com.anatolii.anitsai.hitway.data;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ImageGenerator {
    private int width;
    private int height;

    public ImageGenerator(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void generateRandImage(String pathToFile, String fileName) {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        File imageFile = null;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int a = (int) (Math.random() * 256);
                int r = (int) (Math.random() * 256);
                int g = (int) (Math.random() * 256);
                int b = (int) (Math.random() * 256);
                int p = (a << 24) | (r << 16) | (g << 8) | b;
                img.setRGB(x, y, p);
            }
        }
        try {
            imageFile = new File(pathToFile + fileName + ".jpg");
            ImageIO.write(img, "jpg", imageFile);
        } catch (IOException e) {
            System.err.println("Error: " + e);
        }
    }
}
