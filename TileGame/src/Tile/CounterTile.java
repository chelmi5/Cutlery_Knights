package Tile;

import Graphics.GraphicAssets;

public class CounterTile extends Tile{

    public CounterTile(int id) {
        super(GraphicAssets.mCounter, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
