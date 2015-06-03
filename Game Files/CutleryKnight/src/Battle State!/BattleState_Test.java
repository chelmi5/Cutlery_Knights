import java.util.*;

public class BattleState_Test
{   
   public static void main(String[] args)
   {
      int choice = 1;
      Scanner choiceKB = new Scanner(System.in);
      Scanner kb = new Scanner(System.in);
      
      boolean won = false;
      boolean lost = false;
         
      do
      {         
         AbstractHero[] party = chooseYourParty();
         ArrayList<AbstractMonster> monsters = generateMonsterParty();
         
         int[] tempPartyHP = new int[party.length];
         int combinedPartyHP = 0;
         
         for(int i = 0; i < party.length; i++)
         {
            tempPartyHP[i] = party[i].getHP();
         }
         
        // int[] tempMonsterHP = new int[monsters.size()];
         ArrayList<Integer> tempMonsterHP = new ArrayList<Integer>(monsters.size());
         int combinedMonsterHP = 0;
         
         for(int i = 0; i < monsters.size(); i++)
         {
            tempMonsterHP.add(monsters.get(i).getHP());
            combinedMonsterHP += monsters.get(i).getHP();
         }
            System.out.println("Total hero hp at: " + combinedPartyHP);
            System.out.println("Total monster hp at: " + combinedMonsterHP);
         
         while(lost == false && won == false)
         {
            //do party's attacks
            for(int i = 0; i < party.length; i++)
            {
               //select bad guy to attack
               int j;
               j = chooseMonToAttack(party[i], monsters);
            
               //attack
               if(party[i].getType() == 2)//does Pastry Chef attack separately, so Pastry Chef can heal.
               {
                  System.out.println("\nAs a Pastry Chef, " + party[i].getName() + " has a choice between two moves. Choose between either\n1)Regular Attack (80% chance)\n-or-\n2)Heal");
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
                     tempMonsterHP.set(j, party[i].attack(tempMonsterHP.get(j)) );
                  }
                  else //if(choice == 2)
                  {
                     tempPartyHP[i] = PastryChef.healSelf(tempPartyHP[i]);
                  }
               }
               
               else //warrior and thief
               {
                  tempMonsterHP.set(j, heroAttack(tempMonsterHP.get(j), tempPartyHP[i], party[i]) );
               }
               
               if (tempMonsterHP.get(j) <= 0)
               {
                  System.out.printf("Awesome! %s has defeated the %s!\n", party[i].getName(), monsters.get(j).getName());
                  monsters.remove(j);
                  tempMonsterHP.remove(j);
                  
                  if(monsters.isEmpty())
                  {
                     System.out.printf("\n Defeated all of the monsters! Battle won! \n");
                  }
               }
               else //monHP > 0
               {
                  System.out.println("\nThe group of monsters are currently sitting at: \n");
                  for(int k = 0; k < monsters.size(); k++)
                  {
                     System.out.println(monsters.get(k).getName() + ": " + tempMonsterHP.get(k) + " hp \n" );
                  }
                  
                  //tempMonsterHP[j] = monsters.get(j).heal(tempMonsterHP[j]);
                  tempMonsterHP.set( j, monsters.get(j).heal(tempMonsterHP.get(j)) );
                  tempPartyHP[i] = monsters.get(j).attack(tempPartyHP[i], party[i]);
                  if(tempPartyHP[i] <= 0)
                  {
                     System.out.println("Oh no! " + party[i] + " has fallen! \n");
                  }
                  
               }

            }//end for
         }//end while       
      
      }while (won == false && lost == false);
  
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
   
   public static ArrayList<AbstractMonster> generateMonsterParty()
   {
      AbstractMonster[] m = new AbstractMonster[3];
      ArrayList<AbstractMonster> monsters = new ArrayList<AbstractMonster>(3);
      
      for(int i = 0; i < m.length; i++)
      {
         m[i] = generateMonster();
         monsters.add(m[i]);
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
   
   public static int chooseMonToAttack(AbstractHero as, ArrayList<AbstractMonster> monsters)
   {
      Scanner kb = new Scanner(System.in);
      
      System.out.println("Choose monster for " + as.getName() + " to attack: ");   
      //System.out.println("1) " + monsters\n2) Pastry Chef (Healer)\n3) Fish Chef (Thief)");
      for(int i = 0; i < monsters.size(); i++)
      {
         System.out.println( i + ") " +  monsters.get(i).getName() + " \n" );
      }
      int choice = kb.nextInt();
      kb.nextLine();
      String name = "";
      
      while(choice < 0 || choice > monsters.size())
      {
         System.out.println("Sorry, must have valid input.");
         System.out.println("Choose monster for " + as.getName() + " to attack: ");   
         //System.out.println("1) " + monsters\n2) Pastry Chef (Healer)\n3) Fish Chef (Thief)");
         for(int i = 0; i < monsters.size(); i++)
         {
            System.out.println( i + ") " +  monsters.get(i).getName() + " \n" );
         }
         choice = kb.nextInt();
         kb.nextLine();
      }
      
      System.out.println("Alright, attacking " + monsters.get(choice).getName() + "! ");
      return choice;
      
   }//end chooseToAttack
   
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
