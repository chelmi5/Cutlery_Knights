package Engine;

public class ExplorationState implements IState
{
   transient StateMachine stateMachine;
   private String type;
   
   public ExplorationState(StateMachine s)
   {
      this.stateMachine = s;
      this.type = "explore";
   }
   
   public String getType()
   {
      return this.type;
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
       // new GameFrame(this.type);
    }
 
    public void OnEnter()
    {
        // ExplorationState OnEnter
        System.out.println("Exploration State Entered");
       // this.Render();
    }
 
    public void OnExit()
    {
        // ExplorationState OnExit
        System.out.println("Exploration State OnExit");
    }
}