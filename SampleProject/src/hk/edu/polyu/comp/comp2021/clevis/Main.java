import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
public class Main {
    public static int c=0;

    public static void CreateLogHTML() {
        try {
            FileWriter LogWriter = new FileWriter("log.html");
            LogWriter.write("<!DOCTYPE html>\n");
            LogWriter.write("<html>\n");
            LogWriter.write("<head>\n");
            LogWriter.write("</head>\n");
            LogWriter.write("<body>\n");
            LogWriter.write("</body>\n");
            LogWriter.write("</html>");
            LogWriter.close();
        } catch (IOException e) {
            System.out.println("Error at creating log.html");
            e.printStackTrace();
        }
    }

    public static void CreateLogTXT(String[] args) {
        try {
            FileWriter LogWriter = new FileWriter("log.txt");
            LogWriter.close();
        } catch (IOException e) {
            System.out.println("Error at creating log.txt");
            e.printStackTrace();
        }
    }

    public static void rectangle(String n, double x, double y, double w, double h) {
        DecimalFormat RoundTo2Decimal = new DecimalFormat("#.##");
        c=c+1;
        String col2 = "rectangle("+n+","+x+","+y+","+w+","+h+")";
        try {
            FileWriter RectangleWriter = new FileWriter("log.txt", true);
            RectangleWriter.write("rectangle," + n + ",x:" + RoundTo2Decimal.format(x) + ",y:" + RoundTo2Decimal.format(y) + ",w:" + RoundTo2Decimal.format(w) + ",h:" + RoundTo2Decimal.format(h) + "\n");
            RectangleWriter.close();
            WriteToHTML(Integer.toString(c),col2);
        } catch (IOException e) {
            System.out.println("Error at saving rectangle data");
            e.printStackTrace();
        }
    }

    public static void line(String n, double x1, double y1, double x2, double y2) {
        DecimalFormat RoundTo2Decimal = new DecimalFormat("#.##");
        c=c+1;
        String col2 = "line("+n+","+x1+","+y1+","+x2+","+y2+")";
        try {
            FileWriter LineWriter = new FileWriter("log.txt", true);
            LineWriter.write("line," + n + ",x1:" + RoundTo2Decimal.format(x1) + ",y1:" + RoundTo2Decimal.format(y1) + ",x2:" + RoundTo2Decimal.format(x2) + ",y2:" + RoundTo2Decimal.format(y2) + "\n");
            LineWriter.close();
            WriteToHTML(Integer.toString(c),col2);
        } catch (IOException e) {
            System.out.println("Error at saving line data");
            e.printStackTrace();
        }
    }

    public static void circle(String n, double x, double y, double r) {
        DecimalFormat RoundTo2Decimal = new DecimalFormat("#.##");
        c=c+1;
        String col2 = "circle("+n+","+x+","+y+","+r+")";
        try {
            FileWriter CircleWriter = new FileWriter("log.txt", true);
            CircleWriter.write("circle," + n + ",x:" + RoundTo2Decimal.format(x) + ",y:" + RoundTo2Decimal.format(y) + ",r:" + RoundTo2Decimal.format(r) + "\n");
            CircleWriter.close();
            WriteToHTML(Integer.toString(c),col2);
        } catch (IOException e) {
            System.out.println("Error at saving circle data");
            e.printStackTrace();
        }
    }

    public static void square(String n, double x, double y, double l) {
        DecimalFormat RoundTo2Decimal = new DecimalFormat("#.##");
        c=c+1;
        String col2 = "square("+n+","+x+","+y+","+l+")";
        try {
            FileWriter SquareWriter = new FileWriter("log.txt", true);
            SquareWriter.write("square," + n + ",x:" + RoundTo2Decimal.format(x) + ",y:" + RoundTo2Decimal.format(y) + ",l:" + RoundTo2Decimal.format(l) + "\n");
            SquareWriter.close();
            WriteToHTML(Integer.toString(c),col2);
        } catch (IOException e) {
            System.out.println("Error at saving square data");
            e.printStackTrace();
        }
    }

    public static void WriteToHTML(String col1, String col2) {
        try {
            FileReader reader = new FileReader("log.html");
            StringBuilder content = new StringBuilder();
            int ch;
            while ((ch = reader.read()) != -1) {
                content.append((char) ch);
            }
            reader.close();
            String table = "<table border=\"1\">\n" +
                    "  <tr>\n" +
                    "    <td>" + col1 + "</td>\n" +
                    "    <td>" + col2 + "</td>\n" +
                    "  </tr>\n" +
                    "</table>\n";

            int bodyCloseIndex = content.indexOf("</body>");
            if (bodyCloseIndex == -1) {
                System.out.println("No </body> tag found in log.html");
                return;
            }
            content.insert(bodyCloseIndex, table);
            FileWriter writer = new FileWriter("log.html");
            writer.write(content.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println("Error at appending table to log.html");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CreateLogHTML();
        CreateLogTXT(args);
        rectangle("Rect_1", 10.0, 20.0, 30.0, 40.0);
        line("Line_1", 0.0, 0.0, 100.0, 100.0);
        circle("Cir_1", 50.00, 50.0, 25.0);
        square("Sqr_1", 15.00, 15.0, 20.0);
    }
}