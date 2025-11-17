package hk.edu.polyu.comp.comp2021.clevis.model;

/**
 * Represents a circle shape with a center and radius.
 */
public class Circle extends Shape {
    
    private double centerX, centerY, r;

    /**
     * Constructs a Circle object.
     *
     * @param name     the name of the circle
     * @param centerX  the x-coordinate of the center
     * @param centerY  the y-coordinate of the center
     * @param radius   the radius of the circle
     * @param zOrder   the rendering order
     */
    public Circle(String name, double centerX, double centerY, double radius, int zOrder){
        super(name, zOrder); 
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
    private static final double boundary = 0.05;
    public boolean coverPoint(double px, double py){
        double dist = Math.sqrt(Math.pow(px - centerX, 2) + Math.pow(py - centerY, 2));
        return Math.abs(dist - r) < boundary;
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

    @Override
    public double getX() { 
        return centerX; 
    }

    @Override
    public double getY() { 
        return centerY; 
    }
}   
