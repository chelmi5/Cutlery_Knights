import java.util.*;

public class SauteChef extends AbstractHero
{
   protected SauteChef(String name)
   {
      super(name, 125, 4, 35, 60, 0.8, 0.2, 1, 1);
   }
   
   public static int crushingBlow(int enemyHP)
   {
      Random num = new Random();
      int didItHit = num.nextInt(11);
      int damageDone = num.nextInt(101) + 75;
      
      if (didItHit <= 4)
      {
         System.out.printf("Attack successful! Saute Chef did %d damage to Monster!\n", damageDone);
         enemyHP -= damageDone;
      }
      
      else
      {
         System.out.println("Attack missed...");
      }
      
      return enemyHP;
   }
   
}