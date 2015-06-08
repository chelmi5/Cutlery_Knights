package Tile;

import Graphics.GraphicAssets;

public class StoveTile extends Tile {

    public StoveTile(int id) {
        super(GraphicAssets.mStove, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }

}
