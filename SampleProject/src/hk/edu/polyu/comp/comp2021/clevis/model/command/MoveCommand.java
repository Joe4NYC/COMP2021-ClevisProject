package hk.edu.polyu.comp.comp2021.clevis.model.command;

import hk.edu.polyu.comp.comp2021.clevis.model.Shape;

public class MoveCommand implements Command {
    private final Shape shape;
    private final double changeX;
    private final double changeY;

    public MoveCommand(Shape shape, double changeX, double changeY) {
        this.shape = shape;
        this.changeX = changeX;
        this.changeY = changeY;
    }

    @Override
    public void redo() {
        shape.move(changeX, changeY);
    }

    @Override
    public void undo() {
        shape.move(-changeX, -changeY);
    }
}
