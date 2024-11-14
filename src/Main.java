import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
        ArrayList<String> data = new ArrayList<>();
        data.add("cneicn ");
        data.add("437492754");
        data.add("df7g6");
        TextFile file= new TextFile(data);
        //file.printPlainText();
        //file.printHTML();
        //file.printMarkDown();
        int option = 0;
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
            default:
                file.setFormat(new PlainTextFormat());

        }
        file.printFormatted();

    }
}