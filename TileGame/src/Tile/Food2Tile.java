package Tile;
import Graphics.GraphicAssets;

public class Food2Tile extends Tile {

    public Food2Tile(int id) {
        super(GraphicAssets.mFood2, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
