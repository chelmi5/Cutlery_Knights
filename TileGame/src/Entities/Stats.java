package Entities;

/**
 * Created by CountryGeek1 on 6/8/15.
 */
public class Stats {

    private String mName;
    private int mHitPoints;
    private int mMaxHP;
    private int mAttackSpeed;
    private double mChanceToHit;
    private int mDamageMin;
    private int mDamageMax;

    public Stats(String name, int hp, int attackSpeed, int minDamage, int maxDamage, double chanceToHit) {
        mName = name;
        mMaxHP = hp;
        mHitPoints = hp;
        mAttackSpeed = attackSpeed;
        mChanceToHit = chanceToHit;
        mDamageMax = maxDamage;
        mDamageMin = minDamage;
    }

    public String getName() {
        return mName;
    }

    public int getHitPoints() {
        return mHitPoints;
    }

    public int getAttackSpeed() {
        return mAttackSpeed;
    }

    public double getChanceToHit() {
        return mChanceToHit;
    }

    public int getDamageMin() {
        return mDamageMin;
    }


    public int getDamageMax() {
        return mDamageMax;
    }


    public void setName(String mName) {
        this.mName = mName;
    }

    public void setHitPoints(int hp) {
        if (hp > -1)
            mHitPoints = hp;
        else
            mHitPoints = 0;
    }

    public int getMaxHitPoints(){
        return mMaxHP;
    }

    public void changeHitPoints(int newHp) {
        this.mHitPoints = newHp;
    }

    public void setMaxDamage(int maxRange){
        if (maxRange > 0)
            mDamageMax += maxRange;
    }

    public void setChanceToHit(double num){
        if((mChanceToHit + num) > 0)
            mChanceToHit += num;
    }
}
