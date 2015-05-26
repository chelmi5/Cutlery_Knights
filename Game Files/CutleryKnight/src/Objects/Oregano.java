package Objects;

public class Oregano extends Item {

   // reference to the hero who owns the object
   
   public Oregano(){
      this.name = "Oregano";
      this.description = "Increase damage done by regular attack";
   }
   
   public void action(){
     // Hero.stats.percentToHit( getPercentToHit() + 10 )
   }
}