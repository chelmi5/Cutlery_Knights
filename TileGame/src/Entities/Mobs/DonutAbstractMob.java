package Entities.Mobs;
import Entities.Stats;
import Graphics.GraphicAssets;
import java.awt.image.BufferedImage;

public class DonutAbstractMob extends AbstractMob
{
   private BufferedImage mIcon;

   public DonutAbstractMob(int enemyID)
   {
      super(new Stats("Possessed DonutAbstractMob", 200, 2, 2, 200, 0.6), 0.1, 30, 60, enemyID);
      mIcon = GraphicAssets.mDount;
   }

   public BufferedImage getIcon() {
      return mIcon;
   }
}