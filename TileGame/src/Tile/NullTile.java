package Tile;
import Graphics.GraphicAssets;

public class NullTile extends Tile{

    public NullTile(int id) {
        super(GraphicAssets.mWall, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
