package Engine;

public class ExplorationState implements IState
{
   transient StateMachine stateMachine;
   private String type;
   private AGraphics graphics;
   private boolean change;
   
   public ExplorationState(StateMachine s)
   {
      this.stateMachine = s;
      this.type = "explore";
      this.change = false;
      this.graphics = new ExplorationGraphics(this);
   }
   
   public String getType()
   {
      return this.type;
   }
   
   public boolean getChange()
   {
      return change;
   }
   
   public AGraphics getGraphics()
   {
      return this.graphics;
   }
   
    public void Update()
    {
        // ExplorationState Update
        System.out.println("Exploration State update");
    }
 
    public void Render()
    {
        // ExplorationState Render
        System.out.print("");
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