package Tile;
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Tile {

    // Static maps
    public static Tile[] mTiles = new Tile[256];
    public static Tile wallTile = new WallTile(0);
    public static Tile floorTile = new FloorTile(1);
    public static Tile counterTile = new CounterTile(2);
    public static Tile doorTile = new DoorTile(3);
    public static Tile food1 = new Food1Tile(4);
    public static Tile food2 = new Food2Tile(5);
    public static Tile food3 = new Food3Tile(6);
    public static Tile food4 = new Food4Tile(7);
    public static Tile food5 = new Food5Tile(8);
    public static Tile cake = new CakeTile(9);
    public static Tile cupcake = new CupcakeTile(10);
    public static Tile pie = new PieTile(11);
    public static Tile frosting = new FrostingTile(12);
    public static Tile sprinkesFloor = new SprinkelsFloorTile(13);
    public static Tile emptyPlate = new EmptyPlateTile(14);
    public static Tile stove = new StoveTile(15);
    public static Tile pots = new PotsTile(16);
    public static Tile chop = new ChopTile(17);
    //public static Tile wall = new WallTile(18);

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

}
