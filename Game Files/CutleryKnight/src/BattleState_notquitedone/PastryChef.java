//Chelsea Davis, Assignment 3, CSCD 211, Winter 2014
import java.util.*;

public class PastryChef extends AbstractHero
{
   protected PastryChef(String name)
   {
      super(name, 100, 5, 25, 45, 0.8, 0.2, 1, 2); 
   }

   public static int healSelf(int selfHP)
   {
      if(selfHP < 100)
      {
         Random num = new Random();
         int healPoints = num.nextInt(26)+30;
         selfHP += healPoints;
         if (selfHP > 100)
         {
            selfHP = 100;
            System.out.printf("The Pastry Chef healed herself back to full health! Her HP is now at %d!", selfHP);
         }
         else
         {
            System.out.printf("The Pastry Chef healed herself for %d points! Her HP is now at %d!", healPoints, selfHP);
         }
         return selfHP;
      }
      else
      {
         System.out.println("Don't waste your turn... Why heal when you have full health?");
         return selfHP;  
      }
     
   }
   
}