package hk.edu.polyu.comp.comp2021.clevis.model;

import java.util.*;

public class ShapeManager {
    
    private Map<String, Shape> shapes;
    
    public ShapeManager() {
        // TODO: 初始化
    }
    
    // REQ2: 創建矩形
    public void createRectangle(String name, double x, double y, double w, double h) {
        // TODO: 實現
    }
    
    // REQ4: 創建圓形
    public void createCircle(String name, double x, double y, double r) {
        // TODO: 實現
    }
    
    // REQ3: 創建線段
    public void createLine(String name, double x1, double y1, double x2, double y2) {
        // TODO: 實現
    }
    
    // REQ5: 創建正方形
    public void createSquare(String name, double x, double y, double l) {
        // TODO: 實現
    }
    
    // REQ6: 群組操作
    public void groupShapes(String groupName, List<String> members) {
        List<Shape> children = new ArrayList<>();
        for (String m : members) {
            Shape s = shapes.remove(m);
            if (s != null) children.add(s);
        }
        shapes.put(groupName, new Group(groupName, children));
    }
    
    // REQ7: 解除群組
    public void ungroupShapes(String groupName) {
        Shape g = shapes.remove(groupName);
        if (g instanceof Group) {
            Group group = (Group) g;
            for (Shape child : group.getShapes()) {
                shapes.put(child.name, child);
            }
        }
    }
    
    // REQ8: 刪除操作
    public void deleteShape(String name) {
        // TODO: 實現
    }
    
    // 形狀查詢
    public Shape getShape(String name) {
        // TODO: 實現
        return null;
    }
    
    public boolean shapeExists(String name) {
        // TODO: 實現
        return false;
    }
    
    // REQ11: 獲取在指定位置的最上層形狀
    public Shape getShapeAt(double x, double y) {
        // TODO: 實現 - 找到覆蓋該點的Z-index最高的形狀
        return null;
    }
    
    // REQ10: 移動形狀
    public void moveShape(String name, double dx, double dy) {
        // TODO: 實現
    }
    
    // REQ9: 獲取邊界框
    public double[] getBoundingBox(String name) {
        // TODO: 實現 - 返回 [x, y, w, h]
        return null;
    }
    
    // REQ12: 檢查兩個形狀是否相交
    public boolean checkIntersect(String n1, String n2) {
        // TODO: 實現 - 檢查兩個形狀的邊界框是否有交集
        return false;
    }
    
    // REQ13: 獲取形狀的基本信息
    public String getShapeInfo(String name) {
        // TODO: 實現 - 返回形狀的基本信息
        return null;
    }
    
    // REQ14: 獲取所有形狀列表（按Z-order降序）
    public List<Shape> getAllShapesInZOrder() {
        // TODO: 實現
        return null;
    }
    
    // 驗證
    public void validateShapeName(String name) {
        // 檢查名稱是否已存在
        // TODO: 實現 - 如果已存在則拋出異常
    }
    
    public void validateShapeExists(String name) {
        // 檢查形狀是否存在
        // TODO: 實現 - 如果不存在則拋出異常
    }
}