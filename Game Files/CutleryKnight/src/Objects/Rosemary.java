package Objects;

public class Rosemary extends Item {

   // reference to the hero who owns the object
   
   public Rosemary(){
      this.name = "Rosemary";
      this.description = "Increases health by 10 points";
   }
   
   public void action(){
     // Hero.stats.addHP(10); 
   }
}