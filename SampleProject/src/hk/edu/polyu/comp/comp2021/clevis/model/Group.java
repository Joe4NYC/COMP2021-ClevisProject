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
        double minX = Double.MAX_VALUE, 
        double minY = Double.MAX_VALUE;
        double maxX = -Double.MIN_VALUE
        double maxY = -Double.MIN_VALUE;

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

    public String describe(){
        StringBuilder sb = new StringBuilder("Group " + name + ": ");
        for (Shape s : allShapes){
            sb.append(s.name).append(" ");
        } 
        return sb.toString();
    }

    public List<Shape> getShapes() { 
        return allShapes; 
    }
}
