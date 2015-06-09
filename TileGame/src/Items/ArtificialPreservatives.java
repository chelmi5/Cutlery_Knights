package Items;
import Entities.Characters.AbstractHero;
import java.awt.image.BufferedImage;

public class ArtificialPreservatives implements Item {

    private String name;
    private String description;
    private BufferedImage mIcon;

    public ArtificialPreservatives(){
        this.name = "Artificial Preservatives";
        this.description = " - 10% chance to Hit";
       // mIcon = ;
    }

    @Override
    public void action(AbstractHero character) {
        character.getStats().setChanceToHit(-0.1);
    }

    public BufferedImage getIcon() {
        return mIcon;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }
}
