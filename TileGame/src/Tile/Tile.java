package Tile;
import Graphics.GraphicAssets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    public static final int TILEWIDTH = 64;
    public static final int TILEHEIGHT = 64;
    protected BufferedImage mTexture;
    protected int mID;
    protected boolean mSolid;

    public Tile () {
    }

    public static TileBuilder createBuilder()
    {
        return new TileBuilder();
    }

    public int getID() {
        return mID;
    }

    public BufferedImage getTexture() {
        return mTexture;
    }

    public boolean isSolid() {
        return mSolid;
    }

    public void update() {

    }

    public void render(Graphics paintBrush, int x, int y) {
        paintBrush.drawImage(mTexture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }
}
