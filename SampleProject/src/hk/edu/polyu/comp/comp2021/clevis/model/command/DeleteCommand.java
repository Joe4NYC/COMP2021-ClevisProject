package hk.edu.polyu.comp.comp2021.clevis.model.command;

import hk.edu.polyu.comp.comp2021.clevis.model.Shape;
import hk.edu.polyu.comp.comp2021.clevis.model.ShapeManager;
import hk.edu.polyu.comp.comp2021.clevis.model.Group;

import java.util.ArrayList;
import java.util.List;

public class DeleteCommand implements Command {

    private final ShapeManager manager;
    private final Shape deletedShape;
    private final List<Shape> allDeletedShapes;

    public DeleteCommand(ShapeManager manager, Shape shape) {

        this.manager = manager;
        this.deletedShape = shape;
        this.allDeletedShapes = new ArrayList<>();
        collectAllShapes(shape);

    }

    private void collectAllShapes(Shape s) {

        allDeletedShapes.add(s);
        if (s instanceof Group g) {
            for (Shape member : g.getMembers()) {
                collectAllShapes(member);
            }
        }
    }

    @Override
    public void undo() {
        for (int i = allDeletedShapes.size() - 1; i >= 0; i--) {
            Shape s = allDeletedShapes.get(i);
            manager.addShapeDirectly(s);
        }
        if (deletedShape instanceof Group g) {
            g.restoreMembers();
        }
    }

    @Override
    public void redo() {
        for (Shape s : allDeletedShapes) {
            manager.removeShape(s);
        }
    }
}