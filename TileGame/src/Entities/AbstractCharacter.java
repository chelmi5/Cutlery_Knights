package Entities;

import Engine.Game;
import Utilities.CodeTools;

import java.util.Random;

public abstract class AbstractCharacter
{
   protected String mName;
   protected int mHp;
   protected int mMaxHP;
   protected int mAttackSpeed;
   protected int mMinRange;
   protected int mMaxRange;
   protected double mChanceToHit;
   
   public AbstractCharacter(String name, int hp, int as, int minRange, int maxRange, double chanceToHit)
   {
      mName = name;
      mHp = hp;
      mMaxHP = hp;
      mAttackSpeed = as;
      mMinRange = minRange;
      mMaxRange = maxRange;
      mChanceToHit = chanceToHit;
   }

   public int attack()
   {
      double didItHit = Math.random();
      Random num = new Random();
      int damage = 0;


      if (didItHit <= mChanceToHit)
      {
         System.out.println("min: " + mMinRange + " max: " + mMaxRange);
         damage = CodeTools.randInt(mMinRange, mMaxRange) + mMinRange;
         while (damage < 0)
         {
            System.out.println("damage: " + damage);
            damage = CodeTools.randInt(mMinRange, mMaxRange) + mMinRange;
         }
         //enemyHP -= damage;
         System.out.printf("AttackBehavior successful! Inflicted %d damage!\n", damage);
      }
      else
      {
         System.out.println("AttackBehavior unsucessful...\n");
      }
      return damage;
   }
   
   public String getName()
   {
      return mName;
   }
   
   public int getHP()
   {
      return mHp;
   }

   public void setHp(int hp) {
      if (hp > -1)
         mHp = hp;
      else
         mHp = 0;
   }

   public int getAttackSpeed()
   {
      return mAttackSpeed;
   }

   public int getMaxHP() {
      return mMaxHP;
   }
}