import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> data = new ArrayList<>();
        data.add("Hello World!");
        data.add("This is a test document.");

        TextFile file = new TextFile(data);

        System.out.println("Select a format to apply:");
        System.out.println("0 - Plain Text");
        System.out.println("1 - HTML");
        System.out.println("2 - Markdown");
        System.out.println("3 - JSON");
        System.out.println("4 - XML");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        switch (option) {
            case 0:
                file.setFormat(new PlainTextFormat());
                break;
            case 1:
                file.setFormat(new HTMLFormat());
                break;
            case 2:
                file.setFormat(new MarkDownFormat());
                break;
            case 3:
                file.setFormat(new JSONFormat());
                break;
            case 4:
                file.setFormat(new XMLFormat());
                break;
            default:
                System.out.println("Invalid option. Defaulting to Plain Text.");
                file.setFormat(new PlainTextFormat());
        }

        file.printFormatted();

        System.out.println("Enter a filename to save:");
        scanner.nextLine();
        String filename = scanner.nextLine();
        file.saveToFile(filename);

        System.out.println("Process complete!");
        scanner.close();
    }
}
