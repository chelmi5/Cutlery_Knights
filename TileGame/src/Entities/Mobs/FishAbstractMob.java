package Entities.Mobs;
import Entities.Stats;
import Graphics.GraphicAssets;
import java.awt.image.BufferedImage;

public class FishAbstractMob extends AbstractMob
{
   private BufferedImage mIcon;

   public FishAbstractMob(int enemyID)
   {
      super(new Stats("Smelly FishAbstractMob", 200, 2, 3, 100, 0.6), 0.1, 30, 50, enemyID);
      mIcon = GraphicAssets.mFish;
   }

   public BufferedImage getIcon() {
      return mIcon;
   }
}