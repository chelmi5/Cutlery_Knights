package Objects;

public class ArtificialPreservatives extends Item {

   // reference to the hero who owns the object
   
   public ArtificialPreservatives(){
      this.name = "Artificial Preservatives";
      this.description = "Enemy does no damage for 2 turns";
   }
   
   public void action(){
     // Hero.stats.addHP(10); 
   }
}