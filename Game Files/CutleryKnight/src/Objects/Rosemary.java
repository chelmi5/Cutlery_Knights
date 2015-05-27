package Objects;
import Characters.GameCharacter;

public class Rosemary extends Item {

   // reference to the hero who owns the object
   
   public Rosemary(){
      this.name = "Rosemary";
      this.description = "Increases health by 10 points";
   }
   
   public void action(GameCharacter hero){
     hero.getmStats().setHP(hero.getmStats().getHP()+10);
   }
}