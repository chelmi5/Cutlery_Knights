package Entities.Abilities;
import Entities.Mobs.Mob;
import Entities.Characters.AbstractHero;

public interface SpecialAbilityBehavior {
    int Effect(AbstractHero player, Mob mob);
}
