package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.model.*;
import java.util.*;

public class Clevis {

    private ShapeManager shapeManager;
    private Logger logger;
    private int operationCounter;

    public Clevis(){
        this.shapeManager = new ShapeManager();
        this.logger = null;
        this.operationCounter = 0;
    }
    
    public Clevis(String htmlLogPath, String txtLogPath) {
        this.shapeManager = new ShapeManager();
        this.logger = new Logger(htmlLogPath, txtLogPath);
        this.operationCounter = 0;
    }
    
    public void rectangle(String name, double x, double y, double w, double h) {
        try {
            Rectangle rect = new Rectangle(name, x, y, h, h);
            if (logger != null) {
                operationCounter ++;
                logger.logCommand(operationCounter, "rectangle " + name + " " + x + " " + y + " " + w + " " + h);
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
    }
    
    public void line(String name, double x1, double y1, double x2, double y2) {
        try {
            Line line = new Line(name, x1, y1, x2, y2);
            if (logger != null) {
                operationCounter ++;
                logger.logCommand(operationCounter, "line " + name + " " + x1 + " " + y1 + " " + x2 + " " + y2);
            }
            
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public void circle(String name, double x, double y, double r) {
        try {
            Circle circle = new Circle(name, x, y, r);
            if (logger != null) {
                operationCounter ++;
                logger.logCommand(operationCounter,"circle " + name + " " + x + " " + y + " " + r);
            }
            
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public void square(String name, double x, double y, double l) {
        try {
            Square square = new Square(name, x, y, l);
            if (logger != null) {
                operationCounter ++;
                logger.logCommand(operationCounter,"square " + name + " " + x + " " + y + " " + l);
            }
            
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public void group(String groupName, String... shapeNames) {
        try {
            List<String> nameList = Arrays.asList(shapeNames);
            shapeManager.group(groupName, nameList);

            if (logger != null) {
                operationCounter ++;
                StringBuilder cmd = new StringBuilder("gourp " + groupName);
                for (String shapeName : shapeNames) {
                    cmd.append(" ").append(shapeName);
                }
                logger.logCommand(operationCounter, cmd.toString());
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public void ungroup(String groupName) {
        try {
            shapeManager.ungroupShapes(groupName);
            if (logger != null) {
                logger.logCommand(operationCounter, "ungroup " + groupName);
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public void delete(String name) {
        
    }
    
    public void boundingbox(String name) {
        
    }
    
    public void move(String name, double dx, double dy) {

    }
    
    public void shapeAt(double x, double y) {

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
