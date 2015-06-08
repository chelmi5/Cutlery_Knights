package Tile;
import Graphics.GraphicAssets;

public class Food4Tile extends Tile {

    public Food4Tile(int id) {
        super(GraphicAssets.mFood4, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }

}
