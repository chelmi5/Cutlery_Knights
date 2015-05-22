package Objects;

/**
 * Created by CountryGeek1 on 4/22/2015.
 */
public class Stats {
    private int mHP;
    private int mAttackDamage;
    private int mAttackSpeed;

    public Stats() {
        mHP = 100;
        mAttackDamage = 5;
        mAttackSpeed = 1;
    }

    public int getHP() {
        return mHP;
    }

    public void updateHP(int damage) {
        this.mHP = mHP - damage;
    }

    public int getmAttackDamage() {
        return mAttackDamage;
    }

    public void updateAttackDamage(int attackBoost) {
        this.mAttackDamage = mAttackDamage + attackBoost;
    }

    public int getAttackSpeed() {
        return mAttackSpeed;
    }

    public void updateAttackSpeed(int speedBoost) {
        this.mAttackSpeed = mAttackSpeed + speedBoost;
    }
    // Special attack
}