package Map;
import Tile.Tile;
import Utilitys.FileUtility;

import java.awt.*;

public class Map {

    private int mWidth;
    private int mHeight;
    private int mSpawnX;
    private int mSpawnY;

    private int[][] tileArray;

    public Map(String path) {
        loadMap(path);
    }

    public void update() {

    }

    public void render(Graphics paintBrush) {

        for (int y = 0; y < mHeight; y++) {
            for (int x = 0; x < mWidth; x++) {
                getTile(x, y).render(paintBrush, x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT);
            }
        }
    }

    public Tile getTile(int x, int y) {
        int tileIndex = tileArray[x][y];

        Tile tempTile = Tile.mTiles[tileIndex];
        if (tempTile == null)
            return Tile.floorTile;

        return tempTile;
    }

    private void loadMap(String path) {
        String file = FileUtility.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        mWidth = FileUtility.parseInt(tokens[0]);
        mHeight = FileUtility.parseInt(tokens[1]);
        mSpawnX = FileUtility.parseInt(tokens[2]);
        mSpawnY = FileUtility.parseInt(tokens[3]);

        tileArray = new int[mWidth][mHeight];

        for (int y = 0; y < mHeight; y++)
        {
            for (int x = 0; x < mWidth; x++)
            {
                tileArray[x][y] = FileUtility.parseInt(tokens[(x + y * mWidth)+4]);
            }
        }
    }

}
