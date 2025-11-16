package hk.edu.polyu.comp.comp2021.clevis.model.command;

public interface Command { 
    void undo();
    void redo();
}