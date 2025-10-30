package hk.edu.polyu.comp.comp2021.clevis.model;

public class Clevis {

    public Clevis(){

    }
	
    public abstract class Shape {
        protected String name;
        protected double x, y;
        
        // 基本方法
        public abstract double[] getBoundingBox();  // 獲取邊界盒 (x, y, w, h)
        public abstract void move(double dx, double dy);  // 移動形狀
        public abstract boolean containsPoint(double px, double py);  // 判斷是否包含某點
        public abstract double distanceToPoint(double px, double py);  // 計算點到形狀的距離
        
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }

    public class ShapeManager {
        // 創建形狀
        public void createRectangle(String name, double x, double y, double w, double h);
        public void createCircle(String name, double x, double y, double r);
        public void createLine(String name, double x1, double y1, double x2, double y2);
        public void createSquare(String name, double x, double y, double l);
        
        // 群組操作
        public void groupShapes(String groupName, List<String> shapeNames);
        public void ungroupShapes(String groupName);
        
        // 刪除操作
        public void deleteShape(String name);
        
        // 形狀查詢
        public Shape getShape(String name);
        public boolean shapeExists(String name);
        public Shape getShapeAt(double x, double y);  // 獲取最上面的形狀
        
        // 其他操作
        public void moveShape(String name, double dx, double dy);
        public double[] getBoundingBox(String name);
        
        // 驗證
        public void validateShapeName(String name);  // 檢查名稱是否已存在
        public void validateShapeExists(String name);  // 檢查形狀是否存在
    }

    public class CommandLineInterface {
    // 啟動/關閉
    public void start();  // 啟動命令行介面
    public void shutdown();  // 關閉介面
    
    // 命令處理
    public void processCommand(String commandLine);  // 處理單個命令
    public boolean parseCommand(String input);  // 解析命令
    
    // 輸出
    public void printOutput(String message);  // 輸出消息
    public void printError(String errorMessage);  // 輸出錯誤
}

}
