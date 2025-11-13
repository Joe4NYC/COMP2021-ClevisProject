package hk.edu.polyu.comp.comp2021.clevis;

import java.io.BufferedWriter;

public class Logger {
    
    private String htmlPath;
    private String txtPath;
    private BufferedWriter htmlWriter;
    private BufferedWriter txtWriter;
    private int operationCounter;
    
    // REQ1: 初始化日誌文件
    public Logger(String htmlPath, String txtPath) {
        this.htmlPath = htmlPath;
        this.txtPath = txtPath;
        this.operationCounter = 0;
        // TODO: 初始化寫入器
    }
    
    // REQ1: 記錄操作
    public void logCommand(int operationIndex, String command) {
        // TODO: 同時寫入HTML和TXT文件
    }
    
    // REQ1: 關閉日誌
    public void close() {
        // TODO: 關閉文件寫入器
    }
    
    // 內部方法 - 寫入HTML表格行
    private void writeToHtml(int index, String command) {
        // TODO: 寫入HTML格式的表格行
    }
    
    // 內部方法 - 寫入TXT文件
    private void writeToTxt(String command) {
        // TODO: 寫入純文本命令
    }
    
    // 初始化HTML文件
    private void initHtmlFile() {
        // TODO: 寫入HTML表格頭部
    }
    
    // 完成HTML文件
    private void finalizeHtmlFile() {
        // TODO: 寫入HTML表格尾部
    }
}
