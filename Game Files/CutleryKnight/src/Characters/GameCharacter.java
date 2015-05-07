package Characters;

import Objects.AttackBehavior;
import Objects.DefendBehavior;

/**
 * Created by CountryGeek1 on 4/19/2015.
 */
public abstract class GameCharacter {
    AttackBehavior mAttack;
    DefendBehavior mDefend;

    public abstract void displayStats();


    public GameCharacter() {
    }

    public void exectAttack() {
        mAttack.attack();
    }

    public void exectDefend() {
        mDefend.defend();
    }

    public void setPlayGuitar(AttackBehavior attacking) {
        mAttack = attacking;
    }

    public void setPlaySolo(DefendBehavior defeding) {
        mDefend = defeding;
    }
}
