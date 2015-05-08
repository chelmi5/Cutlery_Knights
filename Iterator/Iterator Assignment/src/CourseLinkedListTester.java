import java.util.Collection;
import java.util.Scanner;

/**
 * Created by CountryGeek1 on 5/7/2015.
 */
public class CourseLinkedListTester {
    public static void main(String[] args)
    {

        Scanner kb = new Scanner (System.in);
        Course myList = new Course();
        int choice = 0;

        System.out.println("-------------------------");
        System.out.println();

        myList = NewLinkList(kb);

        do
        {
            choice = menu(kb);
            myList = executeChoice(choice, myList);
        }while (choice != 24);
        kb.close();
    }

    public static Course NewLinkList(Scanner kb)
    {
        int num = -1;
        String myString = "";
        do {
            System.out.print("How big do you want your Link List to be? : ");
            if(kb.hasNextInt())
            {
                num = kb.nextInt();
            }
            else
            {
                kb.next();
            }
        } while (num < -1 || num == -1);

        kb.nextLine();
        Course myList = new Course();
        for (int i = 0; i < num; i++)
        {
            System.out.print("Enter your String: ");
            myString = kb.nextLine();
            myList.add(myString);
            myString = "";
        }
        printList(myList);

        return myList;
    }

    public static void printList(Object myList) {
        System.out.println();
        System.out.println("Your list is as follows");
        System.out.println(myList);
    }

    public static Course executeChoice(int num, Course myList)
    {
        Scanner kb = new Scanner(System.in);

        if (num == 1)
        {
            myList.removeAll( myList);
            myList = NewLinkList(kb);
        }
        else if(num == 2)
        {
            String newItem = "";
            while(newItem.equals("")) {
                System.out.print("What would you like to add to the front: ");
                if(kb.hasNextLine()) {
                    newItem = kb.nextLine();
                }
            }
            myList.addFirst(newItem);
            printList(myList);
        }
        else if(num == 3)
        {
            System.out.println(myList);
        }
        else if(num == 4) {
            int i = askUser(kb);
            System.out.print("What do you want to add? (String) ");
            String str = kb.nextLine();
            myList.add(i, str);
            printList(myList);
        }

        else
            System.out.println();

        return myList;

    }

    public static int askUser(Scanner kb) {
        int i = -1;
        while(i < 0) {
            System.out.print("What index would you like for the operation? (by index) ");
            if(kb.hasNextInt()){
                i = kb.nextInt();
            }
            kb.nextLine();
        }
        return i;
    }

    public static int menu(Scanner kb)
    {
        System.out.println("1. Create a new list");
        System.out.println("2. Add an new item to the beginning of the list");
        System.out.println("3. Print the linked List");
        System.out.println("4. Inset a mew item?");
        System.out.println("5. Quit");

        int num = 0;
        do {
            System.out.print("Which choice would you like? (1-) : ");
            if(kb.hasNextInt())
            {
                num = kb.nextInt();
            }
            else
            {
                kb.next();
            }
        } while (num < 1);

        return num;
    }
}
