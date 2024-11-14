import java.util.ArrayList;

public class HTMLFormat implements iFormat
{
    @Override
    public void format(ArrayList<String> data) {
        System.out.println("<html dir=\"ltr\" lang=\"en\">");
        System.out.println("<head>");
        for(int i = 0; i < data.size(); i++)
        {
            System.out.println("<text=" + data.get(i) + ">");
        }
        System.out.println("</head>");
        System.out.println("</html>");
    }
}
