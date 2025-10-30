package hk.edu.polyu.comp.comp2021.clevis.view;

import hk.edu.polyu.comp.comp2021.clevis.Clevis;
import hk.edu.polyu.comp.comp2021.clevis.controller.CommandParser;

public class CommandLineInterface {
    
    private Clevis clevis;
    private CommandParser parser;
    private boolean running;
    
    public CommandLineInterface(Clevis clevis) {
        this.clevis = clevis;
        this.parser = new CommandParser();
        this.running = false;
    }
    
    // 啟動命令行介面
    public void start() {
        // TODO: 實現啟動邏輯
    }
    
    // 關閉介面
    public void shutdown() {
        // TODO: 實現關閉邏輯
    }
    
    // 處理單個命令（委託給 CommandParser）
    public void processCommand(String commandLine) {
        // TODO: 調用 parser.parseAndExecute(commandLine, clevis)
    }
    
    // 輸出消息
    public void printOutput(String message) {
        // TODO: 實現輸出
    }
    
    // 輸出錯誤
    public void printError(String errorMessage) {
        // TODO: 實現錯誤輸出
    }
    
    // REQ15: 檢查是否應該退出
    public boolean shouldQuit() {
        // TODO: 實現
        return false;
    }
    
    // 讀取用戶輸入
    public String readInput() {
        // TODO: 實現
        return null;
    }
}
