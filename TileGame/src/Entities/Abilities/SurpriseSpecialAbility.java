package Entities.Abilities;
import Entities.Characters.AbstractHero;
import Entities.Mobs.AbstractMob;

import java.util.Random;

/**
 * Created by CountryGeek1 on 6/8/15.
 */
public class SurpriseSpecialAbility implements SpecialAbilityBehavior {

    @Override
    public int Effect(AbstractHero player, AbstractMob mob) {
        Random num = new Random();
        int didItHit = num.nextInt(11);
        int damage = 0;

        if (didItHit <= 4)
        {
            damage = player.attack(mob);

            if(num.nextInt(11) <= 2)
            {
                System.out.println("The first attack was successful, but the Fish Chef was caught.");
                return damage;
            }
            else
            {
                System.out.println("The second attack was successful!");
                damage = player.attack(mob);
                return damage;
            }
        }

        else
        {
            System.out.println("SpecialAbilityBehavior missed...");
        }

        return damage;
    }
}
