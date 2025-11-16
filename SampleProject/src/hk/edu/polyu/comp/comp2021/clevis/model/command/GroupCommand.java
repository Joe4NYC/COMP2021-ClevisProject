package hk.edu.polyu.comp.comp2021.clevis.model.command;

import hk.edu.polyu.comp.comp2021.clevis.model.Group;
import hk.edu.polyu.comp.comp2021.clevis.model.Shape;
import hk.edu.polyu.comp.comp2021.clevis.model.ShapeManager;

import java.util.ArrayList;
import java.util.List;

public class GroupCommand implements Command {

    private final ShapeManager manager;
    private final Group group;   
    private final List<Shape> members; 

    public GroupCommand(ShapeManager manager, Group group, List<Shape> members) {
        this.manager = manager;
        this.group = group;
        this.members = new ArrayList<>(members);
    }

    @Override
    public void undo() {
        manager.removeShape(group);
        for (Shape s : members) {
            manager.addShapeDirectly(s);
        }
    }

    @Override
    public void redo() {
        for (Shape s : members) {
            manager.removeShape(s);
        }
        manager.addShapeDirectly(group);
    }
}