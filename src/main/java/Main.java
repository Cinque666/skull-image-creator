import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    private static final int height = 2500;
    private static final int width = 2500;

    public static void main(String[] args) throws IOException {
        File[] backgrounds = getFiles("C:/Skull/Background/");
        File[] backs = getFiles("C:/Skull/Back/");
        File[] bodies = getFiles("C:/Skull/Body/");
        File[] eyes = getFiles("C:/Skull/Eyes");
        File[] clothes = getFiles("C:/Skull/Clothes");
        File[] accessories = getFiles("C:/Skull/Accessories");
        File[] heads = getFiles("C:/Skull/Head");
        File[] mouths = getFiles("C:/Skull/Mouth");
        int counter = 0;

        while(counter<100){
            BufferedImage bufBackground = ImageIO.read(backgrounds[ThreadLocalRandom.current().nextInt(backgrounds.length)]);
            BufferedImage bufBack = ImageIO.read(backs[ThreadLocalRandom.current().nextInt(backs.length)]);
            BufferedImage bufBody = ImageIO.read(bodies[ThreadLocalRandom.current().nextInt(bodies.length)]);
            BufferedImage bufClothe = ImageIO.read(clothes[ThreadLocalRandom.current().nextInt(clothes.length)]);
            BufferedImage bufHead = ImageIO.read(heads[ThreadLocalRandom.current().nextInt(heads.length)]);
            BufferedImage bufAccessory = ImageIO.read(accessories[ThreadLocalRandom.current().nextInt(accessories.length)]);
            BufferedImage bufEye = ImageIO.read(eyes[ThreadLocalRandom.current().nextInt(eyes.length)]);
            BufferedImage bufMouth = ImageIO.read(mouths[ThreadLocalRandom.current().nextInt(mouths.length)]);

            BufferedImage combined = new BufferedImage(2500, 2500, BufferedImage.TYPE_INT_ARGB);

            Graphics g = combined.getGraphics();
            g.drawImage(bufBackground, 0, 0, null);
            g.drawImage(bufBack, 0, 0, null);
            g.drawImage(bufBody, 0, 0, null);
            g.drawImage(bufClothe, 0, 0, null);
            g.drawImage(bufHead, 0, 0, null);
            g.drawImage(bufAccessory, 0, 0, null);
            g.drawImage(bufEye, 0, 0, null);
            g.drawImage(bufMouth, 0, 0, null);
            ImageIO.write(combined, "PNG", new File(String.format("C:/nft/nft/generated/%s.png", counter)));
            counter++;
        }
    }

    private static File[] getFiles(String path) {
        File folder = new File(path);
        return folder.listFiles();
    }
}
