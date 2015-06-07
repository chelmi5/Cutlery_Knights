package Tile;

import Graphics.GraphicAssets;

public class Food5Tile extends Tile {

    public Food5Tile(int id) {
        super(GraphicAssets.mFood5, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
