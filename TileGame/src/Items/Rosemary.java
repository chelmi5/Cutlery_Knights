package Items;
import Entities.Characters.AbstractHero;

/**
 * Created by CountryGeek1 on 6/8/15.
 */
public class Rosemary implements Item {

    private String name;
    private String description;

    public Rosemary(){
        this.name = "Rosemary";
        this.description = "Increases health by 10 points";
    }

    @Override
    public void action(AbstractHero character) {
        character.getStats().setHitPoints(character.getStats().getHitPoints() + 10);
        System.out.println("Applied a 10 HP to hero");
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }
}
