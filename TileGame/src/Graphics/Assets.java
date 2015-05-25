package Graphics;
import java.awt.image.BufferedImage;

public class Assets {

    private static final int mPlayerWidth = 128;
    private static final int getmPlayerHeight = 280;

    public static BufferedImage mPlayer;
    public static BufferedImage mLevel;
    public static BufferedImage mMainScreen;
    public static BufferedImage mEnemy;

    public static BufferedImage mWall;
    public static BufferedImage mWood;
    public static BufferedImage mFloor;
    public static BufferedImage mKnife;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/spritesheet.png"));
        SpriteSheet KitchnSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/kitchen.png"));
        SpriteSheet tileSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/tile.jpg"));

        mPlayer = sheet.crop(0,0,mPlayerWidth,getmPlayerHeight);
        mLevel = sheet.crop(0,345,600,447);
        mMainScreen = sheet.crop(0,810,600,345);
        mEnemy = sheet.crop(0,1155,45,45);

        mWood = KitchnSheet.crop(32, 0, 32, 32);
        mFloor = KitchnSheet.crop(64, 0, 32, 32);
        mKnife = KitchnSheet.crop(32 * 3, 0, 32 ,32);

        mWall = tileSheet.crop(0,0, 450, 450);

    }

}
