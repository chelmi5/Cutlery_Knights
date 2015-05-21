package Characters;

public class ConcreteBoss extends Enemy {
   
   //standard bosses have the same initial values
   // DMin        = 10;
   // DMax        = 20;
   // pToDefend   = 40;
   
   public ConcreteBoss(String eName){
      super(eName, 10, 20, 40.0);
   }
   
}