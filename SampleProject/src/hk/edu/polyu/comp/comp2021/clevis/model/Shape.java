package hk.edu.polyu.comp.comp2021.clevis.model;

public abstract class Shape {
    protected String name;
    
    public Shape(String name){
        this.name = name;
    }
    
    public abstract void move(double dx, double dy);

    public abstract double[] getBoundingBox();

    public abstract String describe();

    public abstract boolean coverPoint(double x, double y);

    public abstract boolean intersect(Shape other);

    public String getName() {
        return name;
    }

    public abstract double getX();
    public abstract double getY();
}