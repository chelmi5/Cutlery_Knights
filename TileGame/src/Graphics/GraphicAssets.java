package Graphics;
import Items.Oregano;

import java.awt.image.BufferedImage;

public class GraphicAssets {

    private static final int mPlayerWidth = 128;
    private static final int mPlayerHeight = 280;

    public static BufferedImage mPlayerStill;
    public static BufferedImage mPlayerDownRight;
    public static BufferedImage mPlayerDownMid;
    public static BufferedImage mPlayerDownLeft;
    public static BufferedImage mPlayerLeftLeft;
    public static BufferedImage mPlayerLeftMid;
    public static BufferedImage mPlayerLeftRight;
    public static BufferedImage mPlayerUpLeft;
    public static BufferedImage mPlayerUpMid;
    public static BufferedImage mPlayerUpRight;
    public static BufferedImage mPlayerRightLeft;
    public static BufferedImage mPlayerRightMid;
    public static BufferedImage mPlayerRightRight;

    public static BufferedImage mRoost;
    public static BufferedImage mPastry;
    public static BufferedImage mSaute;
    public static BufferedImage mVegetable;
    public static BufferedImage mFishChef;

    public static BufferedImage mRoostHead;
    public static BufferedImage mPastryHead;
    public static BufferedImage mSauteHead;
    public static BufferedImage mVeggieHead;
    public static BufferedImage mFishHead;

    public static BufferedImage mRoostFight;
    public static BufferedImage mPastryFight;
    public static BufferedImage mSauteFight;
    public static BufferedImage mVeggieFight;
    public static BufferedImage mFishFight;

    public static BufferedImage mMainScreen;
    public static BufferedImage mEnemy;
    public static BufferedImage mWall;
    public static BufferedImage mWood;
    public static BufferedImage mFloor;
    public static BufferedImage mKnife;
    public static BufferedImage choppingBlock;
    public static BufferedImage mBackground;
    public static BufferedImage mCake;
    public static BufferedImage mChop;
    public static BufferedImage mCounter;
    public static BufferedImage mCupcakes;
    public static BufferedImage mDoor;
    public static BufferedImage mEmptyplate;
    public static BufferedImage mFloor2;
    public static BufferedImage mFood1;
    public static BufferedImage mFood2;
    public static BufferedImage mFood3;
    public static BufferedImage mFood4;
    public static BufferedImage mFood5;
    public static BufferedImage mFrosting;
    public static BufferedImage mPie;
    public static BufferedImage mPots;
    public static BufferedImage mSprinklesfloor;
    public static BufferedImage mStove;
    public static BufferedImage mhealthHolder;
    public static BufferedImage mHealth;
    public static BufferedImage mEnter;
    public static BufferedImage mSbutton;
    public static BufferedImage mStatsholder;
    public static BufferedImage mEggs;
    public static BufferedImage mDount;
    public static BufferedImage mFish;
    public static BufferedImage mOregano;
    public static BufferedImage mRoseMary;
    public static BufferedImage mArtificialPer;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/spritesheet.png"));
        SpriteSheet KitchnSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/kitchen.png"));
        SpriteSheet tileSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/tile.jpg"));
        SpriteSheet background = new SpriteSheet(ImageLoader.loadImage("/res/textures/bg.png"));
        SpriteSheet cuttingBoard = new SpriteSheet(ImageLoader.loadImage("/res/textures/choppingBlock.png"));
        SpriteSheet cake = new SpriteSheet(ImageLoader.loadImage("/res/textures/cake.png"));
        SpriteSheet chop = new SpriteSheet(ImageLoader.loadImage("/res/textures/chop.png"));
        SpriteSheet counter = new SpriteSheet(ImageLoader.loadImage("/res/textures/counter.png"));
        SpriteSheet cupcakes = new SpriteSheet(ImageLoader.loadImage("/res/textures/cupcakes.png"));
        SpriteSheet door = new SpriteSheet(ImageLoader.loadImage("/res/textures/door.png"));
        SpriteSheet emptyplate = new SpriteSheet(ImageLoader.loadImage("/res/textures/emptyplate.png"));
        SpriteSheet floor = new SpriteSheet(ImageLoader.loadImage("/res/textures/floor.png"));
        SpriteSheet food1 = new SpriteSheet(ImageLoader.loadImage("/res/textures/food1.png"));
        SpriteSheet food2 = new SpriteSheet(ImageLoader.loadImage("/res/textures/food2.png"));
        SpriteSheet food3 = new SpriteSheet(ImageLoader.loadImage("/res/textures/food3.png"));
        SpriteSheet food4 = new SpriteSheet(ImageLoader.loadImage("/res/textures/food4.png"));
        SpriteSheet food5 = new SpriteSheet(ImageLoader.loadImage("/res/textures/food5.jpg"));
        SpriteSheet frosting = new SpriteSheet(ImageLoader.loadImage("/res/textures/frosting.png"));
        SpriteSheet pie = new SpriteSheet(ImageLoader.loadImage("/res/textures/pie.png"));
        SpriteSheet sprinklesfloor = new SpriteSheet(ImageLoader.loadImage("/res/textures/sprinklesfloor.png"));
        SpriteSheet stove = new SpriteSheet(ImageLoader.loadImage("/res/textures/stove.png"));
        SpriteSheet pots = new SpriteSheet(ImageLoader.loadImage("/res/textures/pot.jpg"));
        SpriteSheet healthHolder = new SpriteSheet(ImageLoader.loadImage("/res/textures/healthholder.png"));
        SpriteSheet health = new SpriteSheet(ImageLoader.loadImage("/res/textures/health.png"));
        SpriteSheet enter = new SpriteSheet(ImageLoader.loadImage("/res/textures/enter.png"));
        SpriteSheet sbutton = new SpriteSheet(ImageLoader.loadImage("/res/textures/sbutton.png"));
        SpriteSheet statsholder = new SpriteSheet(ImageLoader.loadImage("/res/textures/statsholder.png"));
        SpriteSheet oregano = new SpriteSheet(ImageLoader.loadImage("/res/textures/spices.png"));

