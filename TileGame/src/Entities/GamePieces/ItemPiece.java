package Entities.GamePieces;
import Items.Item;
import Engine.Game;
import Map.Map;
import States.ExplorationState;
import States.State;
import java.awt.*;

/**
 * Created by CountryGeek1 on 6/9/15.
 */
public class ItemPiece extends PieceTemplate {

    private PlayerPiece mPlayerPiece;
    private Item mItem;
    private boolean colided = false;
    private ExplorationState mExplore;

    public ItemPiece(Game game, float x, float y, Map map, PlayerPiece playerPiece, Item item, State explore) {
        super(game, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_WIDTH, map);
        mPlayerPiece = playerPiece;
        mItem = item;
        mExplore = (ExplorationState)explore;
    }

    public void update() {
        int numX = (int) (mX + xMove);
        int numY = (int) (mY + yMove);

        int rangeHighX = (numX + 50);
        int rangeLowX = (numX - 10);
        int rangeHighY = (numY + 10);
        int rangeLowY = (numY - 60);

        if ((mPlayerPiece.getCoordinateX() < rangeHighX && mPlayerPiece.getCoordinateX() > rangeLowX) &&
                (mPlayerPiece.getCoordinateY() < rangeHighY && mPlayerPiece.getCoordinateY() > rangeLowY))
        {
            //System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
            for (int x = 0; x < mGame.getPartyArray().length; x++)
                mItem.action(mGame.getPartyArray()[x]);

            mExplore.setEffectString(mItem.getDescription());
            mExplore.setRunTime(true);
            colided = true;
            System.out.println("Applying Item");
        }
    }

    public void render(Graphics paintBrush) {
        paintBrush.drawImage(mItem.getIcon(),(int)(mX -  mGame.getGameCamera().getXoffset()),
                (int)(mY -  mGame.getGameCamera().getYoffset()), mWidth, mHeight, null);
    }

    public boolean getHit() {
        return colided;
    }

}
