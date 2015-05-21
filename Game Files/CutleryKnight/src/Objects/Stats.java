package Objects;

public class Stats {
    private int mHP;
    private int mAttackDamage;
    private int mAttackSpeed;

    public Stats() {
        mHP = 100;
        mAttackDamage = 5;
        mAttackSpeed = 1;
    }

    public Stats(int hp, int ad, int as) {
        mHP = hp;
        mAttackDamage = ad;
        mAttackSpeed = as;
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

    public void displayStats() {
        System.out.println("HP: " + mHP + "\nAttack Damage: " + mAttackDamage + "\nAttack Speed: " + mAttackSpeed);
    }
}
