package Tile;
import Graphics.GraphicAssets;

public class Food3Tile extends Tile {

    public Food3Tile(int id) {
        super(GraphicAssets.mFood3, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
