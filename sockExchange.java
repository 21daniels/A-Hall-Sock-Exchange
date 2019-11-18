import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static java.lang.System.*;
import static java.util.Collections.*;

public class sockExchange
{
    private static int numOfStudents = 80; //Sets the number of students so it could be changed later if needed.
    private static boolean repeated = true; //Sets repeated to true in order to later run the while loop that shuffles the names.
    private static PrintWriter writer; //Creates Output File

    static {
        try {
            writer = new PrintWriter("namesOUT.txt", StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException
    {

        //Puts each name in the nameIN.dat file into two Arrays.
        String[] unchangedNames = makeList("namesIN.dat");
        String[] newNames = makeList("namesIN.dat");

        //Shuffles the second array of names without assigning someone to themselves.
        newNames = shuffleList(unchangedNames, newNames);

        //Prints each array side by side.
        printOut(unchangedNames, newNames);
    }

    //Takes in a string that tells the method where the input file is, and outputs it into an array.
    private static String[] makeList(String path) throws IOException
    {
        Scanner f = new Scanner(new File(path));
        String[] names = new String[numOfStudents]; //Makes an Array only to be used in this method.

        //Puts each line into the array.
        for (int i = 0; i < numOfStudents; i++)
        {
            String studentName = f.nextLine(); //Sets studentName to the line of text the scanner is on in the file.
            names[i] = studentName; //Sets the index of i in the array to studentName.
        }

        return names; //Returns the completed array
    }

    private static String[] shuffleList(String[] arr1, String[] arr2)
    {
        int x = 0; //The number of words that aren't repeated

        while(repeated)
        {
            //Checks to see if a name is repeated and if it's repeated it will reshuffle until it's not repeated.
            for (int i = 0; i < numOfStudents; i++)
                if (arr1[i].equals(arr2[i])) {
                    shuffle(Arrays.asList(arr2)); //Shuffles second array.
                    x = 0; //Sets the number of words that are not repeated to zero.
                }

            //Checks to see if every name is different to the one its assigned to.
            for (int i = 0; i < numOfStudents; i++)
                if (!arr1[i].equals(arr2[i])) x++; //Adds one to x

            //If x (number of students that are not repeated) equals the
            //total number of students (80) then it will set repeated to false.
            if (x == numOfStudents)
                repeated = false;
        }
        return arr2;
    }

    private static void printOut(String[] arr1, String[] arr2)
    {
        //When Array One is printed it will always use 17 spaces for readability.
        for (int i = 0; i < numOfStudents; i++) {
            writer.printf("%-17s - %s\n", arr1[i], arr2[i]);
            out.printf("%-17s - %s\n", arr1[i], arr2[i]);
        }

        out.println("\n------------------");
        out.println("-      Done.     -");
        out.println("------------------");

        //Closes and Saves the file.
        writer.close();
    }
}
