package Engine;

public class BattleState implements IState
{
   transient StateMachine stateMachine;
   private String type;
   
   public BattleState(StateMachine s)
   {
      this.stateMachine = s;
      this.type = "battle";
   }
   
   public String getType()
   {
      return this.type;
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
        //new GameFrame(this.type);
    }
 
    public void OnEnter()
    {
        // BattleState OnEnter
        System.out.println("Batte State Entered");
        //this.Render();
    }
 
    public void OnExit()
    {
        // BattleState OnExit
        System.out.println("Battle State OnExit");
    }
}