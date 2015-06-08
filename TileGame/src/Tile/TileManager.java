package Tile;
import Graphics.GraphicAssets;

import java.awt.*;

public class TileManager
{

    public static Tile[] mTiles = new Tile[256];

    public TileManager() {
        mTiles[0] = Tile.createBuilder().setTexture(GraphicAssets.mWall).setSolid(true).build();
        mTiles[1] = Tile.createBuilder().setTexture(GraphicAssets.mFloor).setSolid(false).build();
        mTiles[2] = Tile.createBuilder().setTexture(GraphicAssets.mCounter).setSolid(true).build();
        mTiles[3] = Tile.createBuilder().setTexture(GraphicAssets.mDoor).setSolid(true).build();
        mTiles[4] = Tile.createBuilder().setTexture(GraphicAssets.mFood1).setSolid(true).build();
        mTiles[5] = Tile.createBuilder().setTexture(GraphicAssets.mFood2).setSolid(true).build();
        mTiles[6] = Tile.createBuilder().setTexture(GraphicAssets.mFood3).setSolid(true).build();
        mTiles[7] = Tile.createBuilder().setTexture(GraphicAssets.mFood4).setSolid(true).build();
        mTiles[8] = Tile.createBuilder().setTexture(GraphicAssets.mFood5).setSolid(true).build();
        mTiles[9] = Tile.createBuilder().setTexture(GraphicAssets.mCake).setSolid(true).build();
        mTiles[10] = Tile.createBuilder().setTexture(GraphicAssets.mCupcakes).setSolid(true).build();
        mTiles[11] = Tile.createBuilder().setTexture(GraphicAssets.mPie).setSolid(true).build();
        mTiles[12] = Tile.createBuilder().setTexture(GraphicAssets.mFrosting).setSolid(true).build();
        mTiles[13] = Tile.createBuilder().setTexture(GraphicAssets.mSprinklesfloor).setSolid(false).build();
        mTiles[14] = Tile.createBuilder().setTexture(GraphicAssets.mEmptyplate).setSolid(true).build();
        mTiles[15] = Tile.createBuilder().setTexture(GraphicAssets.mStove).setSolid(true).build();
        mTiles[16] = Tile.createBuilder().setTexture(GraphicAssets.mPots).setSolid(true).build();
        mTiles[17] = Tile.createBuilder().setTexture(GraphicAssets.mChop).setSolid(true).build();
    }
}
