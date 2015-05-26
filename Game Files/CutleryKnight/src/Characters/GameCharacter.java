package Characters;
import Objects.AttackBehavior;
import Objects.DefendBehavior;

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

    public void setAttack(AttackBehavior attacking) {
        mAttack = attacking;
    }

    public void setDefend(DefendBehavior defeding) {
        mDefend = defeding;
    }
}
