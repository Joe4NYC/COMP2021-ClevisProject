package hk.edu.polyu.comp.comp2021.clevis.model;

public class Square extends Rectangle {
    
    public Square(String name, double x, double y, double length, int zOrder) {
        super(name, x, y, length, length, zOrder);
    }
    
    public String describe() {
        return String.format("Square %s: topLeft=(%.2f,%.2f), side=%.2f", name, getBoundingBox()[0], getBoundingBox()[1], getBoundingBox()[2]);
    }
}
