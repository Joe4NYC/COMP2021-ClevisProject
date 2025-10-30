package hk.edu.polyu.comp.comp2021.clevis.model;

public class Circle extends Shape {
    
    private double radius;
    
    // REQ4: 構造函數
    public Circle(String name, double x, double y, double radius) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    
    @Override
    public double[] getBoundingBox() {
        // TODO: 返回邊界框
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
        // TODO: 計算點到圓輪廓的最小距離
        return 0.0;
    }
    
    @Override
    public String getInfo() {
        // TODO: 返回圓的基本信息
        return null;
    }
    
    // Getter
    public double getRadius() {
        return radius;
    }
}
