package Tile;

import Graphics.GraphicAssets;

public class CakeTile extends Tile {

    public CakeTile(int id) {
        super(GraphicAssets.mCake, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
