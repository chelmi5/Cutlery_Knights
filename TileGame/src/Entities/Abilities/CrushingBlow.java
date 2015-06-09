package Entities.Abilities;

import Entities.Characters.AbstractHero;
import Entities.Mobs.Mob;

import java.util.Random;

/**
 * Created by CountryGeek1 on 6/8/15.
 */
public class CrushingBlow implements SpecialAbilityBehavior {

    @Override
    public int Effect(AbstractHero player, Mob mob) {
        Random num = new Random();
        int damage = 0;
        int didItHit = num.nextInt(11);
        int damageDone = num.nextInt(101) + 75;

        if (didItHit <= 4)
        {
            System.out.printf("SpecialAbilityBehavior successful! Saute Chef did %d damage to Monster!\n", damageDone);
            damage = damageDone;
        }

        else
        {
            System.out.println("SpecialAbilityBehavior missed...");
        }

        return damage;
    }
}
