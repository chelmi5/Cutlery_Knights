package Tile;

import Graphics.GraphicAssets;

public class FrostingTile extends Tile{

    public FrostingTile(int id) {
        super(GraphicAssets.mFrosting, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
