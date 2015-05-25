package Tile;
import Graphics.Assets;

public class KnifeTile extends Tile {

    public KnifeTile(int id) {
        super(Assets.mKnife, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }

}
