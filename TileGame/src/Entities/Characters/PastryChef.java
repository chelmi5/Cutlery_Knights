package Entities.Characters;
import Entities.Abilities.HealPlayer;
import Entities.Abilities.SpecialAbilityBehavior;
import Entities.Mobs.AbstractMob;
import Entities.Stats;
import Graphics.GraphicAssets;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


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

   public int specialAbility(AbstractMob mob)
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