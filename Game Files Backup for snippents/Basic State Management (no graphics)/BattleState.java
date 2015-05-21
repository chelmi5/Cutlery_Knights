public class BattleState implements IState
{
   transient StateMachine stateMachine;
   
   public BattleState(StateMachine s)
   {
      this.stateMachine = s;
   }
   
    public void Update()
    {
        // BattleState Update
        System.out.println("Battle State update");
    }
 
    public void Render()
    {
        // BattleState Render
        System.out.println("Battle State Render");
    }
 
    public void OnEnter()
    {
        // BattleState OnEnter
        System.out.println("Batte State Entered");
    }
 
    public void OnExit()
    {
        // BattleState OnExit
        System.out.println("Battle State OnExit");
    }
}