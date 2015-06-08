package Tile;
import Graphics.GraphicAssets;

public class WallTile extends Tile {

    public WallTile(int id) {
        super(GraphicAssets.mWall, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
