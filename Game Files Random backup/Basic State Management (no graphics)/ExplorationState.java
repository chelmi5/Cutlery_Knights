public class ExplorationState implements IState
{
   transient StateMachine stateMachine;
   
   public ExplorationState(StateMachine s)
   {
      this.stateMachine = s;
   }
   
    public void Update()
    {
        // ExplorationState Update
        System.out.println("Exploration State update");
    }
 
    public void Render()
    {
        // ExplorationState Render
        System.out.println("Exploration State Render");
    }
 
    public void OnEnter()
    {
        // ExplorationState OnEnter
        System.out.println("Exploration State Entered");
    }
 
    public void OnExit()
    {
        // ExplorationState OnExit
        System.out.println("Exploration State OnExit");
    }
}