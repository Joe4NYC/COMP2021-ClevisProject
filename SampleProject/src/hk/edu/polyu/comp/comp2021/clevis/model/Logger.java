package hk.edu.polyu.comp.comp2021.clevis.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    
    private static int count = 0;
    private static PrintWriter txt;
    private static PrintWriter html;
    
    public Logger(String htmlPath, String txtPath) throws IOException {
        txt = new PrintWriter(new FileWriter(txtPath, false));
        html = new PrintWriter(new FileWriter(htmlPath, false));
        html.println("<!DOCTYPE html>");
        html.println("<html><head><meta charset=\"UTF-8\">");
        html.println("<title>Clevis Log</title></head><body>");
        html.println("<h2>Clevis Operation Log</h2>");
        html.println("<table border=\"1\">");
        html.println("<tr><th>No.</th><th>Command</th></tr>");
        html.flush();
    }

    public static void log(String command) {
        count++;
        txt.println(command);
        html.println("<tr><td>" + count + "</td><td>" + command.replace("<", "&lt;").replace(">", "&gt;") + "</td></tr>");
        txt.flush();
        html.flush();
    }
    
    public void close() {
        html.println("</table></body></html>");
        txt.close();
        html.close();
    }
}
