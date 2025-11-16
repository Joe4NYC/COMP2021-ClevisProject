package hk.edu.polyu.comp.comp2021.clevis.model.command;

import hk.edu.polyu.comp.comp2021.clevis.model.Shape;
import hk.edu.polyu.comp.comp2021.clevis.model.ShapeManager;

import java.util.ArrayList;
import java.util.List;

public class DeleteCommand implements Command {

    private final ShapeManager manager;
    private final List<Shape> allDeletedShapes;

    public DeleteCommand(ShapeManager manager, List<Shape> shapes) {

        this.manager = manager;
        this.allDeletedShapes = new ArrayList<>(shapes);
    }

    @Override
    public void undo() {
        for (int i = allDeletedShapes.size() - 1; i >= 0; i--) {
            Shape s = allDeletedShapes.get(i);
            manager.addShapeDirectly(s);
        }
    }

    @Override
    public void redo() {
        for (Shape s : allDeletedShapes) {
            manager.removeShape(s);
        }
    }
}