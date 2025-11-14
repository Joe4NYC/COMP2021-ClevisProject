package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.model.*;
import hk.edu.polyu.comp.comp2021.clevis.model.Logger;
import java.io.IOException;

public class Clevis {

    private ShapeManager shapeManager;
    private Logger logger;

    public Clevis(){
        this.shapeManager = new ShapeManager();
        this.logger = null;
    }
    
    public Clevis(String htmlLogPath, String txtLogPath) throws IOException {
        this.shapeManager = new ShapeManager();
        this.logger = new Logger(htmlLogPath, txtLogPath);
    }
    
    public void rectangle(String name, double x, double y, double w, double h) {
        try {
            Rectangle rect = new Rectangle(name, x, y, h, h);
            if (logger != null) {
                logger.log(" rectangle " + name + " " + x + " " + y + " " + w + " " + h);
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
    }
    
    public void line(String name, double x1, double y1, double x2, double y2) {
        try {
            Line line = new Line(name, x1, y1, x2, y2);
            if (logger != null) {
                logger.log("line " + name + " " + x1 + " " + y1 + " " + x2 + " " + y2);
            }
            
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public void circle(String name, double x, double y, double r) {
        try {
            Circle circle = new Circle(name, x, y, r);
            if (logger != null) {
                logger.log("circle " + name + " " + x + " " + y + " " + r);
            }
            
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public void square(String name, double x, double y, double l) {
        try {
            Square square = new Square(name, x, y, l);
            if (logger != null) {
                logger.log("square " + name + " " + x + " " + y + " " + l);
            }
            
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public void group(String groupName, String... shapeNames) {
        try {
            shapeManager.group(groupName, shapeNames);
            if (logger != null) {
                StringBuilder cmd = new StringBuilder("group " + groupName);
                for (String shapeName : shapeNames) {
                    cmd.append(" ").append(shapeName);
                }
                logger.log(cmd.toString());
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public void ungroup(String groupName) {
        try {
            shapeManager.ungroup(groupName);
            if (logger != null) {
                logger.log("ungroup " + groupName);
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
public void delete(String name) {
    try {
        shapeManager.delete(name);
        if (logger != null) {
            logger.log("delete " + name);
        }
    } catch (IllegalArgumentException e) {
        System.err.println("Error: " + e.getMessage());
    }
}
    
    public void boundingbox(String name) {
        Shape s = shapeManager.get(name);
        if(s != null){
            double[] b = s.getBoundingBox();
            System.out.printf("%.2f %.2f %.2f %.2f%n", b[0], b[1], b[2], b[3]);
        }
        logger.log("boundingbox " + name);
    }
    
    public void move(String name, double dx, double dy) {
        Shape s = shapeManager.get(name);
        if(s != null){
            s.move(dx, dy);
        }
        logger.log("move " + name + " " + dx + " " + dy);
    }
    
    public void shapeAt(double x, double y) {
        Shape s = shapeManager.shapeAt(x, y);
    }
    
    public void intersect(String n1, String n2) {

    }
    
    public void list(String name) {

    }
    
    public void listAll() {

    }
    
    public void quit() {

    }
    
    // BON2: 撤銷操作
    public void undo() {

    }
    
    // BON2: 重做操作
    public void redo() {

    }
    
    public ShapeManager getShapeManager() {
        return shapeManager;
    }
    
    public Logger getLogger() {
        return logger;
    }
}
