package Entities.Characters;
import Entities.Abilities.RegularPlayerSpecialAbility;
import Entities.Abilities.SpecialAbilityBehavior;
import Entities.Stats;
import Entities.Mobs.AbstractMob;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class AbstractHero
{
   protected double mChanceToBlock;
   protected int mNumTurns;
   protected int mType;
   protected Stats mStats;
   private SpecialAbilityBehavior mRegularAttack;

   protected AbstractHero(Stats stats, double ctb, int turns, int type)
   {
      mStats = stats;
      mChanceToBlock = ctb;
      mNumTurns = turns;
      mType = type;
      mRegularAttack = new RegularPlayerSpecialAbility();
   }

   public abstract ArrayList<String> getAttackNames();
   public abstract BufferedImage getIcon();
   public abstract BufferedImage getFightIcon();
   public abstract int specialAbility(AbstractMob mob);

   public int attack(AbstractMob mob)
   {
      return mRegularAttack.Effect(this, mob);
   }

   public double getChanceToBlock()
   {
      return mChanceToBlock;
   }

   public Stats getStats()
   {
      return mStats;
   }

}