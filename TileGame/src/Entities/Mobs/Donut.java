package Entities.Mobs;

import Entities.AbstractMonster;
import Graphics.GraphicAssets;

import java.awt.image.BufferedImage;

public class Donut extends AbstractMonster
{

   private BufferedImage mIcon;

   public Donut(int enemyID)
   {
      super("Possessed Donut", 200, 2, 2, 200, 0.6, 0.1, 30, 60, enemyID);
      mIcon = GraphicAssets.mEnemy;
   }

   public BufferedImage getIcon() {
      return mIcon;
   }
}