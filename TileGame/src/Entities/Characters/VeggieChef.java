package Entities.Characters;
import Entities.Abilities.SpecialAbilityBehavior;
import Entities.Abilities.SurpriseSpecialAbility;
import Entities.Mobs.AbstractMob;
import Graphics.GraphicAssets;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import Entities.Stats;

public class VeggieChef extends AbstractHero
{

   private BufferedImage mIcon;
   private BufferedImage mFightIcon;
   private ArrayList<String> attackNames = new ArrayList<String>();
   private SpecialAbilityBehavior mSpecialAttack;

   public VeggieChef(String name)
   {
      super(new Stats(name, 115, 6, 20, 40, 0.8), 0.3, 1, 4);
      mIcon = GraphicAssets.mVegetable;
      mFightIcon = GraphicAssets.mVeggieFight;
      mSpecialAttack = new SurpriseSpecialAbility();
      attackNames.add("Regular Attack (80% chance)");
      attackNames.add("Slice n Dice");
   }

   public int specialAbility(AbstractMob mob)
   {
     return mSpecialAttack.Effect(this, mob);
   }

   @Override
   public ArrayList<String> getAttackNames() {
      return attackNames;
   }

   @Override
   public BufferedImage getIcon() {
      return mIcon;
   }

   @Override
   public BufferedImage getFightIcon() {
      return mFightIcon;
   }

}