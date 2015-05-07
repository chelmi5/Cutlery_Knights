package Engine;

import java.util.Scanner;

public class GameMenu {

    private int mChoice = 0;

    public void displayMenu() {
        Scanner kb = new Scanner(System.in);
        while(mChoice == 0) {
            System.out.println("-----------------");
            System.out.println("| 1. New Game   |");
            System.out.println("| 2. Load Game  |");
            System.out.println("| 3. Exit       |");
            System.out.println("-----------------");
            System.out.print("Please Enter a Choice: ");
           if (kb.hasNextInt()) {
               mChoice = kb.nextInt();
               if (mChoice < 1 || mChoice > 3) {
                   mChoice = 0;
               }
           }
        }
        executeChoice();
    } // End of displayMenu Method

    public void executeChoice() {
        if(mChoice == 3) {
            System.exit(0);
        }
        else if(mChoice == 2) {
            loadGame();
        }
        else if(mChoice == 1) {
            startNewGame();
        }
        else {
            System.out.println("Program cannot brain today it haz the Dumbz");
            System.exit(1);
        }
    } // End of execute choice
    
    public void startNewGame() {
        NewGame game = new NewGame();
        game.chooseCharacter();

        //play state here
    }

    private void loadGame() {
        LoadGame game = new LoadGame();
        game.fileCraller();
    }
}
