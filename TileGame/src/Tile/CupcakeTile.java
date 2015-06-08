package Tile;

import Graphics.GraphicAssets;

public class CupcakeTile extends Tile {

    public CupcakeTile(int id) {
        super(GraphicAssets.mCupcakes, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
