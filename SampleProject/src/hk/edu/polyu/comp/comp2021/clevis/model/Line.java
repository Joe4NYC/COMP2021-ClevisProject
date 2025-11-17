package hk.edu.polyu.comp.comp2021.clevis.model;

public class Line extends Shape {
    
    private double x;
    private double y;
    private double x2;
    private double y2;

    
    public Line(String name, double x, double y, double x2, double y2, int zOrder) {
        super(name, zOrder);
        this.setX(x);
        this.setY(y);
        this.setX2(x2);
        this.setY2(y2);
    }
    
    @Override
    public void move(double dx, double dy){
        setX(getX() + dx);
        setY(getY() + dy);
        setX2(getX2() + dx);
        setY2(getY2() + dy);
    }

    @Override
    public double[] getBoundingBox(){
        double minX = Math.min(getX(), getX2());
        double minY = Math.min(getY(), getY2());
        double width = Math.abs(getX2() - getX());
        double height = Math.abs(getY2() - getY());
        return new double[]{minX, minY, width, height};
    }

    @Override
    public boolean coverPoint(double px, double py){
        double dx = getX2() - getX();
        double dy = getY2() - getY();
        double length = Math.sqrt(dx*dx + dy*dy);

        double distance = Math.abs((px - getX()) * dy - (py - getY()) * dx) / length;
        double dot = (px - getX()) * dx + (py - getY()) * dy;

        if(dot < 0){
            return false;
        }
        if(dot > dx * dx + dy * dy){
            return false;
        }

        return true;
    }

    @Override
    public boolean intersect(Shape other) {
        if (other instanceof Line) {
            Line line2 = (Line) other;

            double d1 = (line2.getX() - getX()) * (getY2() - getY()) - (line2.getY() - getY()) * (getX2() - getX());
            double d2 = (line2.getX2() - getX()) * (getY2() - getY()) - (line2.getY2() - getY()) * (getX2() - getX());
            double d3 = (getX() - line2.getX()) * (line2.getY2() - line2.getY()) - (getY() - line2.getY()) * (line2.getX2() - line2.getX());
            double d4 = (getX2() - line2.getX()) * (line2.getY2() - line2.getY()) - (getY2() - line2.getY()) * (line2.getX2() - line2.getX());

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

        @Override
        public String describe() {
            return String.format("Line %s: (%.2f,%.2f) -> (%.2f,%.2f)", name, getX(), getY(), getX2(), getY2());
        }
        
    @Override
    public double getX() {
        return Math.min(x, getX2());
    }
    @Override
    public double getY() {
        return Math.min(y, getY2());
    }
    
    public double getX1() { return getX(); }
    public double getY1() { return getY(); }
    public double getX2() { return x2; }
    public double getY2() { return y2; }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }
}
