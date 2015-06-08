package Tile;
import Graphics.GraphicAssets;

public class DoorTile extends Tile {

    public DoorTile(int id) {
        super(GraphicAssets.mDoor, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }

}
