import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by CountryGeek1 on 4/19/2015.
 */
public class LoadGame {

    public void fileCraller() {

        /* Todo: Optimized this for the Game */

        Scanner kb = new Scanner(System.in);
        ArrayList<String> searchResults = new ArrayList<String>();

        String path = "", name = "", extension = "", content = "", date = "";

        System.out.println("Directory search by path, name, extension, content and date.");

        System.out.print("Enter starting directory for the search (like c:\\temp): ");
        path = kb.nextLine();

        while (path.equals("")) {


            System.out.println();
            System.out.println("You must enter a valid directory.");
            System.out.println();
            System.out.print("Enter starting directory for the search (like c:\\temp): ");
            path = kb.nextLine();

            File checkExistence = new File(path);
            if (!checkExistence.exists())
                path = "";
        }// end while loop



        System.out.print("Enter the file name (like myFile or enter for all): ");
        name = kb.nextLine().toLowerCase();
        System.out.print("Enter the file extension (like txt or enter for all): ");
        extension = kb.nextLine().toLowerCase();
        System.out.print("Enter content to search for (like cscd211 or enter for any): ");
        content = kb.nextLine().toLowerCase();
        System.out.print("Enter last modified date (like 01/01/2013 or enter for any): ");
        date = kb.nextLine();

        System.out.println("\nSearching...\n");

        //String fileName = name + "." + extension;
        search(new File(path), name, extension, content, date, searchResults);

        kb.close();

        // Finish up the program by printing out the results from the ArrayList
        System.out.println("Results - " + searchResults.size() + " entries found:");
        for (int x = 0; x < searchResults.size(); x++)
            System.out.println(searchResults.get(x));


    }// end main

    private static void search(File path, String name, String extension, String content, String date, ArrayList<String> searchResults) {

        if (path.isDirectory()) {
            String[] names = path.list();

            if(names != null)
                for (String folderName : names)
                    search(new File(path + File.separator + folderName), name, extension, content, date, searchResults);// append the folderName to directory
        }
        else {
            boolean addFile = isValid(path.toString(), name, extension, content, date);
            if (addFile)
                searchResults.add(path.toString());
        }
    }

    private static boolean isValid(String filePath, String name, String extension, String content, String date) {

        String[] filePathArray = filePath.split("\\\\");
        String[] file = filePathArray[filePathArray.length-1].split("\\.");
        // in file, file[0] == name and file[1] == extension

        if (!name.equals("")) {

            if (!file[0].equals(name))
                return false;
        }

        if (!extension.equals("")) {
            try {
                if (!file[1].equals(extension))
                    return false;
            } catch (Exception e) {
                return false;
            }
        }// end extension check

        if (!content.equals("")) {

            try {
                Scanner fin = new Scanner(new File(filePath));
                if (content.equals(fin.findWithinHorizon(content, 0))) {
                    fin.close();
                    return true;
                }
                else {
                    fin.close();
                    return false;
                }
            }

            catch (Exception e) {
                return false;
            }
        }// end content check

        if (!date.equals("")) {

            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            try {
                Date formattedDate = sdf.parse(date);
                long milliDateUser = formattedDate.getTime();

                File findDateOfFile = new File(filePath);
                long milliDateDirectory = findDateOfFile.lastModified();

                if (milliDateDirectory >= milliDateUser)
                    return true;
                else
                    return false;
            }
            catch (Exception e) {
                return false;
            }


        }// end date

        return true;
    }// end isValid
}