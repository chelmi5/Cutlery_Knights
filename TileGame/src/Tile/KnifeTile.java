package Tile;
import Graphics.GraphicAssets;

public class KnifeTile extends Tile {

    public KnifeTile(int id) {
        super(GraphicAssets.mKnife, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }

}
