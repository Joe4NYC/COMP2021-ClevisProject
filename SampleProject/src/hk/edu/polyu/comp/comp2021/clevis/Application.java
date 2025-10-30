package hk.edu.polyu.comp.comp2021.clevis;

public class Application {

    private Clevis clevis;
    private String htmlLogPath;
    private String txtLogPath;

    public static void main(String[] args){
        Application app = new Application();
        app.initialize(args);
        app.run();
    }

    // 初始化應用程序
    private void initialize(String[] args) {
        parseCommandLineArgs(args);
        clevis = new Clevis(htmlLogPath, txtLogPath);
    }
    
    // 解析命令行參數 (REQ1: -html and -txt parameters)
    private void parseCommandLineArgs(String[] args) {
        // TODO: 解析 -html 和 -txt 參數
    }
    
    // 主程式迴圈
    public void run() {
        // TODO: 實現主運行邏輯
    }

}
