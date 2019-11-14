import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import static java.lang.System.*;

public class sockExchange
{
    public static void main(String[] args) throws IOException {
        int numOfStudents = 80;

        PrintWriter writer = new PrintWriter("names.txt", "UTF-8");

        for (int x = 0; x < 2; x++) {
            Scanner f = new Scanner(new File("students.dat"));
            Integer[] arr = new Integer[numOfStudents];
            String[] names = new String[numOfStudents];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
            Collections.shuffle(Arrays.asList(arr));

            for (int i = 0; i < numOfStudents; i++) {
                String studentName = f.nextLine();
                String studentNumber = arr[i].toString();
                names[arr[i]] = studentName;
            }

            for (int i = 0; i < numOfStudents; i++) {

                writer.println(names[i] + "  -  " + names[++i]);
            }
            writer.close();
        }
    }
}
