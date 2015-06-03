import java.util.*;

public class FishChef extends AbstractHero
{
   protected FishChef(String name)
   {
      super(name, 100, 6, 20, 40, 0.8, 0.4, 1, 3); 
   }
   
   @Override
   public int surpriseAttack(int enemyHP) 
   {
      Random num = new Random();
      int didItHit = num.nextInt(11);
      
      if (didItHit <= 4)
      {
         enemyHP = attack(enemyHP);
         
         if(num.nextInt(11) <= 2)
         {
            System.out.println("The first attack was successful, but the Fish Chef was caught.");
            return enemyHP;
         }
         else
         {
            System.out.println("The second attack was successful!");
            enemyHP = attack(enemyHP);
            return enemyHP;
         }
      }
      
      else
      {
         System.out.println("Attack missed...");
      }
      
      return enemyHP;
   }
   
}