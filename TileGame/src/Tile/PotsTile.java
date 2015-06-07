package Tile;

import Graphics.GraphicAssets;

public class PotsTile extends Tile{

    public PotsTile(int id) {
        super(GraphicAssets.mPots, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
