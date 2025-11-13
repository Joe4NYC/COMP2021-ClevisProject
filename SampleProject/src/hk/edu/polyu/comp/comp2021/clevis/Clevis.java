package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.model.ShapeManager;
import hk.edu.polyu.comp.comp2021.clevis.util.Logger;
import hk.edu.polyu.comp.comp2021.clevis.view.CommandLineInterface;
import java.util.Arrays;
import java.util.List;

public class Clevis {

    private ShapeManager shapeManager;
    private CommandLineInterface cli;
    private Logger logger;
    private int operationCounter;

    public Clevis(){
        this.shapeManager = new ShapeManager();
        this.cli = new CommandLineInterface(this);
        this.logger = null;
        this.operationCounter = 0;
    }
    
    public Clevis(String htmlLogPath, String txtLogPath) {
        // TODO: 使用日誌路徑初始化 (REQ1)
        this.shapeManager = new ShapeManager();
        this.cli = new CommandLineInterface(this);
        this.logger = new Logger(htmlLogPath, txtLogPath);
        this.operationCounter = 0;
    }
    
    // REQ2: 創建矩形
    public void rectangle(String name, double x, double y, double w, double h) {
        // TODO: 實現
        try {
            shapeManager.createRectangle(name, x, y, w, h);
            if (logger != null) {
                operationCounter ++;
                logger.logCommand(operationCounter, "rectangle " + name + " " + x + " " + y + " " + w + " " + h);
            }
        } catch (IllegalArgumentException e) {
            cli.printError(e.getMessage());
        }
        
    }
    
    // REQ3: 創建線段
    public void line(String name, double x1, double y1, double x2, double y2) {
        // TODO: 實現
        try {
            shapeManager.createLine(name, x1, y1, x2, y2);
            if (logger != null) {
                operationCounter ++;
                logger.logCommand(operationCounter, "line " + name + " " + x1 + " " + y1 + " " + x2 + " " + y2);
            }
            
        } catch (IllegalArgumentException e) {
            cli.printError(e.getMessage());
        }
    }
    
    // REQ4: 創建圓形
    public void circle(String name, double x, double y, double r) {
        // TODO: 實現
        try {
            shapeManager.createCircle(name, x, y, r);
            if (logger != null) {
                operationCounter ++;
                logger.logCommand(operationCounter,"circle " + name + " " + x + " " + y + " " + r);
            }
            
        } catch (IllegalArgumentException e) {
            cli.printError(e.getMessage());
        }
    }
    
    // REQ5: 創建正方形
    public void square(String name, double x, double y, double l) {
        // TODO: 實現
        try {
            shapeManager.createSquare(name, x, y, l);
            if (logger != null) {
                operationCounter ++;
                logger.logCommand(operationCounter,"square " + name + " " + x + " " + y + " " + l);
            }
            
        } catch (IllegalArgumentException e) {
            cli.printError(e.getMessage());
        }
    }
    
    // REQ6: 群組操作
    public void group(String groupName, String... shapeNames) {
        // TODO: 實現
        try {
            List<String> nameList = Arrays.asList(shapeNames);
            shapeManager.groupShapes(groupName, nameList);

            if (logger != null) {
                operationCounter ++;
                StringBuilder cmd = new StringBuilder("gourp " + groupName);
                for (String shapeName : shapeNames) {
                    cmd.append(" ").append(shapeName);
                }
                logger.logCommand(operationCounter, cmd.toString());
            }
        } catch (IllegalArgumentException e) {
            cli.printError(e.getMessage());
        }
    }
    
    // REQ7: 解除群組
    public void ungroup(String groupName) {
        // TODO: 實現
        try {
            shapeManager.ungroupShapes(groupName);
            if (logger != null) {
                logger.logCommand(operationCounter, "ungroup " + groupName);
            }
        } catch (IllegalArgumentException e) {
            cli.printError(e.getMessage());
        }
    }
    
    // REQ8: 刪除形狀
    public void delete(String name) {
        // TODO: 實現
        
    }
    
    // REQ9: 計算邊界框
    public void boundingbox(String name) {
        // TODO: 實現並輸出 "x y w h"
    }
    
    // REQ10: 移動形狀
    public void move(String name, double dx, double dy) {
        // TODO: 實現
    }
    
    // REQ11: 找到覆蓋某點的最上層形狀
    public void shapeAt(double x, double y) {
        // TODO: 實現並返回形狀名稱
    }
    
    // REQ12: 判斷兩個形狀是否相交
    public void intersect(String n1, String n2) {
        // TODO: 實現並報告是否相交
    }
    
    // REQ13: 列出形狀的基本信息
    public void list(String name) {
        // TODO: 實現
    }
    
    // REQ14: 列出所有形狀
    public void listAll() {
        // TODO: 實現，按Z-order降序，使用縮進顯示群組關係
    }
    
    // REQ15: 退出程序
    public void quit() {
        // TODO: 實現退出邏輯
    }
    
    // BON2: 撤銷操作
    public void undo() {
        // TODO: 實現撤銷
    }
    
    // BON2: 重做操作
    public void redo() {
        // TODO: 實現重做
    }
    
    // 獲取組件
    public ShapeManager getShapeManager() {
        return shapeManager;
    }
    
    public CommandLineInterface getCLI() {
        return cli;
    }
    
    public Logger getLogger() {
        return logger;
    }
}
