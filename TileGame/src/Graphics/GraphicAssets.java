package Graphics;
import java.awt.image.BufferedImage;

public class GraphicAssets {

    private static final int mPlayerWidth = 128;
    private static final int mPlayerHeight = 280;

    public static BufferedImage mPlayerIcon;

    public static BufferedImage mRoost;
    public static BufferedImage mPastry;
    public static BufferedImage mSaute;
    public static BufferedImage mVegtable;
    public static BufferedImage mFish;
   // public static BufferedImage mLevel;
    public static BufferedImage mMainScreen;
    public static BufferedImage mEnemy;
    public static BufferedImage mWall;
    public static BufferedImage mWood;
    public static BufferedImage mFloor;
    public static BufferedImage mKnife;
    public static BufferedImage choppingBlock;

    public static BufferedImage mBackground;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/spritesheet.png"));
        SpriteSheet KitchnSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/kitchen.png"));
        SpriteSheet tileSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/tile.jpg"));
        SpriteSheet background = new SpriteSheet(ImageLoader.loadImage("/res/textures/bg.png"));
        SpriteSheet cuttingBoard = new SpriteSheet(ImageLoader.loadImage("/res/textures/choppingBlock.png"));

        mPlayerIcon = sheet.crop(0,0,mPlayerWidth, mPlayerHeight);
        mRoost = sheet.crop(0,0,130,mPlayerHeight+62);
        mPastry = sheet.crop(130,0,108,mPlayerHeight+62);
        mSaute = sheet.crop(240, 0, 140, mPlayerHeight+62);
        mVegtable = sheet.crop(368, 0, 130, mPlayerHeight+62);
        mFish = sheet.crop(500, 0, 100, mPlayerHeight+62);


       // mLevel = sheet.crop(0,345,600,447);
        mMainScreen = sheet.crop(0,810,600,345);
        mEnemy = sheet.crop(0,1155,45,45);

        choppingBlock = cuttingBoard.crop(0, 0, 430, 210);

        mWood = KitchnSheet.crop(32, 0, 32, 32);
        mFloor = KitchnSheet.crop(64, 0, 32, 32);
        mKnife = KitchnSheet.crop(32 * 3, 0, 32 ,32);

        mWall = tileSheet.crop(0, 0, 450, 450);
        mBackground = background.crop(0, 0, 1600, 925);
    }

}
