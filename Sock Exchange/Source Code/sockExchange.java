import java.io.*;
import java.util.*;

public class sockExchange {
    private static int numOfStudents = 80; //Sets the number of students so it could be changed later if needed.

    public static void main(String[] args) throws IOException {
        boolean repeated = true; //Sets repeated to true in order to later run the while loop that suffles the names.
        int x = 0; //The number of words that aren't repeated

        PrintWriter writer = new PrintWriter("namesOUT.txt", "UTF-8"); //Creates Output File

        //Puts each name in the nameIN.dat file into two Arrays.
        String[] names1 = makeList("namesIN.dat"); 
        String[] names2 = makeList("namesIN.dat");

        //Suffles the second array of names without assigning someone to themselves.
        while(repeated == true) { 
            for (int i = 0; i < numOfStudents; i++) {
                //Checks to see if a name is repeated and if it's repeated it will resuffle until it's not repeated.
                if (names1[i].equals(names2[i])) { 
                    Collections.shuffle(Arrays.asList(names2)); //Suffles second array.
                    x = 0; //Sets the number of words that are not repeated to zero.
                }
            }
            for (int i = 0; i < numOfStudents; i++) {
                //Checks to see if every name is different to the one its assigned to.
                if (!(names1[i].equals(names2[i]))) {
                    x++; //Adds one to x
                }
            }
            //If x (number of students that are not repeated) equals the 
            //total number of students (80) then it will set repeated to false.
            if (x == numOfStudents) {
                repeated = false;
            }
        }
        
        //Prints each array side by side.
        //When Array One is printed it will always use 17 spaces for readability.
        for (int i = 0; i < numOfStudents; i++) {
            writer.printf("%-17s - %s\n", names1[i], names2[i]);
        }
        
        //Closes and Saves the file.
        writer.close();
    }
    
    //Takes in a string that tells the method where the input file is, and outputs it into an array.
    public static String[] makeList(String path) throws IOException {
        Scanner f = new Scanner(new File(path)); 
        String[] names = new String[numOfStudents]; //Makes an Array only to be used in this method.
        
        //Puts each line into the array.
        for (int i = 0; i < numOfStudents; i++) {
            String studentName = f.nextLine(); //Sets studentName to the line of text the scanner is on in the file.
            names[i] = studentName; //Sets the index of i in the array to studentName.
        }

        return names; //Returns the completed array
    }
}
