package hk.edu.polyu.comp.comp2021.clevis.model;

import hk.edu.polyu.comp.comp2021.clevis.model.command.Command;
import hk.edu.polyu.comp.comp2021.clevis.model.command.CreateShapeCommand;
import hk.edu.polyu.comp.comp2021.clevis.model.command.DeleteCommand;
import hk.edu.polyu.comp.comp2021.clevis.model.command.GroupCommand;
import hk.edu.polyu.comp.comp2021.clevis.model.command.MoveCommand;
import java.util.*;

public class ShapeManager{
    private Map<String, Shape> shapes = new LinkedHashMap<>();
    private final List<Shape> zOrderList = new ArrayList<>();
    private final Deque<Command> undoStack = new ArrayDeque<>();
    private final Deque<Command> redoStack = new ArrayDeque<>();
    private int currentZOrder = 0;

    private int nextZOrder() {
        return ++currentZOrder;
    }

    private void addShape(Shape shape) {
        shapes.put(shape.getName(), shape);
        zOrderList.add(shape);
        zOrderList.sort(Comparator.comparingInt(Shape::getZOrder));
    }

    public void createRectangle(String name, double x, double y, double w, double h) {
        checkNameAvailable(name);
        Rectangle r = new Rectangle(name, x, y, w, h, nextZOrder());
        addShape(r);
        undoStack.push(new CreateShapeCommand(this, r));
        redoStack.clear();
    }

    public void createLine(String name, double x1, double y1, double x2, double y2) {
        checkNameAvailable(name);
        Line line = new Line(name, x1, y1, x2, y2, nextZOrder());
        addShape(line);
        undoStack.push(new CreateShapeCommand(this, line));
        redoStack.clear();
    }

    public void createCircle(String name, double x, double y, double r) {
        checkNameAvailable(name);
        Circle circle = new Circle(name, x, y, r, nextZOrder());
        addShape(circle);
        undoStack.push(new CreateShapeCommand(this, circle));
        redoStack.clear();
    }

    public void createSquare(String name, double x, double y, double s) {
        checkNameAvailable(name);
        Square square = new Square(name, x, y, s, nextZOrder());
        addShape(square);
        undoStack.push(new CreateShapeCommand(this, square));
        redoStack.clear();
    }

    public void group(String rawCommand) {
        String[] tokens = rawCommand.trim().split("\\s+");
        if (tokens.length < 3) {
            throw new IllegalArgumentException("Group command requires at least a name and one member");
        }

        String groupName = tokens[1];
        checkNameAvailable(groupName);

        List<Shape> members = new ArrayList<>();
        for (int i = 2; i < tokens.length; i++) {
            Shape s = shapes.remove(tokens[i]);
            if (s == null) throw new IllegalArgumentException("Shape not found: " + tokens[i]);
            members.add(s);
            zOrderList.remove(s);
        }

        Group group = new Group(groupName, nextZOrder(), members);
        addShape(group);

        undoStack.push(new GroupCommand(this, group, members));
        redoStack.clear();
    }

    public void ungroup(String groupName) {
        Shape g = shapes.remove(groupName);
        if (g == null) {
            throw new IllegalArgumentException("Group not found: " + groupName);
        }
        if (!(g instanceof Group)) {
            throw new IllegalArgumentException("Shape is not a group: " + groupName);
        }
        
        Group group = (Group) g;
        for (Shape shapeInGroup : group.getMembers()) {
            shapes.put(shapeInGroup.getName(), shapeInGroup);
        }

        undoStack.push(new GroupCommand(this, g, ((Group) g).getMembers()));
        redoStack.clear();
    }

    public void move(String name, double dx, double dy) {
        Shape s = shapes.get(name);
        if(s == null){
            throw new IllegalArgumentException("Shape not found");
        }        
        
        undoStack.push((Command) new MoveCommand(s, dx, dy));
        redoStack.clear();
        s.move(dx, dy);
    }

    public void delete(String name) {
    Shape s = shapes.get(name);
    if (s == null) {
        throw new IllegalArgumentException("Shape not found");
    }
    
    List<Shape> deleted = new ArrayList<>();
    collectAll(s, deleted);

    for (Shape shape : deleted) {
        removeShape(shape);
    }

    undoStack.push(new DeleteCommand(this, deleted));
    redoStack.clear();
    }

    private void collectAll(Shape s, List<Shape> list) {
        list.add(s);
        if (s instanceof Group g) {
            for (Shape m : g.getMembers()) {
                collectAll(m, list);
            }
        }
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

    public String shapeAt(double x, double y) {
        List<Shape> list = new ArrayList<>(zOrderList);
        Collections.reverse(list);
        for (Shape s : list) {
            if (s.coverPoint(x, y)) return s.getName();
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
        if (shapes.isEmpty()) {
            return "No shapes available.";
        }
        StringBuilder sb = new StringBuilder();
        for (Shape s : shapes.values()) {
            if (s instanceof Group) {
                Group group = (Group) s;
                sb.append("Group ").append(group.getName()).append(":");
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
