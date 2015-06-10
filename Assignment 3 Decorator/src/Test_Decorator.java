/**
 * Chelsea Davis, CSCD 349, Assignment 3, Decorator
 */
import java.util.Scanner;

public class Test_Decorator
{
    public static void main(String[] args)
    {
        System.out.println();

        Tree mytree = new BlueSpruce(); //Just to initialize tree

        Scanner fin = new Scanner(System.in);

        /////// Choose tree ///////

        boolean treeChosen = false;
        boolean decorationsChosen = false;
        int option;

        while (!treeChosen)
        {
            System.out.println("Choose your tree: ");
            System.out.println("1: Fraser Fir");
            System.out.println("2: Douglas Fir");
            System.out.println("3: Balsam Fir");
            System.out.println("4: Colorado Blue Spruce");
            option = fin.nextInt();

            if(option == 1)
            {
                mytree = new FraserFir();
                treeChosen = true;
            }
            else if(option == 2)
            {
                mytree = new DouglasFir();
                treeChosen = true;
            }
            else if (option == 3)
            {
                mytree = new BalsamFir();
                treeChosen = true;
            }
            else if(option == 4)
            {
                mytree = new BlueSpruce();
                treeChosen = true;
            }
            else //option < 1 || option > 4
            {
                System.out.println("Must choose from given selection. ");
            }

        }//end while

        //System.out.println("Selected " + mytree.getDescription() );

        //////// Choose Decorations //////////

        while (!decorationsChosen)
        {
            System.out.println("Choose your decorations: ");
            System.out.println("1: Star");
            System.out.println("2: Ruffles");
            System.out.println("3: Red Balls");
            System.out.println("4: Silver Balls");
            System.out.println("5: Blue Balls");
            System.out.println("6: Ribbons");
            System.out.println("7: Lights");
            System.out.println("8: LEDs");
            System.out.println("9: Finish");

            option = fin.nextInt();

            if (option == 1)
            { mytree = Star.getUniqueInstance(mytree);}
            else if (option == 2)
            { mytree = new Ruffles(mytree);}
            else if (option == 3)
            { mytree = new BallsRed(mytree);}
            else if (option == 4)
            { mytree = new BallsSilver(mytree);}
            else if (option == 5)
            { mytree = new BallsBlue(mytree);}
            else if (option == 6)
            { mytree = new Ribbons(mytree);}
            else if (option == 7)
            { mytree = new Lights(mytree);}
            else if (option == 8)
            { mytree = new LEDs(mytree);}
            else if (option == 9)
            { /*quit*/ decorationsChosen = true;}
            else //option < 1 || option > 9
            { System.out.println("Must choose from given selection. ");}

        }//end while

        /////// Resulting Tree //////////

        System.out.println("Final Tree: " + mytree.getDescription());
        System.out.println("Total Price: $" + mytree.cost());

    }//end main
}//end class
