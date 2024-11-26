import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MarkDownFormat implements iFormat {

    @Override
    public void format(ArrayList<String> data) {
        String[] options = {"**", "***", "<sub>", "~~", "_"};
        Random rng = new Random();
        System.out.println("#" + data.get(0));
        for (String line : data) {
            int number = rng.nextInt(options.length);
            String option = options[number];
            System.out.println(option + line + option);
        }
    }

    @Override
    public void save(ArrayList<String> data, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("#" + data.get(0) + "\n");
            String[] options = {"**", "***", "<sub>", "~~", "_"};
            Random rng = new Random();
            for (String line : data) {
                int number = rng.nextInt(options.length);
                String option = options[number];
                writer.write(option + line + option + "\n");
            }
            System.out.println("File saved as Markdown: " + filename);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
