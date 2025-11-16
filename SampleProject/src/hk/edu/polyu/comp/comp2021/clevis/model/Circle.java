package hk.edu.polyu.comp.comp2021.clevis.model;

public class Circle extends Shape {
    
    private double centerX, centerY, r;

    public Circle(String name, double centerX, double centerY, double radius){
        super(name); 
        this.centerX = centerX; 
        this.centerY = centerY;
        this.r = radius;
    }
    
    public void move(double dx, double dy){ 
        centerX += dx; 
        centerY += dy; 
    }

    public double[] getBoundingBox(){
        return new double[]{centerX - r, centerY - r, 2*r, 2*r};
    }

    public boolean coverPoint(double px, double py){
        double dist = Math.sqrt(Math.pow(px - centerX, 2) + Math.pow(py - centerY, 2));
        return Math.abs(dist - r) < 0.05;
    }

    public boolean intersect(Shape other) {
        if (other instanceof Circle) {
            Circle c = (Circle) other;
            double distCenters = Math.sqrt(Math.pow(centerX - c.centerX, 2) + Math.pow(centerY - c.centerY, 2));
            return distCenters <= (this.r + c.r);
        } else {
            double[] b1 = this.getBoundingBox();
            double[] b2 = other.getBoundingBox();
            return (b1[0] < b2[0] + b2[2] &&
                    b2[0] < b1[0] + b1[2] &&
                    b1[1] < b2[1] + b2[3] &&
                    b2[1] < b1[1] + b1[3]);
        }
    }

    public String describe(){
        return String.format("Circle %s: center=(%.2f,%.2f), r=%.2f", name, centerX, centerY, r);
    }
}
