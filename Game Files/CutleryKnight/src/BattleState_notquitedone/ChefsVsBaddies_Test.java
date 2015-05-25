//Chelsea Davis, Assignment 3, CSCD 211, Winter 2014
import java.util.*;

public class ChefsVsBaddies_Test
{   
   public static void main(String[] args)
   {
      int choice = 1;
      Scanner choiceKB = new Scanner(System.in);
      Scanner kb = new Scanner(System.in);
      do
      {
         AbstractHero player = chooseYourHero();
         AbstractMonster badGuy = generateMonster();
         setNumTurns(player, badGuy);
         int tempHeroHP = player.getHP();
         int tempMonHP = badGuy.getHP();
         String heroName = player.getName();
      
         while(tempHeroHP > 0 && tempMonHP > 0)
         {
            if(player.getType() == 2)//does Pastry Chef attack separately, so Pastry Chef can heal.
            {
               System.out.println("\nAs a Pastry Chef, you have a choice between two moves. Choose between either\n1)Regular Attack (80% chance)\n-or-\n2)Heal");
               choice = kb.nextInt();
               kb.nextLine();
               
               while (choice < 1 || choice > 2)
               {
                  System.out.println("Invalid attack choice.");
                  System.out.println("Choose between either\n1)Regular Attack (80% chance)/n-or-\n2)Heal");
                  choice = kb.nextInt();
                  kb.nextLine();
               }
               
               if (choice == 1)
               {
                  tempMonHP = player.attack(tempMonHP);
               }
               else //if(choice == 2)
               {
                  tempHeroHP = PastryChef.healSelf(tempHeroHP);
               }
            }
            
            else //warrior and thief
            {
               tempMonHP = heroAttack(tempMonHP, tempHeroHP, player);
            }
            
            if (tempMonHP <= 0)
            {
               System.out.printf("Congrats! Your Hero, %s, has won the battle!\n", heroName);
            }
            else //monHP > 0
            {
               System.out.println("\nThe Monster's current hp is " + tempMonHP + "\n");
               tempMonHP = badGuy.heal(tempMonHP);
               tempHeroHP = badGuy.attack(tempHeroHP, player);
               if(tempHeroHP <= 0)
               {
                  System.out.println("Oh dear... the hero has been defeated.");
               }
            }
         }
         
         System.out.println("\nDo you want to play again? \n1)Yes\nor\n2)No");
         choice = choiceKB.nextInt();
         choiceKB.nextLine();
         
         while(choice > 2 || choice < 1)
         {
            System.out.println("Invalid input.");
            System.out.println("\nDo you want to play again? \n1)Yes\nor\n2)No");
            choice = choiceKB.nextInt();
            choiceKB.nextLine();
         }
      
      }while (choice == 1);
  
   }//end main
   
   public static AbstractHero chooseYourHero()
   {
      Scanner kb = new Scanner(System.in);
      
      System.out.println("Which Hero do you want to play as?");   
      System.out.println("1) Saute Chef (Warrior)\n2) Pastry Chef (Healer)\n3) Fish Chef (Thief)");
      int choice = kb.nextInt();
      kb.nextLine();
      String name = "";
      
      while(choice < 1 || choice > 3)
      {
         System.out.println("Sorry, must have valid input.");
         System.out.println("Which Hero do you want to play as?");   
         System.out.println("1) Saute Chef (Warrior)\n2) Pastry Chef (Healer)\n3) Fish Chef (Thief)");
         choice = kb.nextInt();
         kb.nextLine();
      }
      
      if (choice == 1)
      {
         System.out.println("Saute Chef it is! Your starting hp is 125. What do you want to name your Saute Chef?\n");
         name = kb.nextLine();
         System.out.printf("Alright, %s, it's time to start your adventure!\n", name);
         return new SauteChef(name);
      }
      
      else if (choice == 2)
      {
         System.out.println("Pastry Chef it is! Your starting hp is 100. What do you want to name your Pastry Chef?\n");
         name = kb.nextLine();
         System.out.printf("Alright, %s, it's time to start your adventure!\n", name);
         return new PastryChef(name);
      }
      
      else //choice == 3
      {
         System.out.println("Fish Chef it is! Your starting hp is 100. What do you want to name your Fish Chef?\n");
         name = kb.nextLine();
         System.out.printf("Alright, %s, it's time to start your adventure!\n", name);
         return new FishChef(name);
      }
   
   }//end chooseYourHero
   
   public static AbstractMonster generateMonster()
   {
      Random r = new Random();
      int whichMon = r.nextInt(3) + 1;
      
      while(whichMon > 3 || whichMon < 1) //makes sure to get 1 2 or 3
      {
         whichMon = r.nextInt(3) + 1;
      }
      
      if (whichMon == 1)
      {
         System.out.println("\nSuddenly, a haunted donut appeared! Its hp is 200!");
         return new Donut();
      }
      
      else if (whichMon == 2)
      {
         System.out.println("\nAll of a sudden, some possessed eggs appeared! Their hp is 70!");
         return new Eggs();
      }
      
      else //whichMon == 3
      {
         System.out.println("\nYikes! A smelly fish appeared! Its hp is 100!");
         return new Fish();
      }
   
   }//end generateMonster
   
   public static void setNumTurns(AbstractHero player, AbstractMonster badGuy)
   {
      int heroS = player.getAttackSpeed();
      int monS = badGuy.getAttackSpeed();
      int newHeroTurns = heroS % monS;
      
      if(newHeroTurns < 1)
         newHeroTurns = 1;
         
      player.setNumTurns(newHeroTurns);
   
   }//end set turns
   
   public static int heroAttack(int monHP, int heroHP, AbstractHero player)
   {
      Scanner kb = new Scanner(System.in);
      int choice;
   
      if (player.getType() == 1) //warrior
      {
         System.out.println("\nAs a Saute Chef, you have a choice between two attacks. Choose between either\n1)Regular Attack (80% chance)\n-or-\n2)Crushing Blow (40% chance)");
         choice = kb.nextInt();
         kb.nextLine();
         
         while (choice < 1 || choice > 2)
         {
            System.out.println("Invalid attack choice.");
            System.out.println("Choose between either\n1)Regular Attack (80% chance)\n-or-\n2)Crushing Blow (40% chance)");
            choice = kb.nextInt();
            kb.nextLine();
         }
         
         if (choice == 1)
         {
            monHP = player.attack(monHP);
         }
         else //if(choice == 2)
         {
            monHP = SauteChef.crushingBlow(monHP);
         }
      
      }

      else if (player.getType() == 3) //thief    
      {
         System.out.println("\nAs a Fish Chef, you have a choice between two attacks. Choose between either\n1)Regular Attack (80% chance)\n-or-\n2)Surprise Attack (40% chance of success, but 20% chance of being caught)");
         choice = kb.nextInt();
         kb.nextLine();
         
         while (choice < 1 || choice > 2)
         {
            System.out.println("Invalid attack choice.");
            System.out.println("Choose between either\n1)Regular Attack (80% chance)\n-or-\n2)Surprise Attack (40% chance of success, but 20% chance of being caught)");
            choice = kb.nextInt();
            kb.nextLine();
         }
         
         if (choice == 1)
         {
            monHP = player.attack(monHP);
         }
         else //if(choice == 2)
         {
            monHP = player.surpriseAttack(monHP);
         }
      }   
      return monHP;
   
   }//end hero attack

}//end class