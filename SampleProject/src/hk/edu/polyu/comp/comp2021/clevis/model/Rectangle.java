package hk.edu.polyu.comp.comp2021.clevis.model;

public class Rectangle extends Shape {
    
    private double x;
    private double y;
    private double width;
    private double height;
    
    public Rectangle(String name, double x, double y, double width, double height) {
        super(name);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public double[] getBoundingBox() {
        return new double[]{x, y, width, height};
    }
    
    public void move(double dx, double dy) {
        x += dx; 
        y += dy;
    }
    
    public boolean coverPoint(double px, double py) {
        return (px >= x && px <= x + width && py >= y && py <= y + height);
    }

    public boolean intersect(Shape other) {
        double[] b1 = this.getBoundingBox();
        double[] b2 = other.getBoundingBox();
        return (b1[0] < b2[0] + b2[2] &&
                b2[0] < b1[0] + b1[2] &&
                b1[1] < b2[1] + b2[3] &&
                b2[1] < b1[1] + b1[3]);
    }

    public String describe() {
        return String.format("Rectangle %s: topLeft=(%.2f,%.2f), w=%.2f, h=%.2f", name, x, y, width, height);
    }
    
    public double getWidth() {
        return width;
    }
    
    public double getHeight() {
        return height;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }
}
