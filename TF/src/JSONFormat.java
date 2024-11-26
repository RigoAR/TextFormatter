import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JSONFormat implements iFormat {
    @Override
    public void format(ArrayList<String> data) {
        System.out.println("{");
        System.out.println("\"document\": [");
        for (int i = 0; i < data.size(); i++) {
            System.out.println("  { \"line\": \"" + data.get(i) + "\" }" + (i < data.size() - 1 ? "," : ""));
        }
        System.out.println("]");
        System.out.println("}");
    }

    @Override
    public void save(ArrayList<String> data, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("{\n");
            writer.write("\"document\": [\n");
            for (int i = 0; i < data.size(); i++) {
                writer.write("  { \"line\": \"" + data.get(i) + "\" }" + (i < data.size() - 1 ? "," : "") + "\n");
            }
            writer.write("]\n");
            writer.write("}");
            System.out.println("File saved as JSON: " + filename);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
