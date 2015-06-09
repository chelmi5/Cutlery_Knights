package Entities.Abilities;

import Entities.Characters.AbstractHero;
import Entities.Mobs.Mob;

import java.util.Random;

/**
 * Created by CountryGeek1 on 6/8/15.
 */
public class HealPlayer implements SpecialAbilityBehavior {

    @Override
    public int Effect(AbstractHero player, Mob mob) {
        if(player.getStats().getHitPoints() < 100)
        {
            Random num = new Random();
            int healPoints = num.nextInt(26)+30;
            player.getStats().setHitPoints(player.getStats().getHitPoints()+ healPoints);
            if (player.getStats().getHitPoints() > 100)
            {
                player.getStats().setHitPoints(100);
                System.out.printf("The Pastry Chef healed herself back to full health! Her HP is now at %d!",
                        player.getStats().getHitPoints());
            }
            else
            {
                System.out.printf("The Pastry Chef healed herself for %d points! Her HP is now at %d!",
                        healPoints, player.getStats().getHitPoints());
            }
            return 0;
        }
        else
        {
            System.out.println("Don't waste your turn... Why heal when you have full health?");
            return 0;
        }
    }
}
