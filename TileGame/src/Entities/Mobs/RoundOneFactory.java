package Entities.Mobs;

/**
 * Created by CountryGeek1 on 6/8/15.
 */
public class RoundOneFactory extends MobFactory {

    @Override
    public Mob makeMob(String type, int enemyID) {
        if (type.equalsIgnoreCase("FishMob"))
            return new FishMob(enemyID);
        else if (type.equalsIgnoreCase("EggsMob"))
            return new EggsMob(enemyID);
        else if (type.equalsIgnoreCase("DonutMob"))
            return new DonutMob(enemyID);
        else
            return null;
    }
}
