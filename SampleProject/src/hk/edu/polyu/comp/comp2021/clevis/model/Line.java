package hk.edu.polyu.comp.comp2021.clevis.model;

public class Line extends Shape {
    
    private double x;
    private double y;
    private double x2;
    private double y2;

    
    public Line(String name, double x, double y, double x2, double y2) {
        super(name);
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
    }
    
    public void move(double dx, double dy){
        x += dx;
        y += dy;
        x2 += dx;
        y2 += dy;
    }

    public double[] getBoundingBox(){
        double minX = Math.min(x, x2);
        double minY = Math.min(y, y2);
        double width = Math.abs(x2 - x);
        double height = Math.abs(y2 -y);
        return new double[]{minX, minY, width, height};
    }

    public boolean coverPoint(double px, double py){
        double dx = x2 - x;
        double dy = y2 -y;
        double length = Math.sqrt(dx*dx + dy*dy);

        double distance = Math.abs((px -x) * dy - (py - y) * dx) / length;

        double dot = (px -x) * dy - (py - y) * dx;
        if(dot < 0){
            return false;
        }

        if(dot > dx * dx + dy * dy){
            return false;
        }
        return true;
    }

    public String describe() {
        return String.format("Line %s: (%.2f,%.2f) -> (%.2f,%.2f)", name, x, y, x2, y2);
    }
    
}
