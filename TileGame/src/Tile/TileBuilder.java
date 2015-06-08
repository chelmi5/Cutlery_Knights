package Tile;

import java.awt.image.BufferedImage;

public class TileBuilder {
    private final Tile mTile = new Tile();
    private boolean done = false;

    public Tile build() {
        done = true;
        return mTile;
    }

    public TileBuilder setTexture(BufferedImage image) {
        mTile.mTexture = image;
        return this;
    }

    public TileBuilder setSolid(boolean solid){
        check();
        mTile.mSolid = solid;
        return this;
    }

    private void check() {
        if (done)
            throw new
                    IllegalArgumentException("Do use other builder to create new instance");
    }

}
