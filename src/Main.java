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
                file.printPlainText();
                break;

            case 1:
                file.printHTML();
                break;

            case 2:
                file.printMarkDown();
                break;
            default:
                file.printPlainText();

        }

    }
}