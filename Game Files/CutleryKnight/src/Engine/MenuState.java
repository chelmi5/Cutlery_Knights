package Engine;

//import Objects.Stats;

public class MenuState implements IState{
 
   transient   StateMachine   stateMachine;
   private     String         type;
   private     boolean        change;
   //reference to the party called party
   //reference to inventory called inventory
      
   public MenuState(StateMachine s){
      this.stateMachine = s;
      this.type = "menu";
      this.change = false;
   }

   public void Update(){
     System.out.println("Menu State updated");
     change = true;
   }
 
   public void Render(){
     System.out.print("");
   }
 
   public void OnEnter(){
     System.out.println("Menu State Entered");
   }
 
   public void OnExit(){
      System.out.println("Title State OnExit");
   }
   
   public AGraphics getGraphics(){
      //menuState graphics
      return null;
   }

   public String getType(){
      return this.type;
   }
   
   public boolean getChange(){
      return change;
   }
   
   public void Display(){
      System.out.println("Game Paused");
      
      //party.displayStats();
      //party.displayInvitory();
      //Functional Inventory
         //concrete inventory has 
      
      //To Title Menu (lose all progress)
      // switch to title menu state, like re launching the game
      
      //Save Game
   }
        
}