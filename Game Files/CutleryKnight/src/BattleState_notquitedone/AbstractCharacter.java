//Chelsea Davis, Assignment 3, CSCD 211, Winter 2014
import java.util.*;

public abstract class AbstractCharacter 
{
   protected String name;
   protected int hp;
   protected int attackSpeed;
   protected int minRange;
   protected int maxRange;
   protected double chanceToHit;
   
   public AbstractCharacter(String n, int h, int as, int minr, int maxr, double c)
   {
      this.name = n;
      this.hp = h;
      this.attackSpeed = as;
      this.minRange = minr;
      this.maxRange = maxr;
      this.chanceToHit = c;
   }
   
   public int attack(int enemyHP)
   {
      double didItHit = Math.random();
      Random num = new Random();

      if (didItHit <= this.chanceToHit)
      {
         int damage = num.nextInt(this.maxRange - this.minRange + 1) + this.minRange;
         enemyHP -= damage;
         System.out.printf("Attack successful! Inflicted %d damage!\n", damage);
      }
      
      else
      {
         System.out.println("Attack unsucessful...\n");
      }
   
   
      return enemyHP;
   }
   
   public String getName()
   {return this.name;}
   
   public int getHP()
   {return this.hp;}
   
   public int getAttackSpeed()
   {return this.attackSpeed;}
   
   //so that Thief can use special attack
   public int surpriseAttack(int enemyHP) 
   {return 1;}
}