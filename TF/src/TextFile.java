import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class TextFile {
    private ArrayList<String> fileContent;
    private iFormat format;

    public TextFile() {
        fileContent = new ArrayList<>();
    }

    public TextFile(ArrayList<String> data) {
        fileContent = data;
    }


    public void setFormat(iFormat format) {
        this.format = format;
    }


    public void printFormatted() {
        format.format(fileContent);
    }


    public void saveToFile(String filename) {
        format.save(fileContent, filename);
    }


    public void printPlainText() {
        for (String line : fileContent) {
            System.out.println(line);
        }
    }

    public void printHTML() {
        System.out.println("<html dir=\"ltr\" lang=\"en\">");
        System.out.println("<head>");
        for (String line : fileContent) {
            System.out.println("<text=" + line + ">");
        }
        System.out.println("</head>");
        System.out.println("</html>");
    }

    public void printMarkDown() {
        String[] options = {"**", "***", "<sub>", "~~", "_"};
        Random rng = new Random();
        System.out.println("#" + fileContent.get(0));
        for (String line : fileContent) {
            int number = rng.nextInt(options.length);
            String option = options[number];
            System.out.println(option + line + option);
        }
    }
}
