package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.model.Logger;
import hk.edu.polyu.comp.comp2021.clevis.model.ShapeManager;

import java.io.IOException;
import java.util.Scanner;

/**
 * Main entry point – COMP2021 Clevis Project
 * Run with: java hk.edu.polyu.comp.comp2021.clevis.Application -html log.html -txt log.txt
 */
public class Application {

    public static void main(String[] args) {
        String htmlPath = null;
        String txtPath = null;

        // Parse command-line arguments: -html file.html -txt file.txt
        for (int i = 0; i < args.length; i++) {
            if ("-html".equalsIgnoreCase(args[i]) && i + 1 < args.length) {
                htmlPath = args[++i];
            } else if ("-txt".equalsIgnoreCase(args[i]) && i + 1 < args.length) {
                txtPath = args[++i];
            }
        }

        if (htmlPath == null || txtPath == null) {
            System.err.println("""
                Error: Missing log file parameters.
                Usage: java hk.edu.polyu.comp.comp2021.clevis.Application -html <htmlfile> -txt <txtfile>
                Example: java hk.edu.polyu.comp.comp2021.clevis.Application -html log.html -txt log.txt
                """);
            System.exit(1);
        }

        // Initialize Model components
        Logger logger = null;
        ShapeManager manager = new ShapeManager();

        try {
            logger = new Logger(htmlPath, txtPath);
        } catch (IOException e) {
            System.err.println("Cannot create log files: " + e.getMessage());
            System.exit(1);
        }

        // Ensure HTML file is properly closed on exit (quit or Ctrl+C)
        Runtime.getRuntime().addShutdownHook(new Thread(logger::close));

        System.out.println("=== Clevis – Command Line Vector Graphics Software ===");
        System.out.println("Type 'quit' to exit. Type commands below:\n");

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("> ");
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) continue;
                if ("quit".equalsIgnoreCase(input)) {
                    System.out.println("Goodbye!");
                    break;
                }

                // Controller: Process command and log only on success
                boolean success = CommandProcessor.execute(input, manager);
                if (success) {
                    Logger.log(input);  // REQ1: Only successful commands are logged, raw text
                }
            }
        }
    }
}