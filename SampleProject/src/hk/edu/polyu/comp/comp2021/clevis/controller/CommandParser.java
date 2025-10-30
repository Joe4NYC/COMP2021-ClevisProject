package hk.edu.polyu.comp.comp2021.clevis.controller;

import hk.edu.polyu.comp.comp2021.clevis.Clevis;

public class CommandParser {
    
    // 解析並執行命令
    public void parseAndExecute(String commandLine, Clevis clevis) {
        // TODO: 解析命令並執行
    }
    
    // 解析 rectangle 命令 (REQ2)
    private void parseRectangle(String[] args, Clevis clevis) {
        // TODO: rectangle n x y w h
    }
    
    // 解析 line 命令 (REQ3)
    private void parseLine(String[] args, Clevis clevis) {
        // TODO: line n x1 y1 x2 y2
    }
    
    // 解析 circle 命令 (REQ4)
    private void parseCircle(String[] args, Clevis clevis) {
        // TODO: circle n x y r
    }
    
    // 解析 square 命令 (REQ5)
    private void parseSquare(String[] args, Clevis clevis) {
        // TODO: square n x y l
    }
    
    // 解析 group 命令 (REQ6)
    private void parseGroup(String[] args, Clevis clevis) {
        // TODO: group n n1 n2...
    }
    
    // 解析 ungroup 命令 (REQ7)
    private void parseUngroup(String[] args, Clevis clevis) {
        // TODO: ungroup n
    }
    
    // 解析 delete 命令 (REQ8)
    private void parseDelete(String[] args, Clevis clevis) {
        // TODO: delete n
    }
    
    // 解析 boundingbox 命令 (REQ9)
    private void parseBoundingBox(String[] args, Clevis clevis) {
        // TODO: boundingbox n
    }
    
    // 解析 move 命令 (REQ10)
    private void parseMove(String[] args, Clevis clevis) {
        // TODO: move n dx dy
    }
    
    // 解析 shapeAt 命令 (REQ11)
    private void parseShapeAt(String[] args, Clevis clevis) {
        // TODO: shapeAt x y
    }
    
    // 解析 intersect 命令 (REQ12)
    private void parseIntersect(String[] args, Clevis clevis) {
        // TODO: intersect n1 n2
    }
    
    // 解析 list 命令 (REQ13)
    private void parseList(String[] args, Clevis clevis) {
        // TODO: list n
    }
    
    // 解析 listAll 命令 (REQ14)
    private void parseListAll(String[] args, Clevis clevis) {
        // TODO: listAll
    }
    
    // 解析 quit 命令 (REQ15)
    private void parseQuit(String[] args, Clevis clevis) {
        // TODO: quit
    }
    
    // 解析 undo 命令 (BON2)
    private void parseUndo(String[] args, Clevis clevis) {
        // TODO: undo
    }
    
    // 解析 redo 命令 (BON2)
    private void parseRedo(String[] args, Clevis clevis) {
        // TODO: redo
    }
    
    // 輔助方法
    private String[] tokenize(String commandLine) {
        // TODO: 將命令行拆分為標記
        return null;
    }
    
    private void validateArguments(String[] args, int expectedCount) {
        // TODO: 驗證參數數量
    }
}
