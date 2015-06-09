package Entities.Abilities;
import Entities.Mobs.AbstractMob;
import Entities.Characters.AbstractHero;

public interface SpecialAbilityBehavior {
    int Effect(AbstractHero player, AbstractMob mob);
}
