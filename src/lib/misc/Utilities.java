package lib.misc;

import main.Main;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Utilities {
    public static int[] fullIntArray(int size, int value) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = value;
        }
        return array;
    }

    public static void drawPImage(Transform transform, PImage image, PVector size) {
        PApplet p = Main.p;
        transform = transform.getParentedTransform();

        p.pushMatrix();
        p.translate(transform.position.x, transform.position.y);
        p.rotate(transform.rotation);
        p.image(image, 0, 0, size.x, size.y);
        p.popMatrix();
    }
}
