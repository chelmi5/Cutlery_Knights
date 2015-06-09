package Entities.Abilities;
import Entities.Mobs.Mob;
import Entities.Characters.AbstractHero;
import java.util.Random;

public class BasicEnemySpecialAbility implements SpecialAbilityBehavior {

    @Override
    public int Effect(AbstractHero player, Mob mob) {
        int damage = 0;
        double didItHit = Math.random();
        Random num = new Random();
        System.out.print("\nThe Monster lunges at the Hero to attack...\n");

        if (didItHit <= mob.getStats().getChanceToHit())
        {
            damage = num.nextInt(mob.getStats().getDamageMax() - mob.getStats().getDamageMin() + 1) + mob.getStats().getDamageMin();

            if(player.getChanceToBlock() >= Math.random()) //chance to block for hero
            {
                System.out.print("But the Hero blocked the SpecialAbilityBehavior!\n\n");
            }
            else
            {
                System.out.print("And lands a successful blow!\n\n");
                return damage;
            }
        }

        else
        {
            System.out.print("But they were unsucessful...\n\n");
        }

        return damage;
    }
}
