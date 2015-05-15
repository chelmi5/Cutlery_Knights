public class ConcreteBoss extends Enemy{
   
   //standard bosses have the same initial values
   private  int    DMin        = 5;
   private  int    DMax        = 20;
   private  double pToDefend   = 40;
   
   public ConcreteEnemy(String eName){
      super(eName,DMin,DMax,pToDefend);
   }
   
}