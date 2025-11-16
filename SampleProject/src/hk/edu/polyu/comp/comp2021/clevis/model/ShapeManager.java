package hk.edu.polyu.comp.comp2021.clevis.model;

import java.util.*;

import hk.edu.polyu.comp.comp2021.clevis.model.command.Command;
import hk.edu.polyu.comp.comp2021.clevis.model.command.GroupCommand;

public class ShapeManager{
    private Map<String, Shape> shapes = new LinkedHashMap<>();
    private final List<Shape> zOrderList = new ArrayList<>();
    private final Deque<Command> undoStack = new ArrayDeque<>();
    private final Deque<Command> redoStack = new ArrayDeque<>();

    public void createRectangle(String name, double x, double y, double w, double h) {
        checkNameAvailable(name);
        shapes.put(name, new Rectangle(name, x, y, w, h));
    }

    public void createLine(String name, double x1, double y1, double x2, double y2) {
        checkNameAvailable(name);
        shapes.put(name, new Line(name, x1, y1, x2, y2));
    }

    public void createCircle(String name, double x, double y, double r) {
        checkNameAvailable(name);
        shapes.put(name, new Circle(name, x, y, r));
    }

    public void createSquare(String name, double x, double y, double s) {
        checkNameAvailable(name);
        shapes.put(name, new Square(name, x, y, s));
    }

    public void group(String rawCommand) {
        String[] tokens = rawCommand.trim().split("\\s+");
        if (tokens.length < 3) {
            throw new IllegalArgumentException("Group command requires at least a name and one member");
        }
        
        String groupName = tokens[1];
        checkNameAvailable(groupName);
        
        List<Shape> allShapes = new ArrayList<>();
        for (int i = 2; i < tokens.length; i++) {
            Shape s = shapes.remove(tokens[i]);
            if (s == null) {
                throw new IllegalArgumentException("Shape not found: " + tokens[i]);
            }
            allShapes.add(s);
        }
        shapes.put(groupName, new Group(groupName, allShapes));

        undoStack.push(new GroupCommand(this, shapes.get(groupName), allShapes));
        redoStack.clear();
    }

    public void ungroup(String groupName) {
        Shape g = shapes.remove(groupName);
        if (g instanceof Group) {
            Group group = (Group) g;
            for (Shape shapeInGroup : group.getMembers()) {
                shapes.put(shapeInGroup.name, shapeInGroup);
            }
        }

        undoStack.push(new GroupCommand(this, g, ((Group) g).getMembers()));
        redoStack.clear();
    }

    public void move(String name, double dx, double dy) {
        Shape s = shapes.get(name);
        if(s != null){
            s.move(dx, dy);
        }else{
            throw new IllegalArgumentException("Shape not found");
        }
    }

    public void delete(String name) {
        shapes.remove(name);
    }

    public double[] getBoundingBox(String name) {
        Shape s = shapes.get(name);
        if(s == null){
            throw new IllegalArgumentException("Shape not found");
        }
        
        double[] b = s.getBoundingBox();
            return new double[] {
                round(b[0]), round(b[1]), round(b[2]), round(b[3])
            };
    }

    public Shape shapeAt(double x, double y) {
        List<Shape> list = new ArrayList<>(shapes.values());
        Collections.reverse(list);
        for (Shape s : list) {
            if (s.coverPoint(x, y)) return s;
        }
        return null;
    }

    public boolean intersect(String n1, String n2) {
        Shape s1 = shapes.get(n1);
        Shape s2 = shapes.get(n2);
        if (s1 == null || s2 == null){
            return false;
        }
        double[] b1 = s1.getBoundingBox();
        double[] b2 = s2.getBoundingBox();
        return (b1[0] < b2[0] + b2[2] &&
                b2[0] < b1[0] + b1[2] &&
                b1[1] < b2[1] + b2[3] &&
                b2[1] < b1[1] + b1[3]);
    }

    public String listAll() {
        StringBuilder sb = new StringBuilder();
        for (Shape s : shapes.values()) {
            if (s instanceof Group) {
                Group group = (Group) s;
                sb.append("Group ").append(group.name).append(":");
                for (Shape child : group.getMembers()) {
                    sb.append("\n ").append(child.getName());
                }
            } else {
                sb.append(s.describe());
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public String describeString(String name) {
        Shape s = shapes.get(name);
        if(s != null){
            return s.describe();
        }else{
            return "Shape not found";
        }
    }

    public Map<String, Shape> getAllShapes() {
        return shapes;
    }

    private void checkNameAvailable(String name) {
        if (shapes.containsKey(name)) {
            throw new IllegalArgumentException("Name already used: " + name);
        }
    }

    private double round(double val) {
        return Math.round(val * 100.0) / 100.0;
    }

    public Shape get(String name) {
        return shapes.get(name);
    }

    private void addShape(Shape shape) {
        shapes.put(shape.getName(), shape);
        zOrderList.add(shape);
    }

    public void addShapeDirectly(Shape shape) {
        shapes.put(shape.getName(), shape);
        zOrderList.add(shape);
    }

    public void removeShape(Shape shape) {
        shapes.remove(shape.getName());
        zOrderList.remove(shape);
    }
    
    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo.");
            return;
        }

        Command command = undoStack.pop();
        command.undo(); 
        redoStack.push(command);
    }

    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo.");
            return;
        }

        Command command = redoStack.pop();
        command.redo();  
        undoStack.push(command);
    }
}
