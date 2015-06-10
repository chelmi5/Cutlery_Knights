package Entities.Characters;
import Entities.Abilities.CrushingBlow;
import Entities.Abilities.SpecialAbilityBehavior;
import Graphics.GraphicAssets;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import Entities.Stats;
import Entities.Mobs.AbstractMob;

public class RoastChef extends AbstractHero
{

   private BufferedImage mIcon;
   private BufferedImage mFightIcon;
   private ArrayList<String> attackNames = new ArrayList<String>();
   private SpecialAbilityBehavior mCrushingBlow;

   public RoastChef(String name)
   {
      super(new Stats(name, 125, 4, 35, 60, 0.8), 0.2, 1, 1);
      mIcon = GraphicAssets.mSaute;
      mFightIcon = GraphicAssets.mSauteFight;
      attackNames.add("Regular Attack (80% chance)");
      attackNames.add("Roast 'em");
      mCrushingBlow = new CrushingBlow();
   }
   
   public int specialAbility(AbstractMob mob)
   {
      return mCrushingBlow.Effect(this, mob);
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