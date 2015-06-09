package Entities.Characters;
import Entities.Abilities.SpecialAbilityBehavior;
import Entities.Abilities.SurpriseSpecialAbility;
import Entities.Mobs.AbstractMob;
import Graphics.GraphicAssets;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import Entities.Stats;

public class FishChef extends AbstractHero
{

   private BufferedImage mIcon;
   private ArrayList<String> attackNames = new ArrayList<String>();
   private SpecialAbilityBehavior mSpecialAttack;

   public FishChef(String name)
   {
      super(new Stats(name, 100, 6, 20, 40, 0.8), 0.4, 1, 3);
      mIcon = GraphicAssets.mFishChef;
      mSpecialAttack = new SurpriseSpecialAbility();
      attackNames.add("Regular Effect (80% chance)");
      attackNames.add("Surprise Effect");
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

}