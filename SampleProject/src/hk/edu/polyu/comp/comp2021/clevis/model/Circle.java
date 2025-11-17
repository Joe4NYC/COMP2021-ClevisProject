package hk.edu.polyu.comp.comp2021.clevis.model;

public class Circle extends Shape {
    
    private double centerX;
    private double centerY;
    private double r;

    public Circle(String name, double centerX, double centerY, double radius, int zOrder){
        super(name, zOrder); 
        this.setCenterX(centerX);
        this.setCenterY(centerY);
        this.setR(radius);
    }

    @Override
    public void move(double dx, double dy){ 
        setCenterX(getCenterX() + dx);
        setCenterY(getCenterY() + dy);
    }

    @Override
    public double[] getBoundingBox(){
        return new double[]{getCenterX() - getR(), getCenterY() - getR(), 2* getR(), 2* getR()};
    }
    private static final double boundary = 0.05;

    @Override
    public boolean coverPoint(double px, double py){
        double dist = Math.sqrt(Math.pow(px - getCenterX(), 2) + Math.pow(py - getCenterY(), 2));
        return Math.abs(dist - getR()) < boundary;
    }

    @Override
    public boolean intersect(Shape other) {
        if (other instanceof Circle) {
            Circle c = (Circle) other;
            double distCenters = Math.sqrt(Math.pow(getCenterX() - c.getCenterX(), 2) + Math.pow(getCenterY() - c.getCenterY(), 2));
            return distCenters <= (this.getR() + c.getR());
        } else {
            double[] b1 = this.getBoundingBox();
            double[] b2 = other.getBoundingBox();
            return (b1[0] < b2[0] + b2[2] &&
                    b2[0] < b1[0] + b1[2] &&
                    b1[1] < b2[1] + b2[3] &&
                    b2[1] < b1[1] + b1[3]);
        }
    }

    @Override
    public String describe(){
        return String.format("Circle %s: center=(%.2f,%.2f), r=%.2f", name, getCenterX(), getCenterY(), getR());
    }

    @Override
    public double getX() { 
        return getCenterX();
    }

    @Override
    public double getY() { 
        return getCenterY();
    }

    public double getCenterX() {
        return centerX;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getCenterY() {
        return centerY;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }
}
