import java.io.*;
import java.util.*;

public class sockExchange {
    private static int numOfStudents = 80;

    public static void main(String[] args) throws IOException {
        boolean repeated = true;
        int x = 0;

        PrintWriter writer = new PrintWriter("namesOUT.txt", "UTF-8");

        String[] names1 = makeList("namesIN.dat");
        String[] names2 = makeList("namesIN.dat");

        while(repeated == true) {
            for (int i = 0; i < numOfStudents; i++) {
                if (names1[i].equals(names2[i])) {
                    Collections.shuffle(Arrays.asList(names2));
                }
            }
            for (int i = 0; i < numOfStudents; i++) {
                if (!(names1[i].equals(names2[i]))) {
                    x++;
                }
            }
            if (x == 80) {
                repeated = false;
            }
        }

        for (int i = 0; i < numOfStudents; i++) {
            writer.printf("%-17s - %s\n", names1[i], names2[i]);
        }

        writer.close();
    }

    public static String[] makeList(String path) throws IOException {
        Scanner f = new Scanner(new File(path));
        String[] names = new String[numOfStudents];

        for (int i = 0; i < numOfStudents; i++) {
            String studentName = f.nextLine();

            names[i] = studentName;
        }

        return names;
    }
}