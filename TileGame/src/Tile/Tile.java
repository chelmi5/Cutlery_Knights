package Tile;
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Tile {

    // Static maps
    public static Tile[] mTiles = new Tile[256];
    public static Tile floorTile = new FloorTile(0);

    public static Tile woodTile = new WoodTile(1);
    public static Tile wallTile = new WallTile(2);

    // CLASS

    public static final int TILEWIDTH = 64;
    public static final int TILEHEIGHT = 64;

    protected BufferedImage mTexture;
    protected final int mID;

    public Tile (BufferedImage image, int id) {
        mTexture = image;
        mID = id;

        mTiles[mID] = this;
    }

    public boolean isSolid() {
        return false;
    }

    public void update() {

    }

    public void render(Graphics paintBrush, int x, int y) {
        paintBrush.drawImage(mTexture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }

    public int getID() {
        return mID;
    }
}
