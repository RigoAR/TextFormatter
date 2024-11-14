import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Formatter
{
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("large_file.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }

}
