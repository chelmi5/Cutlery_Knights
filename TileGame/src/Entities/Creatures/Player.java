package Entities.Creatures;
import Engine.Game;
import Graphics.GraphicAssets;
import java.awt.*;

public class Player extends Creature {


    public Player(Game game, float x, float y) {
        super(game, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
    }

    @Override
    public void update() {
        getInput();
        move();
        mGame.getGameCamera().centerOnEntity(this);
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;

        if(mGame.getKeyManager().up || mGame.getKeyManager().wup)
            yMove = -mSpeed;
        if(mGame.getKeyManager().down || mGame.getKeyManager().sdown)
            yMove = +mSpeed;
        if(mGame.getKeyManager().left || mGame.getKeyManager().aleft)
            xMove = -mSpeed;
        if(mGame.getKeyManager().right || mGame.getKeyManager().dright)
            xMove =+ mSpeed;
    }

    @Override
    public void render(Graphics paintBrush) {
        paintBrush.drawImage(GraphicAssets.mPlayer, (int)(mX -  mGame.getGameCamera().getXoffset()), (int)(mY -  mGame.getGameCamera().getYoffset()), mWidth, mHeight, null);    }
}
