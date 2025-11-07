package service;

import lombok.Getter;

import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

@Getter
public class PartsService {

    private static final String IMAGE_PATH = "E:/code/nft/Череп/";

    private final File[] backgrounds = getFiles(IMAGE_PATH + "Background/");
    private final File[] backs = getFiles(IMAGE_PATH + "Back/");
    private final File[] bodies = getFiles(IMAGE_PATH + "Body/");
    private final File[] eyes = getFiles(IMAGE_PATH + "Eyes/");
    private final File[] clothes = getFiles(IMAGE_PATH + "Clothes/");
    private final File[] accessories = getFiles(IMAGE_PATH + "Accessories/");
    private final File[] heads = getFiles(IMAGE_PATH + "Head/");
    private final File[] mouths = getFiles(IMAGE_PATH + "Mouth/");

    private static File[] getFiles(String path) {
        File folder = new File(path);
        return folder.listFiles();
    }

    public File getRandomBackground() {
        return getRandomFileFromArray(backgrounds);
    }

    public File getRandomBack() {
        return getRandomFileFromArray(backs);
    }

    public File getRandomBody() {
        return getRandomFileFromArray(bodies);
    }

    public File getRandomEyes() {
        return getRandomFileFromArray(eyes);
    }

    public File getRandomClothes() {
        return getRandomFileFromArray(clothes);
    }

    public File getRandomAccessories() {
        return getRandomFileFromArray(accessories);
    }

    public File getRandomHeads() {
        return getRandomFileFromArray(heads);
    }

    public File getRandomMouths() {
        return getRandomFileFromArray(mouths);
    }

    private File getRandomFileFromArray(File[] files) {
        if (files == null || files.length == 0) {
            return null;
        }
        return files[ThreadLocalRandom.current().nextInt(files.length)];
    }
}
