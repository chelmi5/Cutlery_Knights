package Entities.Mobs;
import Entities.Stats;
import Graphics.GraphicAssets;
import java.awt.image.BufferedImage;

public class DonutMob extends AbstractMob
{
   private BufferedImage mIcon;

   public DonutMob(int enemyID)
   {
      super(new Stats("Possessed DonutMob", 200, 2, 2, 200, 0.6), 0.1, 30, 60, enemyID);
      mIcon = GraphicAssets.mDount;
   }

   public BufferedImage getIcon() {
      return mIcon;
   }
}