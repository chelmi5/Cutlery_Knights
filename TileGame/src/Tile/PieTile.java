package Tile;

import Graphics.GraphicAssets;

public class PieTile extends  Tile{

    public PieTile(int id) {
        super(GraphicAssets.mPie, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
