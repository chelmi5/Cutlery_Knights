public class ConcreteEnemy extends Enemy{
   
   //standard enemies have the same initial values
   private  int    DMin        = 5;
   private  int    DMax        = 15;
   private  double pToDefend   = 30;
   
   public ConcreteEnemy(String eName){
      super(eName,DMin,DMax,pToDefend);
   }
   
}