package hk.edu.polyu.comp.comp2021.clevis.model;

import java.util.ArrayList;
import java.util.List;

public class Group extends Shape {
    
    private List<Shape> allShapes = new ArrayList<>();
    
    public Group(String name, List<Shape> shapes) {
        super(name);
        allShapes.addAll(shapes);
    }

    public void move(double dx, double dy){
        for(Shape s : allShapes){
            s.move(dx, dy);
        }
    }

    public double[] getBoundingBox(){
        double minX = Double.MAX_VALUE;
        double minY = Double.MAX_VALUE;
        double maxX = -Double.MAX_VALUE;
        double maxY = -Double.MAX_VALUE;

        for(Shape s : allShapes){
            double[] wholeBoundingBox = s.getBoundingBox();
            minX = Math.min(minX, wholeBoundingBox[0]);
            minY = Math.min(minY, wholeBoundingBox[1]);
            maxX = Math.max(maxX, wholeBoundingBox[0] + wholeBoundingBox[2]);
            maxY = Math.max(maxY, wholeBoundingBox[1] + wholeBoundingBox[3]);
        }
        return new double[]{minX, minY, maxX - minX, maxY - minY};
    }
    
    public boolean coverPoint(double x, double y){
        for(Shape s : allShapes){
            if(s.coverPoint(x, y)){
                return true;
            }
        }
        return false;
    }

    public boolean intersect(Shape other) {
        double[] b1 = this.getBoundingBox();
        double[] b2 = other.getBoundingBox();
        return (b1[0] < b2[0] + b2[2] &&
                b2[0] < b1[0] + b1[2] &&
                b1[1] < b2[1] + b2[3] &&
                b2[1] < b1[1] + b1[3]);
    }

    public String describe(){
        StringBuilder sb = new StringBuilder("Group " + name + ": ");
        for (Shape s : allShapes){
            sb.append(s.name).append(" ");
        } 
        return sb.toString();
    }

    public void restoreMembers(){}

    public List<Shape> getMembers() {
        return new ArrayList<>(allShapes);
    }

    @Override
    public double getX() {
        double minX = Double.MAX_VALUE;
        for (Shape s : allShapes) {
            minX = Math.min(minX, s.getX());
        }
        return minX;
    }

    @Override
    public double getY() {
        double minY = Double.MAX_VALUE;
        for (Shape s : allShapes) {
            minY = Math.min(minY, s.getY());
        }
        return minY;
    }

}
