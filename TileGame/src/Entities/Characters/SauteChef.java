package Entities.Characters;
import Entities.Abilities.CrushingBlow;
import Entities.Abilities.SpecialAbilityBehavior;
import Graphics.GraphicAssets;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import Entities.Stats;
import Entities.Mobs.Mob;

public class SauteChef extends AbstractHero
{

   private BufferedImage mIcon;
   private ArrayList<String> attackNames = new ArrayList<String>();
   private SpecialAbilityBehavior mCrushingBlow;

   public SauteChef(String name)
   {
      super(new Stats(name, 125, 4, 35, 60, 0.8), 0.2, 1, 1);
      mIcon = GraphicAssets.mSaute;
      attackNames.add("Regular Effect (80% chance)");
      attackNames.add("Crushing Blow");
      mCrushingBlow = new CrushingBlow();
   }
   
   public int specialAbility(Mob mob)
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
}