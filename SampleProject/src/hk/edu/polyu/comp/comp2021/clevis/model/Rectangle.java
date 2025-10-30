package hk.edu.polyu.comp.comp2021.clevis.model;

public class Rectangle extends Shape {
    
    private double width;
    private double height;
    
    // REQ2: 構造函數
    public Rectangle(String name, double x, double y, double width, double height) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double[] getBoundingBox() {
        // TODO: 返回 [x, y, width, height]
        return null;
    }
    
    @Override
    public void move(double dx, double dy) {
        // TODO: 實現移動
    }
    
    @Override
    public boolean containsPoint(double px, double py) {
        // TODO: 實現點包含檢測
        return false;
    }
    
    @Override
    public double distanceToPoint(double px, double py) {
        // TODO: 計算點到矩形輪廓的最小距離
        return 0.0;
    }
    
    @Override
    public String getInfo() {
        // TODO: 返回矩形的基本信息
        return null;
    }
    
    // Getters
    public double getWidth() {
        return width;
    }
    
    public double getHeight() {
        return height;
    }
}
