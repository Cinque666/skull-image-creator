import service.NftService;

import java.awt.*;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        NftService nftService = new NftService();
        nftService.prepareNfts(100);
    }

}
