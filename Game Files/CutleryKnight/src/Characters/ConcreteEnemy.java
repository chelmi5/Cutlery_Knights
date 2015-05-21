package Characters;
import Objects.Stats;

public class ConcreteEnemy extends Enemy {
   
   // standard enemies have the same initial values
   // DMin        = 5;
   // DMax        = 15;
   // pToDefend   = 30.0;
    public ConcreteEnemy(String eName)
    {
        super(eName, 5, 15, 30.0);
    }
}