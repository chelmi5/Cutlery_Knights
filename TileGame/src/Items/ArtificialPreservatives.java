package Items;

import Entities.Characters.AbstractHero;

public class ArtificialPreservatives implements Item{

    private String name;
    private String description;

    public ArtificialPreservatives(){
        this.name = "Artificial Preservatives";
        this.description = " - 10% chance to ";
    }

    @Override
    public void action(AbstractHero character) {
        character.getStats().setChanceToHit(-0.1);
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }
}
