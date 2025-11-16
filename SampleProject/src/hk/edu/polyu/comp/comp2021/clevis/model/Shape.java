package hk.edu.polyu.comp.comp2021.clevis.model;

public abstract class Shape {
    protected String name;
    protected int zOrder;
    
    public Shape(String name, int zOrder){
        this.name = name;
        this.zOrder = zOrder;
    }
    
    public abstract void move(double dx, double dy);

    public abstract double[] getBoundingBox();

    public abstract String describe();

    public abstract boolean coverPoint(double x, double y);

    public abstract boolean intersect(Shape other);

    public int getZOrder() {
        return zOrder;
    }

    public void setZOrder(int zOrder) { 
        this.zOrder = zOrder; 
    }

    public String getName() {
        return name;
    }

    public abstract double getX();
    public abstract double getY();
}