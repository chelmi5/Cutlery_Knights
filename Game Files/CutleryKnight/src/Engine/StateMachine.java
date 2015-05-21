package Engine;

import java.util.*;
import java.rmi.*;
import java.rmi.server.*;

public class StateMachine extends UnicastRemoteObject
{
    IState titleState;
    IState explorationState;
    IState battleState;
    //IState characterSelectState;
    
    IState currentState;
    String location;
    
    GameFrame gameFrame;
    
    //ExplorationGraphics exploreG;
    //TitleGraphics titleG;
    
    public StateMachine() throws RemoteException//String location) throws RemoteException
    {
         titleState = new TitleState(this);
         explorationState = new ExplorationState(this);
         battleState = new BattleState(this);
         
         //titleG = titleState.getGraphics();
         //exploreG = explorationState.getGraphics();
         
         currentState = new EmptyState(this);
         gameFrame = new GameFrame(titleState);
         
         this.location = "";
         System.out.println("State Machine initialized.");
    }
    
    //actions here
    
    public void changeStates(IState s)
    {
        currentState.OnExit();
        currentState = s;
        String in = currentState.getType();
        gameFrame.changePanel(in, s);        
        currentState.OnEnter();
    }
    
 
    public void Update()
    {
        currentState.Update();
    }
 
    public void Render()
    {
        currentState.Render();
        
        if(currentState.getChange() == true)
        {
            System.out.println("State machine got true");
            if(currentState.getType().equals("title"))
            {
               this.toExplorationState();
            }
        }
    }
    
    public void toTitleState()
    {
      changeStates(titleState);
    }
    public void toExplorationState()
    {
      changeStates(explorationState);
    }
    public void toBattleState()
    {
      changeStates(battleState);
    }
}