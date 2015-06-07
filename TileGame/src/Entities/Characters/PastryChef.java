package Entities.Characters;

import Entities.AbstractHero;
import Graphics.GraphicAssets;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class PastryChef extends AbstractHero
{

   private BufferedImage mIcon;
   private ArrayList<String> attackNames = new ArrayList<String>();

   public PastryChef(String name)
   {
      super(name, 100, 5, 25, 45, 0.8, 0.2, 1, 2);
      mIcon = GraphicAssets.mPastry;
      attackNames.add("Regular Attack (80% chance)");
      attackNames.add("Heal");
   }

   public int specialAttack()
   {
      if(this.getHP() < 100)
      {
         Random num = new Random();
         int healPoints = num.nextInt(26)+30;
         this.mHp += healPoints;
         if (this.getHP() > 100)
         {
            this.mHp = 100;
            System.out.printf("The Pastry Chef healed herself back to full health! Her HP is now at %d!", this.getHP());
         }
         else
         {
            System.out.printf("The Pastry Chef healed herself for %d points! Her HP is now at %d!", healPoints, this.getHP());
         }
         return 0;
      }
      else
      {
         System.out.println("Don't waste your turn... Why heal when you have full health?");
         return 0;
      }
   }

   @Override
   public ArrayList<String> getAttackNames() {
      return attackNames;
   }

   @Override
   public BufferedImage getIcon() {
      return mIcon;
   }
}