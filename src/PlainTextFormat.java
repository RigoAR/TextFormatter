import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PlainTextFormat implements iFormat {

    @Override
    public void format(ArrayList<String> data) {
        for (String line : data) {
            System.out.println(line);
        }
    }

    @Override
    public void save(ArrayList<String> data, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (String line : data) {
                writer.write(line + System.lineSeparator());
            }
            System.out.println("File saved as PlainText: " + filename);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
