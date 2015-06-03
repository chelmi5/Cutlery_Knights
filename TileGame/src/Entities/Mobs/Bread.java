package Entities.Mobs;
import Engine.Game;
import Entities.Creature;
import Map.Map;
import Graphics.GraphicAssets;
import java.awt.*;
import java.awt.image.BufferedImage;
import Utilities.CodeTools;

public class Bread extends Creature {

    private BufferedImage mIcon;
    private int mTime = 0;
    private int mRandomNumber1 = 0;
    private int mRandomNumber2 = 0;

    public Bread(Game game, float x, float y, Map map) {
        super(game, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT, map);
        mIcon = GraphicAssets.mEnemy;
    }

    public void update() {
        wonder();
        move();
    }

    private void wonder() {
        mTime++;
        if (mTime == 60) {
            mRandomNumber1 = CodeTools.randInt(1, 4);
            mRandomNumber2 = CodeTools.randInt(1, 4);
            mTime = 0;
        }

        xMove = 0;
        yMove = 0;
        int minus = 2;

        if (mRandomNumber1 == 1 || mRandomNumber2 == 1)
            yMove = +mSpeed - minus;
        if(mRandomNumber1 == 2 || mRandomNumber2 == 2)
            yMove = -mSpeed + minus;
        if(mRandomNumber1 == 3 || mRandomNumber2 == 3)
            xMove = -mSpeed + minus;
        if(mRandomNumber1 == 4 || mRandomNumber2 == 4)
            xMove =+mSpeed - minus;
    }
    
    @Override
    public void render(Graphics paintBrush) {
        paintBrush.drawImage(mIcon,(int)(mX -  mGame.getGameCamera().getXoffset()), (int)(mY -  mGame.getGameCamera().getYoffset()), mWidth, mHeight, null);
    }
}
