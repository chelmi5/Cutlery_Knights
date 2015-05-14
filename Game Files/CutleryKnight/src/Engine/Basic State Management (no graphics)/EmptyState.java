public class EmptyState implements IState
{
   transient StateMachine stateMachine;
   
   public EmptyState(StateMachine s)
   {
      this.stateMachine = s;
   }
   
    public void Update()
    {
        // Nothing to update in the empty state.
        System.out.println("Empty State update");
    }
 
    public void Render()
    {
        // Nothing to render in the empty state
        System.out.println("Empty State render");
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