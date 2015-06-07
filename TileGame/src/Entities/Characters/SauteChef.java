package Entities.Characters;

import Entities.AbstractHero;
import Entities.AttackBehavior;
import Graphics.GraphicAssets;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class SauteChef extends AbstractHero
{

   private BufferedImage mIcon;
   private ArrayList<String> attackNames = new ArrayList<String>();

   public SauteChef(String name)
   {
      super(name, 125, 4, 35, 60, 0.8, 0.2, 1, 1);
      mIcon = GraphicAssets.mSaute;
      attackNames.add("Regular Attack (80% chance)");
      attackNames.add("Crushing Blow");
   }
   
   public int specialAttack()
   {
      Random num = new Random();
      int damage = 0;
      int didItHit = num.nextInt(11);
      int damageDone = num.nextInt(101) + 75;
      
      if (didItHit <= 4)
      {
         System.out.printf("AttackBehavior successful! Saute Chef did %d damage to Monster!\n", damageDone);
         damage = damageDone;
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