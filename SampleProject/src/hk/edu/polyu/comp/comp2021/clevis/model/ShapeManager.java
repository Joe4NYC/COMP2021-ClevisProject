package hk.edu.polyu.comp.comp2021.clevis.model;

import java.util.*;

public class ShapeManager{
    private Map<String, Shape> shapes = new LinkedHashMap<>();

    public void add(Shape s) {
        shapes.put(s.name, s);
    }
 
    public Shape get(String name) {
        return shapes.get(name);
    }

    public void group(String groupName, String[] members) {
        List<Shape> children = new ArrayList<>();
        for (String m : members) {
            Shape s = shapes.remove(m);
            if (s != null) children.add(s);
        }
        shapes.put(groupName, new Group(groupName, children));
    }

    public void delete(String name) {
        shapes.remove(name);
    }

    public void ungroup(String groupName) {
        Shape g = shapes.remove(groupName);
        if (g instanceof Group) {
            Group group = (Group) g;
            for (Shape child : group.getShapes()) {
                shapes.put(child.name, child);
            }
        }
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
        if (s1 == null || s2 == null) return false;
        double[] b1 = s1.getBoundingBox();
        double[] b2 = s2.getBoundingBox();
        return (b1[0] < b2[0] + b2[2] &&
                b2[0] < b1[0] + b1[2] &&
                b1[1] < b2[1] + b2[3] &&
                b2[1] < b1[1] + b1[3]);
    }

    public void listAll() {
        for (Shape s : shapes.values()) {
            if (s instanceof Group) {
                Group group = (Group) s;
                System.out.println("Group " + group.name + ":");
                for (Shape child : group.getShapes()) {
                    System.out.println("  " + child.name);
                }
            } else {
                System.out.println("Shape: " + s.name);
            }
        }
    }

    public String describeShape(String name) {
        Shape s = shapes.get(name);
        return (s != null) ? s.describe() : "Shape not found";
    }

    public Map<String, Shape> getAllShapes() {
        return shapes;
    }
}