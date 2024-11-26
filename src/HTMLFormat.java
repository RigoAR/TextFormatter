import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class HTMLFormat implements iFormat {

    @Override
    public void format(ArrayList<String> data) {
        System.out.println("<html dir=\"ltr\" lang=\"en\">");
        System.out.println("<head>");
        for (String line : data) {
            System.out.println("<text=" + line + ">");
        }
        System.out.println("</head>");
        System.out.println("</html>");
    }

    @Override
    public void save(ArrayList<String> data, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("<html dir=\"ltr\" lang=\"en\">\n");
            writer.write("<head>\n");
            for (String line : data) {
                writer.write("<text=" + line + ">\n");
            }
            writer.write("</head>\n");
            writer.write("</html>");
            System.out.println("File saved as HTML: " + filename);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
