package Engine;

public class TitleState implements IState
{
   transient StateMachine stateMachine;
   private String type;
   private AGraphics graphics;
      
   public TitleState(StateMachine s)
   {
      this.stateMachine = s;
      this.type = "title";
      this.graphics = new TitleGraphics();
   }
   
   public String getType()
   {
      return this.type;
   }
   
   public AGraphics getGraphics()
   {
      return this.graphics;
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
        //new GameFrame(this.type);
    }
 
    public void OnEnter()
    {
        // TitleState OnEnter
        System.out.println("Title State Entered");
        //this.Render();
    }
 
    public void OnExit()
    {
        // TitleState OnExit
        System.out.println("Title State OnExit");
    }
        
}