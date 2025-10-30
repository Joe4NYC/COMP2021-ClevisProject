package hk.edu.polyu.comp.comp2021.clevis.model;

public class Line extends Shape {
    
    private double x2;
    private double y2;
    
    // REQ3: 構造函數
    public Line(String name, double x1, double y1, double x2, double y2) {
        this.name = name;
        this.x = x1;
        this.y = y1;
        this.x2 = x2;
        this.y2 = y2;
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
        // TODO: 線段不包含點，返回 false
        return false;
    }
    
    @Override
    public double distanceToPoint(double px, double py) {
        // TODO: 計算點到線段的最小距離
        return 0.0;
    }
    
    @Override
    public String getInfo() {
        // TODO: 返回線段的基本信息
        return null;
    }
    
    // Getters
    public double getX1() {
        return x;
    }
    
    public double getY1() {
        return y;
    }
    
    public double getX2() {
        return x2;
    }
    
    public double getY2() {
        return y2;
    }
}
