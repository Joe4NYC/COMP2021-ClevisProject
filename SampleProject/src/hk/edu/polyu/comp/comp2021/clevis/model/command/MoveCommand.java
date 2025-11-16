package hk.edu.polyu.comp.comp2021.clevis.model.command;

import hk.edu.polyu.comp.comp2021.clevis.model.Shape;

public class MoveCommand {
    private final Shape shape;
    private final double chanX;
    private final double chanY;

    public MoveCommand(Shape shape, double chanX, double chanY) {
        this.shape = shape;
        this.chanX = chanX;
        this.chanY = chanY;
    }

    public void redo() {
        shape.move(chanX, chanY);
    }

    public void undo() {
        shape.move(-chanX, -chanY);
    }
}
