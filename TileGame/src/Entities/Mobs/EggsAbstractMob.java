package Entities.Mobs;
import Entities.Stats;
import Graphics.GraphicAssets;
import java.awt.image.BufferedImage;

public class EggsAbstractMob extends AbstractMob
{
   private BufferedImage mIcon;

   public EggsAbstractMob(int enemyID)
   {
      super(new Stats("Rotten EggsAbstractMob", 200, 2, 5, 70, 0.6), 0.1, 15, 30, enemyID);
      mIcon = GraphicAssets.mEggs;
   }

   public BufferedImage getIcon() {
      return mIcon;
   }
}