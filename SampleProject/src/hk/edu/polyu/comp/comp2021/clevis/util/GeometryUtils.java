package hk.edu.polyu.comp.comp2021.clevis.util;

import hk.edu.polyu.comp.comp2021.clevis.model.Shape;
import java.util.List;

public class GeometryUtils {
    
    // REQ11: 距離計算 - 點到點
    public static double distancePointToPoint(double x1, double y1, double x2, double y2) {
        // TODO: 實現
        return 0.0;
    }
    
    // REQ11: 距離計算 - 點到線段
    public static double distancePointToLine(double px, double py, 
                                             double x1, double y1, 
                                             double x2, double y2) {
        // TODO: 實現
        return 0.0;
    }
    
    // REQ11: 距離計算 - 點到圓的輪廓
    public static double distancePointToCircle(double px, double py, 
                                               double cx, double cy, double r) {
        // TODO: 實現
        return 0.0;
    }
    
    // REQ11: 距離計算 - 點到矩形輪廓
    public static double distancePointToRectangle(double px, double py,
                                                  double x, double y,
                                                  double w, double h) {
        // TODO: 實現
        return 0.0;
    }
    
    // REQ11: 點包含檢測 - 矩形
    public static boolean pointInRectangle(double px, double py, 
                                           double x, double y, 
                                           double w, double h) {
        // TODO: 實現
        return false;
    }
    
    // REQ11: 點包含檢測 - 圓
    public static boolean pointInCircle(double px, double py, 
                                        double cx, double cy, double r) {
        // TODO: 實現
        return false;
    }
    
    // REQ9: 邊界盒計算
    public static double[] calculateBoundingBox(List<Shape> shapes) {
        // TODO: 實現 - 計算包含所有形狀的最小邊界框
        return null;
    }
    
    // REQ12: 檢查兩個邊界框是否相交
    public static boolean boundingBoxesIntersect(double[] box1, double[] box2) {
        // TODO: 實現 - 檢查兩個邊界框是否有內部點重疊
        return false;
    }
    
    // 工具方法 - 四捨五入到指定小數位
    public static double round(double value, int places) {
        // TODO: 實現
        return 0.0;
    }
}

