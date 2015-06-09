package Entities.Characters;
import Entities.Abilities.HealPlayer;
import Entities.Abilities.SpecialAbilityBehavior;
import Entities.Stats;
import Graphics.GraphicAssets;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import Entities.Mobs.Mob;


public class PastryChef extends AbstractHero
{

   private BufferedImage mIcon;
   private ArrayList<String> attackNames = new ArrayList<String>();
   private SpecialAbilityBehavior mHeal;

   public PastryChef(String name)
   {

      super(new Stats(name, 100, 5, 25, 45, 0.8), 0.2, 1, 2);
      mIcon = GraphicAssets.mPastry;
      attackNames.add("Regular Effect (80% chance)");
      attackNames.add("HealPlayer");
      mHeal = new HealPlayer();
   }

   public int specialAbility(Mob mob)
   {
      return mHeal.Effect(this, mob);
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