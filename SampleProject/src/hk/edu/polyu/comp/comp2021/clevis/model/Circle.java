package hk.edu.polyu.comp.comp2021.clevis.model;

public class Circle extends Shape {
    
    private double x, y, r;

    public Circle(String name, double x, double y, double radius){
        super(name); 
        this.x = x; 
        this.y = y;
        this.r = radius;
    }
    
    public void move(double dx, double dy){ 
        x += dx; 
        y += dy; 
    }

    public double[] getBoundingBox(){
        return new double[]{x - r, y - r, 2*r, 2*r};
    }

    public boolean coverPoint(double px, double py){
        double dist = Math.sqrt(Math.pow(px - x, 2) + Math.pow(py - y, 2));
        return Math.abs(dist - r) < 0.05;
    }

    public String describe(){
        return String.format("Circle %s: center=(%.2f,%.2f), r=%.2f", name, x, y, r);
    }
}
