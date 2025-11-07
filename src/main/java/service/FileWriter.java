package service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileWriter {

    private static final String SAVE_PATH = "E:/nft/generated/%s.png";
    private static final String FILE_FORMAT = "PNG";

    public void writeFile(BufferedImage nftFile, int counter) throws IOException {
        ImageIO.write(nftFile, FILE_FORMAT, new File(String.format(SAVE_PATH, counter)));
    }
}