        mPlayerStill = sheet.crop(3, 1250, 56, 100);
        mPlayerDownRight = sheet.crop(60, 1250, 56, 100);
        mPlayerDownMid = mPlayerStill;
        mPlayerDownLeft = sheet.crop(172, 1250, 56, 100);
        mPlayerLeftLeft = sheet.crop(278, 1250, 49, 100);
        mPlayerLeftMid = sheet.crop(325, 1250, 50, 100);
        mPlayerLeftRight = sheet.crop(373, 1250, 50, 100);
        mPlayerUpMid = sheet.crop(421, 1250, 56, 100);
        mPlayerUpRight = sheet.crop(479, 1250, 56, 100);
        mPlayerUpLeft = sheet.crop(535, 1250, 56, 100);
        mPlayerRightRight = sheet.crop(393, 1155, 50, 95);
        mPlayerRightMid = sheet.crop(442, 1155, 50, 95);
        mPlayerRightLeft = sheet.crop(490, 1155, 50, 95);

        mRoost = sheet.crop(0, 0, 130, mPlayerHeight+20);
        mPastry = sheet.crop(130, 0, 108 ,mPlayerHeight+20);
        mSaute = sheet.crop(240, 0, 140, mPlayerHeight+20);
        mVegetable = sheet.crop(380, 0, 120, mPlayerHeight+20);
        mFishChef = sheet.crop(500, 0, 100, mPlayerHeight+20);

       // mRoostHead = sheet.crop(0, 0, 130, mPlayerHeight - 20);
       // mPastryHead = sheet.crop(130, 0, 108 ,mPlayerHeight - 20);
       // mSauteHead = sheet.crop(240, 0, 108 ,mPlayerHeight - 20);
       // mVeggieHead = sheet.crop(380, 0, 120, mPlayerHeight - 20);
       // mFishHead = sheet.crop(500, 0, 120, mPlayerHeight - 20);

        mRoostFight = sheet.crop(0, 1355, 120, 120);
        mPastryFight = sheet.crop(125, 1355, 120, 120);
        mSauteFight = sheet.crop(250, 1355, 120, 120);
        mVeggieFight = sheet.crop(375, 1355, 115, 120);
        mFishFight = sheet.crop(490, 1355, 100, 120);

        //mEnemy = sheet.crop(0, 1155, 45, 45);
        mEggs = sheet.crop(50, 1155, 90, 90);
        mDount = sheet.crop(145, 1155, 90, 90);
        mFish = sheet.crop(240, 1155, 156, 90);

        mMainScreen = sheet.crop(0, 810, 600,345);
        choppingBlock = cuttingBoard.crop(0, 0, 430, 210);
        mWood = KitchnSheet.crop(32, 0, 32, 32);
        mFloor = KitchnSheet.crop(64, 0, 32, 32);
        mKnife = KitchnSheet.crop(32 * 3, 0, 32 ,32);
        mWall = tileSheet.crop(0, 0, 450, 450);
        mBackground = background.crop(0, 0, 1600, 925);

        mCake = cake.crop(0, 0, 64, 64);
        mChop = chop.crop(0, 0, 64, 64);
        mCounter = counter.crop(0, 0, 64, 64);
        mCupcakes = cupcakes.crop(0, 0, 64, 64);
        mDoor = door.crop(0, 0, 64, 64);
        mEmptyplate = emptyplate.crop(0, 0, 64, 64);
        mFloor2 = floor.crop(0, 0, 64, 64);
        mFood1 = food1.crop(0, 0, 64, 64);
        mFood2 = food2.crop(0, 0, 64, 64);
        mFood3 = food3.crop(0, 0, 64, 64);
        mFood4 = food4.crop(0, 0, 64, 64);
        mFood5 = food5.crop(0, 0, 64, 64);
        mFrosting = frosting.crop(0, 0, 64, 64);
        mPie = pie.crop(0, 0, 64, 64);
        mSprinklesfloor = sprinklesfloor.crop(0, 0, 64, 64);
        mStove = stove.crop(0, 0, 64, 64);
        mPots = pots.crop(0, 0, 64, 64);

        mHealth = health.crop(0, 0, 200, 20);
        mhealthHolder = healthHolder.crop(0, 0, 200, 20);
        mEnter = enter.crop(0, 0, 300, 100);
        mSbutton = sbutton.crop(0, 0, 100, 100);
        mStatsholder = statsholder.crop(0, 0, 300, 400);

        mOregano = oregano.crop(0, 0, 75, 105);
        mRoseMary = oregano.crop(0, 300, 65, 105);
        mArtificialPer = oregano.crop(320, 150, 80, 105);
    }

}
