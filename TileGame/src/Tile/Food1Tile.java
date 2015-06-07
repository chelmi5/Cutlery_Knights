package Tile;
import Graphics.GraphicAssets;

public class Food1Tile extends Tile {

    public Food1Tile(int id) {
        super(GraphicAssets.mFood1, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
