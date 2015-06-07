package Entities.Characters;
import Entities.AbstractHero;
import Graphics.GraphicAssets;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class FishChef extends AbstractHero
{

   private BufferedImage mIcon;
   private ArrayList<String> attackNames = new ArrayList<String>();

   public FishChef(String name)
   {
      super(name, 100, 6, 20, 40, 0.8, 0.4, 1, 3);
      mIcon = GraphicAssets.mFish;
      attackNames.add("Regular Attack (80% chance)");
      attackNames.add("Surprise Attack");
   }

   @Override
   public int specialAttack()
   {
      Random num = new Random();
      int didItHit = num.nextInt(11);
      int damage = 0;
      
      if (didItHit <= 4)
      {
         damage = attack();
         
         if(num.nextInt(11) <= 2)
         {
            System.out.println("The first attack was successful, but the Fish Chef was caught.");
            return damage;
         }
         else
         {
            System.out.println("The second attack was successful!");
            damage = attack();
            return damage;
         }
      }
      
      else
      {
         System.out.println("AttackBehavior missed...");
      }
      
      return damage;
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