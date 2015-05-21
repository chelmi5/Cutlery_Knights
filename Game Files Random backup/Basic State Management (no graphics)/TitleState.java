public class TitleState implements IState
{
   transient StateMachine stateMachine;
   
   public TitleState(StateMachine s)
   {
      this.stateMachine = s;
   }
   
    public void Update()
    {
        // TitleState Update
        System.out.println("Title State update");
    }
 
    public void Render()
    {
        // TitleState Render
        System.out.println("Title State Render");
    }
 
    public void OnEnter()
    {
        // TitleState OnEnter
        System.out.println("Title State Entered");
    }
 
    public void OnExit()
    {
        // TitleState OnExit
        System.out.println("Title State OnExit");
    }
}