package hk.edu.polyu.comp.comp2021.clevis.model;

import java.util.ArrayList;
import java.util.List;

public class Group extends Shape {
    
    private List<Shape> shapes;
    
    // REQ6: 構造函數
    public Group(String name, List<Shape> shapes) {
        this.name = name;
        this.shapes = new ArrayList<>(shapes);
    }
    
    @Override
    public double[] getBoundingBox() {
        // TODO: 返回包含所有成員形狀的邊界框
        return null;
    }
    
    @Override
    public void move(double dx, double dy) {
        // TODO: 移動所有成員形狀
    }
    
    @Override
    public boolean containsPoint(double px, double py) {
        // TODO: 檢查任何成員形狀是否包含該點
        return false;
    }
    
    @Override
    public double distanceToPoint(double px, double py) {
        // TODO: 返回到最近成員形狀輪廓的距離
        return 0.0;
    }
    
    @Override
    public String getInfo() {
        // TODO: 返回群組的基本信息（包含所有成員名稱）
        return null;
    }
    
    // 群組專屬方法
    public void addShape(Shape shape) {
        // TODO: 添加形狀到群組
    }
    
    public void removeShape(Shape shape) {
        // TODO: 從群組移除形狀
    }
    
    public List<Shape> getShapes() {
        return new ArrayList<>(shapes);
    }
    
    public boolean contains(Shape shape) {
        // TODO: 檢查群組是否包含某個形狀
        return false;
    }
    
    public int size() {
        return shapes != null ? shapes.size() : 0;
    }
}
