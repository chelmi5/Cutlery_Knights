package Entities.GamePieces;
import Items.Item;
import Engine.Game;
import Map.Map;
import java.awt.*;

/**
 * Created by CountryGeek1 on 6/9/15.
 */
public class ItemPiece extends PieceTemplate {

    private PlayerPiece mPlayerPiece;
    private Item mItem;

    public ItemPiece(Game game, float x, float y, Map map, PlayerPiece playerPiece, Item item) {
        super(game, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_WIDTH, map);
        mPlayerPiece = playerPiece;
        mItem = item;
    }

    public void update() {
        int rangeHighX = (int) (mX + 50);
        int rangeLowX = (int) (mX - 10);
        int rangeHighY = (int) (mY + 10);
        int rangeLowY = (int) (mY - 60);

        if ((mPlayerPiece.getCoordinateX() < rangeHighX && mPlayerPiece.getCoordinateX() > rangeLowX) &&
                (mPlayerPiece.getCoordinateY() < rangeHighY && mPlayerPiece.getCoordinateY() > rangeLowY))
        {

            System.out.println("Applying Item");
        }
    }

    public void render(Graphics paintBrush) {
        paintBrush.drawImage(mItem.getIcon(),(int)(mX -  mGame.getGameCamera().getXoffset()),
                (int)(mY -  mGame.getGameCamera().getYoffset()), mWidth, mHeight, null);
    }

}
