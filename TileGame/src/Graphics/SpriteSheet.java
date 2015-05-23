package Graphics;
import java.awt.image.BufferedImage;

public class SpriteSheet {

    private BufferedImage mSheet;

    public SpriteSheet(BufferedImage sheet) {
        mSheet = sheet;
    }

    public BufferedImage crop(int x, int y, int width, int height) {
        return mSheet.getSubimage(x, y, width, height);
    }

}
