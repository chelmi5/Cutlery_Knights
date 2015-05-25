//Chelsea Davis, Assignment 3, CSCD 211, Winter 2014
import java.util.*;

public class ChefParty_Test
{   
   public static void main(String[] args)
   {
      int choice = 1;
      Scanner choiceKB = new Scanner(System.in);
      Scanner kb = new Scanner(System.in);
      do
      {
         /*
         setNumTurns(player, badGuy);
         int tempHeroHP = player.getHP();
         int tempMonHP = badGuy.getHP();
         String heroName = player.getName();*/
         
         //AbstractHero[] party = new AbstractHero[3];
         AbstractHero[] party = chooseYourParty();
         AbstractMonster[] monsters = generateMonsterParty();
         
         int[] tempPartyHP = new int[party.length];
         int[] tempMonsterHP = new int[monsters.length];
         
         //Possibly use later..?
         /*
         int avgHeroSpd = 0;
         int avgMonSpd = 0;
         
         for(int i = 0; i < party.length; i++)
         {
            avgHeroSpd += party[i].getAttackSpeed();
         }
         
         for(int i = 0; i < monsters.length; i++)
         {
            avgMonSpd += monsters[i].getAttackSpeed();
         }
         
         avgHeroSpd = avgHeroSpd / party.length;
         avgMonSpd = avgMonSpd / monsters.length;
         
         int newHeroTurns = avgHeroSpd % avgMonSpd;
         
         if(newHeroTurns < 1)
            newHeroTurns = 1;
         
         for(int i = 0; i < party.length; i++)
         {
            party[i].setNumTurns(newHeroTurns);
         }
         */
         
         
         
         /*
               
         while(tempHeroHP > 0 && tempMonHP > 0)
         {
            if(player.getType() == 2)//does Sorceress attack separately, so Sorceress can heal.
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
         } */
      
      }while (choice == 1);
  
   }//end main
   
   public static AbstractHero[] chooseYourParty()
   {
      AbstractHero[] party = new AbstractHero[3];
         
      for(int i = 0; i < party.length; i++)
      {
         party[i] = chooseYourHero();
      }
      
      return party;
   }
   
   public static AbstractMonster[] generateMonsterParty()
   {
      AbstractMonster[] monsters = new AbstractMonster[3];
      
      for(int i = 0; i < monsters.length; i++)
      {
         monsters[i] = generateMonster();
      }
      
      return monsters;
   }

   
   public static AbstractHero chooseYourHero()
   {
      Scanner kb = new Scanner(System.in);
      
      System.out.println("Choose a hero: ");   
      System.out.println("1) Saute Chef (Warrior)\n2) Pastry Chef (Healer)\n3) Fish Chef (Thief)");
      int choice = kb.nextInt();
      kb.nextLine();
      String name = "";
      
      while(choice < 1 || choice > 3)
      {
         System.out.println("Sorry, must have valid input.");
         System.out.println("Choose a hero: ");   
         System.out.println("1) Saute Chef (Warrior)\n2) Pastry Chef (Healer)\n3) Fish Chef (Thief)");
         choice = kb.nextInt();
         kb.nextLine();
      }
      
      if (choice == 1)
      {
         System.out.println("Saute Chef it is! His starting hp is 125. What do you want to name your Saute Chef?\n");
         name = kb.nextLine();
         System.out.printf("Alright, %s has been added to the party!\n", name);
         return new SauteChef(name);
      }
      
      else if (choice == 2)
      {
         System.out.println("Pastry Chef it is! Her starting hp is 100. What do you want to name your Pastry Chef?\n");
         name = kb.nextLine();
         System.out.printf("Alright, %s has been added to the party!\n", name);
         return new PastryChef(name);
      }
      
      else //choice == 3
      {
         System.out.println("Fish Chef it is! Her starting hp is 100. What do you want to name your Fish Chef?\n");
         name = kb.nextLine();
         System.out.printf("Alright, %s has been added to the party!\n", name);
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

   
}//end class
