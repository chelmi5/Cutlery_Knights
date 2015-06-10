package Items;
import Entities.Characters.AbstractHero;
import Graphics.GraphicAssets;

import java.awt.image.BufferedImage;

public class Rosemary implements Item {

    private String name;
    private String description;
    private BufferedImage mIcon;

    public Rosemary(){
        this.name = "Rosemary";
        this.description = "+ 10 Health Points";
        mIcon = GraphicAssets.mRoseMary;
    }

    @Override
    public void action(AbstractHero character) {
        character.getStats().setHitPoints(character.getStats().getHitPoints() + 10);
        System.out.println("Applied a 10 HP to hero");
    }

    public BufferedImage getIcon(){
        return mIcon;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }
}
