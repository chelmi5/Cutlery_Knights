package Items;
import Entities.Characters.AbstractHero;
import Graphics.GraphicAssets;

import java.awt.image.BufferedImage;

public class Pepper implements Item {

    private String name;
    private String description;
    private BufferedImage mIcon;

    public Pepper(){
        this.name = "Artificial Preservatives";
        this.description = "- 10% chance to Hit";
        mIcon = GraphicAssets.mArtificialPer;
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
