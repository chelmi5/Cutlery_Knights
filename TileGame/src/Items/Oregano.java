package Items;
import Entities.Characters.AbstractHero;
import java.awt.*;
import java.awt.image.BufferedImage;
import Graphics.GraphicAssets;

public class Oregano implements Item {

    private String name;
    private String description;
    private BufferedImage mIcon;

    public Oregano(){
        this.name = "Oregano";
        this.description = "+ 10 Max Damage";
        mIcon = GraphicAssets.mOregano;
    }


    @Override
    public void action(AbstractHero character) {
        character.getStats().setMaxDamage(10);
        System.out.println("Applied a Range boost by 10");
    }

    @Override
    public Image getIcon() {
        return mIcon;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }
}
