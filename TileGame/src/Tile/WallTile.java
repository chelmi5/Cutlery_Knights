package Tile;
import Graphics.Assets;

public class WallTile extends Tile {

    public WallTile(int id) {
        super(Assets.mWall, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
