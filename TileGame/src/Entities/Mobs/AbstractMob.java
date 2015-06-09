package Entities.Mobs;
import Entities.Abilities.BasicEnemySpecialAbility;
import Entities.Abilities.SpecialAbilityBehavior;
import Entities.Stats;
import Entities.Characters.AbstractHero;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by CountryGeek1 on 6/8/15.
 */
public abstract class AbstractMob {
    protected double mChanceToHeal;
    protected int mMinHeal;
    protected int mMaxHeal;
    protected int mEnemyID;
    protected Stats mStats;

    private SpecialAbilityBehavior mAttack;

    public AbstractMob(Stats stats, double chanceToHeal, int minHeal, int maxHeal, int enemyID) {
        mStats = stats;
        mMinHeal = minHeal;
        mMaxHeal = maxHeal;
        mChanceToHeal = chanceToHeal;
        mEnemyID = enemyID;
        mAttack = new BasicEnemySpecialAbility();
    }

    void makeMob(String type){
    }

    public int heal(int selfHP)
    {
        double didItHeal = Math.random();
        Random num = new Random();

        if(selfHP >= mStats.getHitPoints())
        {
            return selfHP;
        }

        else if (didItHeal <= mChanceToHeal && selfHP < mStats.getHitPoints())
        {
            System.out.println("The Monster has a chance to heal itself...\n");
            int healPoints = num.nextInt(mMaxHeal - mMinHeal + 1) + mMinHeal;
            selfHP += healPoints;
            if(selfHP > mStats.getHitPoints())
            {
                System.out.printf("They healed their HP back to full health!");
                selfHP = mStats.getHitPoints();
            }
            else
            {
                System.out.printf("They healed their HP for %d points! Their HP is now at %d!\n", healPoints, selfHP);
            }
            return selfHP;
        }
        else if (didItHeal > mChanceToHeal)
        {
            System.out.println("The Monster has a chance to heal itself...\n");
            System.out.println("But it failed to heal!\n");
        }

        return selfHP;
    }

    public int attack(AbstractHero player)
    {
        return mAttack.Effect(player, this);
    }

    public int getEnemyID() {
        return mEnemyID;
    }

    public Stats getStats() {
        return mStats;
    }

    public abstract BufferedImage getIcon();
}
