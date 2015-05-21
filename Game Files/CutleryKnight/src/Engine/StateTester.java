package Engine;

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
      s.toTitleState();
      
      while(i != 111)
      {
         s.Render();
      }
      
   }//end main
}//end class
