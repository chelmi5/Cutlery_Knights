package temp;

import java.util.*;

public class MainLoop
{
   public static void main(String[] args)
   {
      StateMachine gGameMode = new StateMachine();
    
      // A state for each game mode
      gGameMode.Add("mainmenu",   new MainMenuState(gGameMode));
      gGameMode.Add("localmap",   new LocalMapState(gGameMode));
      gGameMode.Add("worldmap",   new WorldMapState(gGameMode));
      gGameMode.Add("battle",     new BattleState(gGameMode));
      gGameMode.Add("ingamemenu", new InGameMenuState(gGameMode));
       
      gGameMode.Change("mainmenu");
   }
   
   // Main Game Update Loop
   public void Update()
   {
       float elapsedTime = GetElapsedFrameTime();
       gGameMode.Update(elapsedTime);
       gGameMode.Render();
   }
   
}