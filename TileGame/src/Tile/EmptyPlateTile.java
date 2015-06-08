package Tile;

import Graphics.GraphicAssets;

public class EmptyPlateTile extends Tile{

    public EmptyPlateTile(int id) {
        super(GraphicAssets.mEmptyplate, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
