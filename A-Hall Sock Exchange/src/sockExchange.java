import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class sockExchange
{
    public static void main(String[] args) implements IOException
    {
        Scanner f = new Scanner(new File("src/students.dat"));

        while(f.hasNextLine())
        {
            out.println(f.nextLine());
        }
    }
}
