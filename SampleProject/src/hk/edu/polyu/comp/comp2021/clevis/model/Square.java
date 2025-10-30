package hk.edu.polyu.comp.comp2021.clevis.model;

public class Square extends Shape {
    
    private double length;
    
    // REQ5: 構造函數
    public Square(String name, double x, double y, double length) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.length = length;
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
        // TODO: 計算點到正方形輪廓的最小距離
        return 0.0;
    }
    
    @Override
    public String getInfo() {
        // TODO: 返回正方形的基本信息
        return null;
    }
    
    // Getter
    public double getLength() {
        return length;
    }
}
