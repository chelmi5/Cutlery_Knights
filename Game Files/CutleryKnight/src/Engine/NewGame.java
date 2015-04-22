package Engine;

import Characters.*;

import java.util.Scanner;

/**
 * Created by CountryGeek1 on 4/16/2015.
 */
public class NewGame {
    int mChoice  = 0;
    public void chooseCharacter() {

        GameCharacter GamePartyArray[] = new GameCharacter[3];

        System.out.println("\n**********************");
        System.out.println("Choose your party of 3.");
        System.out.println("**********************\n");
        Scanner kb = new Scanner(System.in);
        for (int index = 0; index < 3; index++)
        {
            System.out.println("Choose a Chef.");
            System.out.println("1. Fish Chef");
            System.out.println("2. Pastry Chef");
            System.out.println("3. Saute Chef");
            System.out.println("4. Veggie Chef");
            System.out.println("5. Roast Chef");
            System.out.print("Please Enter a Choice: ");
            if (kb.hasNextInt()) {
                mChoice = kb.nextInt();
                if (mChoice < 1 || mChoice > 5) {
                    mChoice = 0;
                }
            }
            loadCharacter(mChoice, index, GamePartyArray);
        }
        printParty(GamePartyArray);
    }

    private void printParty(GameCharacter[] gamePartyArray) {
        for(int i = 0; i < gamePartyArray.length; i++) {
            gamePartyArray[i].displayStats();
        }
    }

    private void loadCharacter(int choice, int index, GameCharacter[] gamePartyArray) {
        if(choice == 1) gamePartyArray[index] = new FishChef();
        if(choice == 2) gamePartyArray[index] = new PastryChef();
        if(choice == 3) gamePartyArray[index] = new SauteChef();
        if(choice == 4) gamePartyArray[index] = new VeggieChef();
        if(choice == 5) gamePartyArray[index] = new RoastChef();
    }
}