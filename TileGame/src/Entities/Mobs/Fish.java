package Entities.Mobs;

import Entities.AbstractMonster;
import Graphics.GraphicAssets;

import java.awt.image.BufferedImage;

public class Fish extends AbstractMonster
{

   private BufferedImage mIcon;
   private static int mEmemyID;

   public Fish(int enemyID)
   {
      super("Smelly Fish", 200, 2, 3, 100, 0.6, 0.1, 30, 50);
      mIcon = GraphicAssets.mEnemy;
      mEmemyID = enemyID;
   }

   public BufferedImage getIcon() {
      return mIcon;
   }

   public int getEmemyID() {
      return mEmemyID;
   }
}