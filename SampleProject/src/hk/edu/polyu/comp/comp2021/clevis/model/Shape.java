package hk.edu.polyu.comp.comp2021.clevis.model;

public abstract class Shape {
    protected String name;
    protected double x, y;
    protected int zIndex;  // REQ11: Z-order tracking
    
    // REQ9: 獲取邊界框
    public abstract double[] getBoundingBox();
    
    // REQ10: 移動形狀
    public abstract void move(double dx, double dy);
    
    // REQ11: 檢查點是否在形狀內（用於判斷覆蓋）
    public abstract boolean containsPoint(double px, double py);
    
    // REQ11: 計算點到形狀輪廓的最小距離
    public abstract double distanceToPoint(double px, double py);
    
    // REQ13: 獲取形狀的基本信息
    public abstract String getInfo();
    
    // Getters and Setters
    public String getName() { 
        return name; 
    }
    
    public void setName(String name) { 
        this.name = name; 
    }
    
    public int getZIndex() {
        return zIndex;
    }
    
    public void setZIndex(int zIndex) {
        this.zIndex = zIndex;
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
}