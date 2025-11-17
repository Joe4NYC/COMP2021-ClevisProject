package hk.edu.polyu.comp.comp2021.clevis.model;

public class Line extends Shape {
    
    private double x;
    private double y;
    private double x2;
    private double y2;

    
    public Line(String name, double x, double y, double x2, double y2, int zOrder) {
        super(name, zOrder);
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
        double dy = y2 - y;
        double length = Math.sqrt(dx*dx + dy*dy);

        double distance = Math.abs((px - x) * dy - (py - y) * dx) / length;

        double dot = (px - x) * dx + (py - y) * dy;
        if (dot < 0 || dot > dx*dx + dy*dy) {
            return false;
        }

        return distance < 0.05;
    }

    public boolean intersect(Shape other) {
        if (other instanceof Line) {
            Line line2 = (Line) other;

            double d1 = (line2.x - x) * (y2 - y) - (line2.y - y) * (x2 - x);
            double d2 = (line2.x2 - x) * (y2 - y) - (line2.y2 - y) * (x2 - x);
            double d3 = (x - line2.x) * (line2.y2 - line2.y) - (y - line2.y) * (line2.x2 - line2.x);
            double d4 = (x2 - line2.x) * (line2.y2 - line2.y) - (y2 - line2.y) * (line2.x2 - line2.x);

            return (d1 * d2 < 0) && (d3 * d4 < 0);
        } else {
            double[] b1 = this.getBoundingBox();
            double[] b2 = other.getBoundingBox();
            return (b1[0] < b2[0] + b2[2] &&
                    b2[0] < b1[0] + b1[2] &&
                    b1[1] < b2[1] + b2[3] &&
                    b2[1] < b1[1] + b1[3]);
        }
    }

        public String describe() {
            return String.format("Line %s: (%.2f,%.2f) -> (%.2f,%.2f)", name, x, y, x2, y2);
        }
        
    public double getX() {
        return Math.min(x, x2);
    }
    public double getY() {
        return Math.min(y, y2);
    }
    
    public double getX1() { return x; }
    public double getY1() { return y; }
    public double getX2() { return x2; }
    public double getY2() { return y2; }
}
