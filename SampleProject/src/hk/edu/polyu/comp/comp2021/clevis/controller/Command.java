package hk.edu.polyu.comp.comp2021.clevis.controller;

public interface Command {
    void execute(Clevis clevis);
    void undo();  // BON2 需要
}

