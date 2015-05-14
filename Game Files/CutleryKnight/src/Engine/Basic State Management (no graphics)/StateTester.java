import java.util.*;
import java.rmi.*;
import java.rmi.server.*;

public class StateTester
{
   public static void main(String[] args) throws RemoteException
   {
      StateMachine s = new StateMachine();
      int i = 0;
      Scanner fin = new Scanner(System.in);
      
      while(i != 4)
      {
         System.out.println("\n Choose a state to move to: ");
         System.out.println("1)Title 2)Exploration 3)Battle 4)Exit ");
         
         i = fin.nextInt();
         
         if(i == 1)
         {
            s.toTitleState();
         }
         else if(i == 2)
         {
            s.toExplorationState();
         }
         else if(i == 3)
         {
            s.toBattleState();
         }
         else if(i == 4)
         {
            System.out.println("Exiting.. ");
            System.exit(0);
         }
         else
         {
            System.out.println("Bad selection. Try again. ");
         }
         
      }//end while
      
   }//end main
}//end class
