package Entities.Abilities;
import Entities.Characters.AbstractHero;
import Entities.Mobs.AbstractMob;
import Utilities.CodeTools;
import java.util.Random;

public class RegularPlayerSpecialAbility implements SpecialAbilityBehavior {
    @Override
    public int Effect(AbstractHero player, AbstractMob mob) {
            double didItHit = Math.random();
            Random num = new Random();
            int damage = 0;


            if (didItHit <= player.getStats().getChanceToHit())
            {
                System.out.println("min: " + player.getStats().getDamageMin() + " max: " + player.getStats().getDamageMax());
                damage = CodeTools.randInt(player.getStats().getDamageMin(), player.getStats().getDamageMax()) + player.getStats().getDamageMin();
                while (damage < 0)
                {
                    System.out.println("damage: " + damage);
                    damage = CodeTools.randInt(player.getStats().getDamageMin(), player.getStats().getDamageMax()) + player.getStats().getDamageMin();
                }
                //enemyHP -= damage;
                System.out.printf("SpecialAbilityBehavior successful! Inflicted %d damage!\n", damage);
            }
            else
            {
                System.out.println("SpecialAbilityBehavior unsucessful...\n");
            }
            return damage;
    }
}
