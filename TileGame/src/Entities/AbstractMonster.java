package Entities;

import Engine.Game;
import Map.Map;

import java.awt.image.BufferedImage;
import java.util.Random;

public abstract class AbstractMonster extends AbstractCharacter
{
   protected double chanceToHeal;
   protected int minHeal;
   protected int maxHeal;

   public AbstractMonster(String name, int h, int as, int minr, int maxr, double c, double cth, int minh, int maxh)
   {
      super(name, h, as, minr, maxr, c);
      this.chanceToHeal = cth;
      this.minHeal = minh;
      this.maxHeal = maxh;
   }

   public int heal(int selfHP)
   {
      double didItHeal = Math.random();
      Random num = new Random();
   
      if(selfHP >= getHP())
      {
         return selfHP;
      }
   
      else if (didItHeal <= this.chanceToHeal && selfHP < getHP())
      {
         System.out.println("The Monster has a chance to heal itself...\n");
         int healPoints = num.nextInt(this.maxHeal - this.minHeal + 1) + this.minHeal;
         selfHP += healPoints;
         if(selfHP > getHP())
         {
            System.out.printf("They healed their HP back to full health!");
            selfHP = getHP();
         }
         else
         {
            System.out.printf("They healed their HP for %d points! Their HP is now at %d!\n", healPoints, selfHP);
         }
         return selfHP;
      }
      else if (didItHeal > this.chanceToHeal)
      {
         System.out.println("The Monster has a chance to heal itself...\n");
         System.out.println("But it failed to heal!\n");
      }
      
      return selfHP;  
   }
   
   public int attack(AbstractHero player)
   {
      int damage =0;
      double didItHit = Math.random();
      Random num = new Random();
      System.out.print("\nThe Monster lunges at the Hero to attack...\n");

      if (didItHit <= this.mChanceToHit)
      {
         damage = num.nextInt(this.mMaxRange - this.mMinRange + 1) + this.mMinRange;
         
         if(player.getChanceToBlock() >= Math.random()) //chance to block for hero
         {
            System.out.print("But the Hero blocked the AttackBehavior!\n\n");
         }
         else
         {   
            System.out.print("And lands a successful blow!\n\n"); 
            return damage;
         }
      }
      
      else
      {
         System.out.print("But they were unsucessful...\n\n");
      }
   
      return damage;
   }

   public abstract BufferedImage getIcon();
}
