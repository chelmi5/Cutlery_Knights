package Items;
import Entities.Characters.AbstractHero;

public class Oregano implements Item{

    private String name;
    private String description;

    public Oregano(){
        this.name = "Oregano";
        this.description = "Increase damage range by 10 for regular attacks";
    }


    @Override
    public void action(AbstractHero character) {
        character.getStats().setMaxDamage(10);
        System.out.println("Applied a Range boost by 10");
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }
}
