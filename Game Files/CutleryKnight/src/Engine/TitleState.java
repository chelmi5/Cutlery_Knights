package Engine;

public class TitleState implements IState
{
   transient StateMachine stateMachine;
   private String type;
   private AGraphics graphics;
   private boolean change;
      
   public TitleState(StateMachine s)
   {
      this.stateMachine = s;
      this.type = "title";
      this.change = false;
      this.graphics = new TitleGraphics(this);
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
        // TitleState Update
        System.out.println("Title State updated");
        change = true;
    }
 
    public void Render()
    {
        // TitleState Render
        System.out.print("");
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