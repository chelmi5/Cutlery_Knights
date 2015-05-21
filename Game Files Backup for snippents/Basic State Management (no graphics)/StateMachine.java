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
    
    public StateMachine() throws RemoteException//String location) throws RemoteException
    {
         titleState = new TitleState(this);
         explorationState = new ExplorationState(this);
         battleState = new BattleState(this);
         
         currentState = new EmptyState(this);
         
         this.location = "";
         System.out.println("State Machine initialized.");
    }
    
    //actions here
    
    public void changeStates(IState s)
    {
        currentState.OnExit();
        currentState = s;
        currentState.OnEnter();
    }
    
 
    public void Update()
    {
        currentState.Update();
    }
 
    public void Render()
    {
        currentState.Render();
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