package Tile;
import Graphics.GraphicAssets;

public class ChopTile extends Tile {

    public ChopTile(int id) {
        super(GraphicAssets.mChop, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
