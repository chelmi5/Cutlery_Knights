package Entities.Mobs;

/**
 * Created by CountryGeek1 on 6/8/15.
 */
public abstract class MobFactory {

    public AbstractMob orderMob(String type, int enemyID) {
        AbstractMob mob = makeMob(type, enemyID);
        System.out.println("Making a " + mob.getStats().getName());
        // More stuff later maybe :D
        return mob;
    }

    abstract AbstractMob makeMob(String type, int enemyID);
}
