package Entities.GamePieces;
import Engine.Game;
import Graphics.GraphicAssets;
import Map.Map;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerPiece extends PieceTemplate {

    private int cordinateX = 0;
    private int cordinateY = 0;
    private int mRightTime = 0;
    private int mLeftTime = 0;
    private int mDownTime = 0;
    private int mUpTime = 0;
    private BufferedImage mIcon = GraphicAssets.mPlayerStill;

    public PlayerPiece(Game game, float x, float y, Map mMap) {
        super(game, x, y, DEFAULT_CREATURE_WIDTH, 95, mMap);
    }

    @Override
    public void update() {
        getInput();
        move();
        cordinateX = (int)(mX);
        cordinateY = (int)(mY);
        mGame.getGameCamera().centerOnEntity(this);
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;

        if(mGame.getKeyManager().up)
        {
            mUpTime++;
            if (mUpTime < 15)
                mIcon = GraphicAssets.mPlayerUpRight;
            else if(mUpTime < 30)
                mIcon = GraphicAssets.mPlayerUpMid;
            else if (mUpTime < 45)
                mIcon = GraphicAssets.mPlayerUpLeft;
            else
                mIcon = GraphicAssets.mPlayerUpMid;

            if (mUpTime == 60)
                mUpTime = 0;
            yMove = -mSpeed;
        }
        if(mGame.getKeyManager().down)
        {
            mDownTime++;
            if (mDownTime < 15)
                mIcon = GraphicAssets.mPlayerDownRight;
            else if (mDownTime < 30)
                mIcon = GraphicAssets.mPlayerDownMid;
            else if (mDownTime < 45)
                mIcon = GraphicAssets.mPlayerDownLeft;
            else
                mIcon = GraphicAssets.mPlayerDownMid;
            if (mDownTime == 60)
                mDownTime = 0;
            yMove = +mSpeed;
        }
        if(mGame.getKeyManager().left)
        {
            mLeftTime++;
            if (mLeftTime < 15)
                mIcon = GraphicAssets.mPlayerLeftLeft;
            else if (mLeftTime < 30)
                mIcon = GraphicAssets.mPlayerLeftMid;
            else if (mLeftTime < 45)
                mIcon = GraphicAssets.mPlayerLeftRight;
            else
                mIcon = GraphicAssets.mPlayerLeftMid;
            if (mLeftTime == 60)
                mLeftTime = 0;
            xMove = -mSpeed;
        }
        if(mGame.getKeyManager().right)
        {
            mRightTime++;
            if (mRightTime < 15)
                mIcon = GraphicAssets.mPlayerRightRight;
            else if (mRightTime < 30)
                mIcon = GraphicAssets.mPlayerRightMid;
            else if (mRightTime < 45)
                mIcon = GraphicAssets.mPlayerRightLeft;
            if (mRightTime == 60)
                mRightTime = 0;
            xMove =+ mSpeed;
        }
    }

    @Override
    public void render(Graphics paintBrush) {
        paintBrush.drawImage(mIcon, (int) (mX - mGame.getGameCamera().getXoffset()), (int) (mY - mGame.getGameCamera().getYoffset()), mWidth, mHeight, null);
    }

    public int getCoordinateX() {
        return cordinateX;
    }

    public int getCoordinateY() {
        return cordinateY;
    }
}
