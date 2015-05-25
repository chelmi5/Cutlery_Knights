//Chelsea Davis, Assignment 3, CSCD 211, Winter 2014
import java.util.*;

public abstract class AbstractHero extends AbstractCharacter
{
   protected double chanceToBlock;
   protected int numTurns;
   protected int type;
   
   protected AbstractHero(String name, int h, int as, int minr, int maxr, double c, double ctb, int turns, int type)
   {
      super(name, h, as, minr, maxr, c);
      this.chanceToBlock = ctb;
      this.numTurns = turns;
      this.type = type;
   }

   public double getChanceToBlock()
   {return this.chanceToBlock;}
   
   public void setNumTurns(int num)
   {this.numTurns = num;} 
   
   public int getType()
   {return this.type;}
   
   public int getHP()
   {return this.hp;}
   
   //so that Thief can use special attack
   @Override
   public int surpriseAttack(int enemyHP) 
   {
      return 1;
   }

}