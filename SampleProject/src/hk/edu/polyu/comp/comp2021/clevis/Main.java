import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

    public static void CreateLog(String[] args) {
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
        try {
            FileWriter RectangleWriter = new FileWriter("log.txt", true);
            RectangleWriter.write("rectangle," + n + ",x:" + RoundTo2Decimal.format(x) + ",y:" + RoundTo2Decimal.format(y) + ",w:" + RoundTo2Decimal.format(w) + ",h:" + RoundTo2Decimal.format(h) + "\n");
            RectangleWriter.close();
        } catch (IOException e) {
            System.out.println("Error at saving rectangle data");
            e.printStackTrace();
        }
    }

    public static void line(String n, double x1, double y1, double x2, double y2) {
        DecimalFormat RoundTo2Decimal = new DecimalFormat("#.##");
        try {
            FileWriter LineWriter = new FileWriter("log.txt", true);
            LineWriter.write("line," + n + ",x1:" + RoundTo2Decimal.format(x1) + ",y1:" + RoundTo2Decimal.format(y1) + ",x2:" + RoundTo2Decimal.format(x2) + ",y2:" + RoundTo2Decimal.format(y2) + "\n");
            LineWriter.close();
        } catch (IOException e) {
            System.out.println("Error at saving line data");
            e.printStackTrace();
        }
    }

    public static void circle(String n, double x, double y, double r) {
        DecimalFormat RoundTo2Decimal = new DecimalFormat("#.##");
        try {
            FileWriter CircleWriter = new FileWriter("log.txt", true);
            CircleWriter.write("circle," + n + ",x:" + RoundTo2Decimal.format(x) + ",y:" + RoundTo2Decimal.format(y) + ",r:" + RoundTo2Decimal.format(r) + "\n");
            CircleWriter.close();
        } catch (IOException e) {
            System.out.println("Error at saving circle data");
            e.printStackTrace();
        }
    }

    public static void square(String n, double x, double y, double l) {
        DecimalFormat RoundTo2Decimal = new DecimalFormat("#.##");
        try {
            FileWriter SquareWriter = new FileWriter("log.txt", true);
            SquareWriter.write("square," + n + ",x:" + RoundTo2Decimal.format(x) + ",y:" + RoundTo2Decimal.format(y) + ",l:" + RoundTo2Decimal.format(l) + "\n");
            SquareWriter.close();
        } catch (IOException e) {
            System.out.println("Error at saving square data");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CreateLog(args);
        rectangle("Rect_1", 10.0, 20.0, 30.0, 40.0);
        line("Line_1", 0.0, 0.0, 100.0, 100.0);
        circle("Cir_1", 50.00, 50.0, 25.0);
        square("Sqr_1", 15.00, 15.0, 20.0);
    }
