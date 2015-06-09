package Entities.Mobs;

/**
 * Created by CountryGeek1 on 6/8/15.
 */
public class RoundOneFactory extends MobFactory {

    @Override
    public AbstractMob makeMob(String type, int enemyID) {
        if (type.equalsIgnoreCase("FishAbstractMob"))
            return new FishAbstractMob(enemyID);
        else if (type.equalsIgnoreCase("EggsAbstractMob"))
            return new EggsAbstractMob(enemyID);
        else if (type.equalsIgnoreCase("DonutAbstractMob"))
            return new DonutAbstractMob(enemyID);
        else
            return null;
    }
}
