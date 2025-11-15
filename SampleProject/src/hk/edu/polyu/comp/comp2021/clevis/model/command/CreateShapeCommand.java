package hk.edu.polyu.comp.comp2021.clevis.model.command;

import hk.edu.polyu.comp.comp2021.clevis.model.Shape;
import hk.edu.polyu.comp.comp2021.clevis.model.ShapeManager;

public class CreateShapeCommand implements Command {
    private final ShapeManager manager;
    private final Shape shape;

    public CreateShapeCommand(ShapeManager manager, Shape shape) {
        this.manager = manager;
        this.shape = shape;
    }

    @Override
    public void execute() {
        manager.addShapeDirectly(shape);
    }

    @Override
    public void undo() {
        manager.removeShape(shape);
    }
}
