import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class XMLFormat implements iFormat {
    @Override
    public void format(ArrayList<String> data) {
        System.out.println("<document>");
        for (String line : data) {
            System.out.println("  <line>" + line + "</line>");
        }
        System.out.println("</document>");
    }

    @Override
    public void save(ArrayList<String> data, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("<document>\n");
            for (String line : data) {
                writer.write("  <line>" + line + "</line>\n");
            }
            writer.write("</document>");
            System.out.println("File saved as XML: " + filename);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}

