package Map;
import Engine.Game;
import Tile.Tile;
import Utilitys.FileUtility;

import java.awt.*;

public class Map {

    private Game mGame;
    private int mWidth;
    private int mHeight;
    private int mSpawnX;
    private int mSpawnY;

    private int[][] tileArray;

    public Map(Game game, String path) {
        mGame = game;
        loadMap(path);
    }

    public void update() {

    }

    public void render(Graphics paintBrush) {

        int xStart = Math.max(0, (int)mGame.getGameCamera().getXoffset() / Tile.TILEWIDTH);
        int xEnd = Math.min(mWidth, (int)(mGame.getGameCamera().getXoffset() + mGame.getWidth())-1/ Tile.TILEWIDTH);
        int yStart = Math.max(0, (int)mGame.getGameCamera().getYoffset() / Tile.TILEHEIGHT);
        int yEnd = Math.min(mHeight, (int)(mGame.getGameCamera().getYoffset() + mGame.getHeight())-1/ Tile.TILEHEIGHT);

        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                getTile(x, y).render(paintBrush, (int) (x * Tile.TILEWIDTH - mGame.getGameCamera().getXoffset())
                        , (int) (y * Tile.TILEHEIGHT - mGame.getGameCamera().getYoffset()));
            }
        }
    }

    public Tile getTile(int x, int y) {
        try{
            int tileIndex = tileArray[x][y];

            Tile tempTile = Tile.mTiles[tileIndex];
            if (tempTile == null)
                return Tile.floorTile;

            return tempTile;
        }catch (ArrayIndexOutOfBoundsException e){
            return null;
        }
    }

    public int[][] getTileArray() {
        return tileArray;
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
