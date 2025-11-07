package service;

import model.Nft;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class NftService {

    private final PartsService partsService = new PartsService();
    private final DrawService drawService = new DrawService();
    private final FileWriter fileWriter = new FileWriter();

    private static final int WIDTH = 2500;
    private static final int HEIGHT = 2500;

    public void prepareNfts(int totalNfts) throws IOException {
        int counter = 1;

        while(counter<=totalNfts){
            Nft nft = prepareNft();

            BufferedImage nftFile = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);

            Graphics graphic = nftFile.getGraphics();
            drawService.drawImage(graphic, nft.getBufBackground());
            drawService.drawImage(graphic, nft.getBufBack());
            drawService.drawImage(graphic, nft.getBufBody());
            drawService.drawImage(graphic, nft.getBufClothe());
            drawService.drawImage(graphic, nft.getBufHead());
            drawService.drawImage(graphic, nft.getBufAccessory());
            drawService.drawImage(graphic, nft.getBufEye());
            drawService.drawImage(graphic, nft.getBufMouth());

            fileWriter.writeFile(nftFile, counter);
            counter++;
        }
    }

    private Nft prepareNft() throws IOException {
        Nft nft = new Nft();
        nft.setBufBackground(readImage(partsService.getRandomBackground()));
        nft.setBufBack(readImage(partsService.getRandomBack()));
        nft.setBufBody(readImage(partsService.getRandomBody()));
        nft.setBufClothe(readImage(partsService.getRandomClothes()));
        nft.setBufHead(readImage(partsService.getRandomHeads()));
        nft.setBufAccessory(readImage(partsService.getRandomAccessories()));
        nft.setBufEye(readImage(partsService.getRandomEyes()));
        nft.setBufMouth(readImage(partsService.getRandomMouths()));
        return nft;
    }

    private BufferedImage readImage(File file) throws IOException {
        return ImageIO.read(file);
    }
}
