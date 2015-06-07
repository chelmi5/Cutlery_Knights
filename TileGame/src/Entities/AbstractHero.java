package Entities;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class AbstractHero extends AbstractCharacter
{
   protected double mChanceToBlock;
   protected int mNumTurns;
   protected int mType;
   
   protected AbstractHero(String name, int hp, int as, int minRange, int maxRange, double c, double ctb, int turns, int type)
   {
      super(name, hp, as, minRange, maxRange, c);
      mChanceToBlock = ctb;
      mNumTurns = turns;
      mType = type;
   }

   public abstract ArrayList<String> getAttackNames();
   public abstract BufferedImage getIcon();
   public abstract int specialAttack();

   public double getChanceToBlock()
   {
      return mChanceToBlock;
   }
   
   public void setNumTurns(int num)
   {
      this.mNumTurns = num;
   }
   
   public int getType()
   {
      return this.mType;
   }

   public int getHP()
   {
      return this.mHp;
   }

}