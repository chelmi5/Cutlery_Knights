package Entities.Mobs;

import Entities.AbstractMonster;
import Graphics.GraphicAssets;

import java.awt.image.BufferedImage;

public class Eggs extends AbstractMonster
{

   private BufferedImage mIcon;

   public Eggs(int enemyID)
   {
      super("Rotten Eggs", 200, 2, 5, 70, 0.6, 0.1, 15, 30, enemyID);
      mIcon = GraphicAssets.mEnemy;
   }

   public BufferedImage getIcon() {
      return mIcon;
   }
}