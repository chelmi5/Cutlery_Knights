package Engine;

public class EmptyState implements IState
{
    transient StateMachine stateMachine;
    private String type;
    private AGraphics graphics;
   
   public EmptyState(StateMachine s)
   {
      this.stateMachine = s;
      this.type = "empty";
   }
   
   public String getType()
   {
      return this.type;
   }
   
    public void Update()
    {
        // Nothing to update in the empty state.
        System.out.println("Empty State update");
    }

    public AGraphics getGraphics()
    {
        return this.graphics;
    }
 
    public void Render()
    {
        // Nothing to render in the empty state
        System.out.println("Empty State render");
        //new GameFrame(this.type);
    }
 
    public void OnEnter()
    {
        // No action to take when the state is entered
        System.out.println("Empty State OnEnter");
    }
 
    public void OnExit()
    {
        // No action to take when the state is exited
        System.out.println("Empty State OnExit");
    }
}